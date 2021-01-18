package com.javaCucumber.pages;

import com.javaCucumber.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends PageBase
{
    By usuLogadoTextArea = (By.xpath("//span[@class = 'user-info']"));
    By menuProjetoDropDown = (By.xpath("//a[@data-toggle= 'dropdown']"));
    By projetoMassa = (By.xpath("//a[text()=' Teste ']"));//mapeamento para pegar um item específico
    By pesquisaTarefaField = (By.name("bug_id"));



    public String retornaUsuLogado()
    {
        return getText(usuLogadoTextArea);
    }
    public String retornaProjetoMassa()
    {
        click(menuProjetoDropDown);
        String retorno = getText(projetoMassa);
        click(menuProjetoDropDown);
        return retorno;
    }
    public void clicaProjetoMassa()
    {
        click(menuProjetoDropDown);
        click(projetoMassa);
    }
    public void preenchePesquisaTarefa(String tarefaId)
    {
        sendKeys(pesquisaTarefaField, tarefaId);
        sendKeys(pesquisaTarefaField, Keys.ENTER.toString());
    }
}