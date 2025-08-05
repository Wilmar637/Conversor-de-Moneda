package modelo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    private static final String API_KEY = "4e3cac395e4848440a0c6ff8";

    public Moneda consultaMoneda(String baseCode, String targetCode, double amount) {
        String url = String.format(
                "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
                API_KEY, baseCode, targetCode
        );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Usamos Gson para deserializar el JSON
            var json = new Gson().fromJson(response.body(), JsonObject.class);

            // Validamos si la API respondió bien
            if (!"success".equals(json.get("result").getAsString())) {
                throw new RuntimeException("Error en la respuesta de la API");
            }

            double rate = json.get("conversion_rate").getAsDouble();
            return new Moneda(
                    baseCode,
                    targetCode,
                    rate,
                    rate * amount
            );

        } catch (Exception e) {
            throw new RuntimeException("No se pudo hacer la conversion: " + e.getMessage());
        }
    }
}
