<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page  import="java.util.List" %>
    <%@ page import="com.tcs.ilp.tsis.model.*" %>
	<%@ page import="java.sql.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<% List<RetailerModelView> list = (List<RetailerModelView>) request.getAttribute("list1");%>
<table border="1" bgcolor="#D0D0D0">
<tr><td>Retailer Id</td><td>Product ModelId</td><td>Tagged_Date</td></tr>
<% 
for(RetailerModelView tag:list)
{
%>
<tr><td><%=tag.getRetailer_Id()%></td><td><%=tag.getProduct_Model_Id()%></td><td><%=tag.getTagged_date()%></td></tr>
<%
}
%>
</table>
<a href="HtmlPages/Home.html">Home</a>
</body>
</html>