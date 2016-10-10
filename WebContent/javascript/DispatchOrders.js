function toggleCheckBoxes(elem) {

    var div = document.getElementById('orders');

    var chk = div.getElementsByTagName('input');
    var len = chk.length;

    for (var i = 0; i < len; i++) {
        if (chk[i].type === 'checkbox') {
            chk[i].checked = elem.checked;
        }
    }        
}
function resetCheckAll(ele)
{
	if(ele.checked==false)
	{
		document.getElementById("chkall").checked=ele.checked;
    }        
}