/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author moisesvelasco
 */
public class EntidadCliente {
    int idCliente;
    String nombreCliente;
    String apellidoPat;
    String apellidoMat;
    String domicilio;
    String contacto;
    String fechaRegistro;
    String fechaInicia;
    String fechaTermina;
    int edad;
    String sexo;

    public EntidadCliente() {
    }

    public EntidadCliente(int idCliente, String nombreCliente, String apellidoPat, String apellidoMat, String domicilio, String contacto, String fechaRegistro, String fechaInicia, String fechaTermina, int edad, String sexo) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.domicilio = domicilio;
        this.contacto = contacto;
        this.fechaRegistro = fechaRegistro;
        this.fechaInicia = fechaInicia;
        this.fechaTermina = fechaTermina;
        this.edad = edad;
        this.sexo = sexo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaInicia() {
        return fechaInicia;
    }

    public void setFechaInicia(String fechaInicia) {
        this.fechaInicia = fechaInicia;
    }

    public String getFechaTermina() {
        return fechaTermina;
    }

    public void setFechaTermina(String fechaTermina) {
        this.fechaTermina = fechaTermina;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    

    
    
}
