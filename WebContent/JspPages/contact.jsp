<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
</head>
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

<body>
<%@include file="header.jsp" %>
<h3>Corporate Offices</h3><br>
				<table border="2">
				<tr>
				<td>
				<strong>Mumbai</strong><br>
                                206, Madhava, Bandra Kurla Complex, <br>Bandra (E),
				 Mumbai- 400 051. <br>
                                Ph: 022-26590022 
                                Fax No. 022-26590337 <BR><BR><BR>
				</td>
				<td>
                                <strong>Delhi</strong><br>
                              Plot No.262, 1st Floor, 
                              ITDC, Five Senses Road, Saidulajab<BR>
                              M.B. Road, New   Delhi -110 030<BR>
                              Phone cum Fax: 011-29535168/69 <BR><BR><BR></td>
			      </tr>
			      <tr>
				<td>
                              <strong>Chennai</strong><br>
                              No.267, First Floor, Kilpauk Garden Road, <br>
				Chennai- 600 010. <br>
                              Ph: 044-26447333, 
                              Fax No. 044-26443282 <BR><BR><BR></td>
				<td>
                              <STRONG>Kolkata</STRONG><BR>
                              76, BB Ganguli   Street, 
                              Ground Floor, Block-C, Room No.7<BR>
                              Kolkata-700012<BR>
                              Ph: <SPAN id="lw_1278068937_3">09332395749</SPAN> <BR><BR><BR></td>
				</tr>
				<tr>
				<td>
                              <strong>Bangalore</strong><br>
                              207, Universal Business Centre<BR>
                              10/2, Victoria Road<BR>
                              Bangalore &ndash; 560 047 <BR>
                              Ph: 080-25554900;Fax : 080-40316201
				</td>
				<td>
                              <strong>Pune</strong><br>
                              No 109, Swapnanagari, Udhyam Nagar<BR>
                              Opp. Magar Stadium, Pimpri<BR>
                              Pune -   411018<BR>
                              Ph: 020-27502255 </td>
</tr></table>
                              
                            
		
<%@include file="footer.jsp" %>
</body>
</html>