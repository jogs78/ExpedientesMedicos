
package modelo;

/**
 *
 * @author moisesvelasco
 */
public class EntidadHabitos {
    int idHabito;
    String nombreHabito;

    public EntidadHabitos() {
    }

    public EntidadHabitos(int idHabito, String nombreHabito) {
        this.idHabito = idHabito;
        this.nombreHabito = nombreHabito;
    }

    public int getIdHabito() {
        return idHabito;
    }

    public void setIdHabito(int idHabito) {
        this.idHabito = idHabito;
    }

    public String getNombreHabito() {
        return nombreHabito;
    }

    public void setNombreHabito(String nombreHabito) {
        this.nombreHabito = nombreHabito;
    }
    
   
}
