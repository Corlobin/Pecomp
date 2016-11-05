Feature: Eu como usuário quero saber quanto tempo falta para o dia da prova e quando as inscrições irão abrir para ficar atento as datas importantes
	
Scenario: Usuario deseja visuzalizar datas importantes sobre a prova do Poscomp
	Given Eu estou logado no site
	When Eu passo o cursor sobre o icone do calendario
	Then Mensagens com datas importantes da prova Poscomp são apresentadas para mim