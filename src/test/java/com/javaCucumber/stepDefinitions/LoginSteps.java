package com.javaCucumber.stepDefinitions;

import com.javaCucumber.pages.HomePage;
import com.javaCucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    LoginPage loginPage;
    HomePage homePage;

    @Given("acesso o sistema Mantis")
    public void acessoOSistemaMantis() {
        System.out.println("o hooks abre a página");
    }

    @When("efetuo login com usuario '(.*)' e senha '(.*)'")
    public void efetuoLoginComUsuarioESenha(String usuario, String senha) {
        loginPage = new LoginPage();
        homePage = new HomePage();

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmLogin();
        loginPage.preencherSenha(senha);
    }

    @Then("login realizado com sucesso para o usuario '(.*)'")
    public void loginRealizadoComSucesso(String nomeUsuario) {
        loginPage = new LoginPage();
        homePage = new HomePage();

        loginPage.clicarEmLogin();
        String usuLogado = homePage.retornaUsuLogado();
        Assert.assertEquals(usuLogado , nomeUsuario, "Usuário não logado.");
    }

    @Then("a mensagem deverá ser apresentada '(.*)'")
    public void aMensagemDeErroDeveraSerApresentada(String mensagemEsperada) {
        loginPage = new LoginPage();

        loginPage.clicarEmLogin();
        String msgErroLogin = loginPage.retornarMensagemDeErro();
        Assert.assertEquals(msgErroLogin, mensagemEsperada);
    }


}
