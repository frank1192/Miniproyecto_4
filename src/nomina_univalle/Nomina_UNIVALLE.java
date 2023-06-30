/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nomina_univalle;

import Controladores.ControladorBienvenidos;
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
    }
    
}
