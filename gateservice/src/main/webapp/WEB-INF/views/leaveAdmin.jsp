<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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
    <link rel='stylesheet' href='/css/leave.css'>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="/js/leaveAdmin.js"> </script>
  </head>

  <body class="w3-theme-l5">

    <!-- Navbar -->
    <div class="w3-top">
      <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2"
          href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
        <a href="/" class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>Logo</a>
        <%-- User Info --%>
        <a href="/empInfo/${uId}" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="User Info Settings"><i class="fa fa-address-card"></i></a>
        <%-- account --%>
        <a href="/accountInfo/${uId}" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Account Settings"><i class="fa fa-cog"></i></a>
        <a href="/login?logout" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white"
          title="Log Out">
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
            <div class="w3-container">
              <h4 class="w3-center">My Profile</h4>
              <h5 class="w3-center" id="username" uid=${uId}>Name</h5>

              <%-- <p class="w3-center"><img src="/w3images/avatar3.png" class="w3-circle"
                  style="height:106px;width:106px" alt="Avatar"></p> --%>
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
              
              <button class="w3-button w3-block w3-theme-l1 w3-left-align"><i href="/admin/resignationApprove/${uId}" class="fa fa-users fa-fw w3-margin-right"></i><a href="/admin/resignationApprove/${uId}" style="text-decoration: none">Resignation Approve</a></button>
              <button class="w3-button w3-block w3-theme-l1 w3-left-align"><i
                class="fa fa-users fa-fw w3-margin-right"></i><a href="/admin/register/${uId}"
                style="text-decoration: none">Register Employee</a></button>
              <button class="w3-button w3-block w3-theme-l1 w3-left-align"><i
                class="fa fa-users fa-fw w3-margin-right"></i><a href="/admin/empLeaves/${uId}"
                style="text-decoration: none">Employee Leaves</a></button>
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
                  <h3 class="w3-opacity">Approve Leaves</h3>
                  <table>
                    <col span="9" width="100px"/>
                    <tr>
                      <th>Application Date</th>
                      <th>Leave Type</th>
                      <th>Emp Name</th>
                      <th>From Date</th>
                      <th>To Date</th>
                      <th>Days</th>
                      <th>Process Name</th>
                      <th>Status</th>
                      <th>Action</th>
                    </tr>
                    <tbody id="leaveTbody">
                      <tr leaveId=-1>
                        <th>01/01/2020</th>
                        <th>PL</th>
                        <th>Emp Name</th>
                        <th>01/02/2020</th>
                        <th>01/03/2020</th>
                        <th>2</th>
                        <th>Process Name</th>
                        <th>Pending</th>
                        <th><button style="background-color: lightgreen">Approve</button> <button style="background-color: deeppink">Deny</button></th>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>

          <!-- End Middle Column -->
        </div>

      <!-- End Grid -->
    </div>

    <!-- End Page Container -->
    </div>
    <br>

     <!-- Footer -->
    <footer class="w3-container w3-theme-d3 w3-padding-16">
      <p>Powered by Xiaoyi Liu 2022</p>
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