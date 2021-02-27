
package EntidadRelacion;

/**
 *
 * @author moisesvelasco
 */
public class Ent_cita_habitosF {
    int id;
    int folio;
    int idHabito;
    String frecuencia;

    public Ent_cita_habitosF() {
    }

    public Ent_cita_habitosF(int id, int folio, int idHabito, String frecuencia) {
        this.id = id;
        this.folio = folio;
        this.idHabito = idHabito;
        this.frecuencia = frecuencia;
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

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }
    
}
