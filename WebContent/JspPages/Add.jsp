<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ page import="com.tcs.ilp.tsis.model.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Model Added</title>
<link rel="stylesheet" type="text/css" href="/Project/css/StyleSheet.css" />
<script type="text/javascript" src="/Project/javascript/Homepagescript.js"></script>
<script type="text/javascript">
<jsp:include page="../javascript/Pagination.js" />
</script>
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
<%@include file="header.jsp"%>
<h1>Following Model Added Successfully!!!!!!!! </h1>
<%
ProductModelInfoTable pmit = (ProductModelInfoTable) request.getAttribute("pmit");
%>

<table border="1">

<tr><td>prodModelId</td><td>prodModelName</td><td>prodModelDesc</td><td>prodModelFeatures</td><td>prodModelPrice</td><td>prodModelThreshold</td></tr>
<tr><td><%=pmit.getProdModelId() %></td><td><%=pmit.getProdModelName() %></td><td><%=pmit.getProdModelDesc() %></td><td><%=pmit.getProdModelFeatures() %></td><td><%=pmit.getProdModelPrice() %></td><td><%= pmit.getProdModelThreshold() %></td></tr>
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