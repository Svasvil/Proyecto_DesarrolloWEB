package Proyecto.Proyecto.dao;

import Proyecto.Proyecto.domain.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservasDao extends JpaRepository<Reservas, Long> {
    
}
