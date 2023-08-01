import java.util.NoSuchElementException;
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
                    preguntar(ahorcado);
                    break;

                case 2:
                    System.out.println("--BIENVENIDO AL JUEGO DE BASKETBALL--\n");
                    Basket basket = new Basket();
                    basket.jugar();
                    preguntar(basket);
                    break;
                case 3:
                    Casino casino = new Casino();
                    casino.jugar();
                    preguntar(casino);
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        } while (opcion != 0);
    }

    public void preguntar(Object var) {
        Scanner scanner1 = new Scanner(System.in);
        int opcion1 = 2;
        while (opcion1 != 0) {
            System.out.println("Elija una opcion:");
            System.out.println("1. Seguir jugando");
            System.out.println("0. Ir al menu");

            opcion1 = scanner1.nextInt();
            if (opcion1 == 1) {
                if (var.getClass() == Ahorcados.class) {
                    ((Ahorcados) var).jugar();
                }else if(var.getClass()==Basket.class){
                    ((Basket) var).jugar();
                }else if(var.getClass()==Casino.class){
                    ((Casino) var).jugar();
                }
            }

        }

    }
}
