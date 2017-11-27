package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Modulo1;
import Modelo.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @RolandoEscobar
 */
public class Modulo1_Controlador implements ActionListener {

    Modulo1 mod1CRUD = new Modulo1();
    UsuarioDAO userCRUD = new UsuarioDAO();
    ProductoDAO productCRUD = new ProductoDAO();
    ClienteDAO clientCRUD = new ClienteDAO();
    CategoriaDAO catCRUD = new CategoriaDAO();
    ProductoStockDAO prodstockCRUD = new ProductoStockDAO();
    
    // Create an instance of SimpleDateFormat used for formatting 
    // the string representation of date (year/month/day)
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

    // Get the date today using Calendar object.
    Date today = Calendar.getInstance().getTime();        
    // Using DateFormat format method we can create a string 
    // representation of a date with the defined format.
    String reportDate = df.format(today);
    
    public Modulo1_Controlador(Modulo1 vistaC, UsuarioDAO userC, ProductoDAO prodC, ClienteDAO clientC, CategoriaDAO catC, ProductoStockDAO prodSC) {
        this.mod1CRUD = vistaC;
        this.userCRUD = userC;
        this.productCRUD = prodC;
        this.clientCRUD = clientC;
        this.catCRUD = catC;
        this.prodstockCRUD = prodSC;
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
        this.mod1CRUD.btn_stock_editStock.addActionListener(this);
        this.mod1CRUD.btn_stock_finCambio.addActionListener(this);
    }
    
    public void limpiarCamposUsuario() {
        mod1CRUD.txt_usuarios_codUser.setText("");
        mod1CRUD.txt_usuarios_rut.setText("");
        mod1CRUD.txt_usuarios_login.setText("");
        mod1CRUD.pass_usuarios_pass.setText("");
        mod1CRUD.cbox_usuarios_nivelAcceso.setSelectedIndex(0);
    }
    
    public void limpiarCamposProducto() {
        mod1CRUD.txt_productos_codCategoria.setText("");
        mod1CRUD.txt_productos_codProducto.setText("");
        mod1CRUD.txt_productos_descProducto.setText("");
        mod1CRUD.txt_productos_nombreProducto.setText("");
        mod1CRUD.txt_productos_precioCompra.setText("");
        mod1CRUD.txt_productos_precioProducto.setText("");
        mod1CRUD.txt_productos_stock.setText("");
        mod1CRUD.txt_productos_ubicacionBodega.setText("");
        mod1CRUD.txt_productos_unidadProducto.setText("");
    }
    
    public void limpiarCamposCliente() {
        mod1CRUD.txt_clientes_codUser1.setText("");
        mod1CRUD.txt_clientes_rut.setText("");
    }
    
    public void limpiarCamposCategoria() {
        mod1CRUD.txt_categorias_codCategoria.setText("");
        mod1CRUD.txt_categorias_nombreCategoria.setText("");
        mod1CRUD.txt_categorias_descCategoria.setText("");
        mod1CRUD.txt_categorias_grupo.setText("");
    }
    
