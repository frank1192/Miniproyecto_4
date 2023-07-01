/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import DAO.ImplementacionBienvenidos_DAO;
import Modelos.Modelo_InicioSesion;
import vista.VentanaBienvenidos;
import vista.VentanaMenu;

/**
 *
 * @author jeanp
 */

public class ControladorBienvenidos implements ActionListener{
    private VentanaBienvenidos ventanaBienvenido;
    private Modelo_InicioSesion modelo_InicioSesion;
    private ImplementacionBienvenidos_DAO implementacionBienvenidos_DAO;
    
    public ControladorBienvenidos(VentanaBienvenidos ventanaBienvenidos){
        this.ventanaBienvenido = ventanaBienvenidos;
        implementacionBienvenidos_DAO = new ImplementacionBienvenidos_DAO();
        modelo_InicioSesion= new Modelo_InicioSesion();

        this.ventanaBienvenido.btnIniciarSesion.addActionListener(this);

        leerAchivosAdministrador("src/Archivos/Administradores.txt");

    }
    
    public void iniciar(){
        ventanaBienvenido.setTitle("Bienvenido");
        ventanaBienvenido.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ventanaBienvenido.btnIniciarSesion){

            String usuario = ventanaBienvenido.txtUsuario.getText();
            String contraseña = new String(ventanaBienvenido.txtContraseña.getText());

            Modelo_InicioSesion administrador = implementacionBienvenidos_DAO.getAdministrador(usuario);

            if(administrador != null && administrador.getContraseña().equals(contraseña)){

                ventanaBienvenido.setVisible(false);
                VentanaMenu ventanaMenu = new VentanaMenu();
                ventanaMenu.setVisible(true);
                ControladorMenu controladorMenu = new ControladorMenu(ventanaMenu);
                controladorMenu.iniciar();

            }else{

                JOptionPane.showMessageDialog(ventanaBienvenido, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }

    private void leerAchivosAdministrador(String archivo){
        try(FileReader fileReader = new FileReader(archivo); BufferedReader bufferedReader = new BufferedReader(fileReader)){
            
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String [] partes= linea.split(";");
                if(partes.length == 2){
                    String usuario = partes[0].trim();
                    String contraseña = partes[1].trim();
                    
                    modelo_InicioSesion.setUsuario(usuario);
                    modelo_InicioSesion.setContraseña(contraseña);

                    implementacionBienvenidos_DAO.administradores().add(modelo_InicioSesion);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
