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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import = "java.util.List" %>
<%@page import ="com.tcs.ilp.tsis.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tag Model(s)</title>
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
List<ProductModelInfoTable> modelList=(List<ProductModelInfoTable>)request.getAttribute("modelList");
List<Retailer> retList = (List<Retailer>)request.getAttribute("retList");
%>
<body>
<%@include file="header.jsp"%>
<h3 align="center">Tag models with retailers</h3>
<form action="/Project/InventoryController" name="myform">
<table align="center" border="2">
<tr><th>Model Id</th><th>Retailer Id</th></tr>
<tr>
<td><select name="modelId" multiple="multiple" size="6">
<%
for(ProductModelInfoTable mList : modelList)
{
%>
<option value="<%=mList.getProdModelId()%>"><%=mList.getProdModelId()%></option>
<%
}
%>
</select></td>
<td><select name="retailerId" multiple="multiple" size="6">
<%
for(Retailer rList : retList)
{
%>
<option value="<%=rList.getRetailerId()%>"><%=rList.getRetailerId()%></option>
<%
}
%>
</select></td>
</tr>
<tr><td colspan="2" align="center"><input type="submit" value="Tag Model(s)"></input></td></tr>
</table>

<br/>
<br/>
<br/>
<input type="hidden" name="action" value="taggedModels"></input>
</form>
<%@include file="footer.jsp"%>
</body>
</html>