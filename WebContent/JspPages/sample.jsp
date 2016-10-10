<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IM Home</title>
<link rel="stylesheet" type="text/css" href="/TelecomStoreInventory/css/StyleSheet.css" />
<script type="text/javascript" src="/TelecomStoreInventory/javascript/Homepagescript.js"></script>
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
	               <%@include file="/HtmlPages/IMMenu.html" %>
	                <div id="left_section">
	                	<div class="title">Welcome to TelComm Store</div>
	                	<div id="gray_box_border">
	                        	<div id="gray_box_content" onmouseover="hideallimmenu()">
	                         		<table border="2">
										<tr>
											<td class="tagitems" colspan="4" id="sd"><b>Best Deals</b></td>
										</tr>
										<tr>
											
											<td><img src="../images/newentry/htcexplorer.jpg" width="100px" height="100px" /></td>
											<td><img src="../images/newentry/nokiac203.jpg" width="100px" height="100px" /></td>
											<td><img src="../images/newentry/sgd.jpg"  width="100px" height="100px" /></td>
											<td><img src="../images/newentry/sony.jpg"  width="100px" height="100px" /></td>
										</tr>
										<tr>
											
											<td class="tagproducts">HTC Explorer<br/> Sandisk 4GB <br/>Micro SD Card<br/>Rs 9,050</td>
											<td class="tagproducts">Nokia C2- 03<br/> Sandisk 4GB <br/>Micro SD Card<br/>Rs 3,846</td> 
											<td class="tagproducts">Samsung Galaxy<br/>(Gt S- 6102) <br/>Black<br/>Rs 8,990</td>
											<td class="tagproducts">Sony Ericsson<br/>Sandisk 8GB<br/>Micro SD Card<br/>Rs 17,999</td>			
										</tr>
										<tr>
											<td class="tagitems" colspan="5" id="sd"><b>Tablets</b></td>
										</tr>
										<tr>
											<td><img src="../images/tablets/1.jpg"  width="100px" height="100px" /></td>
											<td><img src="../images/tablets/2.jpg"  width="100px" height="100px" /></td>
											<td><img src="../images/tablets/3.jpg"  width="100px" height="100px" /></td>
											<td><img src="../images/tablets/4.jpg"  width="100px" height="100px" /></td>
										</tr>
										<tr>
											<td class="tagproducts">BlackBerry<br/>Playbook <br/>64 GB,Black<br/>Rs 32,990</td>
											<td class="tagproducts">Samsung Galaxy<br/>Tab 10.1, P7500 <br/>White<br/>Rs 33,890</td>
											<td class="tagproducts">iPad 2 16GB<br/>Wi-Fi + 3G<br/>White<br/>Rs 32,900</td>
											<td class="tagproducts">HTC Flyer<br/>Wi-fi + 3G <br/>White<br/>Rs 38,229</td>
										</tr>
									</table>
	                            </div>
	                </div>
	                </div>
	                 <div id="right_section" onmouseover="hiderewardsubmenu()">
	               	
	                 	<div class="title2">Latest News</div>
			            <div class="text_content3" onmouseover="hideallimmenu()">
			            	The TeleComm Store is a one stop mobile solution shop that provides, multi brand handsets, accessories, connections,
							repairs, VAS etc all under one roof. The MobileStore currently has over 1000 outlets across 150 cities, thus covering virtually 
							every major town in every state across India. ---&gt; The Telegraph
	                    </div>
	                    <div class="read_more_box" onmouseover="hideallimmenu()">
	                    <a href="/TelecomStoreInventory/jsp/more.jsp"><img src="/TelecomStoreInventory/images/read_more.gif" width="59" height="16" border="0" alt="more" class="more" /></a>
	                    </div>
	                    
	                    	
	                    <div class="title2" onmouseover="hideallimmenu()">Testimonials</div>
	                    <div class="text_content2" onmouseover="hideallimmenu()">
	                    	<h2>India Today</h2>
	                    </div>
	                   
	                 </div>
	          <div class="clear" onmouseover="hideallimmenu()"></div>       
	    </div>
	    <div id="footer" onmouseover="hideallimmenu()">
			<div class="footer_links">
	                 
	                 <a href="/TelecomStoreInventory/jsp/contact.jsp" title="">contact us</a>       
	        </div>
	    	<div class="copyright">
	        	<a href="#"><img src="/TelecomStoreInventory/images/footerlink.jpg" alt="footerlink" title="footerlink" border="0" /></a>
	        </div>
		</div>
	</div>

</body>
</html>