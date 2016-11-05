Feature: Eu como usuário quero ter acesso a livros no site e acessá-los online para leitura do conteúdo
	
Scenario: Usuario acessa pagina de Conteudos de Livros navegando pelo menu 
	Given Eu estou logado no site
	When Eu clico no item de Menu Conteudos - Livros
	Then Eu sou redirecionado para pagina de Livros
	
Scenario: Usuario faz download de livro
	Given Eu estou na pagina de Livros
	When Eu clico na opcao de download de um livro
	Then Eu recebo download do livro escolhido
	
Scenario: Usuario filtra tema dos livros
	Given Eu estou na pagina de Livros
	When Eu seleciono um tema no campo de pesquisa
	Then A pagina apresenta apenas livros relacionados ao tema escolhido