    public void LlenarTablaUsuarios(JTable tablaD) {
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
    
    public void LlenarTablaProductos(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
            /*int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, 
            int precio_producto, int precio_compra, int stock_producto, String ubicacion_bodega, int cod_categoria*/
        modeloT.addColumn("Cód Producto");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Descripción");
        modeloT.addColumn("Unidad");
        modeloT.addColumn("Precio");
        modeloT.addColumn("Precio Compra");
        modeloT.addColumn("Stock");
        modeloT.addColumn("Ubicación Bodega");
        modeloT.addColumn("Cód Categoría");
        
        Object[] columna = new Object[9];
        
        int numRegistros = productCRUD.ListProducto().size();
        
        for(int i = 0; i < numRegistros; i++) {
            columna[0] = productCRUD.ListProducto().get(i).getCod_producto();
            columna[1] = productCRUD.ListProducto().get(i).getNombre_producto();
            columna[2] = productCRUD.ListProducto().get(i).getDescripcion_producto();
            columna[3] = productCRUD.ListProducto().get(i).getUnidad_producto();
            columna[4] = productCRUD.ListProducto().get(i).getPrecio_producto();
            columna[5] = productCRUD.ListProducto().get(i).getPrecio_compra();
            columna[6] = productCRUD.ListProducto().get(i).getStock_producto();
            columna[7] = productCRUD.ListProducto().get(i).getUbicacion_bodega();
            columna[8] = productCRUD.ListProducto().get(i).getCod_categoriaFK();
            
            modeloT.addRow(columna);
        }
    }
    
    public void LlenarTablaProductoStock(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
            /*int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, 
            int precio_producto, int precio_compra, int stock_producto, String ubicacion_bodega, int cod_categoria*/
        modeloT.addColumn("Cód Producto");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Descripción");
        modeloT.addColumn("Unidad");
        modeloT.addColumn("Precio");
        modeloT.addColumn("Precio Compra");
        modeloT.addColumn("Stock");
        modeloT.addColumn("Fecha Stock");
        
        Object[] columna = new Object[8];
        
        int numRegistros = prodstockCRUD.ListProductoStock().size();
        
        for(int i = 0; i < numRegistros; i++) {
            columna[0] = prodstockCRUD.ListProductoStock().get(i).getCod_producto();
            columna[1] = prodstockCRUD.ListProductoStock().get(i).getNombre_prod();
            columna[2] = prodstockCRUD.ListProductoStock().get(i).getDescripcion_prod();
            columna[3] = prodstockCRUD.ListProductoStock().get(i).getUnid_prod();
            columna[4] = prodstockCRUD.ListProductoStock().get(i).getPrecio_producto();
            columna[5] = prodstockCRUD.ListProductoStock().get(i).getPrecio_compra();
            columna[6] = prodstockCRUD.ListProductoStock().get(i).getStock_producto();
            columna[7] = prodstockCRUD.ListProductoStock().get(i).getFecha_prod();
            
            modeloT.addRow(columna);
        }
    }
    
    public void LlenarTablaClientes(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        //int cod_cliente, String rut
        modeloT.addColumn("Cód Cliente");
        modeloT.addColumn("RUT");
        
        Object[] columna = new Object[2];
        
        int numRegistros = clientCRUD.ListCliente().size();
        
        for(int i = 0; i < numRegistros; i++) {
            columna[0] = clientCRUD.ListCliente().get(i).getCod_cliente();
            columna[1] = clientCRUD.ListCliente().get(i).getRut_cliente();
            
            modeloT.addRow(columna);
        }
    }
    
    public void LlenarTablaCategorias(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        //int cod_categoria, String nombre, String descripcion, int grupo, int borrado
        modeloT.addColumn("Cód Categoría");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Descripción");
        modeloT.addColumn("Grupo");
        modeloT.addColumn("Nivel borrado");
        
        Object[] columna = new Object[5];
        
        int numRegistros = catCRUD.ListCategoria().size();
        
        for(int i = 0; i < numRegistros; i++) {
            columna[0] = catCRUD.ListCategoria().get(i).getCod_categoria();
            columna[1] = catCRUD.ListCategoria().get(i).getNombre();
            columna[2] = catCRUD.ListCategoria().get(i).getDescripcion();
            columna[3] = catCRUD.ListCategoria().get(i).getGrupo();
            columna[4] = catCRUD.ListCategoria().get(i).getBorrado();
            
            modeloT.addRow(columna);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mod1CRUD.btn_usuarios_crearNuevoUsuario) {
            String rut_usuario = mod1CRUD.txt_usuarios_rut.getText();
            String login = mod1CRUD.txt_usuarios_login.getText();
            String password = mod1CRUD.pass_usuarios_pass.getText();
            String acceso = mod1CRUD.cbox_usuarios_nivelAcceso.getSelectedItem().toString();
            
            String rptaRegistro = userCRUD.InsertUsuario(rut_usuario, login, password, acceso);
            
            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erróneo");
            }
            LlenarTablaUsuarios(mod1CRUD.table_usuarios);
            limpiarCamposUsuario();
        }
        
        if(e.getSource() == mod1CRUD.btn_usuarios_listarUsuarios) {
            LlenarTablaUsuarios(mod1CRUD.table_usuarios);
        }
        
        if(e.getSource() == mod1CRUD.btn_usuarios_editarRegistro) {
            int filaEditar = mod1CRUD.table_usuarios.getSelectedRow();
            int numFS = mod1CRUD.table_usuarios.getSelectedRowCount();
            
            if(filaEditar >= 0 && numFS == 1) {
                //mod1CRUD.txt_usuarios_codUser.setText(String.valueOf(mod1CRUD.table_usuarios.getValueAt(filaEditar, 0)));
                mod1CRUD.txt_usuarios_rut.setText(String.valueOf(mod1CRUD.table_usuarios.getValueAt(filaEditar, 1)));
                mod1CRUD.txt_usuarios_login.setText(String.valueOf(mod1CRUD.table_usuarios.getValueAt(filaEditar, 2)));
                //mod1CRUD.txt_usuarios_estado.setText(String.valueOf(mod1CRUD.table_usuarios.getValueAt(filaEditar, 5)));
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
            String rut_usuario = mod1CRUD.txt_usuarios_rut.getText();
            String login = mod1CRUD.txt_usuarios_login.getText();
            String password = mod1CRUD.pass_usuarios_pass.getText();
            String acceso = mod1CRUD.cbox_usuarios_nivelAcceso.getSelectedItem().toString();
            
            
            int rptaEdit = userCRUD.editarUsuario(rut_usuario, login, password, acceso);
            if(rptaEdit > 0) {
                    JOptionPane.showMessageDialog(null, "Edición exitosa");                    
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición");
                }
            mod1CRUD.txt_usuarios_rut.setEditable(true);
            LlenarTablaUsuarios(mod1CRUD.table_usuarios);
            limpiarCamposUsuario();
        }
        
        if(e.getSource() == mod1CRUD.btn_usuarios_eliminarUsuario) {
            
            int filaEditar = mod1CRUD.table_usuarios.getSelectedRow();
            int numFS = mod1CRUD.table_usuarios.getSelectedRowCount();
            
            if(filaEditar >= 0 && numFS == 1) {
                String login = String.valueOf(mod1CRUD.table_usuarios.getValueAt(filaEditar, 2));
                int rptaDelete = userCRUD.eliminarUsuario(login);
                if(rptaDelete > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente (marcado como Inactivo)");
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el registro");
            }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila");
            }
            
            LlenarTablaUsuarios(mod1CRUD.table_usuarios);
            limpiarCamposUsuario();
        }
        
        if(e.getSource() == mod1CRUD.btn_usuarios_limpiar) {
            limpiarCamposUsuario();
        }
        
        if(e.getSource() == mod1CRUD.btn_productos_aniadirProducto) {
            /*int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, 
            int precio_producto, int precio_compra, int stock_producto, String ubicacion_bodega, int cod_categoria*/
            String cod_prod = mod1CRUD.txt_productos_codProducto.getText();
            int codP = Integer.parseInt(cod_prod);
            String nombre_producto = mod1CRUD.txt_productos_nombreProducto.getText();
            String desc_producto = mod1CRUD.txt_productos_descProducto.getText();
            String unid_producto = mod1CRUD.txt_productos_unidadProducto.getText();
            String precio_producto = mod1CRUD.txt_productos_precioProducto.getText();
            int precioP = Integer.parseInt(precio_producto);
            String precio_compra = mod1CRUD.txt_productos_precioCompra.getText();
            int precioC = Integer.parseInt(precio_compra);
            String stock_producto = mod1CRUD.txt_productos_stock.getText();
            int stockP = Integer.parseInt(stock_producto);
            String ubicacion_bodega = mod1CRUD.txt_productos_ubicacionBodega.getText();
            String cod_categoria = mod1CRUD.txt_productos_codCategoria.getText();
            int codC = Integer.parseInt(cod_categoria);
            
            String rptaRegPS = prodstockCRUD.InsertProductoStock(codP, nombre_producto, desc_producto, unid_producto, precioP, precioC, stockP, reportDate);
            String rptaRegP = productCRUD.InsertProducto(codP, nombre_producto, desc_producto, unid_producto, precioP, precioC, stockP, ubicacion_bodega, codC);
            if (rptaRegP != null && rptaRegPS != null) {
                JOptionPane.showMessageDialog(null, rptaRegP);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erróneo");
            }
            LlenarTablaProductos(mod1CRUD.table_productos);
            limpiarCamposProducto();            
        }
        
        if(e.getSource() == mod1CRUD.btn_productos_editarRegistro) {
            int filaEditar = mod1CRUD.table_productos.getSelectedRow();
            int numFS = mod1CRUD.table_productos.getSelectedRowCount();
            
            /*int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, 
            int precio_producto, int precio_compra, int stock_producto, String ubicacion_bodega, int cod_categoria*/
            if(filaEditar >= 0 && numFS == 1) {
                mod1CRUD.txt_productos_codProducto.setText(String.valueOf(mod1CRUD.table_productos.getValueAt(filaEditar, 0)));
                mod1CRUD.txt_productos_nombreProducto.setText(String.valueOf(mod1CRUD.table_productos.getValueAt(filaEditar, 1)));
                mod1CRUD.txt_productos_descProducto.setText(String.valueOf(mod1CRUD.table_productos.getValueAt(filaEditar, 2)));
                mod1CRUD.txt_productos_unidadProducto.setText(String.valueOf(mod1CRUD.table_productos.getValueAt(filaEditar, 3)));
                mod1CRUD.txt_productos_precioProducto.setText(String.valueOf(mod1CRUD.table_productos.getValueAt(filaEditar, 4)));
                mod1CRUD.txt_productos_precioCompra.setText(String.valueOf(mod1CRUD.table_productos.getValueAt(filaEditar, 5)));
                mod1CRUD.txt_productos_stock.setText(String.valueOf(mod1CRUD.table_productos.getValueAt(filaEditar, 6)));
                mod1CRUD.txt_productos_ubicacionBodega.setText(String.valueOf(mod1CRUD.table_productos.getValueAt(filaEditar, 7)));
                mod1CRUD.txt_productos_codCategoria.setText(String.valueOf(mod1CRUD.table_productos.getValueAt(filaEditar, 8)));
                mod1CRUD.txt_productos_codProducto.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila");
            }
        }
        
        if(e.getSource() == mod1CRUD.btn_productos_finEdicion) {
            /*int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, 
            int precio_producto, int precio_compra, int stock_producto, String ubicacion_bodega, int cod_categoria*/
            String cod_prod = mod1CRUD.txt_productos_codProducto.getText();
            int codP = Integer.parseInt(cod_prod);
            String nombre_producto = mod1CRUD.txt_productos_nombreProducto.getText();
            String desc_producto = mod1CRUD.txt_productos_descProducto.getText();
            String unid_producto = mod1CRUD.txt_productos_unidadProducto.getText();
            String precio_producto = mod1CRUD.txt_productos_precioProducto.getText();
            int precioP = Integer.parseInt(precio_producto);
            String precio_compra = mod1CRUD.txt_productos_precioCompra.getText();
            int precioC = Integer.parseInt(precio_compra);
            String stock_producto = mod1CRUD.txt_productos_stock.getText();
            int stockP = Integer.parseInt(stock_producto);
            String ubicacion_bodega = mod1CRUD.txt_productos_ubicacionBodega.getText();
            String cod_categoria = mod1CRUD.txt_productos_codCategoria.getText();
            int codC = Integer.parseInt(cod_categoria);
            
            int rptaEditPS = prodstockCRUD.editarProductoStock(codP, nombre_producto, desc_producto, unid_producto, precioP, precioC, stockP, reportDate);
            int rptaEditP = productCRUD.editarProducto(codP, nombre_producto, desc_producto, unid_producto, precioP, precioC, stockP, ubicacion_bodega, codC);
            if(rptaEditP > 0 && rptaEditPS > 0) {
                    JOptionPane.showMessageDialog(null, "Edición exitosa");                    
            } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición");
            }
            mod1CRUD.txt_productos_codProducto.setEditable(true);
            LlenarTablaProductos(mod1CRUD.table_productos);
            limpiarCamposProducto();
        }
        
        if(e.getSource() == mod1CRUD.btn_productos_eliminarProducto) {
            int filaEditar = mod1CRUD.table_productos.getSelectedRow();
            int numFS = mod1CRUD.table_productos.getSelectedRowCount();
            
            if(filaEditar >= 0 && numFS == 1) {
                String cod = String.valueOf(mod1CRUD.table_productos.getValueAt(filaEditar, 0));
                int codP = Integer.parseInt(cod);
                int rptaDelete = productCRUD.eliminarProducto(codP);
                int rptaDeletePS = prodstockCRUD.eliminarProductoStock(codP);
                if(rptaDelete > 0 && rptaDeletePS > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el registro");
            }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila");
            }
            
            LlenarTablaProductos(mod1CRUD.table_productos);
            limpiarCamposProducto();
        }
        
        if(e.getSource() == mod1CRUD.btn_productos_limpiar) {
            limpiarCamposProducto();
        }
        
        if(e.getSource() == mod1CRUD.btn_productos_listarProductos) {
            LlenarTablaProductos(mod1CRUD.table_productos);
        }
        
        if(e.getSource() == mod1CRUD.btn_clientes_aniadirNuevoCliente) {
            //int cod_cliente, String rut
            String cod_cli = mod1CRUD.txt_clientes_codUser1.getText();
            int codC = Integer.parseInt(cod_cli);
            String rut = mod1CRUD.txt_clientes_rut.getText();
            
            String rptaRegC = clientCRUD.insertarCliente(codC, rut);
            if (rptaRegC != null) {
                JOptionPane.showMessageDialog(null, rptaRegC);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erróneo");
            }
            LlenarTablaClientes(mod1CRUD.table_clientes);
            limpiarCamposCliente();            
        }
        
        if(e.getSource() == mod1CRUD.btn_clientes_editarRegistro) {
            
        int filaEditar = mod1CRUD.table_clientes.getSelectedRow();
        int numFS = mod1CRUD.table_clientes.getSelectedRowCount();
            
        //int cod_cliente, String rut
        if(filaEditar >= 0 && numFS == 1) {
            mod1CRUD.txt_clientes_codUser1.setText(String.valueOf(mod1CRUD.table_clientes.getValueAt(filaEditar, 0)));
            mod1CRUD.txt_clientes_rut.setText(String.valueOf(mod1CRUD.table_clientes.getValueAt(filaEditar, 1)));
            mod1CRUD.txt_clientes_rut.setEditable(false);
        } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila");
        }
        }
        
