/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.guiferbat.agenda;

import java.util.Scanner;


/**
 *
 * @author
 */
public class Menu {
    
    public static void menumain(){
        
        int num = -1;
        
        do {
            Front.menu(); //Abre as opções do menu principal
            Scanner input = new Scanner(System.in);
            ContatoDAO contatoDAO = new ContatoDAO();
            System.out.printf("Digite a opção desejada: ");
            String opcao = input.next();
            switch (opcao) {

                case "1":
                    //Cadastrar contato
                    contatoDAO.cadastrar();
                    System.out.println("");
                    break;
                case "2":
                    //Alterar contato
                    contatoDAO.alterar();
                    System.out.println("");
                    break;
                case "3":
                    //Remover contato
                    contatoDAO.remover();
                    System.out.println("");
                    break;
                case "4":
                    //Listar contatos
                    contatoDAO.listar();
                    System.out.println("");
                    break;

                case "0":

                    System.out.println("");
                    System.err.println("3,2,1.. Sistema encerrado pelo usuário!");
                    num = 0;
                    break;
                default:
                    System.out.println("");
                    System.out.println("OPÇÃO INVÁLIDA!! Digite uma das opções abaixo!");
                    break;
            }
        } while (num != 0);
    }
    
    
    
}
