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
  <%@ page import ="com.tcs.ilp.tsis.model.ProductModelInfoTable" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Model Info</title>
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
 function validate()
{
 
  var regInt=/^[0-9]*$/;
  var regSpaces=/\s\s/;
  var regStringup=/^[a-zA-Z0-9-,\/\ ]*$/;
  var regSingleSpace=/\s/;
  var regFloat=/^((\d+(\d*)?)|((\d*\.)?\d+))$/;
  var regStringdesc=/^[a-zA-Z0-9.)( ]*$/;
  var an = /^[0-9 ]+$/;
  
if(document.myForm.prodModelDesc.value=="")
{
  alert("Please enter model description");
  return false;
}
 if(document.myForm.prodModelDesc.value=='null')
{
alert("Model description should not be null");
 return false;
}
if(document.myForm.prodModelDesc.value.search(regStringdesc)==-1)
{
 alert("Model description should not contain special characters");
 return false;
}
if(!(document.myForm.prodModelDesc.value.search(regSpaces)==-1))
{
 alert("Model description should not contain two consecutive spaces");
 return false;
}
if( !(document.myForm.prodModelDesc.value.search(an)==-1) ) 
{
	alert("Description cannot be only number");
	return false; 
}  
if(document.myForm.productModelFeature.value=="")
  {
   alert("please enter ModelFeatures");
    return false;
    }
 if(document.myForm.productModelFeature.value=='null')
{
alert("ModelFeatures should not be null");
 return false;
}
if(document.myForm.productModelFeature.value.search(regStringup)==-1)
{
 alert("modelFeatures should not contain special characters");
 return false;
}
if(!(document.myForm.productModelFeature.value.search(regSpaces)==-1))
{
 alert("modelFeatures should not contain two consecutive spaces");
 return false;
}
if(document.myForm.productModelPrice.value=="")
  {
   alert("please enter modelPrice");
    return false;
    }
 
if(document.myForm.productModelPrice.value.search(regFloat)==-1)
{
 alert("Price should be in ##/###.## format");
 return false;
}

if(document.myForm.productModelThreshold.value=="")
  {
   alert("please enter modelThreshold");
    return false;
    }
 
if(document.myForm.productModelThreshold.value.search(regInt)==-1)
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
<%
ProductModelInfoTable productmodelinfotable =(ProductModelInfoTable)request.getAttribute("PMIT");
%>

<form name="myForm" action="/Project/InventoryController" method="post" onsubmit="return(validate());">
<table border="1">
<tr><th align="left">Model ID</th><td><input type="text" name="productModelID" value="<%=productmodelinfotable.getProdModelId()%>" readonly="readonly"></td></tr>
<tr><th align="left">Model Name</th><td><input type="text" name="productModelName" value="<%=productmodelinfotable.getProdModelName()%>" readonly="readonly"></td></tr>
<tr><th align="left">Model Description</th><td><input type="text" name="productModelDescription" value="<%=productmodelinfotable.getProdModelDesc()%>"></td></tr>
<tr><th align="left">Model Feature</th><td><input type="text" name="productModelFeature" value="<%=productmodelinfotable.getProdModelFeatures()%>" ></input></td></tr>
<tr><th align="left">Model Price</th><td><input type="text" name="productModelPrice" value="<%=productmodelinfotable.getProdModelPrice()%>"></input></td></tr>
<tr><th align="left">Model Threshold</th><td><input type="text" name="productModelThreshold" value="<%=productmodelinfotable.getProdModelThreshold()%>"></input></td></tr>
</table>
<br/>
<input type="submit" value="Update Model Info"></input>
<input type="hidden" name="action" value="updateModelInfo">
<hr/>
<%@include file="footer.jsp"%>
</form>
</body>
</html>