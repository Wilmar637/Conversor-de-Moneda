package controlador;

import modelo.ConsultaMoneda;
import modelo.Moneda;

public class ConversorControlador {

    private final ConsultaMoneda servicio;

    public ConversorControlador() {
        this.servicio = new ConsultaMoneda();
    }

    public Moneda convertir(String base, String destino, double cantidad) {
        return servicio.consultaMoneda(base, destino, cantidad);
    }
}
