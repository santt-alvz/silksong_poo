import lombok.Getter; 

@Getter
public class Heroina {
    private String nome;
    private int mascaras;
    private int seda;

    public Heroina(String nome) {
        this.nome = nome;
        this.mascaras = 5;
        this.seda = 0;

    
    }

    public void atacar() {
        System.out.println(nome+" ataca com a agulha!");
        this.seda = Math.min(9, this.seda + 1);
    }
    public void atacar (int vezes) {
        for(int i = 0; i < vezes; i++ ) {
            atacar();
        }
    }
    public void receberDano(int dano) {
        this.mascaras = Math.max(0,this.mascaras - dano);
        System.out.println(nome +" recebeu " + dano + " de dano.");
    }
    public void curar() {
        if (this.seda == 9){
            this.mascaras = Math.min(5, this.mascaras + 3);
            this.seda = 0;
            System.out.println(nome + " se amarrou com seda e recuperou mascaras. ");
        }
        else 
            System.out.println(nome + " nao tem seda o suficiente para se curar. ");
    }

    public boolean estaDerrotado() {
        return this.mascaras == 0;
    }
    @Override
    public String toString() {
        return nome + " | Mascaras: " + mascaras + "/5 | Seda : " + seda + "/9"; 
    }
}