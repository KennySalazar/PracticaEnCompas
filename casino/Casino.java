package casino;

import java.util.Random;
import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {
        Casino casino = new Casino();
        casino.jugar();
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al juego de apuestas!");

        Carta[] mazoCartasRevuelto = revolverCartas(generarArregloCartas());
        System.out.println("La carta numero 34 es " + mazoCartasRevuelto[34].getNombre());
    }

    public Carta[] generarArregloCartas() {

        int totalValoresCarta = ValorCartaPoker.values().length;
        int totalPalosCarta = PaloCartaPoker.values().length;

        int totalCartas = totalPalosCarta * totalValoresCarta;

        Carta[] cartas = new Carta[totalCartas];

        int indice = 0;

        for (int i = 0; i < totalPalosCarta; i++) {
            PaloCartaPoker palo = PaloCartaPoker.values()[i];

            for (int j = 0; j < totalValoresCarta; j++) {
                ValorCartaPoker valor = ValorCartaPoker.values()[j];
                cartas[indice] = new Carta(valor, palo);

                indice++;
            }

        }

        return cartas;
    }

    public Carta[] revolverCartas(Carta[] mazo) {
        Carta[] mazoRevuelto = new Carta[mazo.length];

        // generar arreglo de indices aleatorios de 0 a mazo.length -1
        int[] indices = generarIndicesRandom(mazo.length);

        // Revolver mazo en base a los indices random
        for (int i = 0; i < mazo.length; i++) {
            mazoRevuelto[i] = mazo[indices[i]];
        }

        return mazoRevuelto;
    }

    private int[] generarIndicesRandom(int n) {
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Random random = new Random();

        for (int i = n - 1; i >= 1; i--) {
            int j = random.nextInt(i + 1);

            int temp = indices[i];
            indices[i] = indices[j];
            indices[j] = temp;
        }

        return indices;
    }
}
