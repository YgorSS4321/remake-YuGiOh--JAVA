package PacoteA;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ygor
 */
public class Duelo {

    private DueloVisao dv;
    private DueloVisao dvOp;
    /*
    public Duelo(String j1, String j2, ArrayList<String> deck1, ArrayList<String> deck2){
        Duelo.iniciarDuelo(j1, j2, deck1, deck2);
    }
    */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Duelo.inicializarCartas();

        
        
        
        
        
        
        
        
        
        String[] deck3 = {"rei caveira", "facinacao das trevas", "servo caveira", "mago negro", "multistrike dragias", "dragão setupper", "dragão upsetter", "obelisco, o atormentador", "pote da avarice"};
        String[] deck4 = {"dragão branco de olhos azuis", "facinacao das trevas", "mago negro", "item2", "dragão fenix", "dragão do tesouro", "pote da avarice"};
        
        

        
        
        DueloVisao dv = new DueloVisao("preimeika", deck3, deck4);
        DueloVisao dvOP = new DueloVisao("sourubana", deck4, deck3);
        dvOP.setLocation(700, 0);
        
        dv.getNomeOponenteJLabel().setText(dvOP.getNomeJLabel().getText());
        dvOP.getNomeOponenteJLabel().setText(dv.getNomeJLabel().getText());
        
        Duelo.espelharLP(dv, dvOP);
        
        
        PedraPapelTesoura ppt = new PedraPapelTesoura(new javax.swing.JFrame(), true);
        ppt.setVisible(true);
        
        
        
        boolean jogador2Comeca = !ppt.isResultado();

        if(jogador2Comeca){
            Duelo.turno(dvOP, dv);
            dvOP.drawPhaseJB.setEnabled(true);
        }
        while (dv.getLifePoints() > 0 && dvOP.getLifePoints() > 0) {
            Duelo.turno(dv, dvOP);
            dvOP.drawPhaseJB.setEnabled(true);
            //allureOfDarkness.ativar(dv);
            
            if (!(dv.getLifePoints() > 0 && dvOP.getLifePoints() > 0)) {
                break;
            }

            Duelo.turno(dvOP, dv);
            dv.drawPhaseJB.setEnabled(true);
        }

