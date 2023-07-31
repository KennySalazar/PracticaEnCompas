import java.util.Scanner;

public class SeleccionarJuegos {

    Ahorcados juego1 = new Ahorcados();
    Scanner scanner = new Scanner(System.in);

    public void MenuJuego() {
        int opcion = 0;

        do {
            System.out.println("\n-----BIENVENIDO------");
            System.out.println("Seleccione una de los siguientes juegos");
            System.out.println("1. Ahorcados");
            System.out.println("2. Basketball");
            System.out.println("3. Juego de cartas");
            System.out.println("4. Cerrar juego\n");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("--BIENVENIDO AL JUEGO AHORCADOS--\n");
                    juego1.jugar();
                    break;

                case 2:
                    System.out.println("--BIENVENIDO AL JUEGO DE BASKETBALL--\n");

                    break;
                case 3:
                    System.out.println("--BIENVENIDO AL JUEGO DE CARTAS--\n");

                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        } while (opcion != 0);
    }
}
