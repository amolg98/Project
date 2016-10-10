var image1="/Project/images/Slideshow/cod.jpg";
var image2="/Project/images/Slideshow/fship.jpg";
var image3="/Project/images/Slideshow/sd.jpg";
var step=1;


function slideit()
{
	//if browser does not support the image object, exit.
	if (!document.images)
	return
	document.images.slide.src=eval("image"+step);
	
	if (step<3)
	step++;
	else
	step=1;
	//call function "slideit()" every 2.5 seconds
	setTimeout("slideit()",2500);
}
function checkDetail(){
	var element = document.getElementById("detailentered");
	var detail = element.value;
	if(detail.length==0)
	{
		alert("Enter the parameter to search!");
		return false;
	}
	else
	{
		var patt=/^[A-Z \/0-9a-z]+$/;
		var res=patt.test(detail);
	
		if(!res)
		{
			alert("Enter a valid search parameter!");			
			return false;
		}
		
		var str=ltrim(detail);
    	str=rtrim(str);
    	if(str.length==0){
    		alert("Enter the parameter to search!");
    	return false;
    	}    	
    	
     }
	return true;
}


function resetField(){
	document.getElementById("reportmessage").innerHTML="";
}
function validate()
{
		var uname=document.getElementById("uname");
		var pass=document.getElementById("passwrd");
		if(uname.toString().length==0 || pass.toString().length==0)
		{
			alert("Fill it up");
		}
}
function setImageVisible()
{
	var e = document.getElementById("searchselection");
	var selection = e.options[e.selectedIndex].value; 
	if(selection=="orderdate")
	{
		document.getElementById("Calendar").style.visibility="visible";
		document.getElementById("inputdetails").readOnly=true;
	}
	else
	{
		document.getElementById("Calendar").style.visibility="hidden";
		document.getElementById("inputdetails").readOnly=false;
	}
	selection="";
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
	hiderewardsubmenu();
}
function enablemodify(){
	document.getElementById("name").disabled = "false";
	document.getElementById("address").disabled = "false";
		document.getElementById("email").disabled = "false";
	document.getElementById("contact").disabled = "false"; 
}
function showcustomerordersubmenu()
{
	document.getElementById("customerordersubmenu").style.visibility="visible";
}
function hidecustomerordersubmenu()
{
	document.getElementById("customerordersubmenu").style.visibility="hidden";
}
function changeselection(length, type)
{
	
}
function changesimstatus(e,size)
{
	var x=e.value;
	for(i=0;i<=size;i++)
	{
		if(x=="Select SIM Type")
		{
			if(document.getElementById("s"+i).value!="null")
			document.getElementById("s"+i).value="sim";
		}
		else if(document.getElementById("s"+i).value!="null")
		document.getElementById("s"+i).value=x;
	}
}
function changehandsetstatus(e,size)
{
	var x=e.value;
	for(i=0;i<=size;i++)
	{
		if(x=="Select Handset Type")
		{
			if(document.getElementById("h"+i).value!="null")
			document.getElementById("h"+i).value="handset";
		}
		else if(document.getElementById("h"+i).value!="null")
		document.getElementById("h"+i).value=x;
	}
}
function hiderewardsubmenu()
{
	document.getElementById("rewardsubmenu").style.visibility="hidden";
}
function showrewardsubmenu()
{
	hiderewardsubmenu1();
	hiderewardsubmenu2();
	document.getElementById("rewardsubmenu").style.visibility="visible";
}
function hiderewardsubmenu1()
{
	document.getElementById("rewardsubmenu1").style.visibility="hidden";
}
function showrewardsubmenu1()
{
	hiderewardsubmenu();
	hiderewardsubmenu2();
	document.getElementById("rewardsubmenu1").style.visibility="visible";
}
function hiderewardsubmenu2()
{
	document.getElementById("rewardsubmenu2").style.visibility="hidden";
}
function showrewardsubmenu2()
{
	hiderewardsubmenu();
	hiderewardsubmenu1();
	document.getElementById("rewardsubmenu2").style.visibility="visible";
}
/*function showreportsubmenu()
{
	hiderewardsubmenu();
	document.getElementById("reportsubmenu").style.visibility="visible";
}
function hidereportsubmenu()
{
	document.getElementById("reportsubmenu").style.visibility="hidden";
}*/

function hideallimmenu()
{
	hiderewardsubmenu();
	hiderewardsubmenu1();
	hiderewardsubmenu2();
	hidereportsubmenu();
}

