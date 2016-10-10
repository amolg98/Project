<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility

if(session==null || session.getAttribute("username")==null){
	response.sendRedirect("/Project/JspPages/login.jsp");
	return;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Model</title>
<link rel="stylesheet" type="text/css" href="/Project/css/StyleSheet.css" />
<script type="text/javascript" src="/Project/javascript/Homepagescript.js"></script>
<script type="text/javascript" src="/Project/javascript/AddModel.js"></script>
<script language="JavaScript"> 

function noway(go) {
 if (document.all) { 
 if (event.button == 2) { 
 alert("Sorry, right-click is disabled");
  return false;
   }
    } 
  if (document.layers) 
  {
   if (go.which == 3) {
    alert("Sorry, right-click is disabled");
     return false; 
     }
    }
   }
   if (document.layers) 
	{
	 document.captureEvents(Event.MOUSEDOWN); 
	 }
	document.onmousedown=noway; 
</script>

</head>
<body> 	
<%@include file="header.jsp" %>
<h2 align="center">Please enter the Model details</h2>
	                	<form action="/Project/InventoryController" method="post" name="myForm"  onsubmit="return(validate());" >
						<table border="2" align="center">
						<tr><th align="left">Product Model Id:</th><td><input type="text" name="prodModelId" onkeydown="f(this)" onkeyup="f(this)" onblur="f(this)" onclick="f(this)"></input></td></tr>
						<tr><th align="left">Product Model Name:</th><td><input type="text" name="prodModelName" onkeydown="f(this)" onkeyup="f(this)" onblur="f(this)" onclick="f(this)"></input></td></tr>
						<tr><th align="left">Product Model Description:</th><td><textarea rows="5" cols="20" name="prodModelDesc"></textarea></td></tr>
						<tr><th align="left">Product Model Features:</th><td><textarea rows="5" cols="20" name="prodModelFeatures"></textarea></td></tr>
						<tr><th align="left">Product Model Price:</th><td><input type="text" name="prodModelPrice"></input></td></tr>
						<tr><th align="left">Product Model Threshold:</th><td><input type="text" name="prodModelThreshold"></input></td></tr>
						<tr><td colspan="2" align="center"><input  type="submit" value="Add Model"></input></td></tr>
						</table>
						<input type="hidden" name="action" value="addModel"></input>
						</form>
<%@include file="footer.jsp" %>

</body>
</html>