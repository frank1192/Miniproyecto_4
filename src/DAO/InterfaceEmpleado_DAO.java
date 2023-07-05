/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;

import Modelos.Modelo_Empleado;

/**
 *
 * @author Miguel
 */
public interface InterfaceEmpleado_DAO {
    List<Modelo_Empleado> empleados();
    Modelo_Empleado getEmpleados(int identificacion);
    void save(Modelo_Empleado empleado);
    void delete(Modelo_Empleado empleado);
    void update(Modelo_Empleado empleado);
}
