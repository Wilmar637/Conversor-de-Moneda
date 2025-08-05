package modelo;

/* Representa la estructura personalizada que quieres guardar o mostrar, incluyendo cantidad_original.
Si mañana quieres agregar timestamp, usuario, ubicación, historial, etc., lo haces aqui */
public record ConversionGuardada(
        String base_code,
        String target_code,
        double cantidad_original,
        double conversion_rate,
        double conversion_result
) {
}
