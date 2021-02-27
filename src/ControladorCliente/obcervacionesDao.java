
package ControladorCliente;

import EntidadRelacion.EntidadObservaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;

/**
 *
 * @author moisesvelasco
 */
public class obcervacionesDao {
    
        PreparedStatement ps;
        ResultSet rs;
        Conexion cn = new Conexion(); 
        Connection con;
    public int add(Object[] o) {
        
        int r=0;
        String sql="INSERT INTO cita_obcervaciones (folio,obcervaciones) values (?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            r=ps.executeUpdate();  
        }
        catch(Exception e){}
        return r;    
    }
    
    public EntidadObservaciones observaciones(int folio) {        
        EntidadObservaciones ep = new EntidadObservaciones();
        String sql="SELECT * FROM cita_obcervaciones where folio=? ";        
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
            ep.setObcervaciones(rs.getString(3));                                 
            }
        }
        catch(Exception e){}
            return ep;
       
    }
}
