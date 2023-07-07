package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaCajadeCompensacion;

public class ControladorCajaDeCompensacion implements ActionListener{
    private VentanaCajadeCompensacion ventanaCajadeCompensacion;


    public ControladorCajaDeCompensacion(VentanaCajadeCompensacion ventanaCajadeCompensacion){
        this.ventanaCajadeCompensacion = ventanaCajadeCompensacion;
    }

    public void iniciar(){
        ventanaCajadeCompensacion.setTitle("CAJA DE COMPENSACION");
        ventanaCajadeCompensacion.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


}
