// Funcoes dos comentarios do simulado
function show (toBlock){
    setDisplay(toBlock, 'block');
}
function hide (toNone) {
	setDisplay(toNone, 'none');
}
function setDisplay (target, str) {
	document.getElementById(target).style.display = str;
}
