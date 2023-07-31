package basket;

import java.util.Random;
import java.util.Scanner;

public class Jugador {

    private String nombre;
    private int probabilidadAnotar;
    private int puntos;
    private int probabilidadFalta;
    private int puntosXCanasta;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.probabilidadAnotar = 0;
        this.probabilidadFalta = 0;
        this.puntosXCanasta = 0;
    }

    public void decidirDefensa(Jugador jOponente) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(nombre + ", por favor decide que tipo de defensa quieres hacer durante el siguiente turno");
        System.out.println(
                "1. Defensa cuerpo a cuerpo, reduce la probabilidad de anotar en un 15% y probabilidad de hacer falta del 35%");
        System.out.println(
                "2. Defensa fuerte, reduce la probabilidad de anotar en un 30%  y probabilidad de hacer falta del 65%");

        int eleccion = scanner.nextInt();

        if (eleccion == 1) {
            jOponente.reducirProbabilidadAnotar(15);
            this.probabilidadFalta = 35;
        } else if (eleccion == 2) {
            jOponente.reducirProbabilidadAnotar(30);
            this.probabilidadFalta = 65;
        } else {
            System.out.println("Esa no es una opcion");
            this.decidirDefensa(jOponente);
        }

    }

    public void decidirTiro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(nombre + ", por favor decide que tipo de tiro quieres hacer durante el siguiente turno");
        System.out.println("1. Salto largo desde 5 metros, vale 3 puntos y la probabilidad de anotar es de 65%");
        System.out.println("2. Salto corto desde 3 metros, vale 2 puntos y la probabilidad de anotar es de 80%");
        // TODO: Deberiamos poner todo el texto o solo lo primero?

        int eleccion = scanner.nextInt();

        if (eleccion == 1) {
            this.puntosXCanasta = 3;
            this.probabilidadAnotar = 65;
        } else if (eleccion == 2) {
            this.puntosXCanasta = 2;
            this.probabilidadAnotar = 80;
        } else {
            System.out.println("Esa no es una opcion");
            this.decidirTiro();
        }
    }

    public void tirar() {
        Random rnd = new Random();

        int numAleatorio = rnd.nextInt(100) + 1;
        if (numAleatorio <= probabilidadAnotar) {
            this.puntos += puntosXCanasta;
            System.out.println(nombre + " ha anotado y ahora tiene " + puntos + " puntos");
        } else {
            System.out.println(nombre + " ha fallado su tiro, sus puntos siguen en " + puntos);
        }
    }

    public void falta(Jugador jOponente) {
        System.out.println(nombre + " al defender ha hecho falta, por lo que se le otorga un tiro libre a "
                + jOponente.getNombre());
        jOponente.setProbabilidadAnotar(90);
        jOponente.setPuntosXCanasta(2);
        jOponente.tirar();

    }

    public void verificarFalta(Jugador jOponente) {
        Random rnd = new Random();
        int probabilidadFalta = rnd.nextInt(100) + 1;
        if (probabilidadFalta <= this.probabilidadFalta)
            falta(jOponente);
    }

    public void reset() {
        this.probabilidadAnotar = 0;
        this.probabilidadFalta = 0;
        this.puntosXCanasta = 0;
    }

    public void reducirProbabilidadAnotar(int reduccion) {
        this.probabilidadAnotar -= reduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setProbabilidadAnotar(int probabilidadAnotar) {
        this.probabilidadAnotar = probabilidadAnotar;
    }

    public void setProbabilidadFalta(int probabilidadFalta) {
        this.probabilidadFalta = probabilidadFalta;
    }

    public void setPuntosXCanasta(int puntosXCanasta) {
        this.puntosXCanasta = puntosXCanasta;
    }

}
