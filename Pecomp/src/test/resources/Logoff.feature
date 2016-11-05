Feature: Eu como usuário desejo efetuar logoff do site
	
Scenario: Usuario deseja sair do site
	Given Eu estou logado no site
	When Eu clico em minha foto de perfil
	And clico na opcao Sair
	Then Tenho logout bem sucedido 
	And Eu sou redirecionado para pagina de Login