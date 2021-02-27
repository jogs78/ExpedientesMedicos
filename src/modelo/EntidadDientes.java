
package modelo;

/**
 *
 * @author moisesvelasco
 */
public class EntidadDientes {
    int idDiente;
    String nombreDiente;
    String simboloDiente;

    public EntidadDientes() {
    }

    public EntidadDientes(int idDiente, String nombreDiente, String simboloDiente) {
        this.idDiente = idDiente;
        this.nombreDiente = nombreDiente;
        this.simboloDiente = simboloDiente;
    }

    public int getIdDiente() {
        return idDiente;
    }

    public void setIdDiente(int idDiente) {
        this.idDiente = idDiente;
    }

    public String getNombreDiente() {
        return nombreDiente;
    }

    public void setNombreDiente(String nombreDiente) {
        this.nombreDiente = nombreDiente;
    }

    public String getSimboloDiente() {
        return simboloDiente;
    }

    public void setSimboloDiente(String simboloDiente) {
        this.simboloDiente = simboloDiente;
    }
    
    
}
