
package modelo;

/**
 *
 * @author moisesvelasco
 */
public class EntidadRx {
    int idRx;
    String nombreRx;

    public EntidadRx() {
    }

    public EntidadRx(int idRx, String nombreRx) {
        this.idRx = idRx;
        this.nombreRx = nombreRx;
    }

    public int getIdRx() {
        return idRx;
    }

    public void setIdRx(int idRx) {
        this.idRx = idRx;
    }

    public String getNombreRx() {
        return nombreRx;
    }

    public void setNombreRx(String nombreRx) {
        this.nombreRx = nombreRx;
    }
    
}
