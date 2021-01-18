# new feature
# Tags: optional

Feature: Gerenciador

  Background:
    Given login com usuario 'administrator' e senha 'administrator'


  Scenario: Trocar de perfil para Administrador
    Given estou na tela de gerenciar usuario
    And pesquiso o usuario 'usuario1'
    And seleciono o primeiro registro do grid
    And seleciono o nivel de usuario 'administrador'
    When seleciono o botao gravar atualizacao
    Then a alteracao e refletida no banco de dados para o usuario 'usuario1' com o codigo '90'

  Scenario: Inativar usuario
    Given estou na tela de gerenciar usuario
    And pesquiso o usuario 'usuario1'
    And seleciono o primeiro registro do grid
    And desabilito o usuario
    When seleciono o botao gravar atualizacao
    Then a inativacao e refletida no banco de dados para o usuario 'usuario1' com o codigo '0'