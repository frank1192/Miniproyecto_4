package DAO;

import java.util.List;

import Modelos.Modelo_InicioSesion;

public interface InterfaceBienvenidos_DAO {
    List <Modelo_InicioSesion> administradores();
    Modelo_InicioSesion getAdministrador(String nombre);
}
