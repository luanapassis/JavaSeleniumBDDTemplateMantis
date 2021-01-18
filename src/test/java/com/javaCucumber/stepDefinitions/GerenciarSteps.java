package com.javaCucumber.stepDefinitions;

import com.javaCucumber.bases.GerenciarUsuarioPage;
import com.javaCucumber.dbSteps.DataBaseSteps;
import com.javaCucumber.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GerenciarSteps {

    LoginPage loginPage;
    GerenciarUsuarioPage gerenciarUsuarioPage;
    DataBaseSteps dataBaseSteps;

    @Given("login com usuario '(.*)' e senha '(.*)'")
    public void loginComUsuarioESenha(String usuario, String senha) {
        loginPage = new LoginPage();

        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmLogin();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();

    }

    @Given("estou na tela de gerenciar usuario")
    public void estouNaTelaDeGerenciarUsuario() {
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        gerenciarUsuarioPage.abrirMenuGerenciarUsuario();

    }

    @And("pesquiso o usuario '(.*)'")
    public void pesquisoOUsuarioUsuario(String usuarioAtualizar) {
        gerenciarUsuarioPage = new GerenciarUsuarioPage();

        gerenciarUsuarioPage.pesquisarUsuario(usuarioAtualizar);
    }

    @And("seleciono o primeiro registro do grid")
    public void selecionoOPrimeiroRegistroDoGrid() {
        gerenciarUsuarioPage = new GerenciarUsuarioPage();
        gerenciarUsuarioPage.clicaPrimeirGridUsuario();
    }

    @And("seleciono o nivel de usuario '(.*)'")
    public void selecionoONuvelDeUsuarioAdministrador(String perfil) {
        gerenciarUsuarioPage = new GerenciarUsuarioPage();
        gerenciarUsuarioPage.selecionaNivelUsuario(perfil);

    }

    @When("seleciono o botao gravar atualizacao")
    public void selecionoOBotaoGravarAtualizacao() {
        gerenciarUsuarioPage = new GerenciarUsuarioPage();
        gerenciarUsuarioPage.gravaAlteracaoUsuario();
    }

    @Then("a alteracao e refletida no banco de dados para o usuario '(.*)' com o codigo '(.*)'")
    public void aAlteracaoERefletidaNoBancoDeDados(String usuario, String statusEsperado) {
        dataBaseSteps = new DataBaseSteps();

        String status = dataBaseSteps.retornaNivelAcesso(usuario);

        Assert.assertEquals( status,statusEsperado);
    }

    @And("desabilito o usuario")
    public void desabilitoOUsuarioAdministrador() {
        gerenciarUsuarioPage = new GerenciarUsuarioPage();
        gerenciarUsuarioPage.desabilitaUsuario();
    }

    @Then("a inativacao e refletida no banco de dados para o usuario '(.*)' com o codigo '(.*)'")
    public void aInativacaoERefletidaNoBancoDeDadosParaOUsuarioUsuarioComOCodigo(String usuario, String statusEsperado) {
        dataBaseSteps = new DataBaseSteps();
        String status = dataBaseSteps.retornaStatusUsuario(usuario);

        Assert.assertEquals(status, statusEsperado);
    }
}
