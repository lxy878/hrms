package com.hrms.gateservice.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.gateservice.domain.User;
import com.hrms.gateservice.restclients.AdminClient;
import com.hrms.gateservice.restclients.UserClient;
import com.hrms.gateservice.services.UserService;

@Controller
@SessionAttributes("user")
public class UserViewController {
    
	@Autowired
	UserService userService;

	@Autowired
	UserClient userClient;

	@Autowired
	AdminClient adminClient;

    @RequestMapping(value="/login")
	public String login(@RequestParam(required=false) String logout, @RequestParam(required=false) String error, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Model model) {
		String message = "";
		
		// resignation check
		adminClient.getRequest("/resingationCheck");
		if(error!=null) {
			message="Invalid Credentials"; 
		}
		if(logout!=null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if(auth!=null) {
				String userName = auth.getName();
				// find user by name
				User user = userService.findByName(userName);
				Map<String, Long> context = new HashMap<>();
				context.put("uId", user.getId());

				ObjectMapper mapper = new ObjectMapper();
				JsonNode data = mapper.convertValue(context, JsonNode.class);
				// send request to the user micro-service
				userClient.userLog(data, "/empLogout");

				new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
			}
			message="Logout";
			return "login";
		}
	
        // return new ResponseEntity<>(respond, HttpStatus.OK);
		model.addAttribute("Message", message);
		return "login";
		
	} 

	@RequestMapping(value="/accessDenied")
 	public String accessDenied(Principal principal, Model model) {
 		String message = principal.getName()+", Unauthorised access";
 		model.addAttribute("Message", message);
 		return "accessDenied";

 	}

	 @GetMapping({"/", "/index","/home"})
	 private String getIndex(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String admin = "";
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
			admin = "admin";
		}
		String userName = auth.getName();
		// send request to the user micro-service
		User user = userService.findByName(userName);
		Map<String, Long> context = new HashMap<>();
		context.put("uId", user.getId());

		ObjectMapper mapper = new ObjectMapper();
		JsonNode data = mapper.convertValue(context, JsonNode.class);
		// send request to the user microservice
		JsonNode respond = userClient.userLog(data, "/empLogin");
		model.addAttribute("uId", user.getId());
		model.addAttribute("respond", respond);
		model.addAttribute("role", admin);
		return "home";
	 }

	 @GetMapping("/leave/{uId}")
	 private String leave(@PathVariable int uId, Model model){
		model.addAttribute("uId", uId);
		return "leave";
	 }

	 @GetMapping("/resignation/{uId}")
	 private String resignation(@PathVariable int uId, Model model){
		model.addAttribute("uId", uId);
		return "resignation";
	 }
}
