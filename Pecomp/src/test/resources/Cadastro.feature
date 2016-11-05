Feature: Eu como usuário quero ter um cadastro no site para poder ter acesso aos conteúdos
	
Scenario: Redirecionamento para pagina de cadastro
	Given Um usuario anonimo
	When Eu estou na pagina de login
	And clico no botao de Registrar
	Then Eu sou redirecionado para pagina de cadastro
	
Scenario: Sucesso no cadastro com todos os campos preenchidos e validos
	Given Eu estou na pagina de cadastro
	When Eu preencho os campos nome email instituicao senha e confirmacao de senha
	And Eu clico no botao de Cadastrar
	Then Eu recebo uma mensagem de confirmacao de cadastro
	And Sou redirecionado para pagina de login
	
Scenario: Insucesso no cadastro com senha invalida
	Given Eu estou na pagina de cadastro
	When Eu preencho o campo senha com dado invalido
	And Eu clico no botao de Cadastrar
	Then Eu recebo uma mensagem de validacao do campo senha
	
Scenario: Insucesso no cadastro com email invalido
	Given Eu estou na pagina de cadastro
	When Eu preencho o campo email com dado invalido
	And Eu clico no botao de Cadastrar
	Then Eu recebo uma mensagem de validacao do campo email
	
Scenario: Insucesso no cadastro com campos nao preenchidos
	Given Eu estou na pagina de cadastro
	When Eu nao preencho todos os campos
	And Eu clico no botao de Cadastrar
	Then Eu recebo uma mensagem de validacao de campo vazio
	
Scenario: Usuario cancela acao de cadastrar
	Given Eu estou na pagina de cadastro
	When Eu clico no botao de Cancelar
	Then Eu sou redirecionado para pagina de login
