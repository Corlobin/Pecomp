Feature: Eu como usuário quero poder avaliar os outros comentários
	
Scenario: Usuario deseja avaliar os comentarios disponiveis sobre determinada questao
	Given Eu estou na pagina de questoes de um simulado
	And Cliquei no botao Mostrar comentarios
	When Seleciono quantidade de estrelas que quero vincular a um comentario 
	And Clico no botao Registrar avaliacao
	Then Minha avaliacao da questao eh integrada a media de avaliacao do comentari