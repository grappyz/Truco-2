package me.falci.truco.core.entity;

import java.util.List;

public interface Jogador {

	void receberCartas(Carta vira, List<Carta> cartas);

	void avisarVez();
	
}
