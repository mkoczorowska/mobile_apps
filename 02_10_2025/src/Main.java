import java.util.*;

public class Main {

    // metoda losująca liczby od 1 do 6
    public static int[] rzutKoscmi(int liczbaKostek) {
        Random rand = new Random();
        int[] wyniki = new int[liczbaKostek];
        for (int i = 0; i < liczbaKostek; i++) {
            wyniki[i] = rand.nextInt(6) + 1;
        }
        return wyniki;
    }

    public static int obliczPunkty(int[] wyniki) {
        Map<Integer, Integer> licznik = new HashMap<>();

        for (int wynik : wyniki) {
            licznik.put(wynik, licznik.getOrDefault(wynik, 0) + 1);
        }

        int suma = 0;
        for (Map.Entry<Integer, Integer> entry : licznik.entrySet()) {
            if (entry.getValue() >= 2) {
                suma += entry.getKey() * entry.getValue();
            }
        }
        return suma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char wybor;

        System.out.println("Witaj w grze w kości!");

        do {
            int liczbaKostek;

            while (true) {
                System.out.print("Podaj liczbę kostek do rzutu (3-10): ");
                liczbaKostek = scanner.nextInt();
                if (liczbaKostek >= 3 && liczbaKostek <= 10) {
                    break;
                }
                System.out.println("Błędna liczba! Wpisz wartość z przedziału 3-10.");
            }

            int[] wyniki = rzutKoscmi(liczbaKostek);

            System.out.println("\nWyniki rzutu: ");
            for (int i = 0; i < wyniki.length; i++) {
                System.out.println("Kostka " + (i + 1) + ": " + wyniki[i]);
            }

            int suma = obliczPunkty(wyniki);
            System.out.println("Suma punktów: " + suma);

            System.out.print("\nCzy chcesz zagrać ponownie? (t/n): ");
            wybor = scanner.next().toLowerCase().charAt(0);

            System.out.println();
        } while (wybor == 't');

        System.out.println("Dziękujemy za grę!");
        scanner.close();
    }
}
