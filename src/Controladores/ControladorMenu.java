/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Modelo_Arl;
import Modelos.Modelo_Caja_Compensacion;
import Modelos.Modelo_Deduccion;
import Modelos.Modelo_Devengo;
import Modelos.Modelo_Empleado;
import Modelos.Modelo_Empresa;
import Modelos.Modelo_Eps;
import Modelos.Modelo_Fondo_pension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaARL;
import vista.VentanaAgregarEmpleado;
import vista.VentanaAgregarEmpresa;
import vista.VentanaBienvenidos;
import vista.VentanaCajadeCompensacion;
import vista.VentanaEPS;
import vista.VentanaFondoDePension;
import vista.VentanaLiquidacion;
import vista.VentanaMenu;

/**
 *
 * @author Usuario
 */
public class ControladorMenu {
    private VentanaMenu vistamenu;
    private VentanaLiquidacion vistaliquidacion;
    private VentanaFondoDePension vistapension;
    private VentanaEPS vistaeps;
    private VentanaCajadeCompensacion vistacompensacion;
    private VentanaBienvenidos vistabienvenidos;
    private VentanaAgregarEmpresa vistaagregarempresa;
    private VentanaAgregarEmpleado vistaagregarempleado;
    private VentanaARL vistaarl;
    private Modelo_Fondo_pension modelofpension;
    private Modelo_Eps modeloeps;
    private Modelo_Empresa modeloempresa;
    private Modelo_Empleado modeloempleado;
    private Modelo_Devengo modelodevengo;
    private Modelo_Deduccion modelodeduccion;
    private Modelo_Caja_Compensacion modelocajacompensacion;
    private Modelo_Arl modeloarl;


    public ControladorMenu(VentanaMenu vistamenu){
        this.vistamenu=vistamenu;
        //Funcionalidad de los botones
        this.vistamenu.btnArl.addActionListener((ActionListener) this);
        this.vistamenu.btnEps.addActionListener((ActionListener) this);
        this.vistamenu.btnEmpleado.addActionListener((ActionListener) this);
        this.vistamenu.btnLiquidacion.addActionListener((ActionListener) this);
        this.vistamenu.btnCompensacion.addActionListener((ActionListener) this);
        this.vistamenu.btnPension.addActionListener((ActionListener) this);
        
        //Vista pension 
        this.vistapension = new VentanaFondoDePension ();
        this.modelofpension = new Modelo_Fondo_pension();
        //this.interfaceUsuariosDAO = new ImplemetacionUsuariosDAO();
        //Vista liquidacion 
        this.vistaliquidacion = new VentanaLiquidacion();
        //this.modelofpension = new Modelo_Fondo_pension();
        //Vista eps
        this. vistaeps = new VentanaEPS ();
        this. modeloeps = new Modelo_Eps();

        //Vista compensacion
        this. vistacompensacion= new VentanaCajadeCompensacion ();
        this. modelocajacompensacion = new Modelo_Caja_Compensacion ();
        //Vista arl
        this.vistaarl= new VentanaARL  ();
        this.modeloarl = new Modelo_Arl();
        //Vista bienvenidos
        
        this. vistabienvenidos= new VentanaBienvenidos  ();
        //this.modeloarl = new Modelo_Arl();
        //Vista empresa
         
        this.vistaagregarempresa= new VentanaAgregarEmpresa  ();
        this.  modeloempresa = new  Modelo_Empresa ();
        //Vista empleados
        
        this.vistaagregarempleado= new VentanaAgregarEmpleado  ();
        this.modeloempleado  = new Modelo_Empleado();
    }
    

    public void iniciar() {
        vistamenu.setTitle("MENU");
        vistamenu.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistamenu.btnArl){
            //ControladorUsuarios controladorUsuarios = new ControladorUsuarios(vistaUsuarios, modeloUsuarios, interfaceUsuariosDAO, vistaMenu);
            //controladorUsuarios.iniciar();
            vistaarl.setVisible(true);
            vistamenu.setVisible(false);
        }

        if(e.getSource() == vistamenu.btnEps){
            vistamenu.setVisible(false);
            vistaeps.setVisible(true);
            //ControladorRecursos controladorRecursos = new ControladorRecursos(vistaRecursos, vistaMenu, modeloRecursos);
            //controladorRecursos.iniciar();
        }

        if(e.getSource() == vistamenu.btnEmpleado){
            vistamenu.setVisible(false);
            vistaagregarempleado.setVisible(true);
            //ControladorPrestamos controladorPrestamos = new ControladorPrestamos(vistaPrestamos, vistaMenu, modeloPrestamos);
            //controladorPrestamos.iniciar();
        }
        if(e.getSource() == vistamenu.btnLiquidacion){
            vistamenu.setVisible(false);
            vistaliquidacion.setVisible(true);}
        if(e.getSource() == vistamenu.btnCompensacion){
            vistamenu.setVisible(false);
            vistacompensacion.setVisible(true);
        }
        if(e.getSource() == vistamenu.btnPension){
            vistamenu.setVisible(false);
            vistapension.setVisible(true);
        }
        }}
        /*if(e.getSource() == vistaMenu.btnSalir){
            int respuesta;

                respuesta = JOptionPane.showConfirmDialog(
                            null,"¿Quieres salir de la Apliacion?", "Advertencia",
                            JOptionPane.YES_NO_OPTION, 
                            JOptionPane.WARNING_MESSAGE);
                if(respuesta == JOptionPane.YES_OPTION){
                    this.vistaMenu.dispose();
                }
            
            
        }
        
    }*/



