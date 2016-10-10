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
    <%@page  import="java.util.List" %>
    <%@ page import="com.tcs.ilp.tsis.model.*" %>
	<%@ page import="java.sql.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View retailers tagged to models</title>
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
<h3 align="center">View retailers tagged to models</h3>
<% List<Retailer> list = (List<Retailer>)request.getAttribute("list1");%>
<table border="1" align="center" id="viewtagged">
<tr><th>Retailer Id</th><th>Product ModelId</th><th>Tagged_Date</th></tr>
<% 
for(Retailer tag:list)
{
%>
<tr><td><%=tag.getRetailerId()%></td><td><%=tag.getProductModelId()%></td><td><%=tag.getTaggeddate()%></td></tr>
<%
}
%>
</table>
<div align="center" id="pageNavPosition" onmouseover="this.style.cursor='hand'">
<script type="text/javascript"><!--
        var pager = new Pager('viewtagged',10); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
       </script>
       </div>
<%@include file="footer.jsp"%>
</body>
</html>