<!DOCTYPE html>
<html>
 <head>
   <title>Input Schedule</title>
   <#include "head.ftl" />
   <style type="text/css">
     body {background-color:SteelBlue}
     p {color:black}
   </style>
 </head>
 
 <body>
   <#include "navbar.ftl" />
   <font size= 5>
   <center><h1>Input Schedule</h1></center>
  <form action="ViewSchedule" method="get">
  	<center>last schedule tonight: <input  type ="time" name="sleep" value="22:30" > today </center><br>
  	<center>first schedule tomorrow: <input  type ="time" name="wakeup" value="06:30" > tomorrow </center><br>
  	<center><input type="submit" value="submit"></center>
  </form>
</font>
 </body>
</html>
