/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rolando
 */
public class Categoria {
    
    private int cod_categoria, grupo, borrado;
    private String nombre, descripcion;

    public Categoria(int cod_categoria, String nombre, String descripcion, int grupo, int borrado) {
        this.cod_categoria = cod_categoria;
        this.grupo = grupo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.borrado = borrado;
    }

    public Categoria() {
        this.cod_categoria = 0;
        this.grupo = 0;
        this.nombre = "";
        this.descripcion = "";
        this.borrado = 0;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public int getGrupo() {
        return grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getBorrado() {
        return borrado;
    }

    public void setBorrado(int borrado) {
        this.borrado = borrado;
    }
    
    
}
    
