package EntidadRelacion;

/**
 *
 * @author moisesvelasco
 */
public class Ent_dientes_tratamiento {
    int id;
    int folio;
    int idDiente;
    int idTratamiento;

    public Ent_dientes_tratamiento() {
    }

    public Ent_dientes_tratamiento(int id, int folio, int idDiente, int idTratamiento) {
        this.id = id;
        this.folio = folio;
        this.idDiente = idDiente;
        this.idTratamiento = idTratamiento;
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

    public int getIdDiente() {
        return idDiente;
    }

    public void setIdDiente(int idDiente) {
        this.idDiente = idDiente;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }
    
}
