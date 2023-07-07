/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nomina_univalle;

import java.io.IOException;
import java.util.ArrayList;

import Controladores.ControladorBienvenidos;
import Mapeado.Mapeado;
import vista.VentanaBienvenidos;

/**
 *
 * @author Franklin Aguirre
 */
public class Nomina_UNIVALLE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VentanaBienvenidos ventanaBienvenidos = new VentanaBienvenidos();
        ControladorBienvenidos controladorBienvenidos = new ControladorBienvenidos(ventanaBienvenidos);

        controladorBienvenidos.iniciar();
        ventanaBienvenidos.setVisible(true);

        try {
            final ArrayList<String> datosArchivo = Mapeado.readFile("../Archivos/datos.txt");
            final String datosCSV = Mapeado.transformar(datosArchivo);
            final String rutaArchivoSalida = "src/Archivos/Mapeado.txt";

            Mapeado.transformarYGuardar(datosArchivo, rutaArchivoSalida);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
