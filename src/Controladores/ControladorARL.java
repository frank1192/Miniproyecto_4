package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaARL;

public class ControladorARL implements ActionListener{
    private VentanaARL ventanaARL;


    public ControladorARL(VentanaARL ventanaARL){
        this.ventanaARL = ventanaARL;
    }

    public void iniciar(){
        ventanaARL.setTitle("ARL");
        ventanaARL.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
