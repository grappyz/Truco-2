package me.falci.truco;

import me.falci.truco.core.Truco;
import me.falci.truco.core.entity.JogadorMock;

/**
 * Hello world!
 * 
 */
public class App {
	
	public static void main(String[] args) {
		
		JogadorMock j1 = new JogadorMock();
		JogadorMock j2 = new JogadorMock();
		
		Truco truco = new Truco();
		truco.getEquipe1().getJogadores().add(j1);
		truco.getEquipe2().getJogadores().add(j2);
		
		truco.comecar();

		truco.jogar(j1, j1.getCartas().get(0));
		
	}
	
}
