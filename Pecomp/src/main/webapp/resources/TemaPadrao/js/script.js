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
function login_storage() {
	if (typeof(Storage) !== "undefined") 
	{
		var login = document.frm.login.value;
		if (login != ""){
			localStorage.setItem("login", login);			
		}
		else {
			var q = localStorage.getItem("login");;
			document.frm.login.value = localStorage.getItem("login");
		}
	}	
}
function cadastrar_storage(){
	// salvo os dados no local storage
	if (typeof(Storage) !== "undefined") 
	{
		var nome = document.frm.nome.value;
		if (nome == ""){
			var n = localStorage.getItem("nome"); 
			document.frm.nome.value = localStorage.getItem("nome");						
		}
		else 
		{
			localStorage.setItem("nome", document.frm.nome.value);
		}
		
		var email = document.frm.email.value;
		if (email == ""){
			var n = localStorage.getItem("email"); 
			document.frm.email.value = localStorage.getItem("email");						
		}
		else 
		{
			localStorage.setItem("email", document.frm.email.value);
		}
		
		var instituicao = document.frm.instituicao.value;
		if (instituicao == ""){
			var n = localStorage.getItem("instituicao"); 
			document.frm.instituicao.value = localStorage.getItem("instituicao");						
		}
		else 
		{
			localStorage.setItem("instituicao", document.frm.nome.value);
		}
		
		
	}
}


function carregaTabelas() 
{
	var ctx = document.getElementById("desempenhoMaterias");
	var myChart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: ["Calculo", "Programação", "Lógica"],
			datasets: [{
				label: '# de erros',
				data: [12, 19, 3],
				backgroundColor: [
					'rgba(155, 100, 200, 244)',
					'rgba(155, 100, 200, 244)',
					'rgba(155, 100, 200, 244)',
				],
				borderWidth: 1
			}]
		},
		options: {
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero:true
					}
				}]
			}
		}
	});
	
	var ctx = document.getElementById("desempenhoInstituição");
	var myChart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: ["Ifes", "Ufes", "UVV"],
			datasets: [{
				label: '# de inscritos',
				data: [12, 19, 3],
				backgroundColor: [
					'rgba(155, 100, 200, 244)',
					'rgba(155, 100, 200, 244)',
					'rgba(155, 100, 200, 244)',
				],
				borderWidth: 1
			}]
		},
		options: {
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero:true
					}
				}]
			}
		}
	});
	
	var ctx = document.getElementById("desempenhoMaterias2");
	var scatterChart = new Chart(ctx, {
		type: 'line',
		data: {
			datasets: [{
				label: 'Cálculo',
				data: [{ x: 10, y: 1 }, { x: 20, y: 2 }, { x: 30, y: 3 }]
			}]
		},
		options: {
			scales: {
				xAxes: [{
					type: 'linear',
					position: 'bottom'
				}]
			}
		}
	});
}

$(document).ready(function(){
	// Faz efeito do box de informações do usuário
	$('.box-usuario').before('<img id="img-usuario" src="Imagens/brasil.png" alt="logo" onclick="mostrarperfil()">');
	$('.box-usuario').css('display', 'none');
	
	$('img', '#box-toggle').click(function() {
		$(this).next().slideToggle('slow').siblings('.box-usuario:visible').slideToggle('fast');
	});
})


