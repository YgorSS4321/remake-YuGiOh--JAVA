/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PacoteA;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ygor
 */
public class Deck {
    String nome;
    String[] cards = new String[60];

    public Deck(String nome, String[] cards) {
        this.nome = nome;
        this.cards = cards;
    }
    
    public boolean addCard(String card){
        boolean deuCerto = false;
        if(Gerenciamento2.pesquisarCartaPorNome(card) != null){
            ArrayList<String> lista = new ArrayList(List.of(cards));
            lista.add(nome);
            cards = ((String[]) lista.toArray());
            deuCerto = true;
        }
        
        return deuCerto;
        
    }
    
    public void removeCard(String card){
        ArrayList<String> lista = new ArrayList(List.of(cards));
        lista.remove(nome);
        cards = ((String[]) lista.toArray());
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getCards() {
        return cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }
    
    
    
    
    
}
