package RelacionDao;

import EntidadRelacion.Ent_dientes_tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.EntidadTratamiento;

/**
 *
 * @author moisesvelasco
 * en esta clase aremos listas
 */
public class dientes_tratamiento {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;

    
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO tratamiento_dientes (folio,idDiente,idTratamiento) values (?,?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            r=ps.executeUpdate();  
        }
        catch(Exception e){}
        return r;
    }
    
    public EntidadTratamiento obtenerIdTrat (String nom) {
         EntidadTratamiento ec = new EntidadTratamiento();
        String sql="SELECT * FROM tratamiento where nombreTratamiento=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, nom);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setIdTratamiento(rs.getInt(1));
            }
        }
        catch(Exception e){}return ec;
    }
    public EntidadTratamiento obtenerSimbolotrat (String nom) {
         EntidadTratamiento ec = new EntidadTratamiento();
        String sql="SELECT simboloTratamiento FROM tratamiento where nombreTratamiento=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, nom);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setSimboloTratamiento(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
}
