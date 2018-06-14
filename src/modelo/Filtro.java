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
    private String marca;
    private int stock;
    private boolean existencia;
    public String getCodigo;

    public String getCodigo() {
        return codigo;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public int getStock() {
        return stock;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    

    public void setExistencia(boolean existencia) {
        this.existencia = existencia;
    }
    
      public boolean getExistencia(boolean existencia) {
        return existencia;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    

    public Filtro() {
    }
    
    public Filtro(int id, String codigo, String marca, int stock, boolean existencia){
        this.id = id;
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
        this.codigo = codigo;
    }
    
    public Filtro(String codigo, String marca, int stock, boolean existencia){
        this.codigo = codigo;
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
    }
    
     public Filtro(String marca, int stock, boolean existencia){
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
    }

    public boolean getExistencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