        if(e.getSource() == mod1CRUD.btn_clientes_finEdicion) {
            String cod_cli = mod1CRUD.txt_clientes_codUser1.getText();
            int codC = Integer.parseInt(cod_cli);
            String rut = mod1CRUD.txt_clientes_rut.getText();
            
            
            int rptaEdit = clientCRUD.editarCliente(codC, rut);
            if(rptaEdit > 0) {
                    JOptionPane.showMessageDialog(null, "Edición exitosa");                    
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición");
                }
            mod1CRUD.txt_clientes_rut.setEditable(true);
            LlenarTablaClientes(mod1CRUD.table_clientes);
            limpiarCamposCliente();
        }
        
        if(e.getSource() == mod1CRUD.btn_clientes_eliminarCliente) {
            
            int filaEditar = mod1CRUD.table_clientes.getSelectedRow();
            int numFS = mod1CRUD.table_clientes.getSelectedRowCount();
            
            if(filaEditar >= 0 && numFS == 1) {
                String cod_cliente = String.valueOf(mod1CRUD.table_clientes.getValueAt(filaEditar, 0));
                int codC = Integer.parseInt(cod_cliente);
                int rptaDelete = clientCRUD.eliminarCliente(codC);
                if(rptaDelete > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el registro");
            }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila");
            }
            
            LlenarTablaClientes(mod1CRUD.table_clientes);  
            limpiarCamposCliente();
        }
        
