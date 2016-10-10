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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.tcs.ilp.tsis.model.Search" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Project/css/StyleSheet.css" />
<script type="text/javascript" src="/Project/javascript/Homepagescript.js"></script>
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
<%
Search pst = (Search)request.getAttribute("product");
%>
<body>
<%@include file="header.jsp"%>
<h3>Product has been added successfully</h3>
<h1>Product Details are:</h1>
<table border="1">
<tr><td>Model Id</td><td>Model Name</td><td>Model Description</td><td>Model Features</td><td>Model Price</td><td>Model Product Code</td><td>Status</td></tr>
<tr><td><%=pst.getProdModelId() %></td><td><%=pst.getProdModelName()%></td><td><%=pst.getProdModelDesc()%></td><td><%=pst.getProdModelFeatures()%></td><td><%=pst.getProdModelPrice()%></td><td><%=pst.getProdCode()%></td><td><%=pst.getProdModelStatus()%></td></tr>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%@include file="footer.jsp"%>
</body>
</html>