package com.tallerwebi.TDD;

public class Temperatura {
	
	private Integer grados;

	public Temperatura(Integer grados) {
		super();
		this.grados = grados;
	}

	public Integer getGrados() {
		return grados;
	}

	public void setGrados(Integer grados) {
		this.grados = grados;
	}

	public String clasificarTemperatura(Integer gradosXD) {
		
		if(gradosXD < 0) {
			return "CONGELANTE";
		}
		
		if(gradosXD >0 && gradosXD <=15) {
			return "FRIA";
		}
		
		if(gradosXD >=16 && gradosXD <=25) {
			return "TEMPLADA";
		}
		
		if(gradosXD >=26 && gradosXD <=35) {
			return "CALUROSA";
		}
		
		if(gradosXD >35) {
			return "PELIGROSA";
		}
		
		return null;
	}
	
	

}