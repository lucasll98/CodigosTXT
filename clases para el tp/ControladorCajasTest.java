package com.tallerwebi.presentacion;
import com.tallerwebi.dominio.ServicioCaja;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;



public class ControladorCajasTest {


    @Test
    public void dadoQueSePuedeConsultarCajasCuandoLasConsultoSinHaberAgregadoObtengoUnMensajeNoHayCajas(){
    ServicioCaja servicioCaja = mock(ServicioCaja.class);
        ControladorCajas controladorCajas = new ControladorCajas(servicioCaja);

        ModelAndView model = controladorCajas.mostrarCajas();

        assertThat(model.getViewName(), equalToIgnoringCase("cajas"));

        List <CajaDto> cajasDto = (List <CajaDto>)model.getModel().get("cajas");

        assertThat(cajasDto.size(), equalTo(0));
        assertThat(model.getModel().get("error").toString(), equalToIgnoringCase("No hay cajas"));

    }



    @Test
    public void dadoQueSePuedeConsultarCajasCuandoLasConsultoObtengo3Cajas(){

        ServicioCaja servicioCaja = mock(ServicioCaja.class);

        ControladorCajas controladorCajas = new ControladorCajas(servicioCaja);
        List<CajaDto> cajasDto = new ArrayList<>();
        cajasDto.add(new CajaDto());
        cajasDto.add(new CajaDto());
        cajasDto.add(new CajaDto());
        when( servicioCaja.obtener()).thenReturn(cajasDto);

        ModelAndView model = controladorCajas.mostrarCajas();

        assertThat(model.getViewName(), equalToIgnoringCase("cajas"));

        List <CajaDto> cajasObtenidas = (List <CajaDto>)model.getModel().get("cajas");

        assertThat(cajasObtenidas.size(), equalTo(3));

    }

}
