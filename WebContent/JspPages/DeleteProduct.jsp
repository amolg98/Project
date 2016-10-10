<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List"%>
<%@ page import = "com.tcs.ilp.tsis.model.ProductStockTable"%>
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
<!--<script type="text/javascript">
function validate()
{
	if(document.myform.sel.value=="")
	{
		alert("Please select any Product Code");
		return false;
	}
	var prodCode = document.myform.sel.value;
	alert(prodCode);
	document.myform.submit();
}

</script>
-->
<body>

<%@include file="header.jsp" %>
<%
List<ProductStockTable> prodList = (List<ProductStockTable>)request.getAttribute("List");
%>
<form name="myform" action="/Project/InventoryController" method="post" >
<table border="2">
<tr><td>Product Code</td>
<td>
<select name="sel"><option value="">---Select---</option>
<%
for(ProductStockTable pList:prodList)
{
%>
<option value="<%=pList.getProdCode()%>"><%=pList.getProdCode()%></option>
<%
}
%>
</select>
</td>
</tr>
<tr><td><input type="submit" value="Delete Product"></input></td></tr>
</table>
<input type="hidden" name="action" value="delProductInfo"></input>
</form>

<%@include file="footer.jsp" %>
</body>
</html>