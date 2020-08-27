package com.undec.reserva.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Reserva {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String fecha;
    private String hora;
    private Restaurante restaurante;

    @Id
    @Column(name = "id")
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
    @Column(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "fecha")
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "hora")
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id) &&
                Objects.equals(nombre, reserva.nombre) &&
                Objects.equals(apellido, reserva.apellido) &&
                Objects.equals(dni, reserva.dni) &&
                Objects.equals(email, reserva.email) &&
                Objects.equals(fecha, reserva.fecha) &&
                Objects.equals(hora, reserva.hora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, dni, email, fecha, hora);
    }

    @ManyToOne
    @JoinColumn(name = "restaurante_id", referencedColumnName = "id", nullable = false)
    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
