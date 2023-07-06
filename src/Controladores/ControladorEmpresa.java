package Controladores;

import DAO.ImplementacionEmpresa_DAO;
import DAO.InterfaceEmpresa_DAO;
import Modelos.Modelo_Empresa;
import vista.VentanaAgregarEmpresa;
import vista.VentanaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ControladorEmpresa implements ActionListener{
    private VentanaAgregarEmpresa ventanaAgregarEmpresa;
    private InterfaceEmpresa_DAO interfaceEmpresa_DAO;

    public ControladorEmpresa(VentanaAgregarEmpresa ventanaAgregarEmpresa){
        this.ventanaAgregarEmpresa = ventanaAgregarEmpresa;
        this.interfaceEmpresa_DAO = new ImplementacionEmpresa_DAO();
        this.ventanaAgregarEmpresa.btnAgregar.addActionListener(this);
    }

    public void iniciar(){
        ventanaAgregarEmpresa.setTitle("EMPRESA");
        ventanaAgregarEmpresa.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ventanaAgregarEmpresa.btnAgregar) {

            String nombre = ventanaAgregarEmpresa.txtNombre.getText().trim();
            int nit = 0; // Valor predeterminado
            String nitText = ventanaAgregarEmpresa.txtNit.getText().trim();
            if (!nitText.isEmpty()) {
                nit = Integer.parseInt(nitText);
            }

            String telefono = ventanaAgregarEmpresa.txtTelefono.getText().trim();
            String representanteLegal = ventanaAgregarEmpresa.txtRepresentanteLegal.getText().trim();
            String correo = ventanaAgregarEmpresa.txtCorreo.getText().trim();
            String arl = ventanaAgregarEmpresa.txtARL.getText().trim();
            String cajaCompensacion = ventanaAgregarEmpresa.txtCajaCompensacion.getText().trim();

            if (nombre.isEmpty() || nitText.isEmpty() || telefono.isEmpty() ||
                    representanteLegal.isEmpty() || correo.isEmpty() || arl.isEmpty() ||
                    cajaCompensacion.isEmpty()) {

                JOptionPane.showMessageDialog(ventanaAgregarEmpresa, "Necesitas LLenar Todos Los espacios", "Error en agregar empresa", JOptionPane.ERROR_MESSAGE);
            
            } else {
                Modelo_Empresa empresa = new Modelo_Empresa();
                empresa.setNombre(nombre);
                empresa.setNit(nit);
                empresa.setTelefono(telefono);
                empresa.setRepresentante_legal(representanteLegal);
                empresa.setCorreo_de_contacto(correo);
                empresa.setARL(arl);
                empresa.setCaja_compensacion(cajaCompensacion);

                guardarEmpresa(empresa);

                JOptionPane.showMessageDialog(ventanaAgregarEmpresa, "La empresa se agrego exitosamente", "Nueva Empresa", JOptionPane.INFORMATION_MESSAGE);

                ventanaAgregarEmpresa.setVisible(false);
                VentanaMenu ventanaMenu = new VentanaMenu();
                ControladorMenu controladorMenu = new ControladorMenu(ventanaMenu);
                controladorMenu.iniciar();
                ventanaMenu.setVisible(true);
            }
        }
    }

    private void guardarEmpresa(Modelo_Empresa empresa) {
    String rutaArchivo = "src/Archivos/empresa.txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
        writer.write(empresa.toString());
        writer.newLine();
        writer.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
