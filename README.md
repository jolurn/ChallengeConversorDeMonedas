<p align="center">
  <img src="https://i.pinimg.com/736x/50/1d/2c/501d2c40369db576631c9c8f7b6be903.jpg" height="200"/>
</p>
<h1 align="center"> Conversor de Monedas </h1>

Este es un proyecto de conversión de monedas que permite convertir diferentes tipos de monedas a través de un conjunto de tasas de cambio obtenidas de una API externa.
El sistema permite la conversión de monedas como Dólar (USD), Pesos Argentinos (ARS), Real Brasileño (BRL) y Peso Colombiano (COP).

## Tecnologías Usadas
- **Java 20**: Lenguaje de programación principal, aprovechando las funcionalidades modernas del JDK 20 para una mayor eficiencia y rendimiento.
- **Gson**: Biblioteca de Google utilizada para convertir objetos Java a formato JSON y viceversa, facilitando el manejo de datos estructurados.
- **HttpClient (java.net.http)**: API incorporada en Java para realizar solicitudes HTTP. Se utilizaron específicamente:
  - `HttpRequest`: Para construir solicitudes HTTP a servicios externos.
  - `HttpResponse`: Para manejar las respuestas devueltas por la API.
- **API de ExchangeRate**: Servicio externo que provee información actualizada sobre tipos de cambio de divisas en tiempo real.
- **IDE (por ejemplo, IntelliJ IDEA / VS Code / Eclipse)**: Entorno de desarrollo integrado utilizado para escribir, ejecutar y depurar el código.

Estas herramientas permiten que la aplicación consulte una API en tiempo real y realice conversiones de monedas de manera eficiente.

## 🛠️ Instalación
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

Al ejecutar la aplicación, verás un menú interactivo que te permite seleccionar entre diferentes opciones de conversión de monedas. Para utilizar el sistema, sigue estos pasos:

1. Abre la consola y ejecuta el programa.
2. Elige una de las opciones disponibles en el menú. Por ejemplo:
   - 1. Dólar (USD) a Peso argentino (ARS)
   - 2. Dólar (USD) a Real brasileño (BRL)
   - 3. Dólar (USD) a Peso colombiano (COP)
   - 4. Peso argentino (ARS) a Dólar (USD)
   - ...entre otras.
3. Ingresa el monto que deseas convertir.
4. El sistema consultará automáticamente la tasa de cambio actual desde la API y mostrará el resultado de la conversión.
5. Puedes repetir el proceso con otras monedas o salir del programa eligiendo la opción correspondiente.

## Ejemplo de Conversión
- Opción 1: Dólar (USD) a Pesos Argentinos (ARS)
- Ingrese monto: 100
- Resultado: 100 USD corresponde a 18.500 ARS

## 👨‍💻 Contribución
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

## 🧰 Créditos
- **Gson**: Para la deserialización de JSON.
- **ExchangeRate-API**: Para obtener las tasas de conversión de monedas.

<p align="center">
  <img src="https://firebasestorage.googleapis.com/v0/b/confecciones-5368b.appspot.com/o/Captura%20de%20pantalla%202025-04-13%20215533.jpg?alt=media&token=23aed311-540a-4e5b-b88b-0fa273ee66a8" height="200"/>
</p>
