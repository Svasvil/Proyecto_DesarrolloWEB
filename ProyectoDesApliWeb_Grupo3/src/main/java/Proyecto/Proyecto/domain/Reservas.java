package Proyecto.Proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas")

public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Integer idReserva;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Column(name = "idHabitacion")
    private Integer idHabitacion;
    private boolean activa;
    private String fecha;
    @Enumerated(EnumType.STRING)
    @Column(name = "categoriaHabitacion")
    private CategoriaHabitacion categoriaHabitacion;

    public enum CategoriaHabitacion {
        Suite, Estandar, Premium
    }

    public Reservas() {
    }

    public Reservas(Integer idUsuario, Integer idHabitacion, boolean activa, String fecha, CategoriaHabitacion categoriaHabitacion) {
        this.idUsuario = idUsuario;
        this.idHabitacion = idHabitacion;
        this.activa = activa;
        this.fecha = fecha;
        this.categoriaHabitacion = categoriaHabitacion;
    }
}