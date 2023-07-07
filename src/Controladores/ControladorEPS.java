package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaEPS;

public class ControladorEPS implements ActionListener{
    private VentanaEPS ventanaEPS;

    public ControladorEPS(VentanaEPS ventanaEPS){
        this.ventanaEPS = ventanaEPS;
    }

    public void iniciar(){
        ventanaEPS.setTitle("EPS");
        ventanaEPS.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
