
package RelacionDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Conexion;

/**
 *
 * @author moisesvelasco
 */
public class cita_blandosDao {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO cita_blandos (folio,idBlando) values (?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);                    
            r=ps.executeUpdate();  
        }
        catch(Exception e){ }
        return r;
    }
    
}
