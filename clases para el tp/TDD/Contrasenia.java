package com.tallerwebi.TDD;

import java.util.regex.Pattern;

public class Contrasenia{


    private String password;

	public Contrasenia(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String validarFortaleza(String contra) {
		
		if(contra.length()>= 8 && tieneCaracterEspecial(contra) && tieneCuatroNumeros(contra)) {
			return "FUERTE";
		}
		
		if(contra.length()>=4 && tieneCaracterEspecial(contra)) {
			return "MEDIANA";
		}
		if(contra.length() < 8 && !tieneCaracterEspecial(contra)) {
			return "INVALIDA";
		}
		
		if(contra.length() >= 8 && !tieneCaracterEspecial(contra)) {
			return "DEBIL";
		}
		
		
		return null;
	}
	
	
	public boolean tieneCuatroNumeros(String contra) {
        String regex = ".*\\d.*\\d.*\\d.*\\d.*";
        
        return Pattern.matches(regex, contra);
    }
	
	public boolean tieneCaracterEspecial(String contra) {
        String regex = ".*[^a-zA-Z0-9].*";
        
        return Pattern.matches(regex, contra);
    }
}