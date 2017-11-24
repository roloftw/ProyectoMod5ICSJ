package Main;

import Modelo.*;
import Vista.*;
import Controlador.*;
import javax.swing.JFrame;
/**
 *
 * @RolandoEscobar
 */
public class Main {
    //instanciar el controlador para que respondan los botones
    //MainUI_Controlador controlC;
    
    public static void main(String[] args) {
        /*MainUI menu = new MainUI();
        Modulo1 mod1 = new Modulo1();
        UsuarioDAO userC = new UsuarioDAO();
        MainUI_Controlador controlC = new MainUI_Controlador(menu);
        Modulo1_Controlador mod1C = new Modulo1_Controlador(mod1, userC);*/
        Login longi = new Login();
        LoginDAO longiModelo = new LoginDAO();
        Login_Controlador cont = new Login_Controlador(longi, longiModelo);
        longi.setVisible(true);
        longi.setLocationRelativeTo(null);
    }
}
