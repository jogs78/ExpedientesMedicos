
package RelacionDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Conexion;
import modelo.EntidadDientes;
import modelo.EntidadPadecimiento;

/**
 *
 * @author moisesvelasco
 */
public class dientes_padecimiento {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;

    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO dientes_padecimiento (folio,idDiente,idPadecimiento,color) values (?,?,?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r=ps.executeUpdate();  
        }
        catch(Exception e){}
        return r;
    }
    
    public EntidadPadecimiento obtenerIdPad (String nom) {
         EntidadPadecimiento ec = new EntidadPadecimiento();
        String sql="SELECT * FROM padecimiento where nombrePadecimiento=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, nom);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setIdPadecimiento(rs.getInt(1));
            }
        }
        catch(Exception e){}return ec;
    }
    public EntidadPadecimiento obtenerSimboloPad (String nom) {
         EntidadPadecimiento ec = new EntidadPadecimiento();
        String sql="SELECT simbolo FROM padecimiento where nombrePadecimiento=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, nom);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setSimbolo(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
}
