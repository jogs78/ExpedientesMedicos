package modelo;
/**
 *
 * @author moisesvelasco
 */
public class EntidadTipoCons {
    int idTipoConsulta;
    String nombreConsulta;

    public EntidadTipoCons() {
    }
    public EntidadTipoCons(int idTipoConsulta, String nombreConsulta) {
        this.idTipoConsulta = idTipoConsulta;
        this.nombreConsulta = nombreConsulta;
    }
    public int getIdTipoConsulta() {
        return idTipoConsulta;
    }
    public void setIdTipoConsulta(int idTipoConsulta) {
        this.idTipoConsulta = idTipoConsulta;
    }
    public String getNombreConsulta() {
        return nombreConsulta;
    }
    public void setNombreConsulta(String nombreConsulta) {
        this.nombreConsulta = nombreConsulta;
    }    
}
