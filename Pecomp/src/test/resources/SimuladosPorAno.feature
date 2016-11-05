Feature: Eu como usuário quero realizar simulados por ano no site para avaliar o meu desempenho em uma prova específica
	
Scenario: Usuario acessa pagina de Simulados agrupados por ano navegando pelo menu 
	Given Eu estou logado no site
	When Eu clico no item de Menu Simulado - Por ano
	Then Eu sou redirecionado para pagina de simulados agrupados por ano
	
Scenario: Usuario escolhe ano da prova da qual deseja visualizar questoes 
	Given Eu estou na pagina de Simulados - Por ano
	When Eu seleciono o ano 2015
	And clico no botao Iniciar
	Then Uma questao do ano de 2015 eh apresentada para mim
	
Scenario: Usuario envia resposta da questao
	Given Eu estou na pagina de uma questao de Simulados - Por ano
	When Eu seleciono uma opcao como correta
	And Clico no botao Enviar
	Then Eu recebo correcao da questao
	
Scenario: Usuario solicita nova questao
	Given Eu estou na pagina de Simulados - Por disciplina
	When Eu clico no botao Proxima questao
	Then Eu recebo uma nova questao para responder