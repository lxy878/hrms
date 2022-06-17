<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
    $(function(){
        $("#submit").on('click', function(){
            const empInf = $("#newEmp").children(".data") 
            const addrInf = $('#address').children(".data")

            const data = {address:{}}
            for(let e of empInf){
                data[$(e).attr("name")] = $(e).val()
            }
            for(let a of addrInf){
                data['address'][$(a).attr("name")] = $(a).val()
            }

            $.ajax({
                url: 'http://localhost:8080/addEmp',
                type: 'POST',
                contentType: 'application/json',
                dataType: "json",
                data: JSON.stringify(data),
                cache: false
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
    <div align="center" id="newEmp">
        <h3>Employee Information</h3>
        Name: <input class="data" type="text" name="name" required="required"> <br>
        Employee Code: <input class="data" type="text" name="empCode" required="required"> <br>
        Email: <input class="data" type="text" name="email"> <br>
        SSN: <input class="data" type="number" name="ssn"> <br>
        Mobile: <input class="data" type="number" name="mobile"> <br>
        Alternate Mobile: <input class="data" type="number" name="alternateMobile"> <br>
        Birthdate: <input class="data" type="date" name="birthDate"> <br>
        Marital Status: <input class="data" type="text" name="maritalStatus"> <br>
        <div id="address">
            <h3>Address</h3>
            Residence Number: <input class="data" type="text" name="residenceNumber"> <br>
            Locality: <input class="data" type="text" name="locality"> <br>
            Street: <input class="data" type="text" name="street"> <br>
            City: <input class="data" type="text" name="city"> <br>
            State: <input class="data" type="text" name="state"> <br>
		    Zip Code: <input class="data" type="number" name="zipCode"> <br>
        </div>
        <input type="submit" value="register" id="submit"><br>
    </div>
    <a href="/admin">Home</a>
</body>
</html>