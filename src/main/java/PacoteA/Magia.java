package PacoteA;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ygor
 */
public class Magia extends Carta{
    
    
    public Magia(String nome, String desc, boolean implementado){
        super(nome, desc, implementado);
    }
    
    
}

/*
para ser fiel ao jogo original haveriam 
alguns tipos de magia 
magia rápida (pode ser ativada a qualquer momento, inclusive em resposta á ativação 
de cartas e no turno do oponente)
magia de ritual(usado para fazer a invocação-ritual)
magia contínua (permanece no campo)
magia de equipamento (se vincula com um monstro no campo e quando o monstro 
deixar o campo ela é enviada pro grave)
*/
