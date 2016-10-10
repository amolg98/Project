function fun()
{
   var regString=/^[a-zA-Z0-9]*$/;
  var regInt=/^[0-9]*$/;
  var regFloat=/^((\d+(\d*)?)|((\d*\.)?\d+))$/;
  var regSpaces=/\s\s/;
  var code=document.myForm.code.value;
  var first=code.indexOf(" ");
  var last=code.lastIndexOf(" ");
   var modelId=document.myForm.mid.value;
  var first1=modelId.indexOf(" ");
  var last1=modelId.lastIndexOf(" ");
 

if(document.forms["myForm"]["code"].value=="")
{
 alert("Please enter  product code");
 return false;
}
 if(document.forms["myForm"]["code"].value=='null')
{
alert("Product code should not be null");
return false;
}
if(document.myForm.code.value.search(regString)==-1)
{
 alert("Product code should not contain special characters");
 document.myForm.code.select();
 return false;
}
if((last-first)>0)
{
 alert("There should not be more than one space in product code");
return false;
}

 if(document.myForm.mid.value=="")
  {
   alert("Please enter model id");
    return false;
    }
 if(document.myForm.mid.value=='null')
{
alert("Model id should not be null");
 return false;
}
if(document.myForm.mid.value.search(regString)==-1)
{
 alert("Model id should not contain special characters");
 return false;
}
if((last1-first1)>0)
{
 alert("There should not be more than one space in model id");
return false;
}
return true;
}
