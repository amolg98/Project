function refresh()
   {
	    for(i=0;i<3;i++){
        document.getElementById("th"+i).style.visibility="hidden";
        document.getElementById("ts"+i).style.visibility="hidden";
        document.getElementById("ta"+i).style.visibility="hidden";
   	 }
        document.getElementById("display").innerHTML=" ";
        document.getElementById('productselection').reset();
    }

function storeprice(elem)
     {      
          var prodid="t"+elem.id;
          var qty=elem.value;
          var price=document.getElementById(prodid).value;
          var totalprice=price*qty;
          var a=document.getElementById("total").value;
          var finaltotal=parseInt(a)+totalprice;
          document.getElementById("total").value=finaltotal;
          var prodname;
          switch(prodid)
          {
             case 'th1':prodname="Galaxy Tab 680";
                        break;
             case 'th2':prodname="Galaxy S plus";
                        break;
             case 'th3':prodname="Galaxy SII 19100";
                        break;
             case 'ts1':prodname="Vodafone"; 
                        break;
             case 'ts2':prodname="Docomo";
                        break;
             case 'ts3':prodname="Airtel"; 
                        break;
             case 'ta1':prodname="Headset";
                        break;
             case 'ta2':prodname="Memory Card 2GB";
                        break;
             case 'ta3':prodname="Mobile battery";
                        break;
         }
        
       var a=document.getElementById("display").innerHTML;
       document.getElementById("display").innerHTML=a+"<br/><br/>Product:"+prodname+"<br/> Qty:"+qty+"<br/>Price:"+totalprice;
      
     }


     function enabletextbox(cid)
     {
    	 //cid is the checkbox id
         var checkboxid=cid.id;
         var textboxid="t"+checkboxid;
         var count;
         if(cid.checked==true)
         {
           document.getElementById(textboxid).style.visibility="visible"; 
           count = parseInt(document.getElementById("productselectedcount").value);
           count++;
           document.getElementById("productselectedcount").value = count;
         }
         if(cid.checked==false)
         {       
           document.getElementById(textboxid).style.visibility="hidden";    
           document.getElementById(textboxid).value="0";  
           count = parseInt(document.getElementById("productselectedcount").value);
           count--;
           document.getElementById("productselectedcount").value = count;
         }
     }
     function showprice()
     {
         document.getElementById("total").style.visibility="visible";
     }
     
     function moveup(elementtobemoved,hcount,scount,acount)
     {
    	
    	 document.getElementById("blankdiv").style.visibility="hidden";
    	 document.getElementById("maindiv").style.visibility="visible";
    	 document.getElementById("maindivbutton").style.visibility="visible";
    	 document.getElementById("linksdiv").style.visibility="visible";
    	 
    	 var hcount = parseInt(document.getElementById("hcount").value);
    	 var scount = parseInt(document.getElementById("scount").value);
    	 var acount = parseInt(document.getElementById("acount").value);
    	 
        if(elementtobemoved=="handset")
        {
           document.getElementById("handset").style.visibility="visible";
           document.getElementById("sims").style.visibility="hidden";
           document.getElementById("accessories").style.visibility="hidden";
           
           for(i=1;i<=scount;i++){
             document.getElementById("tS"+i).style.visibility="hidden";
           }
           for(i=1;i<=acount;i++){
               document.getElementById("tA"+i).style.visibility="hidden";
               }
           for(i=1;i<=hcount;i++){
               document.getElementById("tH"+i).style.visibility="hidden";
               }
           for(i=1;i<=hcount;i++){
        	   if(document.getElementById("H"+i).checked==true)
            	   document.getElementById("tH"+i).style.visibility="visible";  	   
               }
                    
        } 
        else if(elementtobemoved=="sims")
        {
        	  document.getElementById("handset").style.visibility="hidden";
              document.getElementById("sims").style.visibility="visible";
              document.getElementById("accessories").style.visibility="hidden";
              
              for(i=1;i<=hcount;i++){
              document.getElementById("tH"+i).style.visibility="hidden";
              }
              for(i=1;i<=acount;i++){
                  document.getElementById("tA"+i).style.visibility="hidden";
                  }
              for(i=1;i<=scount;i++){
                  document.getElementById("tS"+i).style.visibility="hidden";
              }
              for(i=1;i<=scount;i++){
           	   if(document.getElementById("S"+i).checked==true)
               	   document.getElementById("tS"+i).style.visibility="visible";
                  }
           
        }
        else if(elementtobemoved=="accessories")
        {
        	  document.getElementById("handset").style.visibility="hidden";
              document.getElementById("sims").style.visibility="hidden";
              document.getElementById("accessories").style.visibility="visible";
              
              for(i=1;i<=hcount;i++){
            	  document.getElementById("tH"+i).style.visibility="hidden";
              }
              for(i=1;i<=scount;i++){
                  document.getElementById("tS"+i).style.visibility="hidden";
                  }
              for(i=1;i<=acount;i++){
                  document.getElementById("tA"+i).style.visibility="hidden";
                  }
              for(i=1;i<=acount;i++){
           	   if(document.getElementById("A"+i).checked==true)
               	   document.getElementById("tA"+i).style.visibility="visible";
                  }
        }
     }
     

