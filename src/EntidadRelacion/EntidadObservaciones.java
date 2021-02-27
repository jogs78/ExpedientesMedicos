package EntidadRelacion;

public class EntidadObservaciones {
    int id;
    int folio;
    String obcervaciones;

    public EntidadObservaciones() {
    }

    public EntidadObservaciones(int id, int folio, String obcervaciones) {
        this.id = id;
        this.folio = folio;
        this.obcervaciones = obcervaciones;
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

    public String getObcervaciones() {
        return obcervaciones;
    }

    public void setObcervaciones(String obcervaciones) {
        this.obcervaciones = obcervaciones;
    }    
}
