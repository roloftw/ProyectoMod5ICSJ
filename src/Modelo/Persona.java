package Modelo;

/**
 *
 * @RolandoEscobar
 */
public class Persona {

    private int cod_persona;
    private String nombre_persona, direccion, telefono, email, contacto, cel_contacto, correo_contacto;

    public Persona(int cod_persona, String nombre_persona, String direccion, String telefono, String email, String contacto, String cel_contacto, String correo_contacto) {
        this.cod_persona = cod_persona;
        this.nombre_persona = nombre_persona;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contacto = contacto;
        this.cel_contacto = cel_contacto;
        this.correo_contacto = correo_contacto;
    }
    
    public Persona() {
        this.cod_persona = 0;
        this.nombre_persona = "";
        this.direccion = "";
        this.telefono = "";
        this.email = "";
        this.contacto = "";
        this.cel_contacto = "";
        this.correo_contacto = "";
    }

    public int getCod_persona() {
        return cod_persona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getContacto() {
        return contacto;
    }

    public String getCel_contacto() {
        return cel_contacto;
    }

    public String getCorreo_contacto() {
        return correo_contacto;
    }

    public void setCod_persona(int cod_persona) {
        this.cod_persona = cod_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setCel_contacto(String cel_contacto) {
        this.cel_contacto = cel_contacto;
    }

    public void setCorreo_contacto(String correo_contacto) {
        this.correo_contacto = correo_contacto;
    }
    
    
}
