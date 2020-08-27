package com.undec.reserva.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Restaurante {
    private Integer id;
    private String nombre;
    private String direccion;
    private String descripcion;
    private String imagen;
    private String precio;
    private String categoria;
    private String url;
    private Collection<Reserva> reservasList;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "imagen")
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Basic
    @Column(name = "precio")
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "categoria")
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurante that = (Restaurante) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(direccion, that.direccion) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(imagen, that.imagen) &&
                Objects.equals(precio, that.precio) &&
                Objects.equals(categoria, that.categoria) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, direccion, descripcion, imagen, precio, categoria, url);
    }

    @OneToMany(mappedBy = "restaurante")
    public Collection<Reserva> getReservasList() {
        return reservasList;
    }

    public void setReservasList(Collection<Reserva> reservasList) {
        this.reservasList = reservasList;
    }
}
