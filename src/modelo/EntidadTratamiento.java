package modelo;

/**
 *
 * @author moisesvelasco
 */
public class EntidadTratamiento {
    int idTratamiento;
    String nombreTratamiento;
    String simboloTratamiento;
    int precioTratamiento;

    public EntidadTratamiento() {
    }

    public EntidadTratamiento(int idTratamiento, String nombreTratamiento, String simboloTratamiento, int precioTratamiento) {
        this.idTratamiento = idTratamiento;
        this.nombreTratamiento = nombreTratamiento;
        this.simboloTratamiento = simboloTratamiento;
        this.precioTratamiento=precioTratamiento;
    }
    

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public String getSimboloTratamiento() {
        return simboloTratamiento;
    }

    public void setSimboloTratamiento(String simboloTratamiento) {
        this.simboloTratamiento = simboloTratamiento;
    }

    public int getPrecioTratamiento() {
        return precioTratamiento;
    }

    public void setPrecioTratamiento(int precioTratamiento) {
        this.precioTratamiento = precioTratamiento;
    }    
}
