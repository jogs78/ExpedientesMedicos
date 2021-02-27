/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadRelacion;

/**
 *
 * @author moisesvelasco
 */
public class cita_duros {
    int id;
    int folio;
    int idDuro;

    public cita_duros() {
    }

    public cita_duros(int id, int folio, int idDuro) {
        this.id = id;
        this.folio = folio;
        this.idDuro = idDuro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getIdDuro() {
        return idDuro;
    }

    public void setIdDuro(int idDuro) {
        this.idDuro = idDuro;
    }
    
}
