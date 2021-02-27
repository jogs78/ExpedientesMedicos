
package EntidadRelacion;

/**
 *
 * @author moisesvelasco
 */
public class Ent_cita_rx {
    int id;
    int folio;
    int idRx;

    public Ent_cita_rx() {
    }

    public Ent_cita_rx(int id, int folio, int idRx) {
        this.id = id;
        this.folio = folio;
        this.idRx = idRx;
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

    public int getIdRx() {
        return idRx;
    }

    public void setIdRx(int idRx) {
        this.idRx = idRx;
    }
    
}
