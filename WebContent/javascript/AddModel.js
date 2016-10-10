function f(o)
{
	o.value=o.value.toUpperCase().replace(/([^0-9A-Z ])/g,"");
}

 function validate()
{
  var regString=/^[A-Z0-9 ]*$/;
  var regInt=/^[0-9]*$/;
  var regFloat=/^[0-9.]*$/;
  //var regFloat=/^((\d+(\d*)?)|((\d*\.)?\d+))$/;
  var regSpaces=/\s\s/;
  var regStringdesc=/^[a-zA-Z0-9.)( ]*$/;
  var regStringup=/^[a-zA-Z0-9-, ]*$/;
  var modelId=document.myForm.prodModelId.value;
  var first=modelId.indexOf(" ");
  var last=modelId.lastIndexOf(" ");
  var modelPrice=document.myForm.prodModelPrice.value;
  var zero=modelPrice.indexOf("0");
  var space=modelPrice.indexOf(" ");
  var modelThreshold=document.myForm.prodModelThreshold.value;
  var zero1=modelThreshold.indexOf("0");
  var space1=modelThreshold.indexOf("0");
  var an = /^[0-9 ]+$/;
 if(document.myForm.prodModelId.value=="")
  {
   alert("Please enter model id");
    return false;
    }
 if(document.myForm.prodModelId.value=='null')
{
alert("Model id should not be null");
 return false;
}
if((last-first)>0)
{
 alert("There should not be more than one space in modelId");
return false;
}
if( !(document.myForm.prodModelId.value.search(an)==-1) ) 
{
	alert("Model id is not alphanumeric");
	return false; 
} 
if(document.myForm.prodModelName.value=="")
  {
   alert("Please enter model name");
    return false;
    }
 if(document.myForm.prodModelName.value=='null')
{
alert("ModelName should not be null");
 return false;
}
if( !(document.myForm.prodModelName.value.search(an)==-1) ) 
{
	alert("Model name is not alphanumeric");
	return false; 
} 
if(!(document.myForm.prodModelName.value.search(regSpaces)==-1))
{
 alert("Model name should not contain two consecutive spaces");
 return false;
}
if(document.myForm.prodModelDesc.value=="")
  {
   alert("Please enter model description");
    return false;
    }
 if(document.myForm.prodModelDesc.value=='null')
{
alert("Model description should not be null");
 return false;
}
if(document.myForm.prodModelDesc.value.search(regStringdesc)==-1)
{
 alert("Model description should not contain special characters");
 return false;
}
if(!(document.myForm.prodModelDesc.value.search(regSpaces)==-1))
{
 alert("Model description should not contain two consecutive spaces");
 return false;
}
if( !(document.myForm.prodModelDesc.value.search(an)==-1) ) 
{
	alert("Description cannot be only number");
	return false; 
} 
if(document.myForm.prodModelFeatures.value=="")
  {
   alert("Please enter model features");
    return false;
    }
 if(document.myForm.prodModelFeatures.value=='null')
{
alert("Model features should not be null");
 return false;
}
if(document.myForm.prodModelFeatures.value.search(regStringup)==-1)
{
 alert("Model features should not contain special characters");
 return false;
}
if(!(document.myForm.prodModelFeatures.value.search(regSpaces)==-1))
{
 alert("Model features should not contain two consecutive spaces");
 return false;
}
if( !(document.myForm.prodModelFeatures.value.search(an)==-1) ) 
{
	alert("Feature cannot be only number");
	return false; 
} 
if(document.myForm.prodModelPrice.value=="")
{
   alert("Please enter model price");
    return false;
}
if(zero==0)
{
	alert("Price cannot start from zero");
	return false;
}
if(space==0)
{
	alert("First letter cannot be space");
	return false;
}
 
if(document.myForm.prodModelPrice.value.search(regFloat)==-1)
{
 alert("Price should be in ##/###.## format");
 return false;
}
if(document.myForm.prodModelThreshold.value=="")
  {
   alert("Please enter model threshold");
    return false;
 }
 
if(zero1==0)
{
	alert("Threshold cannot start from zero");
	return false;
}
if(space1==0)
{
	alert("First letter cannot be space");
	return false;
}
if(document.myForm.prodModelThreshold.value.search(regInt)==-1)
{
 alert("Model threshold should be in #####");
 return false;
}
return true;
}