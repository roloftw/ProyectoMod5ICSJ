package Modelo;

/**
 *
 * @RolandoEscobar
 */
public class Producto {

    public int cod_producto, precio_producto, precio_compra, stock_producto, cod_categoriaFK;
    public String nombre_producto, descripcion_producto, unidad_producto, ubicacion_bodega;
    
    public Producto() {
        this.cod_producto = 0;
        this.precio_producto = 0;
        this.precio_compra = 0;
        this.stock_producto = 0;
        this.cod_categoriaFK = 0;
        this.nombre_producto = "";
        this.descripcion_producto = "";
        this.unidad_producto = "";
        this.ubicacion_bodega = "";
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

    public int getCod_categoriaFK() {
        return cod_categoriaFK;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public String getUnidad_producto() {
        return unidad_producto;
    }

    public String getUbicacion_bodega() {
        return ubicacion_bodega;
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

    public void setCod_categoriaFK(int cod_categoriaFK) {
        this.cod_categoriaFK = cod_categoriaFK;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public void setUnidad_producto(String unidad_producto) {
        this.unidad_producto = unidad_producto;
    }

    public void setUbicacion_bodega(String ubicacion_bodega) {
        this.ubicacion_bodega = ubicacion_bodega;
    }
    
    
}
