var chosenButtonTv = null;
var chosenButtonSsd = null;
var chosenButtonWeb = null;
var chosenButtonSport = null;
var chosenButtonTuwien = null;

function selectButtonTv(e){
	var element = e.target || e.srcElement;
	if(chosenButtonTv === null){	
		chosenButtonTv = element;
		element.setAttribute("class", "activeButton");
	}
	else{
		chosenButtonTv.setAttribute("class", "inactiveButton");
		element.setAttribute("class", "activeButton");
		chosenButtonTv = element;
	}
}

function selectButtonSsd(e){
	var element = e.target || e.srcElement;
	if(chosenButtonSsd === null){	
		chosenButtonSsd = element;
		element.setAttribute("class", "activeButton");
	}
	else{
		chosenButtonSsd.setAttribute("class", "inactiveButton");
		element.setAttribute("class", "activeButton");
		chosenButtonSsd = element;
	}
}

function selectButtonWeb(e){
	var element = e.target || e.srcElement;
	if(chosenButtonWeb === null){	
		chosenButtonWeb = element;
		element.setAttribute("class", "activeButton");
	}
	else{
		chosenButtonWeb.setAttribute("class", "inactiveButton");
		element.setAttribute("class", "activeButton");
		chosenButtonWeb = element;
	}
}

function selectButtonSport(e){
	var element = e.target || e.srcElement;
	if(chosenButtonSport === null){	
		chosenButtonSport = element;
		element.setAttribute("class", "activeButton");
	}
	else{
		chosenButtonSport.setAttribute("class", "inactiveButton");
		element.setAttribute("class", "activeButton");
		chosenButtonSport = element;
	}
}

function selectButtonTuwien(e){
	var element = e.target || e.srcElement;
	if(chosenButtonTuwien === null){	
		chosenButtonTuwien = element;
		element.setAttribute("class", "activeButton");
	}
	else{
		chosenButtonTuwien.setAttribute("class", "inactiveButton");
		element.setAttribute("class", "activeButton");
		chosenButtonTuwien = element;
	}
}
