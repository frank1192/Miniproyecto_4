package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaLiquidacion;

public class ControladorLiquidacion implements ActionListener{
    private VentanaLiquidacion ventanaLiquidacion;


    public ControladorLiquidacion(VentanaLiquidacion ventanaLiquidacion){
        this.ventanaLiquidacion = ventanaLiquidacion;
    }

    public void iniciar(){
        ventanaLiquidacion.setTitle("LIQUIDACION");
        ventanaLiquidacion.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
