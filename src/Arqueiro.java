public class Arqueiro extends Personagem{
    private int habilidadeComArco;
    private int destreza;
   
    public Arqueiro(String nome,int nivel, int forca,int HP,int habilidadeComArco, int destreza) {
        super( nome,nivel,forca,HP);
        this.habilidadeComArco = habilidadeComArco;
        this.destreza = destreza;
    }

    public int getHabilidadeComArco() {
        return habilidadeComArco;
    }

    public void setHabilidadeComArco(int habilidadeComArco) {
        this.habilidadeComArco = habilidadeComArco;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

      
    @Override
    public int atacar(){
        return super.getForca()*habilidadeComArco*destreza;
    }
    //Sobrecarga do método receber dano
    public void receberDano(int dano){
        super.receberDano(dano);
        if(super.getHP()<=0){
            super.setHP(0);
            System.out.println("Arqueiro Morto!");
        }
     }
    
    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.println("Habilidade com Arco: "+this.habilidadeComArco+"\nDestreza: "+this.destreza);
    }

}
