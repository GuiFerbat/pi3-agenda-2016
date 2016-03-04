/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.guiferbat.agenda;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author
 */
public class Contato {
    private int idContato;
    private String nome;
    private String datanasc;
    private Date datacadastro;
    private String telefone;
    private String email;
    
    public Contato (){      
    }
    
    
    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the datacadastro
     */
    public Date getDatacadastro() {
        return datacadastro;
    }

    /**
     * @param datacadastro the datacadastro to set
     */
    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }
    
      
}
