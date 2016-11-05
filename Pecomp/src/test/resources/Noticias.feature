Feature: Eu como usuário quero ter acesso a noticias relacionadas a area de computacao
	
Scenario: Usuario acessa pagina de noticias navegando pelo menu 
	Given Eu estou logado no site
	When Eu clico no item de Menu Inicio
	Then Eu sou redirecionado para pagina de noticias
	
Scenario: Usuario filtra tema das noticias
	Given Eu estou na pagina de noticias
	When Eu seleciono um tema no campo de pesquisa
	Then Eu recebo apenas noticias relacionadas ao tema selecionado