package me.falci.truco.core.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * Popular "Nós" ou "Eles" 
 * @author Falci
 */
public class Equipe {
	
	private final List<Jogador> jogadores = new LinkedList<>();
	private int pontos = 0;
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public int getPontos() {
		return pontos;
	}

}
