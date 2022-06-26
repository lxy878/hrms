# Human Resource Management System

Task 1 - 
a) Setup all the three project the way I did it.
b) Freeze your login, home page design.
c) Implment security that you learnt earlier with me on Gateway project
d) Setup GitHub repository for your project and upload all the three project over there.

Task 2 -
a) Implement User Register functionality - Create a domain entity in Admin Microservice,
 Employment - empCode,maritalStatus,Name,Gender,birthDate,SSN.,mobile,alternateMobile,emailId,address 
 Address - residenceNumber,locality,state,street,city,pinCode,
When you save a entry would go in Users Table & role is assinged as ROLE_USER and setup a default password which is same as of employeeCode and send a mail to the user with credetials so that he can login on his profile

b) Implement User Attendnace functionality - 
 attendanceLog - empCode, logDate, logType
                6779 , sysdate with time, IN
When you logout you will enter in the same table same entyr
                6779 , sysdate with time, OUT
at the same time you will have to enter into another table that
empAttendance - empCode, attendanceDate, Intime, OutTime, attendance
Logic is
if the difference between first In & last Out of current date is greater than 9, then attenenace would be Present,
if greater then or equal to 4 then attendance is Half
if less then 4 then Absent 

c) View Attendance on a Home Page

Task 3 -  Employee Leaves