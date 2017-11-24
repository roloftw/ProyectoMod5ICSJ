package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Modulo1;
import Modelo.UsuarioDAO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        this.mod1CRUD.btn_categorias_aniadirCategoria.addActionListener(this);
        this.mod1CRUD.btn_categorias_editarRegistro.addActionListener(this);
        this.mod1CRUD.btn_categorias_eliminarCategoria.addActionListener(this);
        this.mod1CRUD.btn_categorias_finEdicion.addActionListener(this);
        this.mod1CRUD.btn_categorias_limpiar.addActionListener(this);
        this.mod1CRUD.btn_categorias_listarCategorias.addActionListener(this);
        this.mod1CRUD.btn_clientes_aniadirNuevoCliente.addActionListener(this);
        this.mod1CRUD.btn_clientes_editarRegistro.addActionListener(this);
        this.mod1CRUD.btn_clientes_eliminarCliente.addActionListener(this);
        this.mod1CRUD.btn_clientes_finEdicion.addActionListener(this);
        this.mod1CRUD.btn_clientes_limpiar.addActionListener(this);
        this.mod1CRUD.btn_clientes_listarClientes.addActionListener(this);
        this.mod1CRUD.btn_productos_aniadirProducto.addActionListener(this);
        this.mod1CRUD.btn_productos_editarRegistro.addActionListener(this);
        this.mod1CRUD.btn_productos_eliminarProducto.addActionListener(this);
        this.mod1CRUD.btn_productos_finEdicion.addActionListener(this);
        this.mod1CRUD.btn_productos_limpiar.addActionListener(this);
        this.mod1CRUD.btn_productos_listarProductos.addActionListener(this);
        this.mod1CRUD.btn_stock_listarStock.addActionListener(this);
        this.mod1CRUD.btn_usuarios_crearNuevoUsuario.addActionListener(this);
        this.mod1CRUD.btn_usuarios_editarRegistro.addActionListener(this);
        this.mod1CRUD.btn_usuarios_eliminarUsuario.addActionListener(this);
        this.mod1CRUD.btn_usuarios_finEdicion.addActionListener(this);
        this.mod1CRUD.btn_usuarios_limpiar.addActionListener(this);
        this.mod1CRUD.btn_usuarios_listarUsuarios.addActionListener(this);
    }
    
    
    public void LlenarTabla(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        //int codUsuario, String rut_usuario, String login, String password, String estado, String acceso
        modeloT.addColumn("Cód Usuario");
        modeloT.addColumn("RUT");
        modeloT.addColumn("Login");
        modeloT.addColumn("Contraseña");
        modeloT.addColumn("Estado");
        modeloT.addColumn("Acceso");
        
        Object[] columna = new Object[6];
        
        int numRegistros = userCRUD.ListUsuario().size();
        
        for(int i = 0; i < numRegistros; i++) {
            columna[0] = userCRUD.ListUsuario().get(i).getCod_usuario();
            columna[1] = userCRUD.ListUsuario().get(i).getRut_usuario();
            columna[2] = userCRUD.ListUsuario().get(i).getLogin();
            columna[3] = userCRUD.ListUsuario().get(i).getPassword();
            columna[4] = userCRUD.ListUsuario().get(i).getEstado();
            columna[5] = userCRUD.ListUsuario().get(i).getAcceso();
            
            modeloT.addRow(columna);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mod1CRUD.btn_usuarios_crearNuevoUsuario) {
            String codU = mod1CRUD.txt_usuarios_codUser.getText();
            String rut_usuario = mod1CRUD.txt_usuarios_rut.getText();
            String login = mod1CRUD.txt_usuarios_login.getText();
            String password = mod1CRUD.pass_usuarios_pass.getText();
            String estado = "1";
            String acceso = mod1CRUD.cbox_usuarios_nivelAcceso.getSelectedItem().toString();
            
            String rptaRegistro = userCRUD.InsertUsuario(codU, rut_usuario, login, password, acceso);
            //String rptaRegistro = userCRUD.InsertUsuario("a", "a", "b", "p", "e", "ac");
            
            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erróneo");
            }
            LlenarTabla(mod1CRUD.table_usuarios);
            mod1CRUD.txt_usuarios_codUser.setText("");
            mod1CRUD.txt_usuarios_rut.setText("");
            mod1CRUD.txt_usuarios_login.setText("");
            mod1CRUD.txt_usuarios_estado.setText("");
            mod1CRUD.pass_usuarios_pass.setText("");
            mod1CRUD.cbox_usuarios_nivelAcceso.setSelectedIndex(0);
        }
        
        if(e.getSource() == mod1CRUD.btn_usuarios_listarUsuarios) {
            LlenarTabla(mod1CRUD.table_usuarios);
        }
        
        if(e.getSource() == mod1CRUD.btn_usuarios_editarRegistro) {
            int filaEditar = mod1CRUD.table_usuarios.getSelectedRow();
            int numFS = mod1CRUD.table_usuarios.getSelectedRowCount();
            
            if(filaEditar >= 0 && numFS == 1) {
                mod1CRUD.txt_usuarios_codUser.setText(String.valueOf(mod1CRUD.table_usuarios.getValueAt(filaEditar, 0)));
                mod1CRUD.txt_usuarios_rut.setText(String.valueOf(mod1CRUD.table_usuarios.getValueAt(filaEditar, 1)));
                mod1CRUD.txt_usuarios_login.setText(String.valueOf(mod1CRUD.table_usuarios.getValueAt(filaEditar, 2)));
                mod1CRUD.txt_usuarios_estado.setText(String.valueOf(mod1CRUD.table_usuarios.getValueAt(filaEditar, 5)));
                mod1CRUD.pass_usuarios_pass.setText(String.valueOf(mod1CRUD.table_usuarios.getValueAt(filaEditar, 4)));
                //mod1CRUD.cbox_usuarios_nivelAcceso.setSelectedIndex(numFS);
                mod1CRUD.txt_usuarios_rut.setEditable(false);
                /*mod1CRUD.btn_registrar.setEnabled(false);
                mod1CRUD.btn_eliminar.setEnabled(false);
                mod1CRUD.btn_listar.setEnabled(false);
                mod1CRUD.btn_editar.setEnabled(false);
                */
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila");
            }
        }
        
        if(e.getSource() == mod1CRUD.btn_usuarios_finEdicion) {
            int codUsuario = Integer.parseInt(mod1CRUD.txt_usuarios_codUser.getText());
            String rut_usuario = mod1CRUD.txt_usuarios_rut.getText();
            String login = mod1CRUD.txt_usuarios_login.getText();
            String password = mod1CRUD.pass_usuarios_pass.getText();
            String estado = mod1CRUD.txt_usuarios_estado.getText();
            String acceso = mod1CRUD.cbox_usuarios_nivelAcceso.getSelectedItem().toString();
            
            
            int rptaEdit = userCRUD.editarUsuario(codUsuario, rut_usuario, login, password, acceso);
            if(rptaEdit > 0) {
                    JOptionPane.showMessageDialog(null, "Edición exitosa");                    
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición");
                }
            LlenarTabla(mod1CRUD.table_usuarios);
            mod1CRUD.txt_usuarios_codUser.setText("");
            mod1CRUD.txt_usuarios_rut.setText("");
            mod1CRUD.txt_usuarios_login.setText("");
            mod1CRUD.txt_usuarios_estado.setText("");
            mod1CRUD.pass_usuarios_pass.setText("");
            mod1CRUD.cbox_usuarios_nivelAcceso.setSelectedIndex(0);
        }
        
        if(e.getSource() == mod1CRUD.btn_usuarios_eliminarUsuario) {
            
            int filaEditar = mod1CRUD.table_usuarios.getSelectedRow();
            int numFS = mod1CRUD.table_usuarios.getSelectedRowCount();
            
            if(filaEditar >= 0 && numFS == 1) {
                String cod = String.valueOf(mod1CRUD.table_usuarios.getValueAt(filaEditar, 1));
                int rptaDelete = userCRUD.eliminarUsuario(cod);
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila");
            }
            LlenarTabla(mod1CRUD.table_usuarios);
        }
        
        if(e.getSource() == mod1CRUD.btn_usuarios_limpiar) {
            mod1CRUD.txt_usuarios_codUser.setText("");
            mod1CRUD.txt_usuarios_rut.setText("");
            mod1CRUD.txt_usuarios_login.setText("");
            mod1CRUD.txt_usuarios_estado.setText("");
            mod1CRUD.pass_usuarios_pass.setText("");
            mod1CRUD.cbox_usuarios_nivelAcceso.setSelectedIndex(0);
        }
    }

}