        if(e.getSource() == mod1CRUD.btn_clientes_limpiar) {
            limpiarCamposCliente();
        }
        
        if(e.getSource() == mod1CRUD.btn_clientes_listarClientes) {
            LlenarTablaClientes(mod1CRUD.table_clientes);
        }
        
        if(e.getSource() == mod1CRUD.btn_categorias_aniadirCategoria) {
            //int cod_categoria, String nombre, String descripcion, int grupo
            String cod_cat = mod1CRUD.txt_categorias_codCategoria.getText();
            int codC = Integer.parseInt(cod_cat);
            String nombre = mod1CRUD.txt_categorias_nombreCategoria.getText();
            String descripcion = mod1CRUD.txt_categorias_descCategoria.getText();
            String grupo = mod1CRUD.txt_categorias_grupo.getText();
            int gru = Integer.parseInt(grupo);
            
            String rptaRegC = catCRUD.InsertCategoria(codC, nombre, descripcion, gru);
            if (rptaRegC != null) {
                JOptionPane.showMessageDialog(null, rptaRegC);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erróneo");
            }
            LlenarTablaCategorias(mod1CRUD.table_productos1);
            limpiarCamposCategoria(); 
        }
        
        if(e.getSource() == mod1CRUD.btn_categorias_editarRegistro) {
            int filaEditar = mod1CRUD.table_productos1.getSelectedRow();
            int numFS = mod1CRUD.table_productos1.getSelectedRowCount();
            
            //int cod_categoria, String nombre, String descripcion, int grupo
            if(filaEditar >= 0 && numFS == 1) {
                mod1CRUD.txt_categorias_codCategoria.setText(String.valueOf(mod1CRUD.table_productos1.getValueAt(filaEditar, 0)));
                mod1CRUD.txt_categorias_nombreCategoria.setText(String.valueOf(mod1CRUD.table_productos1.getValueAt(filaEditar, 1)));
                mod1CRUD.txt_categorias_descCategoria.setText(String.valueOf(mod1CRUD.table_productos1.getValueAt(filaEditar, 2)));
                mod1CRUD.txt_categorias_grupo.setText(String.valueOf(mod1CRUD.table_productos1.getValueAt(filaEditar, 3)));
                mod1CRUD.txt_categorias_codCategoria.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila");
            }
        }
        
