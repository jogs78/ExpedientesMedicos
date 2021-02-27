
package modelo;

/**
 *
 * @author moisesvelasco
 */
public class EntidadOclusion {
    int idOclusion;
    String nombreOclusion;

    public EntidadOclusion() {
    }

    public EntidadOclusion(int idOclusion, String nombreOclusion) {
        this.idOclusion = idOclusion;
        this.nombreOclusion = nombreOclusion;
    }

    public int getIdOclusion() {
        return idOclusion;
    }

    public void setIdOclusion(int idOclusion) {
        this.idOclusion = idOclusion;
    }

    public String getNombreOclusion() {
        return nombreOclusion;
    }

    public void setNombreOclusion(String nombreOclusion) {
        this.nombreOclusion = nombreOclusion;
    }
    
    
}
