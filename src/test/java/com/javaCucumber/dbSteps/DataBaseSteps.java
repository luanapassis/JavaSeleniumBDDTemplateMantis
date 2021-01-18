package com.javaCucumber.dbSteps;

import com.javaCucumber.utils.DbUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataBaseSteps extends DbUtils
{

    public void cargaUsuario()
    {
        String consulta1 = String.format("select username from mantis_user_mantis where username = 'usuario1'");
        ArrayList<String> resultado1 = retornaDadosQuery(consulta1);
        if(resultado1 == null)
        {
            String query1 =  String.format("INSERT INTO mantis_user_mantis ( username, realname, email,\n" +
                    "PASSWORD, enabled, protected, access_level, login_count, " +
                    "lost_password_request_count, failed_login_count, cookie_String, last_visit, date_created)\n" +
                    "VALUES('usuario1', 'Teste','luana.assis1@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', " +
                    "1, 0, 90, 1, 0, 0, 'JCIfQbZ9Wdq0eONcOMkSOR17wMSjowjc68', 1574199190, 1574199190)\"");
            executaMudancas(query1);
        }

        String consulta2 = String.format("select username from mantis_user_mantis where username = 'usuario2'");
        ArrayList<String> resultado2 = retornaDadosQuery(consulta2);
        if (resultado2 == null)
        {
            String query2 = String.format("INSERT INTO mantis_user_mantis ( username, realname, email, PASSWORD, " +
                    "enabled, protected, access_level, login_count, lost_password_request_count, failed_login_count, " +
                    "cookie_String, last_visit, date_created) VALUES('usuario2', 'Teste','luana.assis2@gmail.com', " +
                    "'e10adc3949ba59abbe56e057f20f883e', 1, 0, 90, 1, 0, 0, 'JCIfQbZ9Wdq0eONcOMkSOR17wMSjowjc6L'," +
                    " 1574199190, 1574199190)");
            executaMudancas(query2);
        }

        String consulta3 = String.format("select username from mantis_user_mantis where username = 'luana.assis'");
        ArrayList<String> resultado3 = retornaDadosQuery(consulta3);
        if (resultado3 == null)
        {

            String query3 = String.format(" INSERT INTO mantis_user_mantis ( username, realname, email, " +
                    "PASSWORD, enabled, protected, access_level, login_count, lost_password_request_count, failed_login_count, cookie_String, last_visit, date_created)" +
                    "VALUES('luana.assis', 'Luana Assis','luana.assis@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 0, 90, 1, 0, 0, 'JCIfQbZ9Wdq0eONcOMkSOR17wMSjowjc7L', 1574199190, 1574199190)");
            executaMudancas(query3);
        }
        String consulta4 = String.format("select username from mantis_user_mantis where username = 'usu.inativo'");
        ArrayList<String> resultado4 = retornaDadosQuery(consulta4);
        if (resultado4 == null)
        {

            String query4 = String.format(" INSERT INTO mantis_user_mantis ( username, realname, email," +
                    "PASSWORD, enabled, protected, access_level, login_count, lost_password_request_count, failed_login_count, cookie_String, last_visit, date_created)" +
                    "VALUES('usu.inativo', 'Usuario inativo','usu.inativo@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 0, 0, 90, 1, 0, 0, 'JCIfQbZ9Wdq0eONcOMkSOR17wMSjowsc7L', 1574199190, 1574199190)");
            executaMudancas(query4);
        }
        String consulta5 = String.format("select username from mantis_user_mantis where email = 'alteraNome@gmail.com'");
        ArrayList<String> resultado5 = retornaDadosQuery(consulta5);
        if (resultado5 == null)
        {

            String query5 = String.format("INSERT INTO mantis_user_mantis ( username, realname, email, " +
                    "PASSWORD, enabled, protected, access_level, login_count, lost_password_request_count, failed_login_count, cookie_String, last_visit, date_created) " +
                    " VALUES('testeAlteraNome', 'TesteAlteraNomeReal','alteraNome@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 0, 90, 1, 0, 0, 'JCIfQbZ9Wdq0eONcOMkSOR17wMSjokkc7L', 1574199190, 1574199190)");
            executaMudancas(query5);
        }
    }
    public void cargaProjeto()
    {
        String consulta = String.format("SELECT * FROM mantis_project_mantis WHERE NAME = 'Teste'");
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        if (resultado == null)
        {
            String query = String.format("INSERT INTO mantis_project_mantis ( name, status, enabled, view_state, access_min, file_path, description, category_id, inherit_global) " +
                    "VALUES('Teste', 10,1, 10, 10, '', '', 1, 1)");
            executaMudancas(query);
        }
        //

        String consulta3 = String.format("SELECT * FROM mantis_project_mantis WHERE NAME = 'Teste SubProjeto'");
        ArrayList<String> resultado3 = retornaDadosQuery(consulta3);
        if (resultado3 == null)
        {
            String query3 = String.format("INSERT INTO mantis_project_mantis ( name, status, enabled, view_state, access_min, file_path, description, category_id, inherit_global) " +
                    "VALUES('Teste SubProjeto', 10,1, 10, 10, '', '', 1, 1)");
            executaMudancas(query3);
        }


    }

    public void cargaMarcadores()
    {
        //seleciona id
        String consulta0 = String.format("select id from mantis_user_mantis where username = 'luana.assis'");
        ArrayList<String> resultado0 = retornaDadosQuery(consulta0);
        String idUser = resultado0.get(0);

        //where por descricao, porque os casos de testes atualizam o nome dele
        String consulta = String.format("SELECT * FROM mantis_tag_mantis WHERE description = 'descricao'");
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        if (resultado == null)
        {
            String query = String.format("INSERT INTO mantis_tag_mantis(user_id, NAME, description," +
                    " date_created, date_updated) VALUES({0}, 'marcadorTeste', 'descricao', 1581651675, 1581651675)", idUser);
            executaMudancas(query);
        }
        //
        String consulta1 = String.format("SELECT * FROM mantis_tag_mantis WHERE NAME = 'marcadorTeste2'");
        ArrayList<String> resultado1 = retornaDadosQuery(consulta1);
        if (resultado1 == null)
        {
            String query1 = String.format("INSERT INTO mantis_tag_mantis(user_id, NAME, description," +
                    " date_created, date_updated) VALUES({0}, 'marcadorTeste2', 'descricao2', 1581651675, 1581651675)", idUser);
            executaMudancas(query1);
        }

    }

    public void atualizacaoCargaUsuario()
    {
        String consulta = String.format("select username from mantis_user_mantis where username = 'usuario1'");
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        if (resultado == null)
        {
            String query = String.format(" INSERT INTO mantis_user_mantis ( username, realname, email," +
                    " PASSWORD, enabled, protected, access_level, login_count, lost_password_request_count, failed_login_count, cookie_String, last_visit, date_created) " +
                    " VALUES('usuario1', 'Teste','luana.assis1@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 1, 0, 90, 1, 0, 0, 'JCIfQbZ9Wdq0eONcOMkSOR17wMSjowjc68', 1574199190, 1574199190)");
            executaMudancas(query);
        }

        String consulta1 = String.format("select username from mantis_user_mantis where username = 'usuario1'");
        ArrayList<String> resultado1 = retornaDadosQuery(consulta1);
        if (resultado1.size() >= 1)
        {
            String query1 = String.format("update mantis_user_mantis set enabled = 1, access_level = 90, email = 'luana.assis1@gmail.com' where username = 'usuario1'");
            executaMudancas(query1);
        }

        String consulta2 = String.format("select username from mantis_user_mantis where email = 'alteraNome@gmail.com'");
        ArrayList<String> resultado2 = retornaDadosQuery(consulta2);
        if (resultado2.size() >= 1)
        {
            String query2 = String.format("update mantis_user_mantis set username = 'testeAlteraNome', realname = 'TesteAlteraNomeReal'  where email = 'alteraNome@gmail.com'");
            executaMudancas(query2);
        }
    }
    public void atualizacaoCargaProjeto()
    {
        String consulta1 = String.format("SELECT name FROM mantis_project_mantis WHERE NAME = 'Teste'");
        ArrayList<String> resultado1 = retornaDadosQuery(consulta1);
        if (resultado1.size() >= 1)
        {
            String query1 = String.format("update mantis_project_mantis set status = 10, view_state= 10, enabled= 1 where name = 'Teste'");
            executaMudancas(query1);
        }
        String consulta2 = String.format("delete FROM mantis_project_mantis WHERE NAME = 'Projeto Teste Automatizado'");
        executaMudancas(consulta2);

        String consulta3 = String.format("delete FROM mantis_project_hierarchy_mantis");
        executaMudancas(consulta3);
    }
    public void atualizacaoCargaMarcadores()
    {
        String query11 = String.format("update mantis_tag_mantis set NAME = 'marcadorTeste' where description = 'descricao'");
        executaMudancas(query11);
        String query12 = String.format("update mantis_tag_mantis set description = 'descricao2' where NAME = 'marcadorTeste2'");
        executaMudancas(query12);
    }

    //pesquisas-------------------
    public String retornaStatusUsuario(String usuario)
    {
        String consulta = String.format("SELECT enabled FROM mantis_user_mantis where username = '%s'", usuario);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado.get(0);
    }
    public String retornaNivelAcesso(String usuario)
    {
        String consulta = String.format("SELECT access_level FROM mantis_user_mantis where username = '%s'", usuario, "teste");
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado.get(0);
    }
    public String retornaEmailUsuario(String usuario)
    {
        String consulta = String.format("SELECT email FROM mantis_user_mantis where username = '%s'", usuario);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado.get(0);
    }

    public String retornaUsuario(String usuario)
    {
        String consulta = String.format("select username from mantis_user_mantis where username = '%s'", usuario);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        if(resultado == null)
        {
            return null;
        }
        else
        {
            return resultado.get(0);
        }
    }
    public String retornaNomeUsuario(String email)
    {
        String consulta = String.format("SELECT username FROM mantis_user_mantis where email = '%s'", email);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado.get(0);
    }
    public String retornaNomeRealUsuario(String email)
    {
        String consulta = String.format("SELECT realname FROM mantis_user_mantis where email = '%s'", email);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado.get(0);
    }
    public String retornaidUsuario(String nome)
    {
        String consulta = String.format("SELECT id FROM mantis_user_mantis where username = '%s'", nome);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado.get(0);
    }
    public String retornaStatusProjeto(String projeto)
    {
        String consulta = String.format("SELECT status FROM mantis_project_mantis WHERE NAME = '%s'", projeto);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado.get(0);
    }
    public String retornaVisibilidadeProjeto(String projeto)
    {
        String consulta = String.format("SELECT view_state FROM mantis_project_mantis WHERE NAME = '%s'", projeto);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado.get(0);
    }
    public ArrayList<String> retornaDadosProjeto(String projeto)
    {
        String consulta = String.format("SELECT * FROM mantis_project_mantis WHERE NAME = '%s'", projeto);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        if (resultado == null)
        {
            return null;
        }
        else
        {
            return resultado;
        }
    }
    public ArrayList<String> retornaVinculoSubProjeto(String idPai, String idFilho)
    {
        String consulta = String.format("SELECT * FROM mantis_project_hierarchy_mantis WHERE child_id = %s AND parent_id= %s", idFilho, idPai);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        if (resultado == null)
        {
            return null;
        }
        else
        {
            return resultado;
        }
    }
    public ArrayList<String> retornaMarcadorPorNome(String nome)
    {
        String consulta = String.format("SELECT * FROM mantis_tag_mantis WHERE NAME = '%s'", nome);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado;
    }
    public ArrayList<String> retornaMarcadorPorDescricao(String descricao)
    {
        String consulta = String.format("SELECT * FROM mantis_tag_mantis WHERE description = '%s'", descricao);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado;
    }

    //Tarefas
    public ArrayList<String> retornaTarefaCriadaPorNome(String nomeTarefa)
    {
        String consulta = String.format("SELECT * from mantis_bug_mantis bm " +
                "INNER join mantis_bug_text_mantis btm " +
                "ON bm.id = btm.id " +
                " WHERE SUMMARY = '%s'", nomeTarefa);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado;
    }
    public ArrayList<String> retornaTarefaCriadaPorId(String id)
    {
        String consulta = String.format("SELECT * from mantis_bug_mantis bm" +
                " INNER join mantis_bug_text_mantis btm" +
                " ON bm.id = btm.id" +
                " WHERE bm.ID = '%s'", id);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado;
    }
    public ArrayList<String> retornaTagTarefa(int id)
    {
        String consulta = String.format("SELECT * from mantis_bug_tag_mantis WHERE bug_id = '%s'", id);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado;
    }
    public ArrayList<String> retornaRelacaoTarefa(int id)
    {
        String consulta = String.format("SELECT * from mantis_bug_relationship_mantis WHERE SOURCE_bug_id = '%s' ORDER BY destination_bug_id desc", id);
        ArrayList<String> resultado = retornaDadosQuery(consulta);
        return resultado;
    }
}