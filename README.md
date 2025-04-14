<h1 align="center"> Conversor de Monedas </h1>

Este es un proyecto de conversión de monedas que permite convertir diferentes tipos de monedas a través de un conjunto de tasas de cambio obtenidas de una API externa.
El sistema permite la conversión de monedas como Dólar (USD), Pesos Argentinos (ARS), Real Brasileño (BRL) y Peso Colombiano (COP).

## Tecnologías Usadas
- **Java**: Lenguaje principal del proyecto.
- **Gson**: Biblioteca para convertir objetos Java a JSON y viceversa.
- **HTTP Client (Java)**: Para hacer solicitudes HTTP y obtener datos de la API.

## Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/jolurn/ChallengeConversorDeMonedas.git
   ```
2. Navega a la carpeta del proyecto:
   ```bash
   cd conversor-de-monedas
   ```
3. Compila y ejecuta el proyecto (asegúrate de tener Java instalado):
   ```bash
   javac -cp . ConversorDeMonedas.java
   java -cp . ConversorDeMonedas
   ```

#### 5. **Uso**
Explica cómo usar el proyecto o cómo interactuar con la aplicación. Esto es particularmente importante para aplicaciones interactivas o que requieren configuración.
markdown

## Uso
Al ejecutar el programa, verás un menú interactivo en la consola que te permitirá elegir entre varias opciones de conversión de moneda.
Sigue las instrucciones para realizar una conversión, introduciendo el monto y seleccionando las monedas que deseas convertir.

## Ejemplo de Conversión
- Opción 1: Dólar (USD) a Pesos Argentinos (ARS)
- Ingrese monto: 100
- Resultado: 100 USD corresponde a 18.500 ARS

## Contribución
Si deseas contribuir al proyecto, por favor sigue estos pasos:
1. Haz un fork del repositorio.
2. Crea una rama para tu nueva funcionalidad:
   ```bash
   git checkout -b mi-nueva-funcionalidad
   ```
3. Haz tus cambios y haz un commit con un mensaje claro.
4. Envía un pull request con una descripción detallada de los cambios realizados.

## Licencia
Este proyecto está bajo la Licencia MIT. Para más detalles, consulta el archivo [LICENSE](LICENSE).

## Créditos
- **Gson**: Para la deserialización de JSON.
- **ExchangeRate-API**: Para obtener las tasas de conversión de monedas.
