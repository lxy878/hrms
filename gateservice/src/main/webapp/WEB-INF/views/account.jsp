<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel='stylesheet' href='/css/home.css'>
<link rel="stylesheet" href="/css/calendar.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/js/account.js"></script>
</head>
<body class="w3-theme-l5">

<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="/" class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>Logo</a>
  <%-- User Info --%>
  <a href="/empInfo/${uId}" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="User Info Settings"><i class="fa fa-address-card"></i></a>
  <%-- account --%>
  <a href="/accountInfo/${uId}" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Account Settings"><i class="fa fa-cog"></i></a>
  <a href="/login?logout" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="Log Out">
    Log Out
  </a>
 </div>
</div>

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">My Profile</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Log Out</a>
</div>

<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3">
      <!-- Profile -->
      <div class="w3-card w3-round w3-white">
        <div class="w3-container" id="role" role=${role}>
         <h4 class="w3-center">My Profile</h4>
         <h5 class="w3-center" id="username" uid=${uId}>Name</h5>
         
         
         <%-- <p class="w3-center"><img src="/w3images/avatar3.png" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p> --%>
         <hr>
         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> Designer, UI</p>
         <p><i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i> London, UK</p>
         <p><i class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i> April 1, 1988</p>
        </div>
      </div>
      <br>
      
      <!-- Accordion -->
      <div class="w3-card w3-round">
        <div class="w3-white">
          <button class="w3-button w3-block w3-theme-l1 w3-left-align"><i href="/leave/${uId}" class="fa fa-map fa-fw w3-margin-right"></i><a href="/leave/${uId}" style="text-decoration: none">Leaves</a></button>
          <button class="w3-button w3-block w3-theme-l1 w3-left-align"><i href="/resignation/${uId}" class="fa fa-users fa-fw w3-margin-right"></i><a href="/resignation/${uId}" style="text-decoration: none">Resignation</a></button>
          <button class="w3-button w3-block w3-theme-l1 w3-left-align"><i href="/leave/${uId}" class="fa fa-file-pdf-o fa-fw w3-margin-right"></i><a href="/img/cp.pdf" style="text-decoration: none">Company Policy</a></button>
        <div id="Demo3" class="w3-hide w3-container">
         <div class="w3-row-padding">
         </div>
          </div>
        </div>      
      </div>
      <br>
      
      <!-- Interests --> 
      <div class="w3-card w3-round w3-white w3-hide-small">
        <div class="w3-container">
          <p>Interests</p>
          <p>
            <span class="w3-tag w3-small w3-theme-d5">News</span>
            <span class="w3-tag w3-small w3-theme-d4">W3Schools</span>
            <span class="w3-tag w3-small w3-theme-d3">Labels</span>
            <span class="w3-tag w3-small w3-theme-d2">Games</span>
            <span class="w3-tag w3-small w3-theme-d1">Friends</span>
            <span class="w3-tag w3-small w3-theme">Games</span>
            <span class="w3-tag w3-small w3-theme-l1">Friends</span>
            <span class="w3-tag w3-small w3-theme-l2">Food</span>
            <span class="w3-tag w3-small w3-theme-l3">Design</span>
            <span class="w3-tag w3-small w3-theme-l4">Art</span>
            <span class="w3-tag w3-small w3-theme-l5">Photos</span>
          </p>
        </div>
      </div>
      <br>
    
    <!-- End Left Column -->
    </div>
    
    <!-- Middle Column -->
    <div class="w3-col m9">

      <div class="w3-row-padding">
        <div class="w3-col m12">
          <div class="w3-card w3-round w3-white">
            <div class="w3-container w3-padding">
              <h3 class="w3-opacity">Reset Password</h3>
              <hr class="w3-clear">
                <div id="setPassword" align="center">
                  Old Password: <input class="data" type="text" name="oldPassword" > <br><br>
                  New Password: <input class="data" type="text" name="newPassword" > <br><br>
                  <button id="submit">Submit</button>
                </div>
              <br>
            </div>
          </div>
        </div>
      </div>
      
    <!-- End Middle Column -->
    </div>
    
    <%-- <!-- Right Column -->
    <div class="w3-col m2">
      <div class="w3-card w3-round w3-white w3-center">
        <div class="w3-container">
          <p>Name's Birthdate: Date</p>
          <p>Name's Birthdate: Date</p>
          <p>Name's Birthdate: Date</p>
          <p>Name's Birthdate: Date</p>
          <p>Name's Birthdate: Date</p>
          <p>Name's Birthdate: Date</p>
          <p>Name's Birthdate: Date</p>
        </div>
      </div>
      <br>
      
    <!-- End Right Column -->
    </div> --%>
    
  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
</div>
<br>

<!-- Footer -->
<footer class="w3-container w3-theme-d3 w3-padding-16">
  <h5>Footer</h5>
</footer>

<footer class="w3-container w3-theme-d5">
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>
 
<script>
// Accordion
function myFunction(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
    x.previousElementSibling.className += " w3-theme-d1";
  } else { 
    x.className = x.className.replace("w3-show", "");
    x.previousElementSibling.className = 
    x.previousElementSibling.className.replace(" w3-theme-d1", "");
  }
}

// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>

</body>
</html> 
