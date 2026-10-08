import javax.swing.JOptionPane;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        
        System.out.println("=========================");
        System.out.println("HOLLOW KNIGHT: SILKSONG");
        System.out.println("edicao POO em Java");
        System.out.println("=========================");

        String nome = JOptionPane.showInputDialog("Digite o seu nome:");
        System.out.println("Carregando save de " + nome + "...");
        
        Heroina hornet = new Heroina("Hornet");
        System.out.println(hornet);

    
        Inimigo mossMother = new Inimigo("Moss Mother", 12, 1);

        Scanner scanner = new Scanner(System.in);
        int turno = 1;
        boolean fugiu = false;

        
        do {
        
            System.out.println("========== Turno " + turno + " ==========");
            System.out.println(hornet);
            System.out.println(mossMother);

            
            System.out.println("1-Atacar 2-Curar 0-Fugir");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();

            
            switch (opcao) {
                case 1:
                    hornet.atacar();
                    mossMother.receberGolpe();
                    break;
                case 2:
                    hornet.curar();
                    break;
                case 0:
                    fugiu = true;
                    System.out.println(hornet.getNome() + " fugiu da batalha.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            
            if (!fugiu && !mossMother.foiDerrotado() && turno % 3 == 0) {
                System.out.println(mossMother.getNome() + " ataca!");
                hornet.receberDano(mossMother.getDano());
            }

           
            

            
            if (!fugiu && !mossMother.foiDerrotado() && !hornet.estaDerrotado()) {
                turno++;
            }

        } while (!fugiu && !mossMother.foiDerrotado() && !hornet.estaDerrotado());

        
        if (mossMother.foiDerrotado()) {
            System.out.println("Vitoria sobre " + mossMother.getNome() + "!");
        } else if (hornet.estaDerrotado()) {
            System.out.println("Fim de jogo.");
        }

    
        System.out.println(hornet);

        scanner.close();
    }
}