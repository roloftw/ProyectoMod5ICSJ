package Modelo;

/**
 *
 * @RolandoEscobar
 */
public class ProductoStock {

    //int cod_producto, String nombre_producto, String descripcion_producto, String unidad_producto, int precio_producto, int precio_compra, int stock_producto, String fecha_stock
    
    private int cod_producto, precio_producto, precio_compra, stock_producto;
    private String nombre_prod, descripcion_prod, unid_prod, fecha_prod;

    public ProductoStock() {
        this.cod_producto = 0;
        this.nombre_prod = "";
        this.descripcion_prod = "";
        this.unid_prod = "";
        this.precio_producto = 0;
        this.precio_compra = 0;
        this.stock_producto = 0;
        this.fecha_prod = "";        
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public int getPrecio_compra() {
        return precio_compra;
    }

    public int getStock_producto() {
        return stock_producto;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public String getDescripcion_prod() {
        return descripcion_prod;
    }

    public String getUnid_prod() {
        return unid_prod;
    }

    public String getFecha_prod() {
        return fecha_prod;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }

    public void setStock_producto(int stock_producto) {
        this.stock_producto = stock_producto;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public void setDescripcion_prod(String descripcion_prod) {
        this.descripcion_prod = descripcion_prod;
    }

    public void setUnid_prod(String unid_prod) {
        this.unid_prod = unid_prod;
    }

    public void setFecha_prod(String fecha_prod) {
        this.fecha_prod = fecha_prod;
    }    
    
}
