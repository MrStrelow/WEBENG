var chosenButton = null;

function selectButton(e){
	var element = e.target || e.srcElement;
	if(chosenButton === null){	
		chosenButton = element;
		element.setAttribute("class", "activeButton");
	}
	else{
		chosenButton.setAttribute("class", "inactiveButton");
		element.setAttribute("class", "activeButton");
		chosenButton = element;
	}
}
