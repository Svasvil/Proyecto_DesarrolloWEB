package Proyecto.Proyecto.service;

import Proyecto.Proyecto.domain.Reservas;
import java.util.List;

public interface ReservasService {
    public List<Reservas> getReservas(boolean activa);
}
