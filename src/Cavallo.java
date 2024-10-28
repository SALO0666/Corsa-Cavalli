import java.util.Random;

public class Cavallo extends Thread {
    private String nome;
    private int distanzaDaPercorrere;
    private int distanzaPercorsa = 0;
    private Random random;

    public Cavallo(String nome, int distanzaDaPercorrere) {
        this.nome = nome;
        this.distanzaDaPercorrere = distanzaDaPercorrere;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (distanzaPercorsa < distanzaDaPercorrere) {
            // Simula l'avanzamento del cavallo
            int passo = random.nextInt(10) + 1; // Avanza di 1-10 metri
            distanzaPercorsa += passo;

            // Controllo per non superare la distanza da percorrere
            if (distanzaPercorsa > distanzaDaPercorrere) {
                distanzaPercorsa = distanzaDaPercorrere;
            }

            // Stampa l'avanzamento del cavallo
            System.out.println(nome + " ha percorso " + distanzaPercorsa + " metri.");

            // Pausa tra un passo e l'altro
            try {
                Thread.sleep(500); // Aspetta mezzo secondo
            } catch (InterruptedException e) {
                System.out.println(nome + " è stato interrotto.");
            }
        }

        // Il cavallo ha completato la gara
        System.out.println(nome + " ha completato la gara!");
    }
}
