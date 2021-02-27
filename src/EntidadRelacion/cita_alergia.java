
package EntidadRelacion;

/**
 *
 * @author moisesvelasco
 */
public class cita_alergia {
    int id;
    int folio;
    String alergia;

    public cita_alergia() {
    }

    public cita_alergia(int id, int folio, String alergia) {
        this.id = id;
        this.folio = folio;
        this.alergia = alergia;
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

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
    
}
