/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;

import Modelos.Modelo_Empresa;

/**
 *
 * @author Miguel
 */
public class ImplementacionEmpresa_DAO implements InterfaceEmpresa_DAO{

    private List<Modelo_Empresa> empresas;

    public ImplementacionEmpresa_DAO(){
        empresas = new ArrayList<>();
    }

    @Override
    public List<Modelo_Empresa> empresas() {
        return empresas;
    }

    @Override
    public Modelo_Empresa getEmpresa(int nit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmpresa'");
    }

    @Override
    public void save(Modelo_Empresa empresa) {
        empresas.add(empresa);
    }

    @Override
    public void delete(Modelo_Empresa empresa) {
        empresas.remove(empresa);
    }
    
}