        if(e.getSource() == mod1CRUD.btn_categorias_finEdicion) {
            //int cod_categoria, String nombre, String descripcion, int grupo
            String cod_cat = mod1CRUD.txt_categorias_codCategoria.getText();
            int codC = Integer.parseInt(cod_cat);
            String nombre = mod1CRUD.txt_categorias_nombreCategoria.getText();
            String descripcion = mod1CRUD.txt_categorias_descCategoria.getText();
            String grupo = mod1CRUD.txt_categorias_grupo.getText();
            int gru = Integer.parseInt(grupo);
            
            int rptaEdit = catCRUD.editarCategoria(codC, nombre, descripcion, gru);
            if(rptaEdit > 0) {
                    JOptionPane.showMessageDialog(null, "Edición exitosa");                    
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición");
                }
            LlenarTablaCategorias(mod1CRUD.table_productos1);
            limpiarCamposCategoria();
        }
        
        if(e.getSource() == mod1CRUD.btn_categorias_eliminarCategoria) {
            
            int filaEditar = mod1CRUD.table_productos1.getSelectedRow();
            int numFS = mod1CRUD.table_productos1.getSelectedRowCount();
            
            if(filaEditar >= 0 && numFS == 1) {
                String cod_cat = String.valueOf(mod1CRUD.table_productos1.getValueAt(filaEditar, 0));
                int codC = Integer.parseInt(cod_cat);
                int rptaDelete = catCRUD.eliminarCategoria(codC);
                if(rptaDelete > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el registro");
            }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila");
            }
            
            LlenarTablaCategorias(mod1CRUD.table_productos1);
            limpiarCamposCategoria();
        }
        
