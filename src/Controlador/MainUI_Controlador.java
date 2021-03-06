package Controlador;

import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
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
            ProductoDAO prodC = new ProductoDAO();
            ClienteDAO clientC = new ClienteDAO();
            CategoriaDAO catC = new CategoriaDAO();
            ProductoStockDAO prodSC = new ProductoStockDAO();
            Modulo1_Controlador mod1C = new Modulo1_Controlador(mod1, userC, prodC, clientC, catC, prodSC);
            mod1.setVisible(true);
            //mainMenu.setVisible(false);
        }
        if(e.getSource() == mainMenu.btn_mod3){
            Modulo3 mod3 = new Modulo3();
            ProductoDAO prodC = new ProductoDAO();
            
            Modulo3_Controlador mod3C = new Modulo3_Controlador(mod3, prodC);
            mod3.setVisible(true);
        }
    }

    
}
