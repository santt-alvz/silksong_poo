import lombok.ToString;
import lombok.Getter;

@Getter
@ToString
public class Inimigo {
    private String nome;
    private int vida;
    private int dano;

    public Inimigo(String nome, int vida, int dano) {
        this.nome = nome;
        this.vida = (vida>=1 && vida<=20) ? vida : 10;
        this.dano = (dano >= 1 && dano <=2) ? dano : 1;
    }
    public Inimigo(String nome) {
        this(nome, 10, 1);
    }

    public void receberGolpe() {
        this.vida = Math.max(0, this.vida -1);
        System.out.println(this.nome + " recebeu 1 de dano.");
    }

    public boolean foiDerrotado() {
        return this.vida ==0;
    }
}
