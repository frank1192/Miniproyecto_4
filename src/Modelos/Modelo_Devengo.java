/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

public class Modelo_Devengo {
    private String codigo;
    private String nombre;
    private String hacen_base;

    public String getHacen_base() {
        return hacen_base;
    }

    public void setHacen_base(String hacen_base) {
        this.hacen_base = hacen_base;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Nombre: " + nombre +"hacen base ? "+hacen_base; 
    }
}
