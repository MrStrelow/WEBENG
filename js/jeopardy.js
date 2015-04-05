var chosenButton = null;

function lol() {
	alert("asdf");
}

function selectButton() {
	alert("wtf");
	var element = document.getElementById("tv1");
	if(chosenButton === null) {	
		chosenButton = element;
		element.setAttribute("background", "linear-gradient(rgb(251,119,0), rgb(230,109,0));");
	}
	else {
		deselectButton();
	}
}

function deselectButton() {
	/* chosenButton.setAttribute('disabled', 'disabled'); */
	/* NEIN, das gilt nur für komplett inaktive Buttons (graue), deselect soll sie wieder blau machen */
	chosenButton = null;
}
