package com.javaCucumber.utils;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

public class DbUtils {

    public static ArrayList<String> retornaDadosQuery(String query){
        ArrayList<String> arrayList = null;
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = null;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bugtracker?useTimezone=true&serverTimezone=UTC","root","");

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{
                int numberOfColumns;
                ResultSetMetaData metadata=null;

                arrayList = new ArrayList<String>();
                metadata = rs.getMetaData();
                numberOfColumns = metadata.getColumnCount();

                while (rs.next()) {
                    int i = 1;
                    while(i <= numberOfColumns) {
                        arrayList.add(rs.getString(i++));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static void executaQuery(String query){
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = null;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bugtracker?useTimezone=true&serverTimezone=UTC","root","");

            stmt = connection.createStatement();
            stmt.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void executaMudancas(String query){
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = null;
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bugtracker?useTimezone=true&serverTimezone=UTC","root","");

            stmt = connection.createStatement();
            stmt.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
