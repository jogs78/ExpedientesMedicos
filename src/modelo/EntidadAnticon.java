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
public class EntidadAnticon {
    int idAnticonsep;
    String nombreAnt;

    public EntidadAnticon() {
    }

    public EntidadAnticon(int idAnticonsep, String nombreAnt) {
        this.idAnticonsep = idAnticonsep;
        this.nombreAnt = nombreAnt;
    }

    public int getIdAnticonsep() {
        return idAnticonsep;
    }

    public void setIdAnticonsep(int idAnticonsep) {
        this.idAnticonsep = idAnticonsep;
    }

    public String getNombreAnt() {
        return nombreAnt;
    }

    public void setNombreAnt(String nombreAnt) {
        this.nombreAnt = nombreAnt;
    }
    
}
