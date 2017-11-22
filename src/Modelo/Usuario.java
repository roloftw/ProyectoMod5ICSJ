package Modelo;

/**
 *
 * @RolandoEscobar
 */
public class Usuario {

    public int cod_usuario;
    public String rut_usuario, login, password, estado, acceso;

    public Usuario() {
        this.cod_usuario = 0;
        this.rut_usuario = "";
        this.login = "";
        this.password = "";
        this.estado = "";
        this.acceso = "";
    }

    
    
    public int getCod_usuario() {
        return cod_usuario;
    }

    public String getRut_usuario() {
        return rut_usuario;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEstado() {
        return estado;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public void setRut_usuario(String rut_usuario) {
        this.rut_usuario = rut_usuario;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }
    
    
}
