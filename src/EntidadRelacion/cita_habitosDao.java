package EntidadRelacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Conexion;

/**
 *
 * @author moisesvelasco
 */
public class cita_habitosDao {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;
    public int addH(Object[] o) {
        int r=0;
        String sql="INSERT INTO cita_habitos (folio,idHabito) values (?,?) ";
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
    public int addF(Object[] o) {
        int r=0;
        String sql="INSERT INTO cita_habitosF (folio,idHabito,frecuencia) values (?,?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            r=ps.executeUpdate();  
        }
        catch(Exception e){ }
        return r;
    }
    
}
