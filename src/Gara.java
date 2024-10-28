import java.util.ArrayList;
import java.util.List;

public class Gara {
    private List<Cavallo> cavalli;
    private int lunghezzaPercorso;

    public Gara(int lunghezzaPercorso) {
        this.lunghezzaPercorso = lunghezzaPercorso;
        this.cavalli = new ArrayList<>();
    }

    public void aggiungiCavallo(String nome) {
        Cavallo cavallo = new Cavallo(nome, lunghezzaPercorso);
        cavalli.add(cavallo);
    }

    public void iniziaGara() {
        System.out.println("La gara sta per iniziare!");

        // Avvia tutti i cavalli (thread)
        for (Cavallo cavallo : cavalli) {
            cavallo.start();
        }

        // Aspetta che tutti i cavalli finiscano la gara
        for (Cavallo cavallo : cavalli) {
            try {
                cavallo.join();
            } catch (InterruptedException e) {
                System.out.println("Errore: un cavallo è stato interrotto.");
            }
        }

        System.out.println("La gara è finita!");
    }
}
