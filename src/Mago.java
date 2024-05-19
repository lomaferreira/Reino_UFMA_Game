import java.util.Random;

public class Mago extends Personagem{
    private int habilidadeMagica;
    private int esquiva;
    
    public Mago(String nome,int nivel, int forca,int HP, int habilidadeMagica, int esquiva) {
        super( nome,nivel,forca,HP);
        this.habilidadeMagica = habilidadeMagica;
        this.esquiva = esquiva;
    }

    public int getHabilidadeMagica() {
        return habilidadeMagica;
    }

    public void setHabilidadeMagica(int habilidadeMagica) {
        this.habilidadeMagica = habilidadeMagica;
    }

    public int getEsquiva() {
        return esquiva;
    }

    public void setEsquiva(int esquiva) {
        this.esquiva = esquiva;
    }


    @Override
    public int atacar(){
        return super.getForca()*habilidadeMagica;
    }

    //Testa se a minha probabilidade de dano é maior que a minha esquiva, se sim diminui o HP
    @Override
    public void receberDano(int dano){
        Random random = new Random();
        int probabilidadeDano = random.nextInt(80);
        if(probabilidadeDano>this.esquiva){
            System.err.println("Esquiva do Mago: " + this.esquiva);
             System.err.println("Probabilidade de dano: " + probabilidadeDano);
            int novoHP=super.getHP()-dano;
            super.setHP(novoHP);
        }else{
            System.err.println("Mago esquiva e não leva dano!");
        }
        if(super.getHP()<=0){
            super.setHP(0);
            System.err.println("Mago Morto!");
        }

    }
    
    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.println("Habilidade Mágica: "+ this.habilidadeMagica+ "\nEsquiva: "+this.esquiva);
    }
    
}
