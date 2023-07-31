package basket;

import java.util.Scanner;
import java.util.Random;

public class Basket {

    public static void main(String[] args) {
        Basket juego = new Basket();
        juego.jugar();
    }

    public void jugar() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Cual es el nombre del jugador 1?");
        String nombreJ1 = scanner.next();

        System.out.println("Cual es el nombre del jugador 2?");
        String nombreJ2 = scanner.next();

        System.out.println("Entonces los jugadores seran: " + nombreJ1 + " y " + nombreJ2);

        System.out.println("Cuantos turnos tendra este juego?");
        int cantidadTurnos = scanner.nextInt();

        // posicionar jugadores aleatoriamente
        Random rnd = new Random();
        int posicionJ1 = rnd.nextInt(2) + 1;

        // crear jugadores
        Jugador j1 = new Jugador(nombreJ1);
        Jugador j2 = new Jugador(nombreJ2);

        System.out.println("Que empiece el juego!");

        for (int i = 0; i < cantidadTurnos; i++) {

            System.out.println("<---------------------------------------------->");

            j1.reset();
            j2.reset();

            if (posicionJ1 == 1) {
                j1.decidirTiro();
                j2.decidirTiro();
                j1.decidirDefensa(j2);
                j2.decidirDefensa(j1);

                ejecutarTurno(j1, j2);
            } else {
                j2.decidirTiro();
                j1.decidirTiro();
                j2.decidirDefensa(j1);
                j1.decidirDefensa(j2);

                ejecutarTurno(j2, j1);
            }

        }

        if (j1.getPuntos() > j2.getPuntos()) {
            System.out.println(j1.getNombre() + " ha ganado la partida con un total de " + j1.getPuntos() + " contra "
                    + j2.getPuntos());

        } else if (j1.getPuntos() < j2.getPuntos()) {
            System.out.println(j2.getNombre() + " ha ganado la partida con un total de " + j2.getPuntos() + " contra "
                    + j1.getPuntos());

        } else {
            System.out.println("El juego ha terminado en empate");
        }

        scanner.close();
    }

    public void ejecutarTurno(Jugador j1, Jugador j2) {
        j1.tirar();
        j2.tirar();

        // verificar faltas
        j1.verificarFalta(j2);
        j2.verificarFalta(j1);
    }
}