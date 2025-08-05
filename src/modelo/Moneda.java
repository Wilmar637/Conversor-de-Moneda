package modelo;

/* Representa la respuesta de la API. Refleja exactamente el JSON que devuelve el servidor.
Puedes usar Moneda para múltiples APIs o servicios, sin acoplarlo a lógica local. */
public record Moneda(
        String base_code,
        String target_code,
        double conversion_rate,
        double conversion_result) {
}
