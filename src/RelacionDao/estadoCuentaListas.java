
package RelacionDao;

import EntidadRelacion.Ent_cita_blandos;
import EntidadRelacion.Ent_cita_cuidados;
import EntidadRelacion.Ent_cita_cuidadosF;
import EntidadRelacion.Ent_cita_habitos;
import EntidadRelacion.Ent_cita_habitosF;
import EntidadRelacion.Ent_cita_oclusion;
import EntidadRelacion.Ent_dientes_padecimiento;
import EntidadRelacion.Ent_dientes_tratamiento;
import EntidadRelacion.cita_alergia;
import EntidadRelacion.cita_antecedentes;
import EntidadRelacion.cita_anticonseptivos;
import EntidadRelacion.cita_duros;
import EntidadRelacion.Ent_cita_rx;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.EntDuros;
import modelo.EntidadAntecedentes;
import modelo.EntidadAnticon;
import modelo.EntidadBlando;
import modelo.EntidadCuidados;
import modelo.EntidadDientes;
import modelo.EntidadHabitos;
import modelo.EntidadOclusion;
import modelo.EntidadPadecimiento;
import modelo.EntidadRx;
import modelo.EntidadTratamiento;

/**
 * en esta clase se haran todas las listas
 * @author moisesvelasco
 */
public class estadoCuentaListas {
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion(); 
    Connection con;
    public List listarDites_Tratamiento(int folio) {
        List<Ent_dientes_tratamiento> lista = new ArrayList<>();
        String sql="SELECT * FROM tratamiento_dientes where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                Ent_dientes_tratamiento ep = new Ent_dientes_tratamiento(); 
                 
                 ep.setIdDiente(rs.getInt(3));
                 ep.setIdTratamiento(rs.getInt(4));                 
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }   
    
