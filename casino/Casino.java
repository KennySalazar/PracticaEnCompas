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
        System.out.println("Elige con cuanto dinero deseas empezar la partida");
        int dinero = scanner.nextInt();

        Carta[] mazoCartas = generarArregloCartas();

        while (dinero > 0) {
            int[] indicesRevueltos = generarIndicesRandom(mazoCartas.length);
            Carta[] cartasMostradas = new Carta[3];

            for (int i = 0; i < cartasMostradas.length; i++) {
                cartasMostradas[i] = mazoCartas[indicesRevueltos[i]];
            }

            int dineroApostado;

            System.out.println("Despues de revolver las cartas, el casino presenta las siguientes cartas:");
            System.out.println("1) " + cartasMostradas[0].getNombre());
            System.out.println("2) " + cartasMostradas[1].getNombre());

            System.out.println(
                    "Por favor ingresa la cantidad de dinero que quieres apostar para que el valor de la siguiente carta este entre los valores de las 2 cartas mostradas anteriormente");
            dineroApostado = scanner.nextInt();

            System.out.println(
                    "la carta sacada de la baraja es: " + cartasMostradas[2].getNombre() + ". Y tiene un valor de: "
                            + cartasMostradas[2].getValor());

            int valorGrande;
            int valorPequeno;
            if (Integer.valueOf(cartasMostradas[0].getValor()) > Integer.valueOf(cartasMostradas[1].getValor())) {
                valorGrande = Integer.valueOf(cartasMostradas[0].getValor());
                valorPequeno = Integer.valueOf(cartasMostradas[1].getValor());
            } else if (Integer.valueOf(cartasMostradas[0].getValor()) < Integer
                    .valueOf(cartasMostradas[1].getValor())) {
                valorGrande = Integer.valueOf(cartasMostradas[1].getValor());
                valorPequeno = Integer.valueOf(cartasMostradas[0].getValor());
            } else { // son iguales
                valorGrande = Integer.valueOf(cartasMostradas[0].getValor());
                valorPequeno = valorGrande;
            }

            int valorNuevaCarta = Integer.valueOf(cartasMostradas[2].getValor());

            if (valorNuevaCarta >= valorPequeno && valorNuevaCarta <= valorGrande) {
                dinero += dineroApostado;
                System.out.println(
                        "Felicidades!! El valor de la nueva carta mostrada esta entre los valores de las dos cartas mostradas anteriormente, ganas la apuesta y ahora tienes: "
                                + dinero + " de dinero.");

            } else {
                dinero -= dineroApostado;
                System.out.println(
                        "El valor de la nueva carta mostrada no esta entre los valores de las dos cartas mostradas anteriormente, pierdes la apuesta :( y ahora tienes: "
                                + dinero + " de dinero.");
            }
            if (dinero == 0) {
                System.out.println("\nUpss!! :( Te quedaste sin dinero, la partida ha terminado");
            }

        }

        System.out.println();
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
