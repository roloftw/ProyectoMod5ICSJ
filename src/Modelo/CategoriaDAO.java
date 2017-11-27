/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rolando
 */
public class CategoriaDAO {
    
    Conexion conexion;

    public CategoriaDAO() {
        conexion = new Conexion();
    }
    
    public String InsertCategoria(int cod_categoria, String nombre, String descripcion, int grupo) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            //llamar a la rutina creada en phpMyAdmin
            CallableStatement cs = accesoDB.prepareCall("{call insertar_categoria(?,?,?,?)}");
            cs.setInt(1, cod_categoria);            
            cs.setString(2, nombre);
            cs.setString(3, descripcion);
            cs.setInt(4, grupo);           
        
        int numFAfectadas = cs.executeUpdate();
        if(numFAfectadas > 0) {
            rptaRegistro = "Registro exitoso";
        }
        } catch (SQLException e) {
        
        }
        return rptaRegistro;
    }
    
    public ArrayList<Categoria> ListCategoria() {
        ArrayList listaCategoria = new ArrayList();
        Categoria category;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("SELECT * FROM `categoria`");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                category = new Categoria();
                category.setCod_categoria(rs.getInt(1));
                category.setNombre(rs.getString(2));
                category.setDescripcion(rs.getString(3));
                category.setGrupo(rs.getInt(4));
                category.setBorrado(rs.getInt(5));
                listaCategoria.add(category);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaCategoria;
    }
    
    public int editarCategoria(int cod_categoria, String nombre, String descripcion, int grupo) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call editar_categoria(?,?,?,?)}");
            cs.setInt(1, cod_categoria);            
            cs.setString(2, nombre);
            cs.setString(3, descripcion);
            cs.setInt(4, grupo); 
        
            numFA = cs.executeUpdate();            
        } catch (SQLException e) {
            
        }
        return numFA;
    }
    
    public int eliminarCategoria(int cod_categoria) {
        int numFA = 0;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call elimina_categoria(?)}");
            cs.setInt(1, cod_categoria);
            
            numFA = cs.executeUpdate();
        } catch (SQLException e) {
            
        }
        return numFA;
    }
}
