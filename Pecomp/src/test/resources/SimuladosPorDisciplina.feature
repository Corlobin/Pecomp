
Feature: Eu como usuário quero realizar simulados por disciplina no site para melhorar o meu desempenho em determinada matéria
	
Scenario: Usuario acessa pagina de Simulados agrupados por disciplina navegando pelo menu 
	Given Eu estou logado no site
	When Eu clico no item de Menu Simulado - Por disciplina
	Then Eu sou redirecionado para pagina de simulados agrupados por disciplina
	
Scenario: Usuario escolhe disciplina da qual deseja visualizar questoes 
	Given Eu estou na pagina de Simulados - Por disciplina
	When Eu seleciono a disciplina de Calculo
	And clico no botao Iniciar
	Then Uma questao de Calculo eh apresentada para mim
	
Scenario: Usuario envia resposta da questao
	Given Eu estou na pagina de uma questao de Simulados - Por disciplina
	When Eu seleciono uma opcao como correta
	And Clico no botao Enviar
	Then Eu recebo correcao da questao
	
Scenario: Usuario solicita nova questao
	Given Eu estou na pagina de Simulados - Por disciplina
	When Eu clico no botao Proxima questao
	Then Eu recebo uma nova questao para responder