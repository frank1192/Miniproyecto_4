package Controladores;

import DAO.InterfaceFondoPension_DAO;
import Modelos.Modelo_Fondo_pension;
import vista.VentanaFondoDePension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorFondoDePension implements ActionListener{
    private VentanaFondoDePension ventanaFondoDePension;
    private Modelo_Fondo_pension modelo_Fondo_pension;
    private InterfaceFondoPension_DAO interfaceFondoPension_DAO;

    ControladorFondoDePension(VentanaFondoDePension ventanaFondoDePension){
        this.ventanaFondoDePension = ventanaFondoDePension;
    }

    public void iniciar(){
        ventanaFondoDePension.setTitle("FONDO DE PENSION");
        ventanaFondoDePension.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
