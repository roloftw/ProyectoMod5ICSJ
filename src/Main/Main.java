package Main;

import Modelo.*;
import Vista.*;
import Controlador.*;
/**
 *
 * @RolandoEscobar
 */
public class Main {
    //instanciar el controlador para que respondan los botones
    //MainUI_Controlador controlC;
    
    public static void main(String[] args) {
        MainUI menu = new MainUI();
        Modulo1 mod1 = new Modulo1();
        MainUI_Controlador controlC = new MainUI_Controlador(menu);
        
        menu.setVisible(true);
    }
}