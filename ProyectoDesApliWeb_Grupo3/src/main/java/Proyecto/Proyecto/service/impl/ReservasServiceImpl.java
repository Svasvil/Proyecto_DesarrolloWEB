package Proyecto.Proyecto.service.impl;

import Proyecto.Proyecto.dao.ReservasDao;
import Proyecto.Proyecto.domain.Reservas;
import Proyecto.Proyecto.service.ReservasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservasServiceImpl implements ReservasService {
    
    @Autowired
    private ReservasDao reservaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Reservas> getReservas(boolean activa) {
        var lista = reservaDao.findAll();
        if (activa) {
           lista.removeIf(e -> !e.isActiva());
        }
        return lista;
    }
    
    
}