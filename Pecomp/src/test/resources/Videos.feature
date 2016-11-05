Feature: Eu como usuário quero ter acesso a videos no site e acessá-los online para entender melhor os conteúdos
	
Scenario: Usuario acessa pagina de Conteudos de Videos navegando pelo menu 
	Given Eu estou logado no site
	When Eu clico no item de Menu Conteudos - Videos
	Then Eu sou redirecionado para pagina de Videos
	
Scenario: Usuario filtra tema dos videos
	Given Eu estou na pagina de Videos
	When Eu seleciono um tema no campo de pesquisa
	Then A pagina apresenta apenas repositorios de videos relacionados ao tema escolhido
	
Scenario: Usuario deseja visualizar os videos disponiveis de determinado tema 
	Given Eu estou na pagina principal de videos
	When Eu clico no link de repositorios de videos da disciplina de Calculo
	Then Eu sou redirecionado para pagina de videos de Calculo