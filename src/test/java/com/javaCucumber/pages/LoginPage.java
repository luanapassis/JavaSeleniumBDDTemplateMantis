package com.javaCucumber.pages;

import com.javaCucumber.bases.PageBase;
import org.openqa.selenium.By;
import com.javaCucumber.bases.PageBase;

public class LoginPage extends PageBase {
    //Mapping
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//input[@type='submit']");
    By mensagemErroTextArea = By.xpath("//div[@class='alert alert-danger']");

    //Actions
    public void preenhcerUsuario(String usuario) {
        sendKeys(usernameField, usuario);
    }

    public void preencherSenha(String senha) {
        sendKeys(passwordField, senha);
    }

    public void clicarEmLogin() {
        click(loginButton);
    }

    public String retornarMensagemDeErro() {
        return getText(mensagemErroTextArea);
    }

    public void preencherUsuarioJavaScript(String usuario)
    {
        SendKeysJavaScript(usernameField, usuario);
    }
    public void preencherSenhaJavaScript(String senha)
    {
        SendKeysJavaScript(passwordField, senha);
    }
    public void clicarEmLoginJavaScript()
    {
        ClickJavaScript(loginButton);
    }

}