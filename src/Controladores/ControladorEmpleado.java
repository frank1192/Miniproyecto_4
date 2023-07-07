package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JOptionPane;
import DAO.ImplementacionEmpleado_DAO;
import DAO.InterfaceEmpleado_DAO;
import Modelos.Modelo_Empleado;
import vista.VentanaAgregarEmpleado;
import vista.VentanaMenu;

public class ControladorEmpleado implements ActionListener{
    private VentanaAgregarEmpleado ventanaAgregarEmpleado;
    private InterfaceEmpleado_DAO interfaceEmpleado_DAO;
    private VentanaMenu ventanaMenu;

    public ControladorEmpleado(VentanaAgregarEmpleado ventanaAgregarEmpleado){
        this.ventanaAgregarEmpleado = ventanaAgregarEmpleado;
        this.interfaceEmpleado_DAO = new ImplementacionEmpleado_DAO();

        this.ventanaAgregarEmpleado.btnAgregar.addActionListener(this);
        this.ventanaAgregarEmpleado.btnSalir.addActionListener(this);
        this.ventanaAgregarEmpleado.btnBuscar.addActionListener(this);
        this.ventanaAgregarEmpleado.btnEliminar.addActionListener(this);
        this.ventanaAgregarEmpleado.btnActualizar.addActionListener(this);
    }

