package com.alura.conversormonedas.principal;

import com.alura.conversormonedas.modelos.Moneda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class ConversorDeMonedas {
    public static void main(String[] args) throws IOException, InterruptedException{

        List<String> codigosPermitidos = List.of("ARS", "BOB", "BRL", "CLP", "COP", "USD");
        String direccion = "https://v6.exchangerate-api.com/v6/58ed99175f2a13710af2e694/latest/USD";


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        List<Moneda> monedas = Conversor.obtenerMonedas(direccion, gson, codigosPermitidos);

        if (monedas == null || monedas.isEmpty()) {
            System.out.println("No se pudo obtener las tasas de conversión.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {

            Conversor.exibirMenu();
            opcion = scanner.nextInt();

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
        } while (opcion != 7);
    }

    public static void realizarConversionConMonedas(Scanner scanner, List<Moneda> monedas, String monedaOrigen, String monedaDestino) {
        Moneda monedaOrigenObj = null;
        Moneda monedaDestinoObj = null;

        for (Moneda moneda : monedas) {
            if (moneda.getCodigo().equals(monedaOrigen)) {
                monedaOrigenObj = moneda;
            }
            if (moneda.getCodigo().equals(monedaDestino)) {
                monedaDestinoObj = moneda;
            }
        }

        if (monedaOrigenObj == null || monedaDestinoObj == null) {
            System.out.println("Una o ambas monedas ingresadas no son válidas.");
            return;
        }

        System.out.print("Ingrese el monto a convertir (" + monedaOrigen + " a " + monedaDestino + "): ");
        double monto = scanner.nextDouble();

        double montoConvertido = (monto / monedaOrigenObj.getValor()) * monedaDestinoObj.getValor();

        String resultadoFormateado = String.format("%.2f", montoConvertido);

        System.out.println("El monto " + monto + " [" + monedaOrigen + "] corresponde al valor final de =>> " + resultadoFormateado + " [" + monedaDestino +"]");
    }

}
