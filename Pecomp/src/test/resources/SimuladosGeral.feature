	
Feature: Eu como usuário quero realizar simulados gerais no site para melhorar o meu desempenho na prova
	
Scenario: Usuario acessa pagina de Simulados geral navegando pelo menu 
	Given Eu estou logado no site
	When Eu clico no item de Menu Simulado - Geral
	Then Eu sou redirecionado para pagina de simulados sem agrupamento

	
Scenario: Usuario envia resposta da questao
	Given Eu estou na pagina de uma questao de Simulados - Geral
	When Eu seleciono uma opcao como correta
	And Clico no botao Enviar
	Then Eu recebo correcao da questao
	
Scenario: Usuario solicita nova questao
	Given Eu estou na pagina de Simulados - Geral
	When Eu clico no botao Proxima questao
	Then Eu recebo uma nova questao para responder
	