        if(e.getSource() == mod1CRUD.btn_categorias_limpiar) {
            limpiarCamposCategoria();
        }
        
        if(e.getSource() == mod1CRUD.btn_categorias_listarCategorias) {
            LlenarTablaCategorias(mod1CRUD.table_productos1);
        }
        
        if(e.getSource() == mod1CRUD.btn_stock_listarStock) {
            LlenarTablaProductoStock(mod1CRUD.table_stock);
        }
        
        if(e.getSource() == mod1CRUD.btn_stock_editStock) {
            int filaEditar = mod1CRUD.table_stock.getSelectedRow();
            int numFS = mod1CRUD.table_stock.getSelectedRowCount();
            
            //int stockP
            if(filaEditar >= 0 && numFS == 1) {
                mod1CRUD.lab_stock_currentStock.setText(String.valueOf(mod1CRUD.table_stock.getValueAt(filaEditar, 6)));
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila");
            }
        }
        
        if(e.getSource() == mod1CRUD.btn_stock_finCambio) {
            
            int filaEditar = mod1CRUD.table_stock.getSelectedRow();
            int numFS = mod1CRUD.table_stock.getSelectedRowCount();
            //int cod_categoria, String nombre, String descripcion, int grupo
            String cod_producto = String.valueOf(mod1CRUD.table_stock.getValueAt(filaEditar, 0));
            int codP = Integer.parseInt(cod_producto);
            String stock = mod1CRUD.txt_stock_newStock.getText();
            int newStock = Integer.parseInt(stock);
            
            int rptaEditPS = prodstockCRUD.updateStock(codP, newStock);
            int rptaEdit = productCRUD.updateProductoStock(codP, newStock);
            if(rptaEdit > 0 && rptaEditPS > 0) {
                    JOptionPane.showMessageDialog(null, "Edición exitosa");                    
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición");
                }
            LlenarTablaProductoStock(mod1CRUD.table_stock);
        }
    }

}