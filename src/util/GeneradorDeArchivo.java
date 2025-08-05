package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.ConversionGuardada;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {

    public void guardarJson(ConversionGuardada conversion) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String nombreArchivo = String.format("conversion_%s_a_%s.json",
                conversion.base_code(),
                conversion.target_code());
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            escritor.write(gson.toJson(conversion));
        }
        System.out.println("Archivo guardado como: " + nombreArchivo);
    }
}
