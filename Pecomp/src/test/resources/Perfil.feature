Feature: Eu como usuário quero acessar o sistema para manter os meus dados atualizados

Scenario: Usuario deseja abrir seu box de opcoes de usuario
	Given Eu estou logado no site
	When Eu clico em minha foto de perfil
	Then Um box com opcoes para o usuario aparece
	
Scenario: Usuario deseja editar/visualizar sua pagina de perfil
	Given Eu estou logado no site
	When Eu clico em minha foto de perfil
	And clico na opcao Meu perfil
	Then Eu sou redirecionado para pagina de perfil
	
Scenario: Usuario deseja alterar sua foto de perfil
	Given Eu estou na pagina de Perfil
	When Eu clico no botao alterar foto
	And seleciono uma nova foto de perfil
	Then Eu tenho minha foto de perfil atualizada
	
Scenario: Usuario deseja editar seus dados de perfil
	Given Eu estou na pagina de Perfil
	When Eu atualizo meus dados
	And Eu clico no botao Atualizar perfil	
	Then Eu recebo uma mensagem de sucesso
	And tenho meu perfil atualizado
	