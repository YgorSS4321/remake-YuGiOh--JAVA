package PacoteA;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author ygor
 */
public enum Atributo {
    LUZ(1), 
    AGUA(2), 
    TERRA(3),
    VENTO(4),
    FOGO(5),
    TREVAS(6);
    
    private final int indice;
    
    Atributo(int n){
        this.indice = n;
    }
    
    public int getIndice(){
        return indice;
    }
    
}
