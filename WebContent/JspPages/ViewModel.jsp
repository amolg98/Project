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
<%@page import="com.tcs.ilp.tsis.model.ProductModelInfoTable"%>
<%@page  import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Models</title>
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
<script type="text/javascript">
<jsp:include page="../javascript/Pagination.js" />
</script>
<script type="text/javascript">
 function validate()
{
 
  var regInt=/^[0-9]*$/;
  var regFloat=/^((\d+(\d*)?)|((\d*\.)?\d+))$/;
  var regSpaces=/\s\s/;
  var regStringup=/^[a-zA-Z0-9,]*$/;
  var modelId=document.myForm.prodModelId.value;
  var first=modelId.indexOf(" ");
  var last=modelId.lastIndexOf(" ");
  var regSingleSpace=/\s/;


if(document.myForm.prodModelFeatures.value=="")
  {
   alert("please enter ModelFeatures");
    return false;
    }
 if(document.myForm.prodModelFeatures.value=='null')
{
alert("ModelFeatures should not be null");
 return false;
}
if(document.myForm.prodModelFeatures.value.search(regStringup)==-1)
{
 alert("modelFeatures should not contain special characters");
 return false;
}
if(!(document.myForm.prodModelFeatures.value.search(regSpaces)==-1))
{
 alert("modelFeatures should not contain two consecutive spaces");
 return false;
}
if(document.myForm.prodModelPrice.value=="")
  {
   alert("please enter modelPrice");
    return false;
    }
 
if(document.myForm.prodModelPrice.value.search(regFloat)==-1)
{
 alert("Price should be in ##/###.## format");
 return false;
}
if(document.myForm.prodModelPrice.value.search(regSingleSpace)==-1)
{
 alert("Price cannot containg any space(s)");
 return false;
}

if(document.myForm.prodModelThreshold.value=="")
  {
   alert("please enter modelThreshold");
    return false;
    }
 
if(document.myForm.prodModelThreshold.value.search(regInt)==-1)
{
 alert("modelThreshold should be in #####");
 return false;
}

return true;
}
</script>
</head>
<body>
<%@include file="header.jsp"%>
<h3 align="center">View Models</h3>
<%List<ProductModelInfoTable> pmList=(List<ProductModelInfoTable>)request.getAttribute("modelList"); %>
<table border="1" align="center" id="viewmodel">
<tr><th>ModelId</th><th>ModelName</th><th>Model Description</th><th>Model Features</th><th>Model Price</th><th>Model Threshold</th></tr>
<%for(ProductModelInfoTable pm1:pmList)
{	
%>
	<tr><td><%=pm1.getProdModelId() %></td><td><%=pm1.getProdModelName()%></td><td><%=pm1.getProdModelDesc()%></td><td><%=pm1.getProdModelFeatures()%></td><td><%=pm1.getProdModelPrice()%></td><td><%=pm1.getProdModelThreshold()%></td></tr>
<%
}
%>

</table>
<div align="center" id="pageNavPosition" onmouseover="this.style.cursor='hand'">
<script type="text/javascript"><!--
        var pager = new Pager('viewmodel',10); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
       </script>
       </div>
<%@include file="footer.jsp"%>
</body>
</html>