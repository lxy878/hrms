<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
    $(function(){
        $("#submit").on('click', function(){
            const children = $("#newUser").children(".data") 
            // const roles = $("#newUser").children(".data_role")
            // debugger
            const data = {roles: [{name: 'ROLE_USER'}, {name: "ROLE_ADMIN"}]}  
            for(let c of children){
                data[$(c).attr("name")] = $(c).val()
            }
            $.ajax({
                url: 'http://localhost:8383/addUser',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data)
            }).done(function(data){
                console.log(data)
            }).fail(function (xhr, status, error) {
                console.log(`${xhr.status}: ${xhr.statusText}`)
            })
        })
    })
    </script>
    <title>Log In</title>
</head>
<body>
    <%-- <p>${Message}</p> --%>
    <div align="center" id="newUser">
       Name: <input class="data" type="text" name="name" required="required"><br>
       Password: <input class="data" type="password" name="password" required="required"><br>
       Email <input class="data" type="text" name="email" required="required"><br>
       <%-- <input class="data_role" type="checkbox" name="role" value="ROLE_USER">User<br>
       <input class="data_role" type="checkbox" name="role" value="ROLE_ADMIN">Admin<br> --%>
        <input type="submit" value="register" id="submit"><br>
    </div>
    <a href="/">Home</a>
</body>
</html>