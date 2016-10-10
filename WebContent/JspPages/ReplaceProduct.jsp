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
<%@ page import = "java.util.List"%>
<%@ page import = "com.tcs.ilp.tsis.model.DefectProductOrder" %>
<%@ page import = "com.tcs.ilp.tsis.model.ProductStockTable" %>
<%@ page import = "com.tcs.ilp.tsis.dao.InventoryDao" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Replace Product(s)</title>
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
<script>
function validate(obj,obj1)
{
	//var repProductCode = document.myform.selOption[i].value;
	/*if(repProductCode==""||repProductCode==null)
	{
		alert("Please select any Replacement Product Code");
		return false;
	}*/
	alert(obj+" "+obj1);
	document.myform.defProdCode.value=obj;
	document.myform.orderId.value=obj1;
	document.myform.action.value="ReplaceProductCode";
	document.myform.submit();
}
</script>
</head>
<body>
<%@include file="header.jsp"%>
<%
List<DefectProductOrder> dpoList = (List<DefectProductOrder>)request.getAttribute("List");
%>
<form name="myform" action="/Project/InventoryController" method="post">
<input type="hidden" name="defProdCode"></input>
<input type="hidden" name="orderId"></input>
<input type="hidden" name="action"></input>
<%
int i=1;
%>
<table border="2">
<h3>Replace defected products</h3>
<tr><th>OrderId</th><th>Defect Product code</th><th>Defect Reason</th><th>Replace Product</th></tr>
<%
for(DefectProductOrder dpList:dpoList)
{
%>
<tr>
<td><%=dpList.getOrderId()%></td>
<td><%=dpList.getDefectProdCode()%></td>
<td><%=dpList.getReason()%></td>
<td><a href="#" onclick="return validate('<%=dpList.getDefectProdCode()%>','<%=dpList.getOrderId()%>')">Replace</a></td>
</tr>
<%
i++;
%>
<%
}
%>
</table>
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
<%@include file="footer.jsp"%>
</body>
</html>