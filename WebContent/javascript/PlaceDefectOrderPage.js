
function validate()
{
	var a=form1.description.value;
	if(a.length==0 ||a.length<=25){
		alert("enter the description");
		return  true;
		
}
	
function confirmOrder(){
	   var confirmReply = confirm("Are you sure you want to proceed?");  
	   if(confirmReply==true)
		   return true;
	   else
		   return false;
	}