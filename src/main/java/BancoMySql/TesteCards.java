 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BancoMySql;

import PacoteA.Carta;
import PacoteA.DueloVisao;
//import PacoteA.Gerenciamento;
import PacoteA.Magia;
import PacoteA.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ygor
 */
public class TesteCards {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Gerenciamento2.mostrarTabelas();
        System.out.println("=====");
        //System.out.println(JOptionPane.showConfirmDialog(null, "deseja comecar o duelo?"));
        
        
        System.out.println("=====");
        
        
        
        //aqui vai criar as cartas
        Duelo.inicializarCartas();
        
        Gerenciamento2.excluirCarta("jarro metamórfico");
                                    
        System.out.println("=====");
        System.out.println("CARTA: " + Gerenciamento2.getCartas()); 
        System.out.println("=====");
        System.out.println(Gerenciamento2.getCardDatabase());
        System.out.println("=====");
        
        
        
        System.out.println(Gerenciamento2.pesquisarMonstroPorAtributo(Gerenciamento2.getCartas(),6));
        
        
        System.out.println(Gerenciamento2.pesquisarNomeDeCarta(Gerenciamento2.getCartas(), "caveira"));
        
        System.out.println(Gerenciamento2.pesquisarCartaPorNome("dragorite").getNome());
        
        
        
        
        
        
        
        
        /* teste ok
        System.out.println("Conjunto inicial: " + nomeCartas);
        System.out.println("========");
        
        EscolherCarta janela1 = new EscolherCarta(new javax.swing.JFrame(), true, nomeCartas,3, "Escolha 3 cartas: ");
        janela1.setVisible(true);
        System.out.println("FINALIZADO");
        
        System.out.println("Cartas escolhidas");
        for(int n: janela1.getResultado()){
            System.out.println(nomeCartas.get(n));
        }
        System.out.println("========");
        
        janela1.setVisible(false);
        janela1.dispose();
        
        */
        
        
       
        
        
       
       
    }
    
}
