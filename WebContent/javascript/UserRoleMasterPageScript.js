function checkDetail()
{
	var detail = document.getElementById("detailentered").Value;
  
	if(detail.toString().length!=0){
        return true;
    }
   else 
   {
	   alert("Enter the parameter to search customer detail");
       return false;
   }
}

function validateform(){
	var formsubmit;
	varsubmit = validatecustomername();
	if(!varsubmit){
		alert("Please enter valid customer name");
		return false;
	}
	
	varsubmit = validatecustomeraddress();
	if(!varsubmit){
		alert("Please enter a valid address");
		return false;
	}
	
	varsubmit = validatepin();
	if(!varsubmit){
		alert("Please enter a valid pin");
		return false;
	}
	
	varsubmit = validatecustomernumber();
	if(!varsubmit){
		alert("Please enter a valid contact number");
		return false;
	}
	
	varsubmit = validateemail();
	if(!varsubmit){
		alert("Please enter a valid email address");
		return false;
	}
	
	 var confirmReply = confirm("Are you sure you want to proceed?");  
	   if(confirmReply==true)
		   return true;
	   else
		   return false;
}


function validatecustomername()
{
	var element = document.getElementById("cname");
	var name=element.value;
	var errdiv = document.getElementById("errcname");
	if(name.length ==0)
	{
		errdiv.innerHTML="<h5 style='color:red;font-size:12;'>Customer Name Cannot Be Empty</h5>";
		return false;
	}
	else if(name.length>25)
	{
		errdiv.innerHTML="<h5 style='color:red;font-size:12;'>Customer Name must be less than 25 characters.</h5>";
		return false;
	}
	else if(name.length>0&&name.length<25){
		var patt=/^[A-Z a-z]+$/;
		var res=patt.test(name);
		if(!res)
		{
			errdiv.innerHTML="<h5 style='color:red;font-size:12;'>Customer Name should be alphabetic</h5>";			
			return false;
		}	
		var str = ltrim(name);
		str = rtrim(str);
		if(str.length==0){
			errdiv.innerHTML="<h5 style='color:red;font-size:12;'>Please enter customer name</h5>";
			return false;
		}
	}
	return true;
}
function removenamealert()
{
	var e=document.getElementById("errcname");
	e.innerHTML="";
}

function ltrim(str){
	return str.replace(/^\s+/,"");
}
function rtrim(str){
	return str.replace(/\s+$/,"");

}
function validatecustomeraddress()
{
	var element = document.getElementById("cprsntadd");
	var pradd=element.value;
	var errdiv = document.getElementById("errcadd");
	
	if(pradd.length>=10){
		if(pradd.length >= 80){
			errdiv.innerHTML="<h5 style='color:red;font-size:12;'>Address cannot be greater than 80 characters</h5>";
			return false;
		}
		else
		{ 
			var str = ltrim(pradd);
			str = rtrim(str);
			if(str.length<10){
				errdiv.innerHTML="<h5 style='color:red;font-size:12;'>Address length has to be atleast 10 characters</h5>";
				return false;
			}
		}
	}
	else if(pradd.length ==0)
	{
		errdiv.innerHTML="<h5 style='color:red;'>Present Address Cannot Be Empty</h5>";
		return false;
	}
	else if(pradd.length<10)
	{
		errdiv.innerHTML="<h5 style='color:red;font-size:12;'>Address length has to be atleast 10 characters</h5>";
		return false;
	}
	
	return true;
}
function removeaddressalert()
{
	var f=document.getElementById("errcadd");
	f.innerHTML="";
}

function validatepin(){
	var element = document.getElementById("cpin");
	var pin=element.value;
	var errdiv=document.getElementById("errcpin");
	
	if(pin.length ==0)
	{		
		errdiv.innerHTML="<h5 style='color:red;font-size:12;'>Pin Number cannot be empty</h5>";
		return false;
	}
	else if(pin.length!=6)
	{
		errdiv.innerHTML="<h5 style='color:red;font-size:12;'>Pin number has to be 6 digits</h5>";
		return false;
	}
	else if(pin.length==6)
	{
		var number = parseInt(pin);		
		if(number==0){
			var c=document.getElementById("errcpin");
			c.innerHTML="<h5 style='color:red;font-size:12;'>Pin Number Invalid!</h5>";	
			return false;
		}
		
		var patt=/^\d+$/;
		var res=patt.test(pin);
		if(!res)
		{
			errdiv.innerHTML="<h5 style='color:red;font-size:12;'>Pin Number must be numeric </h5>";			
			return false;
		}
	}
	return true;
}
function removepinalert()
{
	var f=document.getElementById("errcpin");
	f.innerHTML="";
}

