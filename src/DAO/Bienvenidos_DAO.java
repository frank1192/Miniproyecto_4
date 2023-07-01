
package DAO;

import java.util.List;
import Modelos.Modelo_InicioSesion ;
import java.util.ArrayList;
/**
 *
 * @author Franklin Aguirre
 */
public class Bienvenidos_DAO {
    private  List<Modelo_InicioSesion> administradores;
     
    public Bienvenidos_DAO(){
        administradores = new ArrayList<>();
    }

    public List<Modelo_InicioSesion> administrador() {
        return administradores;
    }
    public Modelo_InicioSesion getAdministrador(String nombre) {
        for(Modelo_InicioSesion usuario: administradores){
            if(usuario.getUsuario().equals(nombre)){
                return usuario;
            }
        }

        return null;
    }
}
