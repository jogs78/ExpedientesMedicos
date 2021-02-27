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
public class EntDuros {
    int id;
    String nombreDuro;

    public EntDuros() {
    }

    public EntDuros(int id, String nombreDuro) {
        this.id = id;
        this.nombreDuro = nombreDuro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDuro() {
        return nombreDuro;
    }

    public void setNombreDuro(String nombreDuro) {
        this.nombreDuro = nombreDuro;
    }
    
}
