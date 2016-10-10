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
<%@ page import="java.sql.*" %>
<%@ page import = "java.util.List"%>
<%@ page import = "com.tcs.ilp.tsis.model.ProductModelInfoTable"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Model</title>
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
<body>
<%@include file="header.jsp" %>
<%
List<ProductModelInfoTable> modelList = (List<ProductModelInfoTable>)request.getAttribute("List");
%>
<form name="myform" action="/Project/InventoryController" method="post" >
<table border="2" bgcolor="palegreen">
<tr><td>Product Code</td>
<td>
<select name="sel"><option value="">---Select---</option>
<%
for(ProductModelInfoTable mList:modelList)
{
%>
<option value="<%=mList.getProdModelId()%>"><%=mList.getProdModelId()%></option>
<%
}
%>
</select>
</td>
</tr>
<tr><td><input type="submit" value="Delete Model"></input></td></tr>
</table>
<input type="hidden" name="action" value="deleteModelInfo"></input>
</form>
<%@include file="footer.jsp" %>
</body>
</html>