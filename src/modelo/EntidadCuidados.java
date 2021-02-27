
package modelo;

/**
 *
 * @author moisesvelasco
 */
public class EntidadCuidados {
    int idCuidado;
    String nombreCuidado;

    public EntidadCuidados() {
    }

    public EntidadCuidados(int idCuidado, String nombreCuidado) {
        this.idCuidado = idCuidado;
        this.nombreCuidado = nombreCuidado;
    }

    public int getIdCuidado() {
        return idCuidado;
    }

    public void setIdCuidado(int idCuidado) {
        this.idCuidado = idCuidado;
    }

    public String getNombreCuidado() {
        return nombreCuidado;
    }

    public void setNombreCuidado(String nombreCuidado) {
        this.nombreCuidado = nombreCuidado;
    }
    
}
