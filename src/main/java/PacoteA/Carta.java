package PacoteA;

import java.util.Objects;
import javax.swing.JOptionPane;




/**
 *
 * @author ygor
 */
public class Carta {
    private String nome;
    private String descricao;
    private boolean implementado = false;

    private boolean podeAtivarEfeito = false;
    
    private int contador = -1;
    
    
    public boolean invocar(DueloVisao dv){
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isImplementado() {
        return implementado;
    }

    public void setImplementado(boolean implementado) {
        this.implementado = implementado;
    }

    public boolean isPodeAtivarEfeito() {
        return podeAtivarEfeito;
    }

    public void setPodeAtivarEfeito(boolean podeAtivarEfeito) {
        this.podeAtivarEfeito = podeAtivarEfeito;
    }
    
    
    
    /**
     * 
     * @param nome nome da carta
     * @param desc descricao da carta
     * @param implementado diz se o método ativar foi sobreescrito
     */
    
    public Carta(String nome, String desc, boolean implementado){
        this.nome = nome;
        this.descricao = desc;
        this.implementado = implementado;
    }
    
    public void ativar(DueloVisao dv){
        //como seria uma carta sem efeito
        
        //envia carta pro cemitério 
        dv.moverCarta(dv.getHandArrayL(), dv.getHandJList(), dv.getGraveArrayL());
        dv.atualizarTudo();
        
        
          
    };
    
    //METODO INVOCAR??????????????
    
    public void ver(){
        JOptionPane.showMessageDialog(null, this.toString(), "Detalhes", 1);
    };
    
    public String toString(){
        return nome;
    }
    
    public String verDetalhes(){
        return "|" + nome + "|\n" + descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        return Objects.equals(this.nome, other.nome);
    }
    
    
    
}
