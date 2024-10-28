import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Richiedi la lunghezza del percorso
        int lunghezzaPercorso = richiediLunghezzaPercorso(scanner);

        // Crea una nuova gara con la lunghezza specificata
        Gara gara = new Gara(lunghezzaPercorso);

        // Richiedi e aggiungi i cavalli alla gara
        int numeroCavalli = richiediNumeroCavalli(scanner);
        aggiungiCavalliAGara(scanner, gara, numeroCavalli);

        // Inizia la gara
        gara.iniziaGara();
        scanner.close();
    }

    private static int richiediLunghezzaPercorso(Scanner scanner) {
        System.out.print("Inserisci la lunghezza del percorso in metri: ");
        return scanner.nextInt();
    }

    private static int richiediNumeroCavalli(Scanner scanner) {
        System.out.print("Inserisci il numero di cavalli: ");
        int numeroCavalli = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline rimasto
        return numeroCavalli;
    }

    private static void aggiungiCavalliAGara(Scanner scanner, Gara gara, int numeroCavalli) {
        for (int i = 0; i < numeroCavalli; i++) {
            System.out.print("Inserisci il nome del cavallo " + (i + 1) + ": ");
            String nomeCavallo = scanner.nextLine();
            gara.aggiungiCavallo(nomeCavallo);
        }
    }
}
