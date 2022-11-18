/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.AreaMedica;
import servicios.FactoriaServiciosImpl;

/**
 *
 * @author ginot
 */
public class AreaMedicaDAOImpl implements AreaMedicaDAOable{

    @Override
    public void create(AreaMedica t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean read(AreaMedica t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AreaMedica> read() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        ArrayList<AreaMedica> al = new ArrayList();
        String sql = "select * from areaMedica;";
        PreparedStatement ps = FactoriaServiciosImpl.getFactoria().getConexionDB().getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            boolean activa = rs.getBoolean("activa");
            
            AreaMedica areaM = new AreaMedica(id,nombre, activa);            
            al.add(areaM);
        }        
        return al;    
    }

    @Override
    public ArrayList<AreaMedica> readWhere(String whereSQL) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(AreaMedica t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(AreaMedica t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }


