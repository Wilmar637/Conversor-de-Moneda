package vista;

import controlador.ConversorControlador;
import modelo.ConversionGuardada;
import modelo.Moneda;
import util.GeneradorDeArchivo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    private static final String INGRESE_USD = "Ingrese el valor en USD: ";
    private static final String INGRESE_ARS = "Ingrese el valor en ARS: ";
    private static final String INGRESE_BRL = "Ingrese el valor en BRL: ";
    private static final String INGRESE_COP = "Ingrese el valor en COP: ";

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ConversorControlador controlador = new ConversorControlador();

        double valor;
        String menu = """
                ********** Bienvenido/a al Conversor de Moneda **********
                
                1. Dólar => Peso Argentino
                2. Peso Argentino => Dólar
                3. Dólar => Real Brasileño
                4. Real Brasileño => Dólar
                5. Dólar => Peso Colombiano
                6. Peso Colombiano => Dólar
                7. Salir
                
                *********************************************************
                """;
        int opcion;

        do {
            System.out.println(menu);
            System.out.println("Seleccione Opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1 -> procesar(controlador, entrada, "USD", "ARS", INGRESE_USD);
                case 2 -> procesar(controlador, entrada, "ARS", "USD", INGRESE_ARS);
                case 3 -> procesar(controlador, entrada, "USD", "BRL", INGRESE_USD);
                case 4 -> procesar(controlador, entrada, "BRL", "USD", INGRESE_BRL);
                case 5 -> procesar(controlador, entrada, "USD", "COP", INGRESE_USD);
                case 6 -> procesar(controlador, entrada, "COP", "USD", INGRESE_COP);
                case 7 -> System.out.println("Gracias por usar nuestros servicios. ¡Hasta pronto!");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 7);
    }

    private static void procesar(ConversorControlador controlador, Scanner entrada, String origen, String destino, String mensaje) {
        System.out.print(mensaje);
        double cantidad = entrada.nextDouble();
        Moneda resultado = controlador.convertir(origen, destino, cantidad);
        mostrarResultado(resultado, cantidad);
    }

    private static void mostrarResultado(Moneda resultado, double cantidadOriginal) {
        System.out.printf("El valor %.2f [%s] corresponde a = %.2f [%s]%n",
                cantidadOriginal,
                resultado.base_code(),
                resultado.conversion_result(),
                resultado.target_code());

        ConversionGuardada conversion = new ConversionGuardada(
                resultado.base_code(),
                resultado.target_code(),
                cantidadOriginal,
                resultado.conversion_rate(),
                resultado.conversion_result()
        );

        try {
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(conversion);
        } catch (IOException e) {
            System.out.println("Error al guardar archivo JSON: " + e.getMessage());
        }
    }
}
