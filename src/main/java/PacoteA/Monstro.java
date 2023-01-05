package PacoteA;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ygor
 */
public class Monstro extends Carta{
    private int atributo;
    private String tipo;
    private int nivel;
    private int atk;
    private int def;
    private int atk_atual = atk;
    private int q_atk = 1;
    
    
    /**
     * 
     * @return falso caso nao haja condicoes de invocacao exceptionais
     * e pode ser usado para invocar um monstro
     */
    public boolean invocar(DueloVisao dv){
        return false;
    }

    public int getAtributo() {
        return atributo;
    }

    public void setAtributo(int n) {
        //atributo = new Atributo(n);
        this.atributo = n;   
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAtk_atual() {
        return atk_atual;
    }

    public void setAtk_atual(int atk_atual) {
        this.atk_atual = atk_atual;
    }

    public int getQ_atk() {
        return q_atk;
    }

    public void setQ_atk(int q_atk) {
        this.q_atk = q_atk;
    }
    
    
    
    public Monstro(String nome, String desc, boolean implementado, int atributo, String tipo, int nivel, int atk, int def){
        super(nome, desc, implementado);
        this.atributo = atributo;
        this.tipo = tipo;
        this.nivel = nivel;
        this.atk = atk;
        this.def = def;
    }
    /**
     * @return retorna a string com tudo o que vai aparecer no campo
     */
    @Override
    public String toString(){
        return super.getNome() + " " + nivel + "٭" + " ATK/"+ atk + " DEF/"+ def;
    }
    
    @Override
    public String verDetalhes(){
        return "|" + super.getNome() + "|\n" + "|nivel: "+ nivel + " ("+ atributo +")| \n" + tipo + "\nATK:" + atk + "\nDEF:" + def + "\n" + super.getDescricao();
        
    }
}
