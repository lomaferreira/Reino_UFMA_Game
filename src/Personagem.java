public class Personagem {
    private String nome;
    private int nivel;
    private int forca;
    private int HP;
    
    public Personagem(String nome, int nivel, int forca, int hP) {
        this.nome = nome;
        this.nivel = nivel;
        this.forca = forca;
        HP = hP;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

   
    public int atacar(){
        return 0;
    };
    public void receberDano(int dano){
        int novoHP=getHP()-dano;
        setHP(novoHP);
    };
    public void mostrarDetalhes(){
        System.out.println("\nNome: " + this.nome +"\nNível: "+ this.nivel+ "\nForça: "+this.forca+ "\nHP: "+this.HP);
    };
    
    
}
