package Modelo;
import java.sql.*;
/**
 *
 * @RolandoEscobar
 */
public class Conexion {

    public Conexion() {
        
    }
    
    public Connection getConexion(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas","root","rolando");
            System.out.println("Se ha establecido la conexion");
        } catch (Exception e) {
            System.out.println(" La conexion ha fallado");
        }
        
        return con;
    }
  
}