<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tcs.ilp.tsis.model.ProductModelInfoTable" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<html>
<head>
<title>Add Product</title>
<link rel="stylesheet" type="text/css" href="/Project/css/StyleSheet.css" />
<script type="text/javascript" src="/Project/javascript/Homepagescript.js"></script>
<script type="text/javascript" src="/Project/javascript/AddProduct.js"></script>
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

<script type="text/javascript">
function f(o)
{
	o.value=o.value.toUpperCase().replace(/([^0-9A-Z ])/g,"");
}
</script>
</head>
<%
List<ProductModelInfoTable> modelList =(List<ProductModelInfoTable>)request.getAttribute("modelList");
%>
<body>
<%@include file="header.jsp" %>
<h3 align="center">Please enter product code and select Model Id</h3>
<form action="/Project/InventoryController" method ="post" name="myForm" onsubmit="return(fun());">
<table border="2" align="center">
<tr><th>ProductCode</th><td><input type="text" name="code" onkeydown="f(this)" onkeyup="f(this)" onblur="f(this)" onclick="f(this)"></input></td></tr>
<tr><th>Model Id</th><td><select name="mid"><option>--Select--</option><%for(ProductModelInfoTable mList:modelList){ %><option value="<%=mList.getProdModelId()%>"><%=mList.getProdModelId()%></option><%}%></select></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="Add Product" ></input></td></tr>
</table> 

<input type="hidden" name="action" value="addProduct"></input>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
</form>
<%@include file="footer.jsp" %>
</body>
</html>