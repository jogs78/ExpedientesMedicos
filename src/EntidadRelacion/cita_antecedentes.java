
package EntidadRelacion;

/**
 *
 * @author moisesvelasco
 */
public class cita_antecedentes {
    int folio;
    int idAntecedente;
    int idAnticonseptivo;
    String alergias;

    public cita_antecedentes() {
    }

    public cita_antecedentes(int folio, int idAntecedente, int idAnticonseptivo, String alergias) {
        this.folio = folio;
        this.idAntecedente = idAntecedente;
        this.idAnticonseptivo = idAnticonseptivo;
        this.alergias = alergias;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(int idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public int getIdAnticonseptivo() {
        return idAnticonseptivo;
    }

    public void setIdAnticonseptivo(int idAnticonseptivo) {
        this.idAnticonseptivo = idAnticonseptivo;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }
    
    
}
