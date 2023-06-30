/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import Modelos.Modelo_Bienvenido;
import vista.VentanaBienvenidos;
import vista.VentanaMenu;

/**
 *
 * @author jeanp
 */

public class ControladorBienvenidos implements ActionListener{
    private VentanaBienvenidos ventanaBienvenido;
    //private Modelo_Bienvenido modeloBienvenido;
    
    public ControladorBienvenidos(VentanaBienvenidos ventanaBienvenidos){
        this.ventanaBienvenido = ventanaBienvenidos;

        this.ventanaBienvenido.btnIniciarSesion.addActionListener(this);

    }
    
    public void iniciar(){
        ventanaBienvenido.setTitle("Bienvenido");
        ventanaBienvenido.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ventanaBienvenido.btnIniciarSesion){
            ventanaBienvenido.setVisible(false);
            VentanaMenu ventanaMenu = new VentanaMenu();
            ventanaMenu.setVisible(true);
            ControladorMenu controladorMenu = new ControladorMenu(ventanaMenu);
            controladorMenu.iniciar();
        }
    }
}
