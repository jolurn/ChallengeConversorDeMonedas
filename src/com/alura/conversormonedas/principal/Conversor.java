package com.alura.conversormonedas.principal;

import com.alura.conversormonedas.excepcion.ErrorEnConversionDeDuracionException;
import com.alura.conversormonedas.modelos.ConversionApiResponseOmdb;
import com.alura.conversormonedas.modelos.Moneda;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public static void exibirMenu() {
        System.out.println("""
            
            ***************************************************
            
            Sea bienvenido/a al Conversor de Moneda =]
            1) Dólar =>> Pesos argentinos
            2) Pesos argentinos =>> Dólar
            3) Dólar =>> Real brasileño
            4) Real brasileño =>> Dólar
            5) Dólar =>> Peso colombiano
            6) Peso colombiano =>> Dólar
            7) Salir
            Elija una opción válida:
            ***************************************************""");
        }

    public static List<Moneda> obtenerMonedas(String direccion, Gson gson, List<String> codigosPermitidos) throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            if (response.statusCode() == 200) {
                ConversionApiResponseOmdb conversionResponse = gson.fromJson(json, ConversionApiResponseOmdb.class);
                Map<String, Double> conversionRates = conversionResponse.conversionRates();

                List<Moneda> monedas = new ArrayList<>();
                for (Map.Entry<String, Double> entry : conversionRates.entrySet()) {
                    monedas.add(new Moneda(entry.getKey(), entry.getValue()));
                }

                return monedas;
            } else {
                System.out.println("Error en la respuesta de la API. Código de estado: " + response.statusCode());
            }
        } catch(NumberFormatException e){
            System.out.println("Ocurrio un error: ");
            System.out.println(e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println("Error en la URL verifique la dirección.");
        }catch (ErrorEnConversionDeDuracionException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void realizarConversion(Scanner scanner, Map<String, Double> conversionRates, String monedaOrigen, String monedaDestino) {

        if (!conversionRates.containsKey(monedaOrigen) || !conversionRates.containsKey(monedaDestino)) {
            System.out.println("Una o ambas monedas ingresadas no son válidas.");
            return;
        }

        System.out.print("Ingrese el monto a convertir (" + monedaOrigen + " a " + monedaDestino + "): ");
        double monto = scanner.nextDouble();

        double tasaOrigen = conversionRates.get(monedaOrigen);
        double tasaDestino = conversionRates.get(monedaDestino);

        double montoConvertido = (monto / tasaOrigen) * tasaDestino;

        String resultadoFormateado = String.format("%.2f", montoConvertido);

        System.out.println("El monto " + monto + " [" + monedaOrigen + "] corresponde al valor final de =>> " + resultadoFormateado + " [" + monedaDestino +"]");
    }
}
