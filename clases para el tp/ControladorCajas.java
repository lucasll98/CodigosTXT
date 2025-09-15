package com.tallerwebi.presentacion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tallerwebi.dominio.ServicioCaja;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;



@Controller
@RequestMapping("/cajas")
public class ControladorCajas {

    private List<CajaDto> cajas;
    @Autowired
    private ServicioCaja servicioCaja;
    

    public ControladorCajas(ServicioCaja servicioCaja) {
        this.cajas = new ArrayList<>();
        this.servicioCaja = servicioCaja;
    }
   // @RequestMapping(path = "/" , method = RequestMethod.POST)
    public  ModelAndView mostrarCajas() {
        ModelMap model = new ModelMap();
        model.put("cajas", this.servicioCaja.obtener());
        model.put("error", "No hay cajas");
        return new ModelAndView("cajas", model);
        
    }

}
