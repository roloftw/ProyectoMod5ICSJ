package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
import Modelo.*;
import javax.swing.JOptionPane;
/**
 *
 * @RolandoEscobar
 */
public class Login_Controlador implements ActionListener {

    Login longi = new Login();
    LoginDAO longiModelo = new LoginDAO();
    
    public Login_Controlador (Login longiC, LoginDAO longiModC) {
        this.longi = longiC;
        this.longiModelo = longiModC;
        this.longi.btn_aceptar.addActionListener(this);
        this.longi.btn_ayuda.addActionListener(this);
        this.longi.btn_cancelar.addActionListener(this);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        //boton ok
    if(e.getSource() == longi.btn_aceptar) {
    if(longi.txt_user.getText().length()==0)  // Checking for empty field
      JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
    else if(longi.pass_userpass.getPassword().length==0)  // Checking for empty field
      JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
    else{
       String user = longi.txt_user.getText();   // Collecting the input
       char[] pass = longi.pass_userpass.getPassword(); // Collecting the input
       String pwd = String.copyValueOf(pass);  // converting from array to string
       if(longiModelo.validar_login(user,pwd)) {
          //si el Login es correcto, ingresa al menú principal
          longi.dispose();
          JOptionPane.showMessageDialog(null, "Ingreso correcto. Bienvenido");
          MainUI menu = new MainUI();
          MainUI_Controlador controlC = new MainUI_Controlador(menu);
          longiModelo.loginSegunUsuario(user);
          //deshabilitar módulos para vendedor
          if(longiModelo.loginSegunUsuario(user).equals("Vendedor")) {
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
            menu.btn_mod1.setVisible(false);
            menu.btn_mod3.setVisible(false);
            menu.btn_mod4.setVisible(false);
          }
          //deshabilitar módulos para supervisor
          if(longiModelo.loginSegunUsuario(user).equals("Supervisor")) {
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
            menu.btn_mod1.setVisible(false);
            menu.btn_mod2.setVisible(false);
            menu.btn_mod5.setVisible(false);                   
          } 
          if(longiModelo.loginSegunUsuario(user).equals("Administrador")) {
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);              
          }
          } else
          JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
    }
    }
   
        //botón cancelar
    if(e.getSource() == longi.btn_cancelar) {
       System.exit(0);
    }
   
        //botón ayuda
    if(e.getSource() == longi.btn_ayuda) {
        JOptionPane.showMessageDialog(null, "  Debe ingresar su nombre de usuario y contraseña para poder ingresar" +
                                            "\n          al sistema. Su nombre de usuario es su RUT sin guión ni dígito" +
                                            "\n         verificador. Su contraseña le fue asignada por el Administrador" +
                                            "\ndel sistema. Si no puede ingresar o no recuerda su contraseña, contacte" +
                                            "\n                                  al administrador de su sistema");
    }
    }
}


