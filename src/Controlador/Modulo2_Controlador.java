package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Modulo2;
import Modelo.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Modulo2_Controlador implements ActionListener {

    Modulo2 mod2CRUD = new Modulo2();
    ClienteDAO clienteCRUD = new ClienteDAO();
    ProductoDAO productoCRUD = new ProductoDAO();

    public Modulo2_Controlador(Modulo2 vistaC, ClienteDAO clienteC, ProductoDAO prodC) {
        this.mod2CRUD = vistaC;
        this.clienteCRUD = clienteC;
        this.productoCRUD = prodC;
        this.mod2CRUD.btn_seleccione_continuar.addActionListener(this);
        this.mod2CRUD.btn_seleccione_cancelar.addActionListener(this);
        this.mod2CRUD.btn_confirme_terminarVenta.addActionListener(this);
        this.mod2CRUD.btn_confirme_atras.addActionListener(this);
    }
    
    public void LlenarTablaUsuarios(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        //int codUsuario, String rut_usuario
        modeloT.addColumn("Cód Usuario");
        modeloT.addColumn("RUT");
        
        Object[] columna = new Object[2];
        
        int numRegistros = clienteCRUD.ListCliente().size();
        
        for(int i = 0; i < numRegistros; i++) {
            columna[0] = clienteCRUD.ListCliente().get(i).getCod_cliente();
            columna[1] = clienteCRUD.ListCliente().get(i).getRut_cliente();
            
            modeloT.addRow(columna);
        }
    }
    
    public void LlenarTablaProductos(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);

        modeloT.addColumn("Código Producto");
        modeloT.addColumn("Nombre Producto");
        modeloT.addColumn("Precio Producto");
        modeloT.addColumn("Precio Compra");
        modeloT.addColumn("Stock");
        modeloT.addColumn("Ubicación Bodega");

        Object[] columna = new Object[6];
        
        int numRegistros = productoCRUD.ListProducto().size();
        
        for(int i = 0; i < numRegistros; i++) {
            columna[0] = productoCRUD.ListProducto().get(i).getEstado();
            columna[1] = productoCRUD.ListProducto().get(i).getRut_usuario();
            columna[2] = productoCRUD.ListProducto().get(i).getLogin();
            columna[3] = productoCRUD.ListProducto().get(i).getPassword();
            columna[4] = productoCRUD.ListProducto().get(i).getEstado();
            columna[5] = productoCRUD.ListProducto().get(i).getAcceso();
            
            modeloT.addRow(columna);
        }
    }
    
}
