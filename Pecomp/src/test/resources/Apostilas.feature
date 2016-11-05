Feature: Eu como usuário quero ter acesso a apostilas no site e acessá-los online para leitura resumida do conteúdo	
	
Scenario: Usuario acessa pagina de Conteudos de Apstilas navegando pelo menu 
	Given Eu estou logado no site
	When Eu clico no item de Menu Conteudos - Apostilas
	Then Eu sou redirecionado para pagina de Apostilas
	
Scenario: Usuario faz download de apostila
	Given Eu estou na pagina de Apostilas
	When Eu clico na opcao de download de uma apostila
	Then Eu recebo download da apostila escolhido
	
Scenario: Usuario filtra tema das apostilas
	Given Eu estou na pagina de Apostilas
	When Eu seleciono um tema no campo de pesquisa
	Then A pagina apresenta apenas apostilas relacionadas ao tema escolhido
