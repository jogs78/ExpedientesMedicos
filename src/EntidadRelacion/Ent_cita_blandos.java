
package EntidadRelacion;

/**
 *
 * @author moisesvelasco
 */
public class Ent_cita_blandos {
    int id;
    int folio;
    int idBlando;

    public Ent_cita_blandos() {
    }

    public Ent_cita_blandos(int id, int folio, int idBlando) {
        this.id = id;
        this.folio = folio;
        this.idBlando = idBlando;
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

    public int getIdBlando() {
        return idBlando;
    }

    public void setIdBlando(int idBlando) {
        this.idBlando = idBlando;
    }
    
}
