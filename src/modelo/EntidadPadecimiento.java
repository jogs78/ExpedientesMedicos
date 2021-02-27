
package modelo;

/**
 *
 * @author moisesvelasco
 */
public class EntidadPadecimiento {
    int idPadecimiento;
    String nombrePadecimiento;
    String simbolo;

    public EntidadPadecimiento() {
    }

    public EntidadPadecimiento(int idPadecimiento, String nombrePadecimiento, String simbolo) {
        this.idPadecimiento = idPadecimiento;
        this.nombrePadecimiento = nombrePadecimiento;
        this.simbolo = simbolo;
    }

    public int getIdPadecimiento() {
        return idPadecimiento;
    }

    public void setIdPadecimiento(int idPadecimiento) {
        this.idPadecimiento = idPadecimiento;
    }

    public String getNombrePadecimiento() {
        return nombrePadecimiento;
    }

    public void setNombrePadecimiento(String nombrePadecimiento) {
        this.nombrePadecimiento = nombrePadecimiento;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }    
}
