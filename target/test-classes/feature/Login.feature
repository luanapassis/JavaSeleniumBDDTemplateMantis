# new feature
# Tags: optional

Feature: Login feature

  Scenario: Login sucesso
    Given acesso o sistema Mantis
    When efetuo login com usuario 'administrator' e senha 'administrator'
    Then login realizado com sucesso para o usuario 'administrator'

  Scenario: Login e usuario incorreto
    Given acesso o sistema Mantis
    When efetuo login com usuario 'errado' e senha 'errada'
    Then a mensagem deverá ser apresentada 'Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.'

  Scenario Outline: Testar varios logins com sucesso
    Given acesso o sistema Mantis
    When efetuo login com usuario '<usuario>' e senha '<senha>'
    Then login realizado com sucesso para o usuario '<usuario>'
    Examples:
      | usuario     | senha  |
      | luana.assis | 123456 |
      | usuario1    | 123456 |
      | usuario2    | 123456 |
