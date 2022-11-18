/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import vista.Login;
import vista.Menu;


/**
 *
 * @author leo
 Mi ControladorLogin...
 */
public class ControladorLogin {
    //private Vista vista;
    Login vista;
    private Usuario modelo;
   
    /*
    public ControladorLogin(Vista v, Usuario m)
    {
        this.vista = v;
        this.modelo = m;
    }
    */
    
    public ControladorLogin(Login v, Usuario m)
    {
        this.vista = v;
        this.modelo = m;        
    }
    
    /*
    public void logearse() throws InstantiationException, IllegalAccessException, Exception
    {
        modelo = vista.pedirLogin();
        if (modelo.logearse())
        {
            vista.imprimirExito();
        }
        else
        {
            vista.imprimirFracaso();
        }
    }
    */
    
     public void inicializar() throws InstantiationException, IllegalAccessException, Exception
    {
        this.vista.setVisible(true);
        
        
        this.vista.getjButton1().addActionListener(e-> {
            try {
                login();
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
     
     public void login() throws IllegalAccessException, Exception
     {
         String login = this.vista.getjTextField1().getText();
         String pass = this.vista.getjTextField2().getText();
         
         this.modelo.setLogin(login);
         this.modelo.setPassword(pass);
         if (this.modelo.logearse())
         {
             this.vista.setVisible(false);
             new Menu().setVisible(true);
         }
         else
         {
             this.vista.imprimirFracaso();
         }   
     }

}
