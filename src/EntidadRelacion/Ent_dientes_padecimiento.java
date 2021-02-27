
package EntidadRelacion;

/**
 *
 * @author moisesvelasco
 */
public class Ent_dientes_padecimiento {
    int id;
    int folio;
    int IdDiente;
    int idPadecimiento;
    String color;

    public Ent_dientes_padecimiento() {
    }

    public Ent_dientes_padecimiento(int id, int folio, int IdDiente, int idPadecimiento, String color) {
        this.id = id;
        this.folio = folio;
        this.IdDiente = IdDiente;
        this.idPadecimiento = idPadecimiento;
        this.color = color;
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

    public int getIdDiente() {
        return IdDiente;
    }

    public void setIdDiente(int IdDiente) {
        this.IdDiente = IdDiente;
    }

    public int getIdPadecimiento() {
        return idPadecimiento;
    }

    public void setIdPadecimiento(int idPadecimiento) {
        this.idPadecimiento = idPadecimiento;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
    
}
