package Proyecto.Proyecto.service.impl;

import Portafolio.Portafolio.dao.ReservaDao;
import Portafolio.Portafolio.domain.Reserva;
import Portafolio.Portafolio.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaServiceImpl implements ReservaService {
    
    @Autowired
    private ReservaDao reservaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Reserva> getReservas(boolean activas) {
        var lista = reservaDao.findAll();
        if (activas) {
           lista.removeIf(e -> !e.isActiva());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Reserva getReserva(Reserva reserva) {
        return reservaDao.findById(reserva.getIdReserva()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Reserva reserva) {
        reservaDao.save(reserva);
    }
    
    @Override
    @Transactional
    public void delete(Reserva reserva) {
        reservaDao.delete(reserva);
    }
    
    // Métodos adicionales que podrían ser útiles
    
    @Override
    @Transactional(readOnly = true)
    public List<Reserva> getReservasByUsuario(Long idUsuario) {
        return reservaDao.findByIdUsuario(idUsuario);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Reserva> getReservasByHabitacion(Long idHabitacion) {
        return reservaDao.findByIdHabitacion(idHabitacion);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Reserva> getReservasByCategoria(String categoriaHabitacion) {
        return reservaDao.findByCategoriaHabitacion(categoriaHabitacion);
    }
}