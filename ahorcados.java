import java.util.Scanner;

public class ahorcados {
    public static void main(String[] args) {
        String[] palabras = { "java", "programacion", "practica", "juego", "computadora", "desarrollo" };
        String palabraSecreta = seleccionarPalabra(palabras);
        char[] palabraAdivinada = new char[palabraSecreta.length()];
        int intentosMaximos = 6;
        int intentosRealizados = 0;

        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Juego de Ahorcados!");

        while (intentosRealizados < intentosMaximos) {
            System.out.println("\nPalabra a adivinar: " + new String(palabraAdivinada));
            System.out.print("Adivina una letra: ");
            String entrada=scanner.next();
            char letra = entrada.charAt(0);
            boolean letraAdivinada = false;
            if(entrada.equalsIgnoreCase(palabraSecreta)){
                System.out.println("\n¡Felicidades! Adivinaste la palabra: " + palabraSecreta);
                break;
            }
            for (int i = 0; i < palabraSecreta.length(); i++) {
                String letra1 = String.valueOf(palabraSecreta.charAt(i));
                String letra2=String.valueOf(letra);
                if (letra1.equalsIgnoreCase(letra2)) {
                    palabraAdivinada[i] = palabraSecreta.charAt(i);
                    letraAdivinada = true;
                }

            }

            if (!letraAdivinada) {
                System.out.println("Letra incorrecta.");
                intentosRealizados++;
            }

            if(intentosRealizados == 1){
                System.out.println(" + ----- +");
                System.out.println(" |       |");
                System.out.println(" O       |");
                   
            }
               if(intentosRealizados == 2){
                System.out.println(" + ----- +");
                System.out.println(" |       |");
                System.out.println(" O       |");
                System.out.println(" |       |");
                   
            }
                if(intentosRealizados == 3){
                System.out.println(" + ----- +");
                System.out.println(" |       |");
                System.out.println(" O       |");
                System.out.println(" |~      |");
                       
            }
                 if(intentosRealizados == 4){
                System.out.println("  + ----- +");
                System.out.println("  |       |");
                System.out.println("  O       |");
                System.out.println(" ~|~      |");
        
            }
                   if(intentosRealizados == 5){
                System.out.println("  + ----- +");
                System.out.println("  |       |");
                System.out.println("  O       |");
                System.out.println(" ~|~      |");
                System.out.println("   ¬      |");
   
            }
                      if(intentosRealizados == 6){
                System.out.println("  + ----- +");
                System.out.println("  |       |");
                System.out.println("  O       |");
                System.out.println(" ~|~      |");
                System.out.println(" - ¬      |");
  
   
            }
            
            if (new String(palabraAdivinada).equals(palabraSecreta)) {
                System.out.println("\n¡Felicidades! Adivinaste la palabra: " + palabraSecreta);
                break;
            }
        }

        if (intentosRealizados == intentosMaximos) {
            System.out.println("\n¡Oh no! Has perdido. La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }

    private static String seleccionarPalabra(String[] palabras) {
        int indiceAleatorio = (int) (Math.random() * palabras.length);
        return palabras[indiceAleatorio];
    }
}