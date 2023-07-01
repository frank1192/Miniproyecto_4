
package DAO;

import java.util.List;
import Modelos.Modelo_InicioSesion ;
import java.util.ArrayList;
/**
 *
 * @author Franklin Aguirre
 */
public class ImplementacionBienvenidos_DAO implements InterfaceBienvenidos_DAO{
    private  List<Modelo_InicioSesion> administradores;

    public ImplementacionBienvenidos_DAO(){
        administradores = new ArrayList<>();
    }

    @Override
    public List<Modelo_InicioSesion> administradores() {
        return administradores;
    }

    @Override
    public Modelo_InicioSesion getAdministrador(String nombre) {
        for(Modelo_InicioSesion usuario: administradores){
            if(usuario.getUsuario().equals(nombre)){
                return usuario;
            }
        }

        return null;
    }
}