function changehomecolor()
{
	var a=document.getElementById("home");
	a.style.color="white";
}
function resethomecolor()
{
	var a=document.getElementById("home");
	a.style.color="black";
}
function changereportcolor()
{
	var a=document.getElementById("report");
	a.style.color="white";
}
function resetreportcolor()
{
	var a=document.getElementById("report");
	a.style.color="black";
}
function changeordercolor()
{
	var a=document.getElementById("order");
	a.style.color="white";
}
function resetordercolor()
{
	var a=document.getElementById("order");
	a.style.color="black";
}
function showordersubmenu()
{
	hidecustomermenu();
	hidedefectsubmenu();
	document.getElementById("ordersubmenu").style.visibility="visible";
}
function showcustomersubmenu()
{
	hideordermenu();
	hidedefectsubmenu();
	document.getElementById("customersubmenu").style.visibility="visible";
}
function showdefectsubmenu()
{
	hideordermenu();
	hidecustomermenu();
	document.getElementById("defectsubmenu").style.visibility="visible";
}
function hideordermenu()
{
	document.getElementById("ordersubmenu").style.visibility="hidden";
}
function hidecustomermenu()
{
	document.getElementById("customersubmenu").style.visibility="hidden";
}
function hidedefectsubmenu()
{
	document.getElementById("defectsubmenu").style.visibility="hidden";
}
function hideallmenu()
{
	hideordermenu();	
	hidecustomermenu();
	hidedefectsubmenu();
}

function checkNumeric(qty){
	var patt=/^\d+$/;
	var res=patt.test(qty.value);
	if(!res)
	{
		alert("Quantity entered must be numeric");
		qty.focus();
		return false;
	}
	return true;
}
function confirmOrder(){
	var hcount = parseInt(document.getElementById("hcount").value);
	var scount = parseInt(document.getElementById("scount").value);
	var acount = parseInt(document.getElementById("acount").value);
	//alert(hcount+" "+scount+" "+acount);
	var count = parseInt(document.getElementById("productselectedcount").value);
	var i;
	var flag;
	if(count == 0){
		alert("No products selected! Please select atleast one product to place order!");
		return false;
	}
	else{
		for(i=1;i<=hcount;i++){
			if(document.getElementById("H"+i).checked==true){
				var element = document.getElementById("tH"+i);
				var qty = parseInt(element.value);
				if(qty==0){
					
					alert("Quantity of product selected cannot be 0");
					return false;
					document.getElementById("tH"+i).focus();
					
				}
				else
				{							
					flag = checkNumeric(element);
				    if(!flag){
				    	return false;
				    	
				    }
				}
			}
		}
		for(i=1;i<=scount;i++){
			if(document.getElementById("S"+i).checked==true){
				var element = document.getElementById("tS"+i);
				var qty = parseInt(element.value);
				if(qty==0){
					
					alert("Quantity of product selected cannot be 0");
					return false;					
				}
				else
				{							
					flag = checkNumeric(element);
					 if(!flag){
					    	return false;					    
					    }
				}
			}
		}
		for(i=1;i<=acount;i++){
			if(document.getElementById("A"+i).checked==true){
				var element = document.getElementById("tA"+i);
				var qty = parseInt(element.value);
				if(qty==0){
					alert("Quantity of product selected cannot be 0");
					return false;
				
				
				}
				else
				{
							
					flag = checkNumeric(element);
					 if(!flag){
					    	return false;
					    	
					    }
				}
			}
		}

	}
	var confirmReply = confirm("Are you sure you want to proceed?");  
	if(confirmReply==true)
		 return true;
	else
	     return false;	
}

function checkValue(textbox){
	var textvalue = textbox.value;

}
