package Modelo;

/**
 *
 * @RolandoEscobar
 */
public class Cliente {

    public int cod_cliente;
    public String rut_cliente;
    
    public Cliente() {
        this.cod_cliente = 0;
        this.rut_cliente = "";
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public String getRut_cliente() {
        return rut_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public void setRut_cliente(String rut_cliente) {
        this.rut_cliente = rut_cliente;
    }
    
    
}
