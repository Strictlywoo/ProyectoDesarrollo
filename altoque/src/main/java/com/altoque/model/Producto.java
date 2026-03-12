package com.altoque.model;

public class Producto {

    private Long id;
    private String nombre;
    private String descripcion;
    private int precio;
    private String imagen;

    public Producto(Long id, String nombre, String descripcion, int precio, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public String getImagen() {
        return imagen;
    }

}