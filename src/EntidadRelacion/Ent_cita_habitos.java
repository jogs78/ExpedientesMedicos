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
public class Ent_cita_habitos {
    int id;
    int folio;
    int idHabito;

    public Ent_cita_habitos() {
    }

    public Ent_cita_habitos(int id, int folio, int idHabito) {
        this.id = id;
        this.folio = folio;
        this.idHabito = idHabito;
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

    public int getIdHabito() {
        return idHabito;
    }

    public void setIdHabito(int idHabito) {
        this.idHabito = idHabito;
    }
    
    
}
