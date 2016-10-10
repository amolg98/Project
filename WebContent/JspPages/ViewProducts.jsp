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
    <%@ page import="com.tcs.ilp.tsis.model.ProductStockTable"  %>
        <%@ page import="java.util.ArrayList"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Products</title>
<link rel="stylesheet" type="text/css" href="/Project/css/StyleSheet.css" />
<script type="text/javascript" src="/Project/javascript/Homepagescript.js"></script>
<script type="text/javascript"><jsp:include page="../javascript/Pagination.js" /></script>
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
<body>
<%@include file="header.jsp"%>
<h3 align="center">Please enter Model Id</h3>
<%ArrayList<ProductStockTable> arrList=(ArrayList<ProductStockTable>)request.getAttribute("PMIT");

%>
<form action="/Project/InventoryController" method="post" name="myForm" >
<table align="center" border="2">
<tr><th>Product Model Id:</th><td><input type="text" name="prodModelId" onkeydown="f(this)" onkeyup="f(this)" onblur="f(this)" onclick="f(this)"></input></td><td><input type="submit" align="center" value="submit"></input></td></tr>

</table>

<input type="hidden" name="action" value="viewProducts"></input>
</form>
<form action="/Project/InventoryController" name="myform" onsubmit="return(validate());">
<table align="center" border="1" id = "tableviewproducts">
<tr><th>ProductCode</th><th>ProdModelId</th><th>ProductName</th><th>ProductStatus</th></tr>
<%
for(ProductStockTable pst:arrList)
{%>
<tr>
<td><%=pst.getProdCode() %></td><td><%=pst.getProdModelId()%></td><td><%=pst.getProdModelName() %></td><td><%=pst.getProdModelStatus() %></td>
</tr>
<%}%>
</table>
<div align="center" id="pageNavPosition" onmouseover="this.style.cursor='hand'">
<script type="text/javascript"><!--
        var pager = new Pager('tableviewproducts',10); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
</script>
</div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>