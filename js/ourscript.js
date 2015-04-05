function check(){

	var birt = document.getElementById("Geburtstag");
	var regBut = document.getElementById("register");
	var user = document.getElementById("Username").value;
	var pw = document.getElementById("Passwort").value;
	
	if(user.length <= 8 && user.length >= 4 && pw.length <= 8 && pw.length >= 4 && (birt.validity.valid == true || birt.value == "")){
		regBut.disabled = false;
	}
	else{
		regBut.setAttribute('disabled','disabled');
	}
	
}

window.onerror = function(msg, url, linenumber) {
    alert('Error message: '+msg+'\nURL: '+url+'\nLine Number: '+linenumber);
    return true;
}

