
package EntidadRelacion;

/**
 *
 * @author moisesvelasco
 */
public class Ent_cita_cuidadosF {
    int id;
    int folio;
    int vecesCepilla;
    int idCuidado;

    public Ent_cita_cuidadosF() {
    }

    public Ent_cita_cuidadosF(int id, int folio, int vecesCepilla, int idCuidado) {
        this.id = id;
        this.folio = folio;
        this.vecesCepilla = vecesCepilla;
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

    public int getVecesCepilla() {
        return vecesCepilla;
    }

    public void setVecesCepilla(int vecesCepilla) {
        this.vecesCepilla = vecesCepilla;
    }

    public int getIdCuidado() {
        return idCuidado;
    }

    public void setIdCuidado(int idCuidado) {
        this.idCuidado = idCuidado;
    }
}
