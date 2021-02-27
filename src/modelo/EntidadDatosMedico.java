
package modelo;

/**
 *
 * @author moisesvelasco
 */
public class EntidadDatosMedico {
    int id;
    int idCliente;
    String tipoTratamiento;
    String nombreMedico;
    String contacto;
    String tomaMedicamento;
    String hospitalizado;

    public EntidadDatosMedico() {
    }

    public EntidadDatosMedico(int id, int idCliente, String tipoTratamiento, String nombreMedico, String contacto, String tomaMedicamento, String hospitalizado) {
        this.id = id;
        this.idCliente = idCliente;
        this.tipoTratamiento = tipoTratamiento;
        this.nombreMedico = nombreMedico;
        this.contacto = contacto;
        this.tomaMedicamento = tomaMedicamento;
        this.hospitalizado = hospitalizado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTomaMedicamento() {
        return tomaMedicamento;
    }

    public void setTomaMedicamento(String tomaMedicamento) {
        this.tomaMedicamento = tomaMedicamento;
    }

    public String getHospitalizado() {
        return hospitalizado;
    }

    public void setHospitalizado(String hospitalizado) {
        this.hospitalizado = hospitalizado;
    }
    
}
