
function checkUserAndPassword(){
	//var user = Document.registerForm.Username.value;
	//var pw = Document.registerForm.Passwort.value;
	
	var regBut = document.getElementById("register");
	var user = document.getElementById("Username").value;
	var pw = document.getElementById("Passwort").value;
	if(user.length <= 8 && user.length >= 4 && pw.length <= 8 && pw.length >= 4){
		regBut.setAttribute('disabled','');
	}
	else{
		regBut.setAttribute('disabled','disabled');
	}
	
	//alert(pw);
}

window.onerror = function(msg, url, linenumber) {
    alert('Error message: '+msg+'\nURL: '+url+'\nLine Number: '+linenumber);
    return true;
}
