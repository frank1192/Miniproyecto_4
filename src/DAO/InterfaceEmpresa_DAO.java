/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;

import Modelos.Modelo_Empresa;

/**
 *
 * @author Miguel
 */
public interface InterfaceEmpresa_DAO {
    List<Modelo_Empresa> empresas();
    Modelo_Empresa getEmpresa(int nit);
    void save(Modelo_Empresa empresa);
    void delete(Modelo_Empresa empresa);

}
