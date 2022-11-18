/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.CrudDAOable;
import dao.InsumosMedicosDAOImpl;
import java.util.ArrayList;
import java.util.Date;
import servicios.FactoriaServiciosImpl;

/**
 *
 * @author ginot
 */
public class InsumosMedicos {
    
    private int id;
    private String nombre;
    private float inyeccion;
    private Date fechaCreacion;
    //valores nuevos
    private String uso;
    private boolean activo;
    
    private int id_areaMedica;
    
    //nombre del area medica
    private String areaNombre;
    

//insumoMedico(
//id int not null,
//nombre varchar(10),
//inyeccion real,
//fechaCreacion Date,
//

    public InsumosMedicos() {
    }

    public InsumosMedicos(int id, String nombre, float inyeccion, Date fechaCreacion, String uso, boolean activo, int id_areaMedica, String areaNombre) throws Excepcion {
        this.setId(id);
        this.setNombre(nombre);
        this.setInyeccion(inyeccion);
        this.setFechaCreacion(fechaCreacion);
        this.setUso(uso);
        this.setActivo(activo);
        this.setId_areaMedica(id_areaMedica);
        
//        this.id = id;
//        this.nombre = nombre;
//        this.inyeccion = inyeccion;
//        this.fechaCreacion = fechaCreacion;
//        this.uso = uso;
//        this.activo = activo;
//        this.id_areaMedica = id_areaMedica;
//        this.areaNombre = areaNombre;
    }

    @Override
    public String toString() {
        return "InsumosMedicos{" + "id=" + id + ", nombre=" + nombre + ", inyeccion=" + inyeccion + ", fechaCreacion=" + fechaCreacion + ", uso=" + uso + ", activo=" + activo + ", id_areaMedica=" + id_areaMedica + ", areaNombre=" + areaNombre + '}';
    }

    //getters && setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) throws Excepcion{
        if ( id == 0 ) {
            throw new Excepcion("el campo id no puede estar vacio");
        }
        else{
            this.id = id;
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Excepcion{
        if(nombre.isEmpty()){
         throw new Excepcion("el campo nombre no debe estar vacio");
        }
        else{
            this.nombre = nombre;
        }
    }

    public float getInyeccion() {
           return inyeccion;
    }

    public void setInyeccion(float inyeccion) throws Excepcion {
        if(inyeccion == 0 ){
            throw new Excepcion("el campo cantidad no puede estar vacio");
        }else{
            this.inyeccion = inyeccion;
        }
    }


    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) throws Excepcion {
        if (fechaCreacion == null)
        {
            throw new Excepcion("La fecha no puede ser vacia o invalida");
        }
        else
        {
            this.fechaCreacion = fechaCreacion;
        }        
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getId_areaMedica() {
        return id_areaMedica;
    }

    public void setId_areaMedica(int id_areaMedica) {
        this.id_areaMedica = id_areaMedica;
    }

    public String getAreaNombre() {
        return areaNombre;
    }

    public void setAreaNombre(String areaNombre) {
        this.areaNombre = areaNombre;
    }    
    @Override
    public int hashCode() {
        int hash = 3;
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
        final InsumosMedicos other = (InsumosMedicos) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void create(InsumosMedicos im) throws InstantiationException, IllegalAccessException, Exception{
        
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
           System.out.println(this.getClass().getCanonicalName() + "Entrando al create()");
        }
        
        CrudDAOable<InsumosMedicos> imDAO = new InsumosMedicosDAOImpl();
        imDAO.create(im);
    }
    
    public ArrayList<InsumosMedicos> read() throws InstantiationException, IllegalAccessException, Exception{
         if (FactoriaServiciosImpl.getFactoria().isDEBUG())
         {
            System.out.println(this.getClass().getCanonicalName() + "Entrando al read()");
         }
        
        CrudDAOable<InsumosMedicos> imDAO = new InsumosMedicosDAOImpl();
        return imDAO.read(); 
    }
     
    public ArrayList<InsumosMedicos> readConWhere(String whereSQL) throws InstantiationException, IllegalAccessException, Exception{
         if (FactoriaServiciosImpl.getFactoria().isDEBUG())
         {
            System.out.println(this.getClass().getCanonicalName() + "Entrando al read()");
         }
        
        CrudDAOable<InsumosMedicos> imDAO = new InsumosMedicosDAOImpl();
        return imDAO.readWhere(whereSQL); 
    }    
    
    
    public void update(InsumosMedicos im) throws InstantiationException, IllegalAccessException, Exception{
        
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
           System.out.println(this.getClass().getCanonicalName() + "Entrando al update()");
        }
        
        CrudDAOable<InsumosMedicos> imDAO = new InsumosMedicosDAOImpl();
        imDAO.update(im);
    }    
    
    public void delete(InsumosMedicos im) throws InstantiationException, IllegalAccessException, Exception{
        
        if (FactoriaServiciosImpl.getFactoria().isDEBUG())
        {
           System.out.println(this.getClass().getCanonicalName() + "Entrando al modelo.InsumosMedicos delete()");
        }
        
        CrudDAOable<InsumosMedicos> imDAO = new InsumosMedicosDAOImpl();
        imDAO.delete(im);
    }    
    
    
    
    public int getAreaNombreById(int id) throws IllegalAccessException, Exception{
        
        InsumosMedicosDAOImpl imDAO = new InsumosMedicosDAOImpl();
        return imDAO.getAreaNombreById(id);
    }
    
    public InsumosMedicos getInsumosMedicos(InsumosMedicos iM) throws InstantiationException, IllegalAccessException, Exception{
        
        InsumosMedicosDAOImpl imDAO = new InsumosMedicosDAOImpl();
        return imDAO.read(" where im.id='" + iM.getId() + "'");  
    }
}
