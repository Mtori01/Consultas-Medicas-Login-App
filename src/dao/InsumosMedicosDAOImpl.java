/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import modelo.InsumosMedicos;
import servicios.FactoriaServiciosImpl;
 
/**
 *
 * @author ginot
 */
public class InsumosMedicosDAOImpl implements InsumosMedicosDAOable {

    @Override
    public void create(InsumosMedicos t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
           System.out.println(this.getClass().getCanonicalName() + "Entrando al create()InsumosMedicosDAOImpl");
        }
//    int id;
//    String nombre;
//    float inyeccion;
//    Date fechaCreacion;
//    String uso;
//    boolean activo; 
//    int id_areaMedica;
        
        String sql = "insert into insumoMedico values(?,?,?,?,?,?,?);";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        //linea 38 comentada 
        ps.setInt(1, t.getId());
        ps.setString(2, t.getNombre());
        ps.setFloat(3, t.getInyeccion());
        ps.setDate(4, new java.sql.Date(t.getFechaCreacion().getTime()));
        ps.setString(5, t.getUso());
        ps.setBoolean(6, t.isActivo());
        ps.setInt(7, t.getId_areaMedica());
        ps.executeUpdate();        
    }

    @Override
    public boolean read(InsumosMedicos t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public ArrayList<InsumosMedicos> read() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        
         if (FactoriaServiciosImpl.getFactoria().isDEBUG())
         {
            System.out.println(this.getClass().getCanonicalName() + "Entrando al read() solo read()");
         }
        
        ArrayList<InsumosMedicos> al = new ArrayList();
        String sql = "select im.*, am.nombre "
                + " from insumoMedico as im"
                + " inner join areaMedica as am on im.id_areaMedica = am.id;";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            int id = rs.getInt("id");
            String nombre = rs.getString("im.nombre");
            float inyeccion = rs.getFloat("inyeccion");
            Date fechaCreacion = rs.getDate("fechaCreacion");
            // valores agregados
            String uso = rs.getString("uso");
            boolean activo = rs.getBoolean("activo");
            int id_areaMedica = rs.getInt("id_areaMedica");
            //nombre de la tabla AreaMedica
            String areaNombre = rs.getString("am.nombre");
            
            
            
            InsumosMedicos insumosM = new InsumosMedicos();
            insumosM.setId(id);
            insumosM.setNombre(nombre);
            insumosM.setInyeccion(inyeccion);
            insumosM.setFechaCreacion(fechaCreacion);
            //valores nuevos
            insumosM.setUso(uso);
            insumosM.setActivo(activo);
            
            insumosM.setId_areaMedica(id_areaMedica);
            insumosM.setAreaNombre(areaNombre);
            
            al.add(insumosM);
        }        
        return al;
    }

    @Override
    public ArrayList<InsumosMedicos> readWhere(String whereSQL) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        ArrayList<InsumosMedicos> al = new ArrayList();
        String sql = "select im.*, am.nombre as areaNombre "
                + "from insumoMedico im "
                + " join areaMedica am on (im.id_areaMedica = am.id) " 
                + whereSQL + ";";
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a readWhere()");
            System.out.println(sql);
        }
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            //tabla insumoMedico
            int id = rs.getInt("im.id");
            String nombre = rs.getString("im.nombre");
            float inyeccion = rs.getFloat("inyeccion");
            Date fechaCreacion = rs.getDate("fechaCreacion");
            int id_areaMedica = rs.getInt("id_areaMedica");
            // valores agregados
            String uso = rs.getString("uso");
            boolean activo = rs.getBoolean("activo");
            //tabla areaMedica
            String areaNombre = rs.getString("am.areaNombre");
            
            InsumosMedicos insumosM = new InsumosMedicos();
            
            insumosM.setId(id);
            insumosM.setNombre(nombre);
            insumosM.setInyeccion(inyeccion);
            insumosM.setFechaCreacion(fechaCreacion);
            insumosM.setUso(uso);
            insumosM.setActivo(activo);
            insumosM.setId_areaMedica(id_areaMedica);
            insumosM.setAreaNombre(areaNombre);
            
            al.add(insumosM);
        }        
        return al; 
     }
    
    
    public InsumosMedicos read(String whereSQL) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {

        InsumosMedicos insumosM = null;
        
        String sql = "select im.*, am.nombre as areaNombre "
                + "from insumoMedico im "
                + " join areaMedica am on (im.id_areaMedica = am.id) " 
                + whereSQL + ";";
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a read(String whereSQL)");
            System.out.println(sql);
        }
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            //tabla insumoMedico
            int id = rs.getInt("im.id");
            String nombre = rs.getString("im.nombre");
            float inyeccion = rs.getFloat("inyeccion");
            Date fechaCreacion = rs.getDate("fechaCreacion");
            int id_areaMedica = rs.getInt("id_areaMedica");
            // valores agregados
            String uso = rs.getString("uso");
            boolean activo = rs.getBoolean("activo");
            //tabla areaMedica
            String areaNombre = rs.getString("am.areaNombre");
            
            insumosM = new InsumosMedicos();
            
            insumosM.setId(id);
            insumosM.setNombre(nombre);
            insumosM.setInyeccion(inyeccion);
            insumosM.setFechaCreacion(fechaCreacion);
            insumosM.setUso(uso);
            insumosM.setActivo(activo);
            insumosM.setId_areaMedica(id_areaMedica);
            insumosM.setAreaNombre(areaNombre);
            
        }        
        return insumosM; 
     }
    @Override
    public void update(InsumosMedicos t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
           System.out.println(this.getClass().getCanonicalName() + "Entrando al update()InsumosMedicosDAOImpl");
        }
         
//id int not null,
//nombre varchar(10),
//inyeccion real,
//fechaCreacion Date,
//uso varchar(1),
//activo bit(1),
//
//id_areaMedica int,      
         
        String sql = "update insumoMedico set nombre=?, inyeccion=?, fechaCreacion=?, uso=?, activo=?, id_areaMedica=? where id=?;";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        
        ps.setString(1, t.getNombre());
        ps.setFloat(2, t.getInyeccion());
        ps.setDate(3, new java.sql.Date(t.getFechaCreacion().getTime()));
        ps.setString(4, t.getUso());
        ps.setBoolean(5, t.isActivo());
        ps.setInt(6, t.getId_areaMedica());
        ps.setInt(7, t.getId());
        ps.executeUpdate();        
        
    }

    @Override
    public void delete(InsumosMedicos t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
           System.out.println(this.getClass().getCanonicalName() + "Entrando al delete()InsumosMedicosDAOImpl");
        }
        String sql = "delete from insumoMedico where id=?;";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ps.setInt(1, t.getId());
        ps.executeUpdate();        
    }

 
    public int getAreaNombreById(int id) throws InstantiationException, IllegalAccessException, Exception{
        InsumosMedicos im = this.read(" where im.id ='"+ id +"'");
        System.out.println(im);
        if (im == null){
            return 0;
        }else{
            return im.getId_areaMedica();
        }
    }
    
    //metodo para retornar la id maxima registrada + 1 
    public int retornarId(int id) throws InstantiationException, IllegalAccessException, Exception{
        InsumosMedicos im = this.read(" select max(im.id) + 1 from insumoMedico im ");
//        String sql = "select max(im.id) + 1 from insumoMedico im";
//        return Integer.parseInt(sql);
        if (im == null) {
            return 0;
        }else{
            return im.getId();
        }
    }    
    
}
