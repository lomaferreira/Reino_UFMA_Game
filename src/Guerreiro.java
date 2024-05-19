public class Guerreiro extends Personagem {
    private int habilidadeDeCombate;
    private int escudo;
    
    public Guerreiro(String nome,int nivel, int forca,int HP,int habilidadeDeCombate, int escudo) {
        super( nome,nivel,forca,HP);
        this.habilidadeDeCombate = habilidadeDeCombate;
        this.escudo = escudo;
    }

    public int getHabilidadeDeCombate() {
        return habilidadeDeCombate;
    }

    public void setHabilidadeDeCombate(int habilidadeDeCombate) {
        this.habilidadeDeCombate = habilidadeDeCombate;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    //Métodos  referentes ao ataque 
    @Override
    public int atacar(){
        return super.getForca()*habilidadeDeCombate;
    }

    //primeiro desconta o dano do escudo, se o dano for maior que o escudo, o excesso de dano deve será subtraído do HP, caso contrário retira normalmente do HP
    //SOBRECARGA OU SOBREESCRITA????
    public void receberDano(int dano){
        if(this.escudo>0){
            this.escudo-=dano;
            if (this.escudo < 0) {
                super.receberDano(-this.escudo);
                this.escudo = 0;
            }
        }else{
            super.receberDano(dano);
        }
        
        if(super.getHP()<=0){
            super.setHP(0);
            System.out.println("Guerreiro Morto!");
        }
    }

    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.println("Habilidade de Combate: "+ this.habilidadeDeCombate+"\nEscudo: "+this.escudo);
    
    }
}