function prev(noOfPages){
	
	var pageNumber = parseInt(document.getElementById("pageNumber").innerHTML);	
	if(pageNumber==0){
	    alert("No page before this!");
	}
	else{
		for(i=0;i<=noOfPages;i++){
			document.getElementById(i).style.visibility = "hidden";
		}
		
		pageNumber--;
		document.getElementById(pageNumber).style.visibility = "visible";
	    document.getElementById("pageNumber").innerHTML = pageNumber;
	    document.getElementById("visiblePageNumber").innerHTML = (pageNumber+1);
	    
	}
}
function next(noOfPages,size){
	var pageNumber = parseInt(document.getElementById("pageNumber").innerHTML);	
    var isMultipleOfTen;
	if(size%10==0){
		isMultipleOfTen = true;
	}
	else
		isMultipleOfTen = false;
    	
	if((!isMultipleOfTen)&&(pageNumber!=0)&&(pageNumber==noOfPages)){
	    alert("No page after this!");
	}
	else if((isMultipleOfTen)&&(pageNumber!=0)&&(pageNumber==(noOfPages-1))){
		 alert("No page after this!");
	}
	else{
		for(i=0;i<=noOfPages;i++){
			document.getElementById(i).style.visibility = "hidden";
		}
		pageNumber++;
	    document.getElementById(pageNumber).style.visibility = "visible";
	    document.getElementById("pageNumber").innerHTML = pageNumber;
	    document.getElementById("visiblePageNumber").innerHTML = (pageNumber+1);
		  
	}
}

function sort_table(x)
{
 m=document.getElementById('tblData');

 for(i=1;i<m.rows.length-1;i++)
 {
  for(j=i+1;j<m.rows.length;j++)
  {
   var cmp=-1;
   if(x==2)
      cmp=m.rows[i].cells[x].childNodes[0].data >m.rows[j].cells[x].childNodes[0].data;
    if(x==3)
     cmp=parseInt(m.rows[i].cells[x].childNodes[0].data) > parseInt(m.rows[j].cells[x].childNodes[0].data);
    if(x==1)
    cmp=m.rows[i].cells[x].childNodes[0].data > m.rows[j].cells[x].childNodes[0].data;
    if(x==0)
    cmp=parseInt(m.rows[i].cells[x].childNodes[0].data) >parseInt( m.rows[j].cells[x].childNodes[0].data);
    if(x==5)
    {
    	var temp1="";
    	var temp2="";        
    	var str1 = m.rows[i].cells[x].childNodes[0].data;         
        var str2 = m.rows[j].cells[x].childNodes[0].data;          
        var dt1  = str1.substring(0,2);         
        var mon1 = str1.substring(3,5);         
        var yr1  = str1.substring(6,10);          
        var dt2  = str2.substring(0,2);         
        var mon2 = str2.substring(3,5);          
        var yr2  = str2.substring(6,10);          
        temp1 = mon1 +"/"+ dt1 +"/"+ yr1;        
        temp2 = mon2 +"/"+ dt2 +"/"+ yr2;          
        var cfd = Date.parse(temp1);         
        var ctd = Date.parse(temp2);           
        var date1 = new Date(cfd);          
        var date2 = new Date(ctd); 
        cmp= date1<date2;
    }
    if(x==6)
    {
    	var temp1="";
    	var temp2="";        
    	var str1 = m.rows[i].cells[x].childNodes[0].data;         
        var str2 = m.rows[j].cells[x].childNodes[0].data;          
        var dt1  = str1.substring(0,2);         
        var mon1 = str1.substring(3,5);         
        var yr1  = str1.substring(6,10);          
        var dt2  = str2.substring(0,2);         
        var mon2 = str2.substring(3,5);          
        var yr2  = str2.substring(6,10);          
        temp1 = mon1 +"/"+ dt1 +"/"+ yr1;        
        temp2 = mon2 +"/"+ dt2 +"/"+ yr2;          
        var cfd = Date.parse(temp1);         
        var ctd = Date.parse(temp2);           
        var date1 = new Date(cfd);          
        var date2 = new Date(ctd); 
        cmp= date1<date2;
    }
   if(x==4)
        cmp=m.rows[i].cells[x].childNodes[0].data > m.rows[j].cells[x].childNodes[0].data;
   if(cmp)
   {
    for(k=0;k<7;k++)
    {
     t=m.rows[i].cells[k].childNodes[0].data;
     m.rows[i].cells[k].childNodes[0].data=m.rows[j].cells[k].childNodes[0].data;
     m.rows[j].cells[k].childNodes[0].data=t;
    }
   }
  }
 }
 
}
function checkselection()
{
	var flag=99;
	if(document.getElementById("globalsimselection").value=="Select SIM Type")
	{
		alert("Select SIM Type");
		flag=15;
		return(false);
	}
	if(document.getElementById("globalhandsetselection").value=="Select Handset Type")
	{
		alert("Select Handset Type");
		flag=15;
		return(false);
	}
	if(flag==15)
	{
		return(true);
	}
	
}

