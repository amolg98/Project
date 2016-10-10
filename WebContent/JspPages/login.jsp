<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<body onload="slideit();">

<div id="main_content">
		<div id="top_banner" onmouseover="hideallimmenu()"></div>
		<div id="page_content" onclick="hideallimmenu()">
	               <%@include file="../HtmlPages/IMMenu.html" %>
	               <div class="title" align="left">Welcome to Telecom Store Inventory</div>
		<div id="left_section">
	                	
	                	<div id="gray_box_border">
	                		<div id="gray_box_content1">
	                      		<img src="/Project/images/Slideshow/sd.jpg" align="left" name="slide" width="450px" height="205px" />
	                    	</div>
	                    </div>
	                    	
	                   </div> 
	                   
		 
	        		<div id="right_section" onmouseover="hiderewardsubmenu()">
	        			<BR>
						<BR>
						<BR>
						<BR>
	                 	<% if(request.getParameter("valid")!=null)
						{
							out.println("<font color='red'>Invalid Login</font>");
						} 
						%>
	                 	<form action="<%=request.getContextPath() %>/LoginController"
						method="Post">
						<table>
						<tr>
						<td colspan="2"><i>Login Page</i></td>
						</tr>
						<tr>
						<td>Username :</td>
						<td><input type="text" name="username" value=""></td>
						</tr>
						<tr>
							<td>Password :</td>
							<td><input type="password" name="password" value=""></td>
							<input type="hidden" name="login" value="login"/>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="Submit" value="Login" /></td>
						</tr>
						</table>
						</form>
	                   
	               </div>
					   
		<BR></BR>
						
					
	</div>
	<BR></BR>
	 <br/>
	 <br/>
	 <div id="footer" onmouseover="hideallimmenu()">
					<div class="footer_links">
						                 
					<a href="/Project/jsp/contact.jsp" title="">contact us</a>       
			</div>
			 <div class="clear" onmouseover="hideallimmenu()"></div>   
	    	
		</div>
</div>
		
		
		

</body>
</html>