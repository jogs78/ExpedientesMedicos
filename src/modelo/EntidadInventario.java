/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author moisesvelasco
 */
public class EntidadInventario {
    int idProducto ;
    String nombreProducto;
    String codigo;
    int existencia;
    String fechaCaducidad;

    public EntidadInventario() {
    }
    
    

    public EntidadInventario(int idProducto, String nombreProducto, String codigo,int existencia, String fechaCaducidad) {
        this.idProducto=idProducto;
        this.nombreProducto=nombreProducto;
        this.codigo=codigo;
        this.existencia=existencia;
        this.fechaCaducidad=fechaCaducidad;
    
    }

    public int getidProducto() {
        return idProducto;
    }

    public void setidProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    

    
    
    
    
}
