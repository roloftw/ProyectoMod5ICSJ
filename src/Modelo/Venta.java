package Modelo;

/**
 *
 * @RolandoEscobar
 */
public class Venta {

    public int cod_venta, cod_productoFK, total_venta, cod_usuarioFK, cod_clienteFK, num_factura, pago, descuento;
    public String fecha_venta, tipo_comprobante;
    
    public Venta() {
        this.cod_venta = 0;
        this.total_venta = 0;
        this.cod_usuarioFK = 0;
        this.cod_clienteFK = 0;
        this.num_factura = 0;
        this.pago = 0;
        this.descuento = 0;
        this.fecha_venta = "";
        this.tipo_comprobante = "";
    }

    public int getCod_venta() {
        return cod_venta;
    }

    public int getTotal_venta() {
        return total_venta;
    }

    public int getCod_usuarioFK() {
        return cod_usuarioFK;
    }

    public int getCod_clienteFK() {
        return cod_clienteFK;
    }

    public int getNum_factura() {
        return num_factura;
    }

    public int getPago() {
        return pago;
    }

    public int getDescuento() {
        return descuento;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public String getTipo_comprobante() {
        return tipo_comprobante;
    }

    public void setCod_venta(int cod_venta) {
        this.cod_venta = cod_venta;
    }

    public void setTotal_venta(int total_venta) {
        this.total_venta = total_venta;
    }

    public void setCod_usuarioFK(int cod_usuarioFK) {
        this.cod_usuarioFK = cod_usuarioFK;
    }

    public void setCod_clienteFK(int cod_clienteFK) {
        this.cod_clienteFK = cod_clienteFK;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }
    
    
}
