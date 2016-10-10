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
<title>View Stock</title>
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
</head>
<body>
<%@include file="header.jsp"%>
<h3 align="center">View the Stock</h3>
<%List<ProductModelInfoTable> pmList=(List<ProductModelInfoTable>)request.getAttribute("list1"); %>
<table align="center" border="2" id="viewstock">
<tr><th>ModelId</th><th>ModelName</th><th>ThresholdValue</th><th>NoOfProductsAvailable</th></tr>
<%for(ProductModelInfoTable pm1:pmList)
	{%>
	<%if(pm1.getProdModelThreshold()>=pm1.getProdModelThreshold1())
		{%>
	<tr><td><div style="color:RED"><%=pm1.getProdModelId()%></div></td><td><%=pm1.getProdModelName()%></td><td><%=pm1.getProdModelThreshold()%></td><td><%=pm1.getProdModelThreshold1()%></td></tr>
	<%}
	else if((pm1.getProdModelThreshold()+10)<=pm1.getProdModelThreshold1()){%>
	<tr><td><div style="color:GREEN">
	<%=pm1.getProdModelId()%></div></td><td><%=pm1.getProdModelName()%></td><td><%=pm1.getProdModelThreshold()%></td><td><%=pm1.getProdModelThreshold1()%></td></tr>
	<%}
	else
	{%>
	<tr><td><div style="color:#1E90FF">
	<%=pm1.getProdModelId()%></div></td><td><%=pm1.getProdModelName()%></td><td><%=pm1.getProdModelThreshold()%></td><td><%=pm1.getProdModelThreshold1()%></td></tr>
	<%
	}
	%>
<%}
%>
</table>
<br/>
<div align="center" id="pageNavPosition" onmouseover="this.style.cursor='hand'">
<script type="text/javascript"><!--
        var pager = new Pager('viewstock',8); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
       </script>
       </div>
<h4>LEGEND</h4>
<table border="1" cellpadding="5">
<tr><td bgcolor="red" colspan="20"></td><th>Below Threshold Value</th></tr>
<tr><td bgcolor="green" colspan="20"></td><th>Above Threshold Value</th></tr>
<tr><td bgcolor="#1E90FF" colspan="20"></td><th>Nearer to Threshold value</th></tr>
</table>
<%@include file="footer.jsp"%>
</body>
</html>