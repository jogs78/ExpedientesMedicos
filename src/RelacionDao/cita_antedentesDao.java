
package RelacionDao;

import EntidadRelacion.cita_antecedentes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.CRUD;
import modelo.Conexion;
import modelo.EntidadAntecedentes;

/**
 *
 * @author moisesvelasco
 */
public class cita_antedentesDao implements CRUD {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;

    public EntidadAntecedentes obtenerIdAntece (String nom) {
        EntidadAntecedentes ec = new EntidadAntecedentes();
        String sql="SELECT * FROM antecedentes where nombreAntecedente=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, nom);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setId(rs.getInt(1));
            }
        }
        catch(Exception e){}return ec;
    }
    
    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO cita_antecedentes (folio,idAntecedente) values (?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);                     
            r=ps.executeUpdate();  
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null, "error al agregar anteced"+e.getMessage()); }
        return r;
    }
    
    public int addAlergia(Object[] o) {
        int r=0;
        String sql="INSERT INTO cita_alergia (folio,alergia) values (?,?) ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);                     
            r=ps.executeUpdate();  
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null, "error al agregar alergia"+e.getMessage()); }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
