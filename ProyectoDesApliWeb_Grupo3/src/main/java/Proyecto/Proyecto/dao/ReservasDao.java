package Proyecto.Proyecto.dao;

import EjercPractico1.EjercPractico1.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDao extends JpaRepository<Reserva, Long> {
    
}
