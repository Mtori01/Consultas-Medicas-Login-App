/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Excepcion;
import modelo.InsumosMedicos;
import servicios.FactoriaServiciosImpl;
import vista.InsumoModificar;

import vista.Insumos;


/**
 *
 * @author ginot
 */
public class ControladorInsumosMedicos {
        //private Vista vista;
    Insumos vista;
    private InsumosMedicos modelo;
   
    /*
    public ControladorLogin(Vista v, Usuario m)
    {
        this.vista = v;
        this.modelo = m;
    }
    */
    
    public ControladorInsumosMedicos(Insumos v, InsumosMedicos m)
    {
        this.vista = v;
        this.modelo = m;        
    }
    
     public void inicializar() throws InstantiationException, IllegalAccessException, Exception
    {
        this.vista.setVisible(true);

//      vista.read
        this.vista.getjButton2().addActionListener( e-> {
            try {
                read();
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        // vista.update
        this.vista.getjButton5().addActionListener( e-> {
            try {
                update();
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //delete 
        this.vista.getjButton6().addActionListener( e-> {
            try {
                delete();
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });        
        this.read();
//        this.vista.setVisible(true);
        
    }
     
     public void read(){
         
         
         if (FactoriaServiciosImpl.getFactoria().isDEBUG())
         {
             System.out.println(this.getClass().getCanonicalName() + "Entrando al read()");
         }
         try {
             ArrayList a1 = null;
             if(this.vista.getjTextField1().getText().isEmpty()){
                 
                    a1 = this.modelo.read();
                 
         }else{
                 
                String nombre = this.vista.getjTextField1().getText().trim(); 
                a1 = this.modelo.readConWhere(" where im.nombre like '%" + nombre + "%' "); 
             
         }
         this.vista.llenarTabla(a1);
         
        
            
            
        }catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException ex){
            JOptionPane.showMessageDialog(null,"Posible falla de la BBDD" );
        }
        catch(Excepcion ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }     
     
     
     
     public void update(){
         
        DefaultTableModel m = (DefaultTableModel) this.vista.getjTable1().getModel();
        int filas = m.getRowCount();
        if (filas>0)
        {
            if (this.vista.getjTable1().getSelectedRow()==-1)
            {
                JOptionPane.showMessageDialog(null, "Debe elejir una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);
            }
            else
            {
                int fila = this.vista.getjTable1().getSelectedRow();
                 
                int id = (int) m.getValueAt(fila, 0);
                
                InsumoModificar unaVistaIm = new InsumoModificar(null, false, id);
                InsumosMedicos iModelo = new InsumosMedicos();
                try {
                    iModelo.setId(id);
                } catch (Excepcion ex) {
                    Logger.getLogger(ControladorInsumosMedicos.class.getName()).log(Level.SEVERE, null, ex);
                }
                ControladorInsumoModificar cim = new ControladorInsumoModificar(unaVistaIm, iModelo);
                
                try {
                    cim.inicializar();
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ControladorInsumosMedicos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorInsumosMedicos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "No hay registros", "Información", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);    
        }         
//         JOptionPane.showMessageDialog(vista, "update");
     }
     
     public void delete(){
         
        DefaultTableModel m = (DefaultTableModel) this.vista.getjTable1().getModel();
        int filas = m.getRowCount();
        if (filas>0)
        {
            if (this.vista.getjTable1().getSelectedRow()==-1)
            {
                JOptionPane.showMessageDialog(null, "Debe elejir una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);
            }
            else
            {
                int fila = this.vista.getjTable1().getSelectedRow();
                 
                int id = (int) m.getValueAt(fila, 0);
                
                InsumoModificar unaVistaIm = new InsumoModificar(null, false, id);
                InsumosMedicos iModelo = new InsumosMedicos();
                try {
                    iModelo.setId(id);
                } catch (Excepcion ex) {
                    Logger.getLogger(ControladorInsumosMedicos.class.getName()).log(Level.SEVERE, null, ex);
                }
//                iModelo.getNombre(iModelo.getNombre());
                try{
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro de eliminar este registro: " + iModelo.getId()+"?","Eliminado",JOptionPane.WARNING_MESSAGE + JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    {
                        iModelo.delete(iModelo);
                        this.read();
                    }
                }
                 catch (IllegalAccessException ex) {
                    Logger.getLogger(ControladorInsumosMedicos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorInsumosMedicos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No hay registros", "Información", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);    
        }         
 
     }         
     
}
