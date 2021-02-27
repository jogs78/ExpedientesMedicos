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
public class cita_anticonseptivos {
    int id;
    int folio;
    int idAnticonseptivo;

    public cita_anticonseptivos() {
    }

    public cita_anticonseptivos(int id, int folio, int idAnticonseptivo) {
        this.id = id;
        this.folio = folio;
        this.idAnticonseptivo = idAnticonseptivo;
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

    public int getIdAnticonseptivo() {
        return idAnticonseptivo;
    }

    public void setIdAnticonseptivo(int idAnticonseptivo) {
        this.idAnticonseptivo = idAnticonseptivo;
    }
    
}
