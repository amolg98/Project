
function enabletextarea(cid)
{
    var checkboxid=cid.id;
    var textareaid=checkboxid.slice(1);
    if(cid.checked==true)
    {
      document.getElementById(textareaid).style.visibility="visible"; 
    }
    if(cid.checked==false)
    {    
      document.getElementById(textareaid).style.visibility="hidden"; 
      document.getElementById("display").innerHTML=" ";    
      document.getElementById(textareaid).value="0";  
    }
}