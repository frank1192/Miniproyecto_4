package Mapeado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;



public class Mapeado {
    
    public static final String[] cabeceras = {
        "Ficha",
        "Fecha De Corte",
        "Hacienda Suerte",
        "Tonelada De Corte",
        "Tipo De Caña",
        "Dia De Corte"
    };

    public static ArrayList<String> readFile(final String ruta) throws IOException{
        final InputStream in = Mapeado.class.getResourceAsStream(ruta);
        final Reader fr = new InputStreamReader(in, "utf-8");
        
        final BufferedReader reader = new BufferedReader(fr);

        final ArrayList<String> datos = new ArrayList<>();

        String linea;

        while((linea = reader.readLine()) != null){
            datos.add(linea);
        }

        return datos;
    }

    public static String transformar(final ArrayList<String> datos){
        String res = String.join(";", cabeceras) + "\n";

        final Iterator<String> it = datos.iterator();

        while(it.hasNext()){
            final String fila = it.next();

            if (fila != null) {
                final String sub = fila.substring(0, 18) + fila.substring(22, 29);

                final String ficha = sub.substring(0, 4);
                final String fecha = sub.substring(4, 12);
                final String hacienda_suerte = sub.substring(12, 18);
                final String corte = sub.substring(18, 23);
                final String tipo_cana = String.valueOf(sub.charAt(23));
                final String dia_corte = String.valueOf(sub.charAt(24));

                final String[] dat = {
                        ficha,
                        fecha,
                        hacienda_suerte,
                        corte,
                        tipo_cana,
                        dia_corte
                };

                res += String.join(";", dat) + "\n";

            }
        }

        return res;
    }

    public static void transformarYGuardar(final ArrayList<String> datos, final String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(String.join(";", cabeceras));
            writer.newLine();

            final Iterator<String> it = datos.iterator();

            while (it.hasNext()) {
                final String fila = it.next();

                if (fila != null) {
                    final String sub = fila.substring(0, 18) + fila.substring(22, 29);

                    final String ficha = sub.substring(0, 4);
                    final String fecha = sub.substring(4, 12);
                    final String hacienda_suerte = sub.substring(12, 18);
                    final String corte = sub.substring(18, 23);
                    final String tipo_cana = String.valueOf(sub.charAt(23));
                    final String dia_corte = String.valueOf(sub.charAt(24));

                    final String[] dat = {
                            ficha,
                            fecha,
                            hacienda_suerte,
                            corte,
                            tipo_cana,
                            dia_corte
                    };
                    
                    writer.write(String.join(";", dat));
                    writer.newLine();
                }
            }

            System.out.println("Mapeo guardado en el archivo: " + rutaArchivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
