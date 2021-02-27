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
public class EntidadAntecedentes {
    int id;
    String nombreAntecedente;

    public EntidadAntecedentes() {
    }

    public EntidadAntecedentes(int id, String nombreAntecedente) {
        this.id = id;
        this.nombreAntecedente = nombreAntecedente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreAntecedente() {
        return nombreAntecedente;
    }

    public void setNombreAntecedente(String nombreAntecedente) {
        this.nombreAntecedente = nombreAntecedente;
    }
    
    
}
