/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;

import Modelos.Modelo_Empleado;

/**
 *
 * @author Miguel
 */
public class ImplementacionEmpleado_DAO implements InterfaceEmpleado_DAO{

    private List<Modelo_Empleado> listaEmpleados;

    public ImplementacionEmpleado_DAO(){
        listaEmpleados= new ArrayList<>();
    }

    @Override
    public List<Modelo_Empleado> empleados() {
        return listaEmpleados;
    }

    @Override
    public Modelo_Empleado getEmpleados(int identificacion) {
        for (Modelo_Empleado empleado : listaEmpleados) {
            if (empleado.getIdentificacion() == identificacion) {
                return empleado;
            }
        }
        return null;
    }

    @Override
    public void save(Modelo_Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    @Override
    public void delete(Modelo_Empleado empleado) {
        listaEmpleados.remove(empleado);
    }

    @Override
    public void update(Modelo_Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
