Feature: Eu como usu�rio quero saber o meu desempenho em rela��o aos simulados no site para avaliar o meu desempenho
	
Scenario: Usuario acessa pagina de Desempenho navegando pelo menu 
	Given  Eu estou logado no site
	When Eu clico no item de Menu Desempenho
	Then Eu sou redirecionado para pagina de Desempenho