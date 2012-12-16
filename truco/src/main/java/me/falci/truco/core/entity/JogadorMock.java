package me.falci.truco.core.entity;

import java.util.List;

import org.apache.log4j.Logger;

public class JogadorMock implements Jogador{
	
	private List<Carta> cartas;

	@Override
	public void receberCartas(Carta vira, List<Carta> cartas) {
		this.cartas = cartas;
		Logger.getLogger(getClass()).info(String.format("%s recebeu: %s e %s", this, vira, cartas));
		
	}

	@Override
	public void avisarVez() {
		Logger.getLogger(getClass()).info(String.format("É a vez de %s jogar", this));
		
	}
	
	public List<Carta> getCartas() {
		return cartas;
	}

}