    public List listarDites_padecimiento(int folio) {
        List<Ent_dientes_padecimiento> lista = new ArrayList<>();
        String sql="SELECT * FROM dientes_padecimiento where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                Ent_dientes_padecimiento ep = new Ent_dientes_padecimiento(); 
                 
                 ep.setIdDiente(rs.getInt(3));
                 ep.setIdPadecimiento(rs.getInt(4));
                 ep.setColor(rs.getString(5));
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    public List listarCita_Antecedentes(int folio) {
        List<cita_antecedentes> lista = new ArrayList<>();
        String sql="SELECT * FROM cita_antecedentes where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                cita_antecedentes ep = new cita_antecedentes(); 
                 
                 ep.setIdAntecedente(rs.getInt(3));
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    public List listarCita_Habitos(int folio) {
        List<Ent_cita_habitos> lista = new ArrayList<>();
        String sql="SELECT * FROM cita_habitos where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                Ent_cita_habitos ep = new Ent_cita_habitos(); 
                 
                 ep.setIdHabito(rs.getInt(3));
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    public List listarCita_HabitosF(int folio) {
        List<Ent_cita_habitosF> lista = new ArrayList<>();
        String sql="SELECT * FROM cita_habitosF where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                Ent_cita_habitosF ep = new Ent_cita_habitosF();
                 ep.setIdHabito(rs.getInt(3));
                 ep.setFrecuencia(rs.getString(4));
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    
    public List listarCita_alergia(int folio) {
        List<cita_alergia> lista = new ArrayList<>();
        String sql="SELECT * FROM cita_alergia where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                cita_alergia ep = new cita_alergia();
                 ep.setAlergia(rs.getString(3));
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    public List listarCita_anticonsep(int folio) {
        List<cita_anticonseptivos> lista = new ArrayList<>();
        String sql="SELECT * FROM cita_anticonseptivos where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                cita_anticonseptivos ep = new cita_anticonseptivos();
                 ep.setIdAnticonseptivo(rs.getInt(3));
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    public List listarCita_duros(int folio) {
        List<cita_duros> lista = new ArrayList<>();
        String sql="SELECT * FROM cita_duros where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                cita_duros ep = new cita_duros();
                 ep.setIdDuro(rs.getInt(3));
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    public List listarCita_Rx(int folio) {
        List<Ent_cita_rx> lista = new ArrayList<>();
        String sql="SELECT * FROM cita_rx where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                Ent_cita_rx ep = new Ent_cita_rx();
                 ep.setIdRx(rs.getInt(3));
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    public List listarCita_Blandos(int folio) {
        List<Ent_cita_blandos> lista = new ArrayList<>();
        String sql="SELECT * FROM cita_blandos where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                Ent_cita_blandos ep = new Ent_cita_blandos();
                 ep.setIdBlando(rs.getInt(3));
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    public List listarCita_oclusion(int folio) {
        List<Ent_cita_oclusion> lista = new ArrayList<>();
        String sql="SELECT * FROM cita_oclusion where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                Ent_cita_oclusion ep = new Ent_cita_oclusion();
                 ep.setIdOclusion(rs.getInt(3));
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    public List listarCita_cuidados(int folio) {
        List<Ent_cita_cuidados> lista = new ArrayList<>();
        String sql="SELECT * FROM cita_cuidados where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                Ent_cita_cuidados ep = new Ent_cita_cuidados();
                 ep.setIdCuidado(rs.getInt(3));
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    public List listarCita_cuidadosF(int folio) {
        List<Ent_cita_cuidadosF> lista = new ArrayList<>();
        String sql="SELECT * FROM cita_cuidadosF where folio=? ";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, folio);
            rs=ps.executeQuery();
            while(rs.next()){
                Ent_cita_cuidadosF ep = new Ent_cita_cuidadosF();
                 ep.setVecesCepilla(rs.getInt(3));
                 ep.setIdCuidado(rs.getInt(4));
                 lista.add(ep);                 
            }
        }
        catch(Exception e){}
        return lista;
    }
    
    
    public EntidadDientes obtenerNomDiente (int id) {
         EntidadDientes ec = new EntidadDientes();
        String sql="SELECT nombreDiente  FROM dientes where idDiente=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreDiente(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
    
    public EntidadTratamiento obtenerNomTratamiento (int id) {
         EntidadTratamiento ec = new EntidadTratamiento();
        String sql="SELECT *  FROM tratamiento where idTratamiento=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreTratamiento(rs.getString(2));
                ec.setPrecioTratamiento(rs.getInt(4));
            }
        }
        catch(Exception e){}return ec;
    }
    public EntidadPadecimiento obtenerNomPademiento (int id) {
         EntidadPadecimiento ec = new EntidadPadecimiento();
        String sql="SELECT nombrePadecimiento  FROM padecimiento where idPadecimiento=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombrePadecimiento(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
    public EntidadAntecedentes obtenerNomAntecedente (int id) {
         EntidadAntecedentes ec = new EntidadAntecedentes();
        String sql="SELECT nombreAntecedente  FROM antecedentes where idAntecedente=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreAntecedente(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
 public EntidadHabitos obtenerNomHabitos (int id) {
         EntidadHabitos ec = new EntidadHabitos();
        String sql="SELECT nombreHabito FROM habitos where idHabito=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreHabito(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }   
    public EntidadAnticon obtenerNomAnticonsep (int id) {
         EntidadAnticon ec = new EntidadAnticon();
        String sql="SELECT tipoAnt FROM anticonseptivos where idAnticonsep=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreAnt(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
    public EntDuros obtenerNomDuro (int id) {
         EntDuros ec = new EntDuros();
        String sql="SELECT nombreDuro FROM duros where idDuro=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreDuro(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
    public EntidadRx obtenerNomRx (int id) {
         EntidadRx ec = new EntidadRx();
        String sql="SELECT nombreRx FROM rx where idRx=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreRx(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
    public EntidadBlando obtenerNomblando (int id) {
         EntidadBlando ec = new EntidadBlando();
        String sql="SELECT nombreBlando FROM blandos where idBlando=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreBlando(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
    public EntidadOclusion obtenerNomOclusion (int id) {
         EntidadOclusion ec = new EntidadOclusion();
        String sql="SELECT nombreOclusion FROM oclusion where idOclusion=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreOclusion(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
    public EntidadCuidados obtenerNomCuidado (int id) {
         EntidadCuidados ec = new EntidadCuidados();
        String sql="SELECT nombreCuidado FROM cuidados where idCuidado=?";
        try{
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                ec.setNombreCuidado(rs.getString(1));
            }
        }
        catch(Exception e){}return ec;
    }
}
