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
<%@ page import = "java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
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
List<String> modelList = (List<String>)request.getAttribute("modelList");
List<String> productList = (List<String>)request.getAttribute("prodList");
%>
<body>
<%@include file="header.jsp"%>
<h3 align="center">Choose your search type</h3>
<form name="myform" action="/Project/InventoryController?action=Search" method="post">
<table align="center" border="2" bgcolor="">
<tr><th>Choose your option</th><td>
<select name="option">
<option value="">--Select--</option>
<option value="Brand">Brand</option>
<option value="Product">Product</option>
<option value="Features">Features</option>
<option value="Price">Price</option>
<option value="Status">Status</option>
</select>
</td><td><input type="submit" value="Search" ></input></td></tr>
</table>
</form>
<%
if(request.getParameter("option").equals("Brand"))
{
%>
<form action="/Project/InventoryController?action=SearchType&action1=Brand&option=Brand" method="post">
<table align="center" border="2" bgcolor="">
<tr><th>Choose Brand</th><td><select name="optionChoosen"><option value="">--Select Brand--</option>
<%
for(String model:modelList)
{
%>
<option value="<%=model%>"><%=model%></option>
<%
}
%>
</select></td><td><input type="submit" value="Search" ></input></td></tr>
</table>
</form>
<%
}

else if(request.getParameter("option").equals("Product"))
{
%>

<form action="/Project/InventoryController?action=SearchType&action1=Product&option=Product" method="post">
<table align="center" border="2" bgcolor="">
<tr><th>Choose Product Type</th><td><select name="optionChoosen"><option value="">--Select Product--</option>
<%for(String product:productList)
{
%>
<option value="<%=product%>"><%=product%></option>
<%
}
%>
</select></td><td><input type="submit" value="Search" ></input></td></tr>
</table>
</form>
<%
}

else if(request.getParameter("option").equals("Features"))
{
%>
<form action="/Project/InventoryController?action=SearchType&action1=Features&option=Features" method="post">
<table align="center" border="2" bgcolor="">
<tr><th>Choose Features</th><td>
<select name="optionChoosen">
<option value="">--Select--</option>
<option value="Bluetooth">Bluetooth enabled devices</option>
<option value="GPRS">GPRS enabled devices</option>
<option value="3G">3G enabled devices</option>
<option value="Wi-Fi">Wi-Fi enabled devices</option>
</select></td><td><input type="submit" value="Search" ></input></td></tr>
</table>
</form>
<%
}

else if(request.getParameter("option").equals("Price"))
{
%>
<form action="/Project/InventoryController?action=SearchType&action1=Price&option=Price" method="post">
<table align="center" border="2" bgcolor="">
<tr><th>Choose your option</th><td><select name="optionChoosen">
<option value="">--Select Price--</option>
<option value="3000">Less than 3000</option>
<option value="5000">Less than 5000</option>
<option value="10000">Less than 10000</option>
<option value="20000">Less than 20000</option>
<option value="30000">Less than 30000</option>
<option value="50000">Less than 50000</option>
</select></td><td><input type="submit" value="Search" ></input></td></tr>
</table>
</form>
<%
}

else if(request.getParameter("option").equals("Status"))
{
%>
<form action="/Project/InventoryController?action=SearchType&action1=Status&option=Status" method="post">
<table align="center" border="2" bgcolor="">
<tr><th>Choose your option</th><td><select name="optionChoosen">
<option value="">--Select Status--</option>
<option value="Available">Available</option>
<option value="Allocated">Allocated</option>
<option value="Dispatched">Dispatched</option>
<option value="Defected">Defected</option>
</select></td><td><input type="submit" value="Search" ></input></td></tr>
</table>
</form>
<%
}
%>
<%@include file="footer.jsp"%>
</body>
</html>