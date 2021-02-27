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
public class EntidadCita {
    int folio;
    int idCliente;
    String fechaCita;
    int tipoConsulta;
    int saldo;

    public EntidadCita() {
    }
    public EntidadCita(int folio, int idCliente, String fechaCita, int tipoConsulta, int saldo) {
        this.folio = folio;
        this.idCliente = idCliente;
        this.fechaCita = fechaCita;
        this.tipoConsulta = tipoConsulta;
        this.saldo = saldo;
    }
    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    
    
}