function validatecustomernumber()
{
	var element = document.getElementById("cno");
	var cnum=element.value;
	if(cnum.length ==0)
	{
		var c=document.getElementById("errcnum");
		c.innerHTML="<h5 style='color:red;font-size:12;'>Contact Number Cannot Be Empty</h5>";
		return false;	
	}
	else if(cnum.length>10 || cnum.length<10)
	{
		var c=document.getElementById("errcnum");
		c.innerHTML="<h5 style='color:red;font-size:12;'>Contact Number Must Be 10 Digits</h5>";
		return false;
	}
	else if(cnum.length==10)
	{
	
		var patt=/^\d+$/;
		var res=patt.test(cnum);
		if(!res)
		{
			var c=document.getElementById("errcnum");
			c.innerHTML="<h5 style='color:red;font-size:12;'>Contact Number Must Be Numeric</h5>";	
			return false;
		}
	}
	return true;

}
function removenumber()
{
	var c=document.getElementById("errcnum");
	c.innerHTML="";
}

function echeck(str) 
{
	var patt=/^[a-z0-9_\+-]+(\.[a-z0-9_\+-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*\.([a-z]{2,4})$/;
	var res=patt.test(str);
	if(!res)
	{
		return false;
	}
		/*var at="@";
		var dot=".";
		var lat=str.indexOf(at);
		var lstr=str.length;
		var ldot=str.indexOf(dot);
		var lastdot = str.lastIndexOf(dot);
		
		if (str.indexOf(at)==-1)
		{
		   return false;
		}

		if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr)
		{
		   return false;
		}

		if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr)
		{
		   return false;
		}
		if (str.indexOf(at,(lat+1))!=-1)
		{
		     return false;
		}
		if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot)
		{
		    return false;
		}
		if (str.indexOf(dot,(lat+2))==-1)
		{
		    return false;
		}
		if (str.indexOf(" ")!=-1)
		{
		    return false;
        }
		if(lastdot-ldot==1)
		{
			return false;
		}
		*/
 		 return true;					
	}
function validateemail()
{
	var element = document.getElementById("cemail");
	var eid=element.value;
	if(eid.length ==0)
	{
		var d=document.getElementById("errcemail");
		d.innerHTML="<h5 style='color:red;font-size:12;'>E-Mail Address Cannot Be Empty</h5>";
		return false;
	}
	if(eid.length>0)
	{
		var resp=echeck(eid);
		var e = document.getElementById("errcemail");
		if(resp==false)
		{
			e.innerHTML="<h5 style='color:red;font-size:12;'>E-Mail Address Invalid!!</h5>";
			return false;
		
		}
		else{
			var string = eid.split("@");
			var stringafterat = string[1];
			var count = 0;
			
			for(var i=0;i<stringafterat.length;i++){
				if(stringafterat.charAt(i)=='.'){
					count++;
				}
			}
			
			if(count>3){
				e.innerHTML="<h5 style='color:red;font-size:12;'>E-Mail Address Invalid!!</h5>";
				return false;
			}
		}
	}
	
	return true;
}
function removeemail()
{
	var d=document.getElementById("errcemail");
	d.innerHTML="";
}

function changehomecolor()
{
	var a=document.getElementById("home");
	a.style.color="Black";
}



function resethomecolor()
{
	var a=document.getElementById("home");
	a.style.color="MediumBlue";
}
function changereportcolor()
{
	var a=document.getElementById("report");
	a.style.color="Black";
}
function resetreportcolor()
{
	var a=document.getElementById("report");
	a.style.color="MediumBlue";
}
function changeordercolor()
{
	var a=document.getElementById("order");
	a.style.color="Black";
}
function changedefectcolor()
{
	var a=document.getElementById("defect");
	a.style.color="Black";
}
function resetdefectcolor()
{
	var a=document.getElementById("defect");
	a.style.color="MediumBlue";
}
function changerewardcolor()
{
	var a=document.getElementById("rewards");
	a.style.color="Black";
}
function resetrewardcolor()
{
	var a=document.getElementById("rewards");
	a.style.color="MediumBlue";
}
function resetordercolor()
{
	var a=document.getElementById("order");
	a.style.color="MediumBlue";
}
function showcancelsubmenu()
{
	hideviewsubmenu();
	document.getElementById("cancelordersubmenuholder").style.visibility="visible";
}
function hidecancelsubmenu()
{
	hideviewsubmenu();
	document.getElementById("cancelordersubmenuholder").style.visibility="hidden";
}
function showviewsubmenu()
{
	hidecancelsubmenu();
	document.getElementById("viewordersubmenuholder").style.visibility="visible";
}
function hideviewsubmenu()
{
	document.getElementById("viewordersubmenuholder").style.visibility="hidden";
}
function showrewardsubmenu()
{
	document.getElementById("rewardsubmenuholder").style.visibility="visible";
}
function hiderewardsubmenu()
{
	document.getElementById("rewardsubmenuholder").style.visibility="hidden";
}