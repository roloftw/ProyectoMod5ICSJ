package Controlador;

import Modelo.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
import javax.swing.JOptionPane;
/**
 *
 * @RolandoEscobar
 */
public class MainUI_Controlador implements ActionListener {

    MainUI mainMenu = new MainUI();
    
    public MainUI_Controlador(MainUI vistaC) {
        this.mainMenu = vistaC;
        this.mainMenu.btn_mod1.addActionListener(this);
        this.mainMenu.btn_mod2.addActionListener(this);
        this.mainMenu.btn_mod3.addActionListener(this);
        this.mainMenu.btn_mod4.addActionListener(this);
        this.mainMenu.btn_mod5.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //reacciones a los click en botones de la Main UI
        //
        if(e.getSource() == mainMenu.btn_mod1) {
            //JOptionPane.showMessageDialog(null, "holi");
            //mainMenu.setVisible(false);
            //mainMenu.dispose();
            Modulo1 mod1 = new Modulo1();
            UsuarioDAO userC = new UsuarioDAO();
            Modulo1_Controlador mod1C = new Modulo1_Controlador(mod1, userC);
            mod1.setVisible(true);
        }
    }

    
}
