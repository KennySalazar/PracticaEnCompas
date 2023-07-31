import java.util.Scanner;

import ahorcado.Ahorcados;
import basket.Basket;
import casino.Casino;

public class SeleccionarJuegos {

    Scanner scanner = new Scanner(System.in);

    public void desplegarMenu() {
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
                    Ahorcados ahorcado = new Ahorcados();
                    ahorcado.jugar();
                    break;

                case 2:
                    System.out.println("--BIENVENIDO AL JUEGO DE BASKETBALL--\n");
                    Basket basket = new Basket();
                    basket.jugar();
                    break;
                case 3:
                    Casino casino = new Casino();
                    casino.jugar();
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        } while (opcion != 0);
    }
}