        //Duelo.turno(dv, dvOP);
        //Duelo.turno(dv, dvOP);
        //Duelo.turno(dv, dvOP);
        if (dv.getLifePoints() <= 0) {
            JOptionPane.showMessageDialog(null, ("O jogador " + dvOP.getNomeJLabel().getText() + " Venceu"));
        } else if (dvOP.getLifePoints() <= 0) {
            JOptionPane.showMessageDialog(null, ("O jogador " + dv.getNomeJLabel().getText() + " Venceu"));
        } else {
            JOptionPane.showMessageDialog(null, "Empate");
        }
        dv.dispose();
        dvOP.dispose();

    }

    private static void turno(DueloVisao dv, DueloVisao dvOP) {
        dv.setVisible(true);

        while (!dv.getPhase().equals("Oponente")) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Duelo.class.getName()).log(Level.SEVERE, null, ex);
            }
            Duelo.espelharLP(dv, dvOP);
            
            Duelo.atualizarOponente(dv, dvOP);
            //Duelo.atualizarOponente(dvOP, dv);
        }
        dvOP.setPhase("Ready");
        dvOP.getDrawPhaseJB().setBackground(new java.awt.Color(255,204,102));
        dvOP.getDrawPhaseJB().setForeground(new java.awt.Color(0,0,0));

    }
    
    private static void espelharLP(DueloVisao dv, DueloVisao dvOP){
        /*
        
        dv.getLpOpJLabel().setText(String.valueOf(dvOP.getLifePoints()));
        dvOP.getLpOpJLabel().setText(String.valueOf(dv.getLifePoints()));
        dvOP.getLpJLabel().setText(String.valueOf(dvOP.getLifePoints()));
        */
        
        dv.setLifePoints(Integer.parseInt(dv.getLpJLabel().getText()));
        dvOP.setLifePoints(Integer.parseInt(dv.getLpOpJLabel().getText()));
        
        Duelo.atualizarLP(dv);
        Duelo.atualizarLP(dvOP);
        
        
        
        
    }
    
    private static void atualizarLP(DueloVisao dv){
        dv.getLpJLabel().setText(String.valueOf(dv.getLifePoints()));
    }
    
    /**
     * 
     * @param dv
     * @param oponente 
     * espelha o campo, grave, deck e mao de ambos os jogadores
     */
    private static void atualizarOponente(DueloVisao dv, DueloVisao oponente){
        
        oponente.setGraveArrayL(dv.getGraveArrayL_Op());
        oponente.setDeckArrayL(dv.getDeckArrayL_Op());
        oponente.setHandArrayL(dv.getHandArrayL_Op());
        oponente.setFieldArrayL(dv.getFieldArrayL_Op());
        
        oponente.setGraveArrayL_Op(dv.getGraveArrayL());
        oponente.setDeckArrayL_Op(dv.getDeckArrayL());
        oponente.setHandArrayL_Op(dv.getHandArrayL());
        oponente.setFieldArrayL_Op(dv.getFieldArrayL());
        
        oponente.atualizarTudo();
        
    }
    
    /**
     * inicializa e depois salva as cartas criadas 
     * com o método salvarCarta()
     * 
     */
    public static void inicializarCartas(){
        //inicializando os monstros
        Carta blueEyesWDragon = new Monstro("dragão branco de olhos azuis", "normal",false, 1, "dragão",8, 3000, 2500);
        Carta darkMagician = new Monstro("mago negro", "normal",false, 6, "mago",7, 2500, 2100);
        Carta summonedSkull = new Monstro("rei caveira", "normal",false, 6, "demonio",6, 2500, 1200);
        Carta skullServant = new Monstro("servo caveira", "normal", false, 6, "zumbi", 1, 300, 200);
        Carta token = new Monstro("token", "normal",false, 1, "sem tipo",1, 0, 0);
        
        Carta morphingJar = new Monstro("jarro metamórfico", "tribute este card, ambos os duelistas descartam a mão inteira, e compram 5 cartas", true, 6, "rocha",2, 700, 600){
            @Override
            public void ativar(DueloVisao dv){
                if(!(dv.getFieldJList().isSelectionEmpty())){
                    
                    
                    ArrayList<String> novoGrave = new ArrayList();
                    novoGrave.addAll(dv.getHandArrayL());
                    novoGrave.addAll(dv.getGraveArrayL());
                    dv.setGraveArrayL(novoGrave);
                    dv.setHandArrayL(new ArrayList());
                    
                    
   
                    ArrayList<String> novoGraveOp = new ArrayList();
                    novoGraveOp.addAll(dv.getHandArrayL_Op());
                    novoGraveOp.addAll(dv.getGraveArrayL_Op());
                    dv.setGraveArrayL_Op(novoGraveOp);
                    dv.setHandArrayL_Op(new ArrayList()); 
                    dv.atualizarTudo();
                   
                    
                    int selectedIndex = dv.getFieldJList().getSelectedIndex();
                    
                    dv.moverCarta(dv.getFieldArrayL(), selectedIndex, dv.getGraveArrayL());
                    
                    int n = 5;
                    int tamanho = dv.getDeckArrayL().size();
                    for(int i = 0; i < tamanho; i++){
                        dv.draw();
                        n--;
                        
                        if(n <= 0){
                            break;
                        }
                    }
                    dv.atualizarTudo();
                    
                    n = 5;
                    tamanho = dv.getDeckArrayL_Op().size();
                    for(int i = 0; i < tamanho; i++){
                        dv.drawOp();
                        n--;
                        
                        if(n <= 0){
                            break;
                        }
                    }
                    
                }
                
            }
        };
        
        
        
        
        
        
        
                
        
        //inicializando as magias
        Carta allureOfDarkness;
        allureOfDarkness = new Magia("facinacao das trevas", "compre 2 cartas, entao descarte 1 monstro do atributo TREVAS, caso contrário descarte a sua mao inteira", true) {
            @Override
            public void ativar(DueloVisao dv){
                //condicao para dizer que so pode ser ativado da mao ou do campo ou do cemiterio
                if(!(dv.getHandJList().isSelectionEmpty())){
                    dv.draw();
                    dv.draw();
                    //ver se tem algum monstro de trevas
                    ArrayList<String> cardList = new ArrayList();
                    cardList.addAll(Gerenciamento2.getCartas());
                    cardList.retainAll(dv.getHandArrayL());
                    ArrayList<String> r = Gerenciamento2.pesquisarMonstroPorAtributo(cardList, 6);
                    if (!r.isEmpty()) {
                        //escolhe um monstro de trevas e descarta
                        EscolherCarta dialog = new EscolherCarta(new javax.swing.JFrame(), true, r, 1, "escolha um monstro de trevas:");
                        dialog.setVisible(true);
                        dialog.atualizarJList(r);
                
                        String cartaEscolhida = dialog.getArrayL1().get(dialog.getResultado()[0]);
                        int index = dv.getHandArrayL().indexOf(cartaEscolhida);
                        dv.moverCarta(dv.getHandArrayL(), index, dv.getGraveArrayL());   
                        
                        //envia a carta para o cemitério depois de ativada
                    
                        
                        
                        dv.getHandArrayL().remove(this.getNome());
                        dv.getGraveArrayL().add(this.getNome());
                        
                    }else{
                        //descarta tudo
                        ArrayList<String> novoGrave = new ArrayList();
                        novoGrave.addAll(dv.getHandArrayL());
                        novoGrave.addAll(dv.getGraveArrayL());
                        dv.setGraveArrayL(novoGrave);
                        dv.getGraveArrayL().remove("facinacao das trevas");
                        dv.setHandArrayL(new ArrayList());
                        dv.atualizarTudo();
                    }
                    
                    
                    
                }else if(!(dv.getDeckJList().isSelectionEmpty())){
                    JOptionPane.showMessageDialog(null, "NAO ATIVA EFEITO NO DECK");
                    
                    
                    
                }
                
            }
        };
        
        Carta potOfAvaraice = new Magia("pote da avarice", "retorne 5 cartas do cemiterio pro deck, e se isso acontesser, compre 2 cartas", true){
            @Override
            public void ativar(DueloVisao dv){
                if(dv.getGraveArrayL().size() >= 5){
                    EscolherCarta dialog = new EscolherCarta(new javax.swing.JFrame(), true, dv.getGraveArrayL(), 5, "escolha 5 cartas:");
                    dialog.setVisible(true);

                    String cartaEscolhida1 = dialog.getArrayL1().get(dialog.getResultado()[0]);
                    String cartaEscolhida2 = dialog.getArrayL1().get(dialog.getResultado()[1]);
                    String cartaEscolhida3 = dialog.getArrayL1().get(dialog.getResultado()[2]);
                    String cartaEscolhida4 = dialog.getArrayL1().get(dialog.getResultado()[3]);
                    String cartaEscolhida5 = dialog.getArrayL1().get(dialog.getResultado()[4]);
                    
                    dv.moverCarta(dv.getGraveArrayL(), dv.getGraveArrayL().indexOf(cartaEscolhida1), dv.getDeckArrayL());   
                    dv.moverCarta(dv.getGraveArrayL(), dv.getGraveArrayL().indexOf(cartaEscolhida2), dv.getDeckArrayL());
                    dv.moverCarta(dv.getGraveArrayL(), dv.getGraveArrayL().indexOf(cartaEscolhida3), dv.getDeckArrayL());
                    dv.moverCarta(dv.getGraveArrayL(), dv.getGraveArrayL().indexOf(cartaEscolhida4), dv.getDeckArrayL());
                    dv.moverCarta(dv.getGraveArrayL(), dv.getGraveArrayL().indexOf(cartaEscolhida5), dv.getDeckArrayL());
                    
                    dv.moverCarta(dv.getHandArrayL(), dv.getHandArrayL().indexOf("pote da avarice"), dv.getGraveArrayL());
                    
                    dv.draw();
                    dv.draw();
                    
                    
                    dv.atualizarTudo();
                }else{
                    JOptionPane.showMessageDialog(null, "nao tem 5 cartas para retornar pro deck");
                }
                
            }
            
        };
                
                
        
        Carta obelisk = new Monstro("obelisco, o atormentador", "a invocacao deste card exige 3 tributos, não pode ser alvo de efeitos, e uma vez por turno você pode tributar 2 monstros no seu campo, e se isso acontecer atiive um desses efeitos: *envie para o cemitério todos os monstro no campo do oponente * o ataque deste card se torna 999_999 ", true, 6, "besta divina",10, 4000, 4000){
            @Override
            public boolean invocar(DueloVisao dv){
                EscolherCarta dialog = new EscolherCarta(new javax.swing.JFrame(), true, dv.getFieldArrayL(), 3,"Escolha 3 monstro para tributar: ");
                    
                dialog.setVisible(true);
                dialog.atualizarJList(dv.getFieldArrayL());
                if(dialog.getResultado().length > 0){
                    //invoca o monstro para o campo
                    dv.moverCarta(dv.getHandArrayL(), dv.getHandJList(), dv.getFieldArrayL());

                    //envia a carta tributada para o grave
                    dv.moverCarta(dv.getFieldArrayL(), dialog.getResultado()[0], dv.getGraveArrayL());   
                    dv.moverCarta(dv.getFieldArrayL(), (dialog.getResultado()[1] - 1), dv.getGraveArrayL());
                    dv.moverCarta(dv.getFieldArrayL(), (dialog.getResultado()[2] - 2), dv.getGraveArrayL());
                }
                
                return true;
                
            }
            
            @Override
            public void ativar(DueloVisao dv){
                
                
                EscolherCarta escolha = new EscolherCarta(new javax.swing.JFrame(), true, new ArrayList(List.of("destruir monstros", "aumentar ataque")), 1,"Escolha o efeito desejado: ");
                    
                escolha.setVisible(true);
                //escolha.atualizarJList(lista);
                
                ArrayList<String> lista = new ArrayList();
                lista.addAll(dv.getFieldArrayL());
                lista.remove(dv.getFieldJList().getSelectedValue());

                EscolherCarta dialog = new EscolherCarta(new javax.swing.JFrame(), true, lista, 2,"Escolha 2 monstro para tributar: ");

                dialog.setVisible(true);
                dialog.atualizarJList(lista);

                //envia a carta tributada para o grave
                String nomeCarta1 = lista.get(dialog.getResultado()[0]);
                String nomeCarta2 = lista.get(dialog.getResultado()[1]);


                dv.moverCarta(dv.getFieldArrayL(), dv.getFieldArrayL().indexOf(nomeCarta1), dv.getGraveArrayL());   
                dv.moverCarta(dv.getFieldArrayL(), dv.getFieldArrayL().indexOf(nomeCarta2), dv.getGraveArrayL());

                if(escolha.getResultado()[0] == 0){
                    if(dialog.getResultado() != null){
                        do{
                            dv.moverCarta(dv.getFieldArrayL_Op(), 0, dv.getGraveArrayL_Op());
                        }while(!dv.getFieldArrayL_Op().isEmpty());
                    }
                    
                }else if(escolha.getResultado()[0] == 1){
                    Carta obelisk = Gerenciamento2.pesquisarCartaPorNome("obelisco, o atormentador");
                    ((Monstro) obelisk).setAtk(9_999_999);
                    
                }
                
                    
            }
        };
        
        
        
        
        Gerenciamento2.salvarCarta(allureOfDarkness);
        Gerenciamento2.salvarCarta(skullServant);
        Gerenciamento2.salvarCarta(blueEyesWDragon);
        Gerenciamento2.salvarCarta(darkMagician);
        Gerenciamento2.salvarCarta(summonedSkull);
        Gerenciamento2.salvarCarta(morphingJar);
        Gerenciamento2.salvarCarta(obelisk);
        Gerenciamento2.salvarCarta(token);
        Gerenciamento2.salvarCarta(potOfAvaraice);
        Duelo.inicializarDeckLuke();
        
    }
    
    private static void inicializarDeckLuke(){
        /*
        Luke deck==
        3 [X]"multistrike dragias", "uma vez por turno mande a carta do topo do seu deck para o cemitério, e se isso acontecer, esse card pode atacar 2 vezes durante a fase de batalha", true, 1, "dragão", 7, 2500, 1500 

        1 "dragão volcano", "normal", false, 5, "dragão", 7, 2300, 2000 [X]

        1 "dragão da pressão gravitacional", "uma vez por turno descarte 1 carta, escolha um monstro no campo, ele perde 700 ATK/DEF até o fim deste turno", true, 3, "dragão", 6, 1500, 1000


        2 "guardião do fogo", "normal", false, 5, "dragão", 6, 2100, 400 [X]

        1 "cavaleiro dracônico das trevas", "normal", false, 6, "dragão", 5, 1600, 1100 [X]

        3 "dragorite", "normal", false, 3, "dragão", 4,  1500, 0 [X]

        3 "sylphidra", "normal", false, 4, "dragão", 4,  1500, 0 [X]

        3  [X]"dragão do tesouro", "uma vez por turno tribute este card e compre 1 carta", true, 3, "dragão", 3,  1100, 0

        3 [X]"dragão upsetter", "uma vez por turno, se não houver outros monstros no campo, invoque 1 'dragão setupper' do cemitério para o campo", true, 6, "dragão", 3,  1000, 0

        3 [X]"dragão setupper", "uma vez por turno, se não houver outros monstros no campo, invoque 1 'dragão upsetter' do cemitério para o campo", true, 6, "dragão", 3,  0, 1000

        3 [X]"dragão fenix", "uma vez por turno, descarte 1 carta, escolha um dragão de nível 5 ou mais no cemitério e adicione para a mão",true, 5, "dragão", 2,  500, 500

        "inferno do dragão", "se você tiver um monstro do tipo dragão no campo, escolha uma carta na mão do oponente e descarte o alvo"

        "pressão dracônica", "descarte 3 monstros do tipo dragão e destrua todos os monstros no campo do oponente"
        
        */
        
        Carta c1 = new Monstro("dragão volcano", "normal", false, 5, "dragão", 7, 2300, 2000);
        Carta c2 = new Monstro("guardião do fogo", "normal", false, 5, "dragão", 6, 2100, 400);
        Carta c3 = new Monstro("cavaleiro dracônico das trevas", "normal", false, 6, "dragão", 5, 1600, 1100);
        Carta c4 = new Monstro("dragorite", "normal", false, 3, "dragão", 4,  1500, 0);
        Carta c5 = new Monstro("sylphidra", "normal", false, 4, "dragão", 4,  1500, 0);
        Carta c6 = new Monstro("dragão do tesouro", "uma vez por turno tribute este card e compre 1 carta", true, 3, "dragão", 3,  1100, 0){
            @Override
            public void ativar(DueloVisao dv){
                if(!(dv.getFieldJList().isSelectionEmpty())){
                    
                    //efeito de se enviar para o grave
                    dv.getGraveArrayL().add(dv.getFieldJList().getSelectedValue());
                    dv.getFieldArrayL().remove(dv.getFieldJList().getSelectedIndex());
                    
                    dv.draw();
                }
            }
        };
        
        Carta c7 = new Monstro("multistrike dragias", "uma vez por turno mande a carta do topo do seu deck para o cemitério, e se isso acontecer, esse card pode atacar 2 vezes durante a fase de batalha", true, 1, "dragão", 7, 2500, 1500){
            @Override
            public void ativar(DueloVisao dv){
                if(!(dv.getFieldJList().isSelectionEmpty()) && !dv.getDeckArrayL().isEmpty()){
                    dv.moverCarta(dv.getDeckArrayL(), 0, dv.getGraveArrayL());
                    this.setQ_atk(2);
                }
            }
        };
        
        Carta c8 = new Monstro("dragão fenix", "uma vez por turno, descarte 1 carta, escolha um dragão de nível 5 ou mais no cemitério e adicione para a mão",true, 5, "dragão", 2,  500, 500){
            @Override
            public void ativar(DueloVisao dv){
                ArrayList<String> listaDragoes = Gerenciamento2.pesquisarMonstroPorTipo(dv.getGraveArrayL(), "dragão");
                ArrayList<String> lista = new ArrayList();
                for(String s: listaDragoes){
                    if(((Monstro)Gerenciamento2.pesquisarCartaPorNome(s)).getNivel() >= 5){
                        lista.add(s);
                    }
                }
                boolean condicao = lista.isEmpty();
                if(!dv.getDeckArrayL().isEmpty() && condicao == false){
                    EscolherCarta janelaDescarte = new EscolherCarta(new javax.swing.JFrame(), true, dv.getHandArrayL(), 1, "Descarte 1 carta: ");
                    janelaDescarte.setVisible(true);
                    janelaDescarte.atualizarJList(dv.getHandArrayL());
                    String cartaEscolhida = janelaDescarte.getArrayL1().get(janelaDescarte.getResultado()[0]);
                    int index = dv.getHandArrayL().indexOf(cartaEscolhida);
                    dv.moverCarta(dv.getHandArrayL(), index, dv.getGraveArrayL());
                    janelaDescarte.dispose();
                    if(janelaDescarte.getResultado() == null){
                        JOptionPane.showMessageDialog(null, "Erro");
                        
                    }else{
                        EscolherCarta janelaAdicionar = new EscolherCarta(new javax.swing.JFrame(), true, lista, 1, "Escolha 1 carta: ");
                        janelaAdicionar.setVisible(true);
                        janelaAdicionar.atualizarJList(dv.getGraveArrayL());
                        cartaEscolhida = janelaAdicionar.getArrayL1().get(janelaAdicionar.getResultado()[0]);
                        index = dv.getGraveArrayL().indexOf(cartaEscolhida);
                        dv.moverCarta(dv.getGraveArrayL(), index, dv.getHandArrayL());
                        
                    }   
                }
                
            }
        };
        
        Carta c9 = new Monstro("dragão upsetter", "uma vez por turno, se não houver outros monstros no campo, invoque 1 'dragão setupper' do cemitério para o campo", true, 6, "dragão", 3,  1000, 0){
            @Override
            public void ativar(DueloVisao dv){
                if(!(dv.getFieldJList().isSelectionEmpty()) && dv.getFieldArrayL().size() == 1){

                    for(String nome: dv.getGraveArrayL()){
                        if(nome.equals("dragão setupper")){
                            dv.moverCarta(dv.getGraveArrayL(), dv.getGraveArrayL().indexOf(nome), dv.getFieldArrayL());
                            dv.atualizarTudo();
                            break;
                            
                        }
                        
                    }
                }
            }
            
        };
        
        Carta c10 = new Monstro("dragão setupper", "uma vez por turno, se não houver outros monstros no campo, invoque 1 'dragão upsetter' do cemitério para o campo", true, 6, "dragão", 1,  0, 1000){
            @Override
            public void ativar(DueloVisao dv){
                if(!(dv.getFieldJList().isSelectionEmpty()) && dv.getFieldArrayL().size() == 1){
                    for(String nome: dv.getGraveArrayL()){
                        if(nome.equals("dragão upsetter")){
                            dv.moverCarta(dv.getGraveArrayL(), dv.getGraveArrayL().indexOf(nome), dv.getFieldArrayL());
                            dv.atualizarTudo();
                            break;
                            
                        }
                        
                    }
                }
            }    
        };
        Carta c11 = new Magia("inferno do dragão", "se você tiver um monstro do tipo dragão no campo, escolha uma carta na mão do oponente e descarte o alvo",true){
            @Override
            public void ativar(DueloVisao dv){
                
                ArrayList<String> lista = Gerenciamento2.pesquisarMonstroPorTipo(dv.getFieldArrayL(), "dragão");
                
                if(!(lista.isEmpty()) && !(dv.getHandArrayL_Op().isEmpty())){
                    EscolherCarta janela = new EscolherCarta(new javax.swing.JFrame(), true, dv.getHandArrayL_Op(), 1, "Escolha 1 carta: ");
                    janela.setVisible(true);
                    janela.atualizarJList(dv.getGraveArrayL_Op());
                    String cartaEscolhida = janela.getArrayL1().get(janela.getResultado()[0]);
                    int index = dv.getGraveArrayL_Op().indexOf(cartaEscolhida);
                    
                    dv.moverCarta(dv.getHandArrayL_Op(), index, dv.getGraveArrayL_Op());
                }
                
                
            }
            
        };
        
        Gerenciamento2.salvarCarta(c1);
        Gerenciamento2.salvarCarta(c2);
        Gerenciamento2.salvarCarta(c3);
        Gerenciamento2.salvarCarta(c4);
        Gerenciamento2.salvarCarta(c5);
        Gerenciamento2.salvarCarta(c6);
        Gerenciamento2.salvarCarta(c7);
        Gerenciamento2.salvarCarta(c8);
        Gerenciamento2.salvarCarta(c9);
        Gerenciamento2.salvarCarta(c10);        
    }
    
   
    
    
    
    
    

}
