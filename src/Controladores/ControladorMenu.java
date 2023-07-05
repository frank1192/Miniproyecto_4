/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaARL;
import vista.VentanaAgregarEmpleado;
import vista.VentanaCajadeCompensacion;
import vista.VentanaEPS;
import vista.VentanaFondoDePension;
//import vista.VentanaLiquidacion;
import vista.VentanaMenu;


public class ControladorMenu implements ActionListener{
    private VentanaMenu ventanaMenu;


    public ControladorMenu(VentanaMenu ventanaMenu){
        this.ventanaMenu = ventanaMenu;

        //Funcionalidad de los botones
        this.ventanaMenu.btnARL.addActionListener((ActionListener) this);
        this.ventanaMenu.btnEPS.addActionListener((ActionListener) this);
        this.ventanaMenu.btnEmpleado.addActionListener((ActionListener) this);
        this.ventanaMenu.btnPreparar_Liquidacion.addActionListener((ActionListener) this);
        this.ventanaMenu.btnCaja_De_Compensacion.addActionListener((ActionListener) this);
        this.ventanaMenu.btnFondo_Pension.addActionListener((ActionListener) this);
    }
    

    public void iniciar() {
        ventanaMenu.setTitle("MENU");
        ventanaMenu.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ventanaMenu.btnARL){

            ventanaMenu.setVisible(false);
            VentanaARL ventanaARL = new VentanaARL();
            //ControladorARL controladorARL = new ControladorARL();
            ventanaARL.setVisible(true);
            
        }

        if(e.getSource() == ventanaMenu.btnEPS){

            ventanaMenu.setVisible(false);
            VentanaEPS ventanaEPS = new VentanaEPS();
            //ControladorEPS controladorEPS = new ControladorEPS();
            ventanaEPS.setVisible(true);
        }

        if(e.getSource() == ventanaMenu.btnEmpleado){

            ventanaMenu.setVisible(false);
            VentanaAgregarEmpleado ventanaAgregarEmpleado = new VentanaAgregarEmpleado();
            ControladorEmpleado controladorEmpleado = new ControladorEmpleado(ventanaAgregarEmpleado);
            ventanaAgregarEmpleado.setVisible(true);
            controladorEmpleado.iniciar();

        }

        /*if(e.getSource() == ventanaMenu.btnPreparar_Liquidacion){
            ventanaMenu.setVisible(false);
            vistaliquidacion.setVisible(true);
        }*/

        if(e.getSource() == ventanaMenu.btnCaja_De_Compensacion){

            ventanaMenu.setVisible(false);
            VentanaCajadeCompensacion ventanaCajadeCompensacion = new VentanaCajadeCompensacion();
            //ControladorCajaDeCompensacion controladorCajaDeCompensacion = new ControladorCajaDeCompensacion();
            ventanaCajadeCompensacion.setVisible(true);
        }
        if(e.getSource() == ventanaMenu.btnFondo_Pension){

            ventanaMenu.setVisible(false);
            VentanaFondoDePension ventanaFondoDePension = new VentanaFondoDePension();
            ControladorFondoDePension controladorFondoDePension = new ControladorFondoDePension(ventanaFondoDePension);
            ventanaFondoDePension.setVisible(true);
            controladorFondoDePension.iniciar();
        }
    }
}



