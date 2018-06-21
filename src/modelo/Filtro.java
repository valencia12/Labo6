/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Filtro {
    
    private int id;
    private String codigo;
    private String nombre;
    private int cantidad;
    private boolean disponibilidad;

    public Filtro() {
    }

    public Filtro(int id, String codigo, String nombre, int cantidad, boolean disponibilidad) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
    }
    
    public Filtro(String codigo, String nombre, int cantidad, boolean disponibilidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
    }
    
    public Filtro(String nombre, int cantidad, boolean exisdisponibilidadtencia) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