    public void iniciar(){
        ventanaAgregarEmpleado.setTitle("EMPLEADOS");
        ventanaAgregarEmpleado.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ventanaAgregarEmpleado.btnAgregar){
            String codigo = ventanaAgregarEmpleado.txtCodigo.getText().trim();

             int identificacion = 0; // Valor predeterminado
            String identificacionText = ventanaAgregarEmpleado.txtIdentificacion.getText().trim();
            if (!identificacionText.isEmpty()) {
                identificacion = Integer.parseInt(identificacionText);
            }
            String nombres = ventanaAgregarEmpleado.txtNombres.getText().trim();
            String apellidos = ventanaAgregarEmpleado.txtApellidos.getText().trim();
            String direccion = ventanaAgregarEmpleado.txtDireccion.getText().trim();
            String eps = ventanaAgregarEmpleado.cmbEPS.getSelectedItem().toString();
            String fondoPension = ventanaAgregarEmpleado.cmbFondo_Pension.getSelectedItem().toString();
            


            // Verificar si los campos están vacíos
            if (codigo.isEmpty() || identificacionText.isEmpty() || nombres.isEmpty() || apellidos.isEmpty()
                    || direccion.isEmpty() || eps.isEmpty() || fondoPension.isEmpty()) {

                JOptionPane.showMessageDialog(ventanaAgregarEmpleado, "Necesitas LLenar Todos Los espacios", "Error en agregar empreado", JOptionPane.ERROR_MESSAGE);
            } else {

                Modelo_Empleado empleado = new Modelo_Empleado();
                empleado.setIdentificacion(identificacion);
                empleado.setNombres(nombres);
                empleado.setApellidos(apellidos);
                empleado.setCodigo_empleado(codigo);
                empleado.setDireccion(direccion);
                empleado.setEPS(eps);
                empleado.setFondo_pension(fondoPension);

                interfaceEmpleado_DAO.save(empleado);

                guardarEmpleado(empleado);

                JOptionPane.showMessageDialog(ventanaAgregarEmpleado, "Empleado agregado exitosamente", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                
            }
        }

        if(e.getSource() == ventanaAgregarEmpleado.btnActualizar){

            String codigo = ventanaAgregarEmpleado.txtCodigo.getText().trim();

            int identificacion = 0; 
            String identificacionText = ventanaAgregarEmpleado.txtIdentificacion.getText().trim();
            if (!identificacionText.isEmpty()) {
                identificacion = Integer.parseInt(identificacionText);
            }

            String nombres = ventanaAgregarEmpleado.txtNombres.getText().trim();
            String apellidos = ventanaAgregarEmpleado.txtApellidos.getText().trim();
            String direccion = ventanaAgregarEmpleado.txtDireccion.getText().trim();
            String eps = ventanaAgregarEmpleado.cmbEPS.getSelectedItem().toString();
            String fondoPension = ventanaAgregarEmpleado.cmbFondo_Pension.getSelectedItem().toString();

            if (codigo.isEmpty() || identificacionText.isEmpty() || nombres.isEmpty() || apellidos.isEmpty()
                    || direccion.isEmpty() || eps.isEmpty() || fondoPension.isEmpty()) {
                JOptionPane.showMessageDialog(ventanaAgregarEmpleado, "Necesitas LLenar Todos Los espacios",
                        "Error en actualizar empleado", JOptionPane.ERROR_MESSAGE);
            } else {
                Modelo_Empleado empleado = new Modelo_Empleado();
                empleado.setIdentificacion(identificacion);
                empleado.setNombres(nombres);
                empleado.setApellidos(apellidos);
                empleado.setCodigo_empleado(codigo);
                empleado.setDireccion(direccion);
                empleado.setEPS(eps);
                empleado.setFondo_pension(fondoPension);

                interfaceEmpleado_DAO.update(empleado);

                actualizarEmpleado(empleado);

                JOptionPane.showMessageDialog(ventanaAgregarEmpleado, "Empleado actualizado exitosamente", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (e.getSource() == ventanaAgregarEmpleado.btnEliminar) {
            String identificacionText = ventanaAgregarEmpleado.txtIdentificacion.getText().trim();

            if (identificacionText.isEmpty()) {
                JOptionPane.showMessageDialog(ventanaAgregarEmpleado, "Ingresa el código del empleado a eliminar",
                        "Error en eliminar empleado", JOptionPane.ERROR_MESSAGE);
            } else {

                int identificacion = Integer.parseInt(identificacionText);

                int confirmacion = JOptionPane.showConfirmDialog(ventanaAgregarEmpleado,
                        "¿Estás seguro de que quieres eliminar este empleado?", "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {

                    eliminarEmpleado(identificacion);

                    JOptionPane.showMessageDialog(ventanaAgregarEmpleado, "Empleado eliminado exitosamente", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        if (e.getSource() == ventanaAgregarEmpleado.btnBuscar) {
                int identificacion = Integer.parseInt(ventanaAgregarEmpleado.txtIdentificacion.getText().trim());
        }
        
        if(e.getSource() == ventanaAgregarEmpleado.btnSalir){
            ventanaAgregarEmpleado.setVisible(false);
            ventanaMenu.setVisible(true);
        }
    }

    // METODOS ARCHIVOS

    private void guardarEmpleado(Modelo_Empleado empleado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Archivos/empleados.txt", true))) {

            writer.write(empleado.getCodigo_empleado() + "," +
                    empleado.getIdentificacion() + "," +
                    empleado.getNombres() + "," +
                    empleado.getApellidos() + "," +
                    empleado.getDireccion() + "," +
                    empleado.getEPS() + "," +
                    empleado.getFondo_pension());
            writer.newLine(); 

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(ventanaAgregarEmpleado, "Error al guardar los datos del empleado",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarEmpleado(Modelo_Empleado empleado) {

        try {
            List<String> lineas = Files.readAllLines(Paths.get("src/Archivos/empleados.txt"), StandardCharsets.UTF_8);

            for (int i = 0; i < lineas.size(); i++) {
                String linea = lineas.get(i);
                String[] datos = linea.split(",");
                if (datos[0].equals(empleado.getCodigo_empleado())) {
                    lineas.set(i, empleado.getCodigo_empleado() + "," +
                            empleado.getIdentificacion() + "," +
                            empleado.getNombres() + "," +
                            empleado.getApellidos() + "," +
                            empleado.getDireccion() + "," +
                            empleado.getEPS() + "," +
                            empleado.getFondo_pension());
                    break;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Archivos/empleados.txt"))) {
                for (String linea : lineas) {
                    writer.write(linea);
                    writer.newLine();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(ventanaAgregarEmpleado, "Error al actualizar los datos del empleado",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(ventanaAgregarEmpleado, "Error al leer los datos del archivo",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarEmpleado(int identificacion) {

        Modelo_Empleado empleado = interfaceEmpleado_DAO.getEmpleados(identificacion);

            if (empleado != null) {
                // Eliminar el empleado utilizando el método delete de la interfaz DAO
                interfaceEmpleado_DAO.delete(empleado);

                try {
                List<String> lineas = Files.readAllLines(Paths.get("src/Archivos/empleados.txt"), StandardCharsets.UTF_8);

                

                for (int i = 0; i < lineas.size(); i++) {
                    String linea = lineas.get(i);
                    String[] datos = linea.split(",");
                    int codigoEmpleado = Integer.parseInt(datos[0]);
                    if (codigoEmpleado == identificacion) {
                        lineas.remove(i);
                        break;
                    }
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Archivos/empleados.txt"))) {
                    for (String linea : lineas) {
                        writer.write(linea);
                        writer.newLine();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ventanaAgregarEmpleado, "Error al eliminar el empleado del archivo",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ventanaAgregarEmpleado, "Error al eliminar el empleado del archivo",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
        }

        
    }
}
