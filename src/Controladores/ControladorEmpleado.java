package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.InterfaceEmpleado_DAO;
import Modelos.Modelo_Empleado;
import vista.VentanaAgregarEmpleado;

public class ControladorEmpleado implements ActionListener{
    private VentanaAgregarEmpleado ventanaAgregarEmpleado;
    private Modelo_Empleado modelo_Empleado;
    private InterfaceEmpleado_DAO interfaceEmpleado_DAO;

    public ControladorEmpleado(VentanaAgregarEmpleado ventanaAgregarEmpleado){
        this.ventanaAgregarEmpleado = ventanaAgregarEmpleado;

        this.ventanaAgregarEmpleado.btnAgregar.addActionListener(this);
    }

    public void iniciar(){
        ventanaAgregarEmpleado.setTitle("EMPLEADOS");
        ventanaAgregarEmpleado.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ventanaAgregarEmpleado.btnAgregar){
            
        }
    }
}
