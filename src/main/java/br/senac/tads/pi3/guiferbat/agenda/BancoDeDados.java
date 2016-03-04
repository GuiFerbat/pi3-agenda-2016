/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.guiferbat.agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author
 */
public class BancoDeDados {
    
    public String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDataSource"; //String do driver JDBC Sqlite
    public String DB_URL = "jdbc:derby://localhost:1527/agendabd;SecurityMechanism=3"; //URL do arquivo do bando de dados
    public String user = "app";
    public String pass = "app";
    public Connection conn = null; //Instancia que recebe a conexão com o banco
    public Statement stm = null; // Instancia que recebe comandos SQL no banco
    public ResultSet rs; // Armazena o resultado de um select passada para o Statement


    public void conectaDB() { // Realiza a conexão com o Banco
        try {
            conn = DriverManager.getConnection(DB_URL, user, pass); // Abre a conexão com o banco passando a URL do banco
            stm = conn.createStatement(); //Inicia o statement para ser usado
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void desconectaDB() { // Realiza a desconexão com o Banco
        try {
            conn.close(); // Fecha a conexão
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }
    
}
