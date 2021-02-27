
package ControladorCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.EntidadDatosMedico;

/**
 *
 * @author moisesvelasco
 */
public class datosMedicoDao {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;
    public List listarDatosMedico(int idC) {
        List<EntidadDatosMedico> lista = new ArrayList<>();
        String sql="SELECT * FROM datosMedico where idCliente=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, idC);
            rs=ps.executeQuery();
            while(rs.next()){
                EntidadDatosMedico ep = new EntidadDatosMedico();
                 ep.setIdCliente(rs.getInt(2));
                 ep.setTipoTratamiento(rs.getString(3));
                 ep.setNombreMedico(rs.getString(4));
                 ep.setContacto(rs.getString(5));
                 ep.setTomaMedicamento(rs.getString(6));
                 ep.setHospitalizado(rs.getString(7));
                 lista.add(ep);
                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO datosMedico (idCliente, tipoTratamiento,nombreMedico, contacto,tomaMedicamento,hospitalizado) values (?,?,?,?,?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r=ps.executeUpdate(); 
        }
        catch(Exception e){}
        return r;
     
    }
    
}
