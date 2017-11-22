package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Modulo1;
import Modelo.UsuarioDAO;

/**
 *
 * @RolandoEscobar
 */
public class Modulo1_Controlador implements ActionListener {

    Modulo1 mod1CRUD = new Modulo1();
    UsuarioDAO userCRUD = new UsuarioDAO();
    
    public Modulo1_Controlador(Modulo1 vistaC, UsuarioDAO userC) {
        this.mod1CRUD = vistaC;
        this.userCRUD = userC;
        //this.mod1CRUD.
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