function confirmSubmit(){
	   var confirmReply = confirm("Are you sure you want to proceed?");  
	   if(confirmReply==true)
		   return true;
	   else
		   return false;
	}
function validateOrderId(){
	var a=document.form.orderid.value.length;
	if(a==0){
		document.getElementById("side_section").innerHTML="Please enter the order id";
		return false;
	}
	return true;
}
function ltrim(str){
	return str.replace(/^\s+/,"");
}
function rtrim(str){
	return str.replace(/\s+$/,"");
}

function validateDescription(){
    var desc=document.form.description.value;
          if(desc.length<=20){
    document.getElementById("side_section").innerHTML="Please enter atleast 20 characters in the description";
    return false;
    }
       else if(desc.length>=20){
    	var str=ltrim(desc);
    	str=rtrim(str);
    	if(str.length<=20){
    		document.getElementById("side_section").innerHTML="Please enter atleast 20 characters in the description";
    	return false;
        }
    	else if(str.length>=150){
    		document.getElementById("side_section").innerHTML="Please enter maximum of 150 characters in the description";
        	return false;
    	}
    	var patt=/^[A-Z0-9 a-z]+$/;
		var res=patt.test(desc);
		if(!res)
		{
			document.getElementById("side_section").innerHTML="Product Description should have valid characters";
			return false;
		}

       }
    	return true;
}
function validateCustomerId(){
	var a=document.form.customerId.value;
	if(a.length==0 ||isNAN(a)){
		document.getElementById("side_Section").innerHTML="Please enter the customer id";
		return false;
	}
	return true;
}
function validateId(){
	var search=document.form.detailentered.value;
	if(search.length<=0){
		alert("please enter the value");
		
		return false;
	}
	return true;
}
function validateDetails(){
	var search=document.form.detailentered.value.length;	
		if(search<=0){
		alert("please enter the value in seach field provided");
		return false;
		}
		return true;
		}


function removeerrormessage(){
   document.getElementById("errormessage").innerHTML = "";
}
 

function Pager(tableName, itemsPerPage) {   
    this.tableName = tableName;   
    this.itemsPerPage = itemsPerPage;   
    this.currentPage = 1;   
    this.pages = 0;   
    this.inited = false;   
       
    this.showRecords = function(from, to) {           
        var rows = document.getElementById(tableName).rows;   
        // i starts from 1 to skip table header row   
        for (var i = 1; i < rows.length; i++) {   
            if (i < from || i > to)     
                rows[i].style.display = 'none';   
            else   
                rows[i].style.display = '';   
        }   
        }  
       
    this.showPage = function(pageNumber) {   
     if (! this.inited) {   
      alert("not inited");   
      return;   
     }   
  
        var oldPageAnchor = document.getElementById('pg'+this.currentPage);   
        oldPageAnchor.className = 'pg-normal';   
           
        this.currentPage = pageNumber;   
        var newPageAnchor = document.getElementById('pg'+this.currentPage);   
        newPageAnchor.className = 'pg-selected';   
           
        var from = (pageNumber - 1) * itemsPerPage + 1;   
        var to = from + itemsPerPage - 1;   
        this.showRecords(from, to);   
    }      
       
    this.prev = function() {   
        if (this.currentPage > 1)   
            this.showPage(this.currentPage - 1);   
    }   
       
    this.next = function() {   
        if (this.currentPage < this.pages) {   
            this.showPage(this.currentPage + 1);   
        }   
    }                           
       
    this.init = function() {   
        var rows = document.getElementById(tableName).rows;   
        var records = (rows.length - 1);    
        this.pages = Math.ceil(records / itemsPerPage);   
        this.inited = true;   
    }   
  
    this.showPageNav = function(pagerName, positionId) {   
     if (! this.inited) {   
      alert("not inited");   
      return;   
     }   
     var element = document.getElementById(positionId);   
        
     var pagerHtml = '<span onclick="' + pagerName + '.prev();" class="pg-normal"> « Prev </span> | ';   
        for (var page = 1; page <= this.pages; page++)    
            pagerHtml += '<span id="pg' + page + '" class="pg-normal" onclick="' + pagerName + '.showPage(' + page + ');">' + page + '</span> | ';   
        pagerHtml += '<span onclick="'+pagerName+'.next();" class="pg-normal"> Next »</span>';               
           
        element.innerHTML = pagerHtml;   
    }   
}   
  
 

	


function orderValidate(radiobutton){
	
	if(radiobutton.value=="Yes"){
		document.getElementById("customerdiv").style.visibility = "visible";
	}
	else
	{
	    history.go(-1);
	}
	
}



