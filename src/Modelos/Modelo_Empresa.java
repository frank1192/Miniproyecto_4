/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Franklin Aguirre
 */
public class Modelo_Empresa {
    private int Nit;
    private String Nombre;
    private String Telefono;
    private String Representante_legal;
    private String Correo_de_contacto;
    private String ARL;
    private String caja_compensacion;
    private String Auxilio_Transporte;

    public int getNit() {
        return Nit;
    }

    public void setNit(int Nit) {
        this.Nit = Nit;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getRepresentante_legal() {
        return Representante_legal;
    }

    public void setRepresentante_legal(String Representante_legal) {
        this.Representante_legal = Representante_legal;
    }

    public String getCorreo_de_contacto() {
        return Correo_de_contacto;
    }

    public void setCorreo_de_contacto(String Correo_de_contacto) {
        this.Correo_de_contacto = Correo_de_contacto;
    }

    public String getARL() {
        return ARL;
    }

    public void setARL(String ARL) {
        this.ARL = ARL;
    }

    public String getCaja_compensacion() {
        return caja_compensacion;
    }

    public void setCaja_compensacion(String caja_compemsacion) {
        this.caja_compensacion = caja_compemsacion;
    }

    public String getAuxilio_Transporte() {
        return Auxilio_Transporte;
    }

    public void setAuxilio_Transporte(String Auxilio_Transporte) {
        this.Auxilio_Transporte = Auxilio_Transporte;
    }
    @Override
    public String toString() {
        return "Nit: " + Nit + ", Nombre: " + Nombre + ", Telefono: " + Telefono + ", Representante_legal: " + Representante_legal + ", Correo_de_contacto : " + Correo_de_contacto + ", ARL: " + ARL+", caja_compensacion:"+caja_compensacion+", Auxilio_Transporte: "+Auxilio_Transporte; 
    }

}
