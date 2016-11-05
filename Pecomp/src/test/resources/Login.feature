Feature: Eu como usuario quero fazer o login para ter acesso aos conteúdos

Scenario: Acessar o formulario de login com dados validos
	Given Um usuario anonimo
	When Eu envio dados validos
	Then Eu sou redirecionado para pagina inicial do site
	And Meu nome aparece no box do usuario enquanto estou logado

Scenario: Acessar o formulario de login com dados invalidos	
	Given Um usuario anonimo
	When Eu envio dados invalidos
	Then Eu recebo mensagens de validacao de campos