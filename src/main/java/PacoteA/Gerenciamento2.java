/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PacoteA;

import BancoMySql.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ygor
 */
public class Gerenciamento2 {
    
    //
    public static void mostrarTabelas(){
        String sql = "SHOW TABLES;";
        
        Connection conn = Conexao.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet r7 = pst.executeQuery();
        
            while(r7.next()){
                System.out.println(r7.getString("tables_in_BANCO"));

            }
            conn.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Gerenciamento2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                
                
    }
    
    public static void salvarCarta(Carta card){
        
        String sql = "INSERT INTO CARTAS(nome, implementado, descricao) VALUES(?,?,?);";
        
        boolean alreadyExist = false;
        
        for(Carta c: cardDatabase){
            if(card.equals(c)){
                alreadyExist = true;
            }
        }
        
        if(!alreadyExist){
            Gerenciamento2.cardDatabase.add(card);
        }
        
        
        
        try{
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            boolean implementado = false;
            
            if(!card.getDescricao().equals("normal")){
                implementado = true;
            }
            
            pst.setString(1, card.getNome());
            pst.setBoolean(2, implementado);
            pst.setString(3, card.getDescricao());
                    
            if(!Gerenciamento2.getCartas().contains(card.getNome())){
                pst.execute();
                Gerenciamento2.cardDatabase.add(card);
                
                pst.clearParameters();
                if(card instanceof Monstro){
                    String sql2 = "INSERT INTO MONSTRO(nome_fk, atributo, tipo, nivel, atk, def) VALUES(?,?,?,?,?,?);";
                    
                    pst = conn.prepareStatement(sql2);
                    
                    pst.setString(1, card.getNome());
                    pst.setInt(2, ((Monstro) card).getAtributo());
                    pst.setString(3, ((Monstro) card).getTipo());
                    pst.setInt(4, ((Monstro) card).getNivel());
                    pst.setInt(5, ((Monstro) card).getAtk());
                    pst.setInt(6, ((Monstro) card).getDef());
                    
                    pst.execute();
                    
                    conn.close();
                    pst.close();
                    
                }else if(card instanceof Magia){
                    String sql2 = "INSERT INTO MAGIA(nome_fk) VALUES(?)";
                    
                    pst = conn.prepareStatement(sql2);
                    pst.setString(1, card.getNome());
                    
                    conn.close();
                    pst.close();
                    
                    
                }else{
                    //else if(card instanceof Armadilha){}
                    //else if(card instanceof Habilidade){}
                }
                    
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
    };
    
    public static ArrayList<String> getCartas(){
        String sql = "SELECT * FROM CARTAS;";
        ArrayList<String> r = new ArrayList();
        
        try{
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet r7 = pst.executeQuery();

            while(r7.next()){
                r.add(r7.getString("nome"));
            }
            conn.close();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return r;
    };
    
    
    
    
    
    public static Carta pesquisarCartaPorNome(ArrayList<String> array, String nome){
        Duelo.inicializarCartas();
        
        Carta card = null;
        for(int i = 0; i < Gerenciamento2.getCardDatabase().size();i++){
            
            if(Gerenciamento2.getCardDatabase().get(i).getNome().equals(nome) && array.contains(nome)){
                card = Gerenciamento2.getCardDatabase().get(i); 
                break;
            }
        }
        
        
        return card;
        
    };
    
    public static Carta pesquisarCartaPorNome(String nome){
        Duelo.inicializarCartas();
        
        Carta card = null;
        for(int i = 0; i < Gerenciamento2.getCardDatabase().size();i++){
            
            if(Gerenciamento2.getCardDatabase().get(i).getNome().equals(nome)){
                card = Gerenciamento2.getCardDatabase().get(i); 
                break;
            }
        }
        
        
        return card;
        
        
    };
    
    public static ArrayList<String> pesquisarMonstroPorAtributo(ArrayList<String> array, int atributo){
        String sql = "SELECT * FROM MONSTRO WHERE atributo = ?;";
        
        ArrayList<String> r = new ArrayList();
        
        try{
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, atributo);

            ResultSet r7 = pst.executeQuery();

            while(r7.next()){
                r.add(r7.getString("nome_fk"));
            }
            conn.close();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
                
        }
        r.retainAll(array);
        return r;
    };
    
    public static ArrayList<String> pesquisarMonstroPorTipo(ArrayList<String> array, String tipo){
        String sql = "SELECT * FROM MONSTRO WHERE tipo = ?;";
        
        ArrayList<String> r = new ArrayList();
        
        try{
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, tipo);

            ResultSet r7 = pst.executeQuery();

            while(r7.next()){
                r.add(r7.getString("nome_fk"));
            }
            conn.close();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
                
        }
        r.retainAll(array);
        return r;
        
        
    };
    
    public static ArrayList<String> pesquisarMonstroPorNivel(ArrayList<String> array, int nivel){
        String sql = "SELECT * FROM MONSTRO WHERE nivel = ?;";
        
        ArrayList<String> r = new ArrayList();
        
        try{
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setInt(1, nivel);

            ResultSet r7 = pst.executeQuery();

            while(r7.next()){
                r.add(r7.getString("nome_fk"));
            }
            conn.close();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
                
        }
        r.retainAll(array);
        return r;
        
        
        
    };
    public static boolean excluirCarta(String nomeCarta){
        String sql = "DELETE FROM CARTAS WHERE nome = ?;";
        boolean logic = true;
        
        if(Gerenciamento2.pesquisarCartaPorNome(nomeCarta) instanceof Monstro){
            String sql2 = "DELETE FROM MONSTRO WHERE nome_fk = ?;";
            try{
                Connection conn = Conexao.getConnection();
                PreparedStatement pst2 = conn.prepareStatement(sql2);
                pst2.setString(1 , nomeCarta);

                if(Gerenciamento2.getCartas().contains(nomeCarta)){
                    pst2.execute();

                }
                conn.close();
                pst2.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(Gerenciamento2.pesquisarCartaPorNome(nomeCarta) instanceof Magia){
            String sql2 = "DELETE FROM MAGIA WHERE nome_fk = ?;";
            
            try{
                Connection conn = Conexao.getConnection();
                PreparedStatement pst2 = conn.prepareStatement(sql2);
                pst2.setString(1 , nomeCarta);

                if(Gerenciamento2.getCartas().contains(nomeCarta)){
                    pst2.execute();

                }
                conn.close();
                pst2.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "CARTA SEM TIPO?");
            
        }
        
            
        
        try{
            Connection conn2 = Conexao.getConnection();
            PreparedStatement pst = conn2.prepareStatement(sql);
            pst.setString(1 , nomeCarta);
                        
            if(Gerenciamento2.getCartas().contains(nomeCarta)){
                pst.execute();
            }

            conn2.close();
            pst.close();
                    
        }catch(Exception e){
            e.printStackTrace();
            logic = false;
        }
        //Carta card = Gerenciamento2.pesquisarCartaPorNome(nomeCarta);
        //cardDatabase.remove(card);
        
        for(Carta card: cardDatabase){
            if(card.getNome().equals(nomeCarta)){
                cardDatabase.remove(card);
                break;
            }
            
        }
        
        return logic;
    };
    
    public static boolean sobreescreverCarta(Carta card){
        boolean funcionou = false;
        if(Gerenciamento2.getCartas().contains(card.getNome())){
            Gerenciamento2.excluirCarta(card.getNome());
            Gerenciamento2.salvarCarta(card);
            funcionou = true;
        }
        
        return funcionou;
    };
    
    public static ArrayList<String> pesquisarNomeDeCarta(ArrayList<String> array, String nome){
        String sql = "SELECT * FROM CARTAS WHERE nome LIKE ?;";
        ArrayList<String> r = new ArrayList();
        
        try{
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, "%" + nome + "%");
            ResultSet r7 = pst.executeQuery();

            while(r7.next()){
                r.add(r7.getString("nome"));
           
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return r;
        
        
    }
    
    
    private static ArrayList<Carta> cardDatabase = new ArrayList();

    public static ArrayList<Carta> getCardDatabase(){
        return cardDatabase;
    }
    
    public static void setCardDatabase(ArrayList<Carta> cardDatabase) {
        Gerenciamento2.cardDatabase = cardDatabase;
    }
    
    
    
            
    
}
