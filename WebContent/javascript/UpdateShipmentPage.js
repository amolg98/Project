function show_confirm()
  { 
	  var result=confirm("Do you want to proceed?");
	    if (result==true)
	    {
	      return true;
	    }
	    else
	    {
	       return false;
	    }
  }
  
  function validate()
  {
	   
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
  function load_content(id,content)
  {
  	var node = document.getElementById( id );
  	node.innerHTML = content;
  }
