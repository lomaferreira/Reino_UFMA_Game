import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {  
        Random random = new Random();
        int esquiva = random.nextInt(20);
       
        
        Guerreiro guerreiro=new Guerreiro("Jaspeon", 1, 20, 20, 5, 10);
        Mago mago=new Mago("Balduin", 1, 5, 20, 2, esquiva);
        Arqueiro arqueiro= new Arqueiro("Archi", 1, 3, 20, 3, 3);

        
        telaMenuPrincipal();
        int menuPrincial=obterInput();
        while(menuPrincial==1){
        // Exibe o menu de seleção de personagens
        System.out.println("Escolha o primeiro personagem para a batalha:");
        System.out.println("1 - Guerreiro\n2 - Mago\n3 - Arqueiro");
        int menuP1 = obterInput();
        
        System.out.println("Escolha o segundo personagem para a batalha:");
        System.out.println("1 - Guerreiro\n2 - Mago\n3 - Arqueiro");
        int menuP2 = obterInput();

        // Inicializa os personagens selecionados
        Personagem p1 = escolherPersonagem(menuP1, guerreiro, mago, arqueiro);
        Personagem p2 = escolherPersonagem(menuP2, guerreiro, mago, arqueiro);

        // Verifica se ambos os personagens foram escolhidos corretamente
        if (p1 != null && p2 != null) {
            if(p1.getHP()==0){
                System.err.println(p1.getNome()+" morto, selecione outro!");
                
            }else if(p2.getHP()==0){
                System.err.println(p2.getNome()+" morto, selecione outro!");
            }else{
                combate(p1, p2);
                if(verificaObitoPersonagem(guerreiro,mago,arqueiro)){
                    return;
                }
                
            }
            
        } else {
            System.err.println("Personagem inválido selecionado.");
        }    
        
        telaMenuPrincipal();
        menuPrincial=obterInput();
    }
        


    }

    public static void combate(Personagem p1, Personagem p2 ){
        Personagem atacante;
        Personagem defensor;
        Random random = new Random();

        //o ataque é definido pelo nivel do personagem
        if(p1.getNivel()>p2.getNivel()){
            atacante = p1;
            defensor = p2;

       }else if(p2.getNivel()> p1.getNivel()){
            atacante = p2;
            defensor = p1;
       }else{
            int escolheAtacante = random.nextInt(2);            
            if(escolheAtacante==0){
                atacante = p1;
                defensor = p2;
                
            }else{
                atacante = p2;
                defensor = p1;
            }
       }

        int dano = atacante.atacar();
        System.err.println(atacante.getNome()+" ataca "+ defensor.getNome());
        atacante.setNivel(atacante.getNivel()+1);
        defensor.receberDano(dano);
        atacante.mostrarDetalhes();
        defensor.mostrarDetalhes();
        
    }

    public static int obterInput(){
        Scanner input=new Scanner(System.in);
        int menu=0;
        try{
            menu=input.nextInt();
        }catch(InputMismatchException exc){
            System.err.println("Entrada inválida. Por favor, insira um número inteiro.");
            obterInput();
        }

       
        return menu;
    }


    public static Personagem escolherPersonagem(int escolha, Guerreiro guerreiro, Mago mago, Arqueiro arqueiro) {
        switch (escolha) {
            case 1:
                return guerreiro;
            case 2:
                return mago;
            case 3:
                return arqueiro;
            default:
                return null;
        }
    }

    public static void telaMenuPrincipal(){
        System.out.println("\nOlá, bem-vindo ao Reino da UFMA!");
        System.err.println("1 - Selecionar Personagens\n0 - Sair\n");
    }

    public static boolean verificaObitoPersonagem(Guerreiro guerreiro, Mago mago, Arqueiro arqueiro){
                        boolean guerreiroEstaMorto = guerreiro.getHP() == 0;
                boolean magoEstaMorto = mago.getHP() == 0;
                boolean arqueiroEstaMorto = arqueiro.getHP() == 0;

                if (guerreiroEstaMorto && magoEstaMorto) {
                    System.err.println(arqueiro.getNome() +", o arqueiro, é o campeão!!!!👌");
                    return true;
                }
                if (guerreiroEstaMorto && arqueiroEstaMorto) {
                    System.err.println(mago.getNome() + ", o mago, é o campeão!!!👌");
                    return true;
                }
                if (magoEstaMorto && arqueiroEstaMorto) {
                    System.err.println(guerreiro.getNome() + ", o guerreiro, é o campeão!!!👌");
                    return true;
                }
                return false;
    }
}


