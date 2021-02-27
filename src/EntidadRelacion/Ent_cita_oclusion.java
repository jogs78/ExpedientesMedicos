
package EntidadRelacion;

/**
 *
 * @author moisesvelasco
 */
public class Ent_cita_oclusion {
    int id;
    int folio;
    int idOclusion;

    public Ent_cita_oclusion() {
    }

    public Ent_cita_oclusion(int id, int folio, int idOclusion) {
        this.id = id;
        this.folio = folio;
        this.idOclusion = idOclusion;
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

    public int getIdOclusion() {
        return idOclusion;
    }

    public void setIdOclusion(int idOclusion) {
        this.idOclusion = idOclusion;
    }
    
    
}
