import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("**********************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida: ");
            System.out.println("**********************");

            int opcion = scanner.nextInt();

            if (opcion == 7) {
                continuar = false;
                System.out.println("Gracias por usar el conversor de monedas");
                break;
            }

            System.out.print("Ingrese el valor que deseas convertir: ");
            double monto = scanner.nextDouble();

            // Realizar la conversión
            Conversor conversor = new Conversor();
            String resultado = conversor.convertir(opcion, monto);

            System.out.println(resultado);
        }

        scanner.close();
    }
}
