
package EntidadRelacion;

/**
 *
 * @author moisesvelasco
 */
public class Ent_cita_cuidados {
    int id;
    int folio;
    int idCuidado;

    public Ent_cita_cuidados() {
    }

    public Ent_cita_cuidados(int id, int folio, int idCuidado) {
        this.id = id;
        this.folio = folio;
        this.idCuidado = idCuidado;
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

    public int getIdCuidado() {
        return idCuidado;
    }

    public void setIdCuidado(int idCuidado) {
        this.idCuidado = idCuidado;
    }
    
    
}
