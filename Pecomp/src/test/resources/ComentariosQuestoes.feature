Feature: Eu como usu�rio quero poder comentar quest�es e ter acesso aos coment�rios que eu tenho d�vida para interagir com os outros usu�rios

Scenario: Usuario deseja comentar em determinada questao
	Given Eu estou na pagina de questoes de um simulado
	When Eu preencho o campo de comentario 
	And Eu clico no botao Enviar comentario
	Then Eu tenho meu comentario vinculado a questao
	
Scenario: Usuario deseja visualizar os comentarios disponiveis sobre determinada questao
	Given Eu estou na pagina de questoes de um simulado
	When Eu clico no botao Mostrar comentarios
	Then Eu visualizo os comentarios disponiveis sobre a questao