/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Modulo2;
import Modelo.*;
import Vista.Modulo1;
import Vista.Modulo3;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Mirager
 */
public class Modulo3_Controlador implements ActionListener{
    
    
    Modulo3 mod3CRUD = new Modulo3();
    ProductoDAO productCRUD = new ProductoDAO();


    //

    public Modulo3_Controlador(Modulo3 vistaC, ProductoDAO prodSC) {
        this.mod3CRUD = vistaC;

        this.productCRUD = prodSC;

        this.mod3CRUD.btn_rankingProductos_buscar.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mod3CRUD.btn_rankingProductos_buscar) {
            LlenarTablaRankingProductos(mod3CRUD.tab_historialVentas_productosVenta);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void LlenarTablaRankingProductos(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        //int codUsuario, String rut_usuario, String login, String password, String estado, String acceso
        modeloT.addColumn("Producto");
        modeloT.addColumn("Venta");

        
        Object[] columna = new Object[2];
        
        int numRegistros = productCRUD.ListProducto().size();
        
        for(int i = 0; i < numRegistros; i++) {
            columna[0] = productCRUD.ListProducto().get(i).getNombre_producto();
            columna[1] = productCRUD.ListProducto().get(i).getPrecio_compra();

            
            modeloT.addRow(columna);
        }
    }
}
