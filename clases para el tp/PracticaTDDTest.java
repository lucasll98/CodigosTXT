package com.tallerwebi;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

import org.junit.jupiter.api.Test;

import com.tallerwebi.TDD.Contrasenia;
import com.tallerwebi.TDD.Temperatura;


public class PracticaTDDTest {

   @Test
	public void dadoQueExisteUnaContraseniaQuePuedaSerInvalida() {
	
		Contrasenia contrasenia = new Contrasenia("abc");
		
		String contraseniaResultado = contrasenia.validarFortaleza(contrasenia.getPassword());
		
		assertThat( contraseniaResultado, equalToIgnoringCase("INVALIDA"));
		
	}
	
	@Test
	public void dadoQueExisteUnaContraseniaQuePuedaSerDebil() {
	
		Contrasenia contrasenia = new Contrasenia("abcdefgh");
		
		String contraseniaResultado = contrasenia.validarFortaleza(contrasenia.getPassword());
		
		assertThat( contraseniaResultado, equalToIgnoringCase("DEBIL"));
		
	}
	
	@Test
	public void dadoQueExisteUnaContraseniaQuePuedaSerMediana() {
	
		Contrasenia contrasenia = new Contrasenia("abc@");
		
		String contraseniaResultado = contrasenia.validarFortaleza(contrasenia.getPassword());
		
		assertThat(contraseniaResultado , equalToIgnoringCase("MEDIANA") );
		
	}
	
	@Test
	public void dadoQueExisteUnaContraseniaQuePuedaSerFuerte() {
	
		Contrasenia contrasenia = new Contrasenia("1234@abc");
		
		String contraseniaResultado = contrasenia.validarFortaleza(contrasenia.getPassword());
		
		assertThat( contraseniaResultado, equalToIgnoringCase("FUERTE"));
		
	}


	@Test
	public void dadoQueExisteUnaTemperaturaQuePuedaSerCongelante() {
	
		Temperatura temperatura = new Temperatura(-3);
		
		String temperaturaResultado = temperatura.clasificarTemperatura(temperatura.getGrados());
		
		assertThat(temperaturaResultado, equalToIgnoringCase("CONGELANTE")  );
		
	}
	
	@Test
	public void dadoQueExisteUnaTemperaturaQuePuedaSerFria() {
	
		Temperatura temperatura = new Temperatura(10);
		
		String temperaturaResultado = temperatura.clasificarTemperatura(temperatura.getGrados());
		
		assertThat(temperaturaResultado, equalToIgnoringCase("FRIA")  );

		
	}
	
	@Test
	public void dadoQueExisteUnaTemperaturaQuePuedaSerTemplada() {
	
		Temperatura temperatura = new Temperatura(23);
		
		String temperaturaResultado = temperatura.clasificarTemperatura(temperatura.getGrados());
		
		assertThat(temperaturaResultado, equalToIgnoringCase("TEMPLADA")  );
		
	}
	
	@Test
	public void dadoQueExisteUnaTemperaturaQuePuedaSerCalurosa() {
	
		Temperatura temperatura = new Temperatura(30);
		
		String temperaturaResultado = temperatura.clasificarTemperatura(temperatura.getGrados());
		
		assertThat(temperaturaResultado, equalToIgnoringCase("CALUROSA")  );
		
	}
	
	@Test
	public void dadoQueExisteUnaTemperaturaQuePuedaSerPeligrosa() {
	
		Temperatura temperatura = new Temperatura(42);
		
		String temperaturaResultado = temperatura.clasificarTemperatura(temperatura.getGrados());
		
		assertThat(temperaturaResultado, equalToIgnoringCase("PELIGROSA")  );
		
	}

}
