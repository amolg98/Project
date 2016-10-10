<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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
 	
 	
 	
	<div id="main_content">
		<div id="top_banner" onmouseover="hideallimmenu()"></div>
		<div id="page_content" onclick="hideallimmenu()">
	               <%@include file="../JspPages/IMMenu.jsp" %>
	                <div id="left_section" onmouseover="hideallimmenu()">
	                	<div class="title">Welcome to TeleCom Store Inventory</div>
	                	<br></br>
	                   
	                   
	                	<table border="1">
	                	<tr>
										<td><img src="../images/images/samsung.JPG" width="500px" height="400px" /></td>
										</tr>
							</table>			
	                </div>
	             
	               
	                
	        		<div id="right_section" onmouseover="hideallimmenu()">
	                 	
	                 	<div class="title2">Latest News</div>
			            <div class="text_content3" onmouseover="hideallimmenu()">
			            	The TeleComm Store is a one stop mobile solution shop that provides multi brand handsets, accessories, connections,
							VAS etc all under one roof. The MobileStore currently has over 1000 outlets across 150 cities, thus covering virtually 
							every major town in every state across India. ---&gt; The Telegraph
	                    </div>
	                 </div>
	                </div>	
	          
	    <div class="clear" onmouseover="hideallimmenu()"></div> 
	    <div id="footer" onmouseover="hideallimmenu()">
			<div class="footer_links">
	                 
	                 <a href="/Project/JspPages/contact.jsp" title="">contact us</a>       
	        </div>
	    	
		</div>
	</div>

</body>
</html>


