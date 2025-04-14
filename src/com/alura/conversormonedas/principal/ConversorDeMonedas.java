package com.alura.conversormonedas.principal;

import com.alura.conversormonedas.modelos.Moneda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

public class ConversorDeMonedas {
    public static void main(String[] args) throws IOException, InterruptedException{
        // Listar monedas permitidas
        List<String> codigosPermitidos = List.of("ARS", "BOB", "BRL", "CLP", "COP", "USD");
        String direccion = "https://v6.exchangerate-api.com/v6/58ed99175f2a13710af2e694/latest/USD";

        // Crear objeto Gson para deserializar la respuesta JSON
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        // Obtener las monedas (con sus tasas) desde la API
        List<Moneda> monedas = Conversor.obtenerMonedas(direccion, gson, codigosPermitidos);

        if (monedas == null || monedas.isEmpty()) {
            System.out.println("No se pudo obtener las tasas de conversión.");
            return;
        }

        // Bucle de interacción con el usuario
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el menú
            Conversor.exibirMenu();
            opcion = scanner.nextInt();  // Capturar la opción elegida

            switch (opcion) {
                case 1:
                    realizarConversionConMonedas(scanner, monedas, "USD", "ARS");
                    break;
                case 2:
                    realizarConversionConMonedas(scanner, monedas, "ARS", "USD");
                    break;
                case 3:
                    realizarConversionConMonedas(scanner, monedas, "USD", "BRL");
                    break;
                case 4:
                    realizarConversionConMonedas(scanner, monedas, "BRL", "USD");
                    break;
                case 5:
                    realizarConversionConMonedas(scanner, monedas, "USD", "COP");
                    break;
                case 6:
                    realizarConversionConMonedas(scanner, monedas, "COP", "USD");
                    break;
                case 7:
                    System.out.println("¡Gracias por usar el conversor! Adiós.");
                    break;
                default:
                    System.out.println("Elija una opción válida.");
            }
        } while (opcion != 7); // El bucle continúa hasta que el usuario elija salir
    }

    // Método para realizar la conversión de monedas usando los objetos Moneda
    public static void realizarConversionConMonedas(Scanner scanner, List<Moneda> monedas, String monedaOrigen, String monedaDestino) {
        Moneda monedaOrigenObj = null;
        Moneda monedaDestinoObj = null;

        // Buscar las monedas en la lista
        for (Moneda moneda : monedas) {
            if (moneda.getCodigo().equals(monedaOrigen)) {
                monedaOrigenObj = moneda;
            }
            if (moneda.getCodigo().equals(monedaDestino)) {
                monedaDestinoObj = moneda;
            }
        }

        // Verificar si ambas monedas fueron encontradas
        if (monedaOrigenObj == null || monedaDestinoObj == null) {
            System.out.println("Una o ambas monedas ingresadas no son válidas.");
            return;
        }

        // Solicitar el monto a convertir
        System.out.print("Ingrese el monto a convertir (" + monedaOrigen + " a " + monedaDestino + "): ");
        double monto = scanner.nextDouble();

        // Calcular la conversión
        double montoConvertido = (monto / monedaOrigenObj.getValor()) * monedaDestinoObj.getValor();

        // Redondear el resultado a 2 decimales
        String resultadoFormateado = String.format("%.2f", montoConvertido);

        // Mostrar el resultado
        System.out.println("El monto " + monto + " [" + monedaOrigen + "] corresponde al valor final de =>> " + resultadoFormateado + " [" + monedaDestino +"]");
    }

}
