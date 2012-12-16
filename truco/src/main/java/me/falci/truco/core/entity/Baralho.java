package me.falci.truco.core.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
	
	private static Baralho instance = new Baralho();
	private final List<Carta> cartas = new ArrayList<Carta>(40);
	private int cursor = 0;

	// ninguem pode ficar pegando um baralho novo no meio do jogo
	private Baralho(){
	
		for(int i=0; i<40; i++){
			Nipe nipe = Nipe.fromValue(i/10 + 1);
			Integer valor = i % 10 + 1;
			
			cartas.add(Carta.getCarta(nipe, valor));
		}
		
	}
	
	public static Baralho getInstance(){
		return instance;
	}
	
	public List<Carta> getCartas() {
		return cartas;
	}
	
	public void embaralhar(){
		cursor = 0; // reset
		Collections.shuffle(cartas);
	}

	public List<Carta> getProximaCarta(int i) {
		cursor += i;
		return cartas.subList(cursor-i, cursor);
	}

	public Carta getProximaCarta() {
		return getProximaCarta(1).get(0);
	}

	/**
	 * Chama {@link Carta#setMania(Carta)} em todas as cartas
	 * @param vira
	 */
	public void setVira(Carta vira) {
		for (Carta carta : cartas) {
			carta.setMania( vira );
		}
		
	}
	
}
