/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.guiferbat.agenda;

import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author
 */
public class ContatoDAO {
    
    static Scanner input = new Scanner(System.in);
    BancoDeDados banco = new BancoDeDados();
    
    
    public int procurarId() {
        Contato contato = new Contato(); //Instanciando o objeto funcionário
        System.out.printf("Digite o nome do funcionário: ");
        contato.setNome(input.nextLine()); // Atribuindo o nome do funcionário

            try {
                banco.conectaDB();
                String sql = "SELECT ID_CONTATO FROM TB_CONTATO WHERE NM_CONTATO = '" + contato.getNome() + "'";
                banco.rs = banco.stm.executeQuery(sql);
                
                //verificando se o select acima retornou algo com o parâmetro passado
                contato.setIdContato(0);
                //passando o resultado do select para a minha variável
                while (banco.rs.next()) {
                    contato.setIdContato(banco.rs.getInt(1));
                }
                //Caso a variável encontrado não altere o valor para 1, não foi encontrado o nome no cadastro
                if (contato.getIdContato() == 0) {
                    System.out.println("");
                    System.out.println("Contato " + contato.getNome() + " não encontrado!");
                    System.out.println("Tente novamente ou digite 0 para retornar ao menu principal!");
                    System.out.println("");
                    //retorna para o método procurarId()
                    return procurarId();

                } else {
                    //Caso a variável encontrado altere o valor para 1, retornará o Id encontrado
                    return contato.getIdContato();
                }

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            } finally {
                banco.desconectaDB();
            }
        return 0;
    }
    
    public void cadastrar(){
        
        Date data = new Date(System.currentTimeMillis());  
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy"); 
        
        Contato contato = new Contato();
        
        System.out.println("Digite o nome: ");
        contato.setNome(input.nextLine());
        System.out.println("Digite a data de nascimento no formato dd/mm/aaaa: ");
        contato.setDatanasc(input.nextLine());
        System.out.println("Digite o telefone: ");
        contato.setTelefone(input.nextLine());
        System.out.println("Digite o email: ");
        contato.setEmail(input.nextLine());
        
        
        try {
                banco.conectaDB();
                String sql = "INSERT INTO TB_CONTATO (NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL,DT_CADASTRO) "
                        + "VALUES('" + contato.getNome() + "' , "
                        + "'" + contato.getDatanasc() + "' , "
                        + "'" + contato.getTelefone() + "' , "
                        + "'" + contato.getEmail() + "' , "
                        + "CURRENT_TIMESTAMP)";
                banco.stm.executeUpdate(sql);
                System.out.println("Contato cadastrado na agenda com sucesso!");

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.out.println("Contato " + contato.getNome() + " não cadastrado na agenda!");
            } finally {
                banco.desconectaDB();
            }
    }
    
    public void remover() {
        
        int idCont = procurarId();
        
        try {
            banco.conectaDB();
            String sql = "DELETE FROM TB_CONTATO WHERE ID_CONTATO = " + idCont + "";
            banco.stm.executeUpdate(sql);
            System.out.println("Contato removido com sucesso!");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            banco.desconectaDB();
        }
    }
    
    public void alterar() {
        
        int idCont = procurarId();
        
        try {
            banco.conectaDB();
            System.out.printf("Digite o novo nome: ");
            String nome = input.next();
            System.out.println("Digite a nova data de nascimento: ");
            String datanasc = input.next();
            System.out.println("Digite o novo telefone: ");
            String telefone = input.next();
            System.out.println("Digite o novo email: ");
            String email = input.next();
            
            System.out.println("");
            String sql = "UPDATE TB_CONTATO SET NM_CONTATO = '" + nome + "' , "
                        + "DT_NASCIMENTO = '" + datanasc + "' , "
                        + "DT_CADASTRO = CURRENT_TIMESTAMP , "
                        + "VL_TELEFONE = '" + telefone + "' , "
                        + "VL_EMAIL = '" + email + "' WHERE ID_CONTATO = " + idCont + "";
            banco.stm.executeUpdate(sql);
            System.out.println("Contato atualizado com sucesso!");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            banco.desconectaDB();
        }
    }
    
    
    public void listar() {
        try {
            banco.conectaDB();
            String sql = "SELECT ID_CONTATO, NM_CONTATO, DT_NASCIMENTO, DT_CADASTRO, VL_TELEFONE, VL_EMAIL FROM TB_CONTATO";
            banco.rs = banco.stm.executeQuery(sql);
            
            SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy"); 
            
            while (banco.rs.next()) {
                int id = banco.rs.getInt("ID_CONTATO");
                String nome = banco.rs.getString("NM_CONTATO");
                String dataNasc = banco.rs.getString("DT_NASCIMENTO");
                String email = banco.rs.getString("VL_EMAIL");
                String telefone = banco.rs.getString("VL_TELEFONE");
                String datacadastro = banco.rs.getString("DT_CADASTRO");
                System.out.println(id + " | " + nome + " | " + dataNasc + " | " + email + " | " + telefone+ " | " + datacadastro);
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            banco.desconectaDB();
        }
    }
    

}
