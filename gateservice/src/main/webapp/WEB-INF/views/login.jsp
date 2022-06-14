<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log In</title>
</head>
<body>
    <p>${Message}</p>
    <div align="center">
        <form action="/login" method="POST">
            <table>
                <tr>
                    <td>UserName</td><td><input type="text" name="username" required="required"></td>
                </tr>
                <tr>
                    <td>Password</td><td><input type="password" name="password" required="required"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" name="submit" value="LogIn"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>