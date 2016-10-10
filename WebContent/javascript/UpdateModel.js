function validate()
{
 
  var regInt=/^[0-9]*$/;
  var regFloat=/^((\d+(\d*)?)|((\d*\.)?\d+))$/;
  var regSpaces=/\s\s/;
  var regStringup=/^[a-zA-Z0-9,]*$/;
  var modelId=document.myForm.prodModelId.value;
  var first=modelId.indexOf(" ");
  var last=modelId.lastIndexOf(" ");
  var regSingleSpace=/\s/;


if(document.myForm.prodModelFeatures.value=="")
  {
   alert("please enter ModelFeatures");
    return false;
    }
 if(document.myForm.prodModelFeatures.value=='null')
{
alert("ModelFeatures should not be null");
 return false;
}
if(document.myForm.prodModelFeatures.value.search(regStringup)==-1)
{
 alert("modelFeatures should not contain special characters");
 return false;
}
if(!(document.myForm.prodModelFeatures.value.search(regSpaces)==-1))
{
 alert("modelFeatures should not contain two consecutive spaces");
 return false;
}
if(document.myForm.prodModelPrice.value=="")
  {
   alert("please enter modelPrice");
    return false;
    }
 
if(document.myForm.prodModelPrice.value.search(regFloat)==-1)
{
 alert("Price should be in ##/###.## format");
 return false;
}
if(document.myForm.prodModelPrice.value.search(regSingleSpace)==-1)
{
 alert("Price cannot containg any space(s)");
 return false;
}

if(document.myForm.prodModelThreshold.value=="")
  {
   alert("please enter modelThreshold");
    return false;
    }
 
if(document.myForm.prodModelThreshold.value.search(regInt)==-1)
{
 alert("modelThreshold should be in #####");
 return false;
}

return true;
}