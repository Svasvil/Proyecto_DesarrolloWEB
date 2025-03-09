package Proyecto.Proyecto.controller;

import Proyecto.Proyecto.domain.Reservas;
import Proyecto.Proyecto.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/hotel")
public class ReservasController {
    
    @Autowired
    private ReservasService reservasService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var reservas = reservasService.getReservas(false);
        model.addAttribute("reservas", reservas);
        model.addAttribute("totalReservas", reservas.size());
        return "/reserva/listado";
    }
    
}
