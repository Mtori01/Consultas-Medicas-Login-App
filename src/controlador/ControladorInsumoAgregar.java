/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.AreaMedica;
import modelo.Excepcion;
import modelo.InsumosMedicos;
import servicios.FactoriaServiciosImpl;
import vista.InsumoAgregar;
    


/**
 *
 * @author ginot
 */
public class ControladorInsumoAgregar {
        //private Vista vista;
    InsumoAgregar vista;
    private InsumosMedicos modelo;
   
    /*
    public ControladorLogin(Vista v, Usuario m)
    {
        this.vista = v;
        this.modelo = m;
    }
    */
    
    public ControladorInsumoAgregar(InsumoAgregar v, InsumosMedicos m)
    {
        this.vista = v;
        this.modelo = m;        
    }
        
     public void inicializar() throws InstantiationException, IllegalAccessException, Exception
    {
        this.vista.setVisible(true);
        
        AreaMedica am = new AreaMedica();
        ArrayList AreasMedicas = am.read();
        this.vista.cargarArea(AreasMedicas);
        
        this.vista.getjButton1().addActionListener( e-> {
            try {
                create();
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.vista.setVisible(true);
    }
     
    public void create(){
                  
         if (FactoriaServiciosImpl.getFactoria().isDEBUG())
         {
             System.out.println(this.getClass().getCanonicalName() + "Entrando al create()");
         }
         
//         if (!validarForm()){
//             return;
//         }
         
         try {
             int id = 0;
             
             String s = this.vista.getjTextField1().getText();
             if (!s.isEmpty()){
             // id = Integer.parseInt(s); 
             // en caso de pibe quita el try catch y solo deja la linea 81 dentro del if
            try
            {
                id = Integer.parseInt(s);            
            }
            catch(NumberFormatException e)
            {
                //no haremos nada
                JOptionPane.showMessageDialog(null, "no se adminte texto");
            }                 
//                id = Integer.parseInt(s);
             }
             
             String nombre = this.vista.getjTextField2().getText();
             
             float cantidad = 0;
             String c = this.vista.getjTextField3().getText();
             if(!c.isEmpty()){
//                 cantidad = Float.parseFloat(c);      
             try{
                 cantidad = Float.parseFloat(c);
                 
             }catch(NumberFormatException e){
                 JOptionPane.showMessageDialog(null, "no se adminte texto");
             }

             }
             String fechaCreacionString = this.vista.getjTextField4().getText();
             SimpleDateFormat procesadorDeFechasStringChilensis = new SimpleDateFormat ("dd-MM-yyyy");
             procesadorDeFechasStringChilensis.setLenient(false);
             Date fechaCreacionTipoDate = null;
            try
            {
                fechaCreacionTipoDate = procesadorDeFechasStringChilensis.parse(fechaCreacionString);
            }
            catch(ParseException e)
            {
                //no haremos nada
            }
             
             
             String uso = null;
             if (this.vista.getjRadioButton1().isSelected())
            {
                uso = "s";
            }
             else{
                 uso = "n";
             }
             
             boolean activo = false;
             if (this.vista.getjCheckBox1().isSelected()){
                 activo = true;
             }
             
             String areaNombreSelecionada = null; 
             int codigoAreaNombre = 0;
             String nombreAreaMedica = null;
             if (this.vista.getjComboBox1().getModel().getSize()!=0){
                 
                 areaNombreSelecionada = (String)this.vista.getjComboBox1().getSelectedItem();
                       
                 String corcheteAbiertoADerecha="[";
                 String corcheteAbiertoAIzquierda="]";
                
                 int dondeCorcheteAbiertoADerecha = areaNombreSelecionada.indexOf(corcheteAbiertoADerecha);
                 int dondeCorcheteAbiertoAIzquierda = areaNombreSelecionada.indexOf(corcheteAbiertoAIzquierda);
                
                 String codigoDentroDeLosCorchetes = areaNombreSelecionada.substring(dondeCorcheteAbiertoADerecha+1, dondeCorcheteAbiertoAIzquierda);
                 codigoAreaNombre = Integer.parseInt(codigoDentroDeLosCorchetes);
                 
                 nombreAreaMedica = areaNombreSelecionada.substring(0, dondeCorcheteAbiertoADerecha).trim();
                 
             }
             
             
             InsumosMedicos im = new InsumosMedicos();
             
             im.setId(id);
             im.setNombre(nombre);
             im.setInyeccion(cantidad);
             im.setFechaCreacion(fechaCreacionTipoDate);
             im.setUso(uso);
             im.setActivo(activo);
             im.setId_areaMedica(codigoAreaNombre);
             im.setAreaNombre(nombreAreaMedica);
             
             this.modelo.create(im);
             JOptionPane.showMessageDialog(null,"Registro agregado" );
            
        }catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException ex){
            JOptionPane.showMessageDialog(null,"Posible falla de la BBDD" );
        }
        catch(Excepcion ex){
            this.vista.mostrarValidacion(ex.getMessage());
//            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
     
    //metodo para retornar la id maxima registrada + 1 
     
//    public boolean validarForm(){
//         boolean validar = true;
//         
////         if (this.vista.getjTextField1().getText().isEmpty()) {
////             JOptionPane.showMessageDialog(null, "Se debe ingresar la id de medicamento.");
////             validar = false;
////         }
//         
//         if ( this.vista.getjTextField2().getText().isEmpty()) {
//             JOptionPane.showMessageDialog(null, "Se debe ingresar nombre de medicamento.");
//             validar = false;
//            }
//         if (this.vista.getjTextField3().getText().isEmpty()) {
//             JOptionPane.showMessageDialog(null, "Se debe ingresar la cantidad del medicamento.");
//             validar = false;
//         }
//         
//         if (this.vista.getjTextField4().getText().isEmpty()){
//             JOptionPane.showMessageDialog(null, "Se debe ingresar fecha del medicamento.");
//             validar = false;
//         }
//         return validar;
//     }
    
}
