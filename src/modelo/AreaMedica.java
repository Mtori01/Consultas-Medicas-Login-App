/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.AreaMedicaDAOImpl;
import dao.CrudDAOable;
import java.util.ArrayList;
import servicios.FactoriaServiciosImpl;

/**
 *
 * @author ginot
 */
public class AreaMedica {
    
//id int not null,
//nombre varchar(10),
//activa bit(1),
    
    private int id;
    private String nombre;
    private boolean activa;

    public AreaMedica() {
    }

    public AreaMedica(int id, String nombre, boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.activa = activa;
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

//    @Override
//    public String toString() {
//        return "AreaMedica{" + "id=" + id + ", nombre=" + nombre + ", activa=" + activa + '}';
//    }

    @Override
    public String toString() {
        return nombre + "[" + id + "]";
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AreaMedica other = (AreaMedica) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    public ArrayList read() throws InstantiationException, IllegalAccessException, Exception
    {
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
            System.out.println(this.getClass().getCanonicalName() + " Entrando a read");
        }
        
        CrudDAOable<AreaMedica> cDAO = new AreaMedicaDAOImpl();
        return cDAO.read(); 
    }
}
