package com.javaCucumber.bases;

import org.openqa.selenium.By;

public class GerenciarUsuarioPage extends PageBase {

    By menuGerenciar = By.xpath("//a[@href= '/mantis/manage_overview_page.php']");
    By menuUsuario = By.xpath("//a[@href= '/mantis/manage_user_page.php']");
    By pesquisaUsuarioField = By.id("search");
    By aplicarFiltroButton = By.xpath("//input[@value= 'Aplicar Filtro']");
    By usuarioGrid = By.xpath("//a[contains(@href,'manage_user_edit_page.php')]");
    By enabledCheck = By.xpath("//label/span[@class='lbl']");
    By atualizarUsuarioButton = By.xpath("//input[@value='Atualizar Usuário']");
    By nivelUsuarioCombo = By.id("edit-access-level");
    By emailField = By.id("email-field");
    By apagarUsuarioButton = By.xpath("//input[@value='Apagar Usuário']");
    By apagarContaButton = By.xpath("//input[@value='Apagar Conta']");
    By nomeUsuarioField = By.id("edit-username");
    By nomeVerdadeiroField = By.id("edit-realname");
    By enviaEmailCheck = By.xpath("//*[@id='edit-user-form']/div/div[2]/div[2]/label/span");
    By criarNovoUsuarioButton = By.xpath("//a[text()='Criar nova conta']");
    By confirmarNovoUsuarioButton = By.xpath("//input[@value='Criar Usuário']");
    By novoNomeUsuarioField = By.id("user-username");
    By novoNomeRealField = By.id("user-realname");
    By novoEmailField = By.id("email-field");
    By novoNivelField = By.id("user-access-level");
    By msgErro = By.xpath("//p[contains(text(),'APPLICATION ERROR')]");

    public void abrirMenuGerenciarUsuario() {

        click(menuGerenciar);
        click(menuUsuario);
    }


    public void pesquisarUsuario(String usuario) {
        sendKeys(pesquisaUsuarioField, usuario);
        click(aplicarFiltroButton);
    }

    public void clicaPrimeirGridUsuario() {
        click(usuarioGrid);
    }

    public void desabilitaUsuario() {
        click(enabledCheck);
    }

    public void gravaAlteracaoUsuario() {
        click(enviaEmailCheck);
        click(atualizarUsuarioButton);
    }

    public void selecionaNivelUsuario(String perfil) {
        comboBoxSelectByVisibleText(nivelUsuarioCombo, perfil);
    }

    public void preencheEmail(String email) {
        clearAndSendKeys(emailField, email);
    }

    public void apagaUsuario() {
        click(apagarUsuarioButton);
        click(apagarContaButton);
    }

    public void preencheNomeUsuario(String nome) {
        clearAndSendKeys(nomeUsuarioField, nome);
    }

    public void preencheNomeVerdadeiro(String nomeVerdadeiro) {
        clearAndSendKeys(nomeVerdadeiroField, nomeVerdadeiro);
    }

    public void criarNovoUsuario() {
        click(criarNovoUsuarioButton);
    }

    public void confirmarNovoUsuario() {
        click(confirmarNovoUsuarioButton);
    }

    public void preencheCampoNovoNomeUsuario(String usuario) {
        sendKeys(novoNomeUsuarioField, usuario);
    }

    public void preencheCampoNovoNomeReal(String nomeReal) {
        sendKeys(novoNomeRealField, nomeReal);
    }

    public void preencheCampoNovoEmail(String email) {
        sendKeys(novoEmailField, email);
    }

    public void preencheCampoNovoNivel(String nivel) {
        sendKeys(novoNivelField, nivel);
    }
    public boolean retornaMsgErro()
    {
        return returnIfElementIsDisplayed(msgErro);
    }
}
