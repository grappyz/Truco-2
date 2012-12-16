package me.falci.truco.core.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class BaralhoTest {

	@Test
	public void testEmbaralhar() {
		Baralho baralho = Baralho.getInstance();
		List<Carta> emOrdem = Lists.newCopyOnWriteArrayList(baralho.getCartas());
		
		// Antes de embaralhar, precisam ser iguais
		assertEquals(emOrdem, baralho.getCartas());
		
		baralho.embaralhar();
		assertNotEquals(emOrdem, baralho.getCartas());
	}


	@Test
	public void tesSetVira() {
		// diz que as 4 primeiras cartas são manias, como se fosse de uma rodada passada
		for (Carta carta : Baralho.getInstance().getProximaCarta(4)) {
			carta.setMania(true);
		}
		
		// Pega um novo vira
		Carta vira = Baralho.getInstance().getProximaCarta();
		Baralho.getInstance().setVira(vira);
		
		// Conta quantas manias há agora
		int manias = 0;
		for (Carta item : Baralho.getInstance().getCartas()) {
			if(item.isMania()){
				manias++;
			}
		}
		
		assertEquals(4, manias);
		
	}
	
	
	@Test
	public void testGetProximaCarta() {
		Baralho baralho = Baralho.getInstance();
		baralho.embaralhar();
		
		List<Carta> todas = baralho.getCartas();
		Carta vira = baralho.getProximaCarta();
		
		List<Carta> j1 = baralho.getProximaCarta(3);
		List<Carta> j2 = baralho.getProximaCarta(3);
		
		assertEquals(3, j1.size());
		assertEquals(todas.get(1), j1.get(0));
		assertEquals(todas.get(2), j1.get(1));
		assertEquals(todas.get(3), j1.get(2));
		
		assertEquals(3, j2.size());
		assertEquals(todas.get(4), j2.get(0));
		assertEquals(todas.get(5), j2.get(1));
		assertEquals(todas.get(6), j2.get(2));
		
		assertEquals(todas.get(0), vira);
		
	}
	
	
	@Test
	public void testQuantidadeDeCartas() {
		assertEquals(40, Baralho.getInstance().getCartas().size());
	}
	
	@Test
	public void testSeTodasAsCartasEstaoPresentes() {
		List<Carta> cartas = Baralho.getInstance().getCartas();
		
		assertTrue(cartas.contains(Carta.getCarta(Nipe.PAUS, 1)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.PAUS, 2)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.PAUS, 3)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.PAUS, 4)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.PAUS, 5)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.PAUS, 6)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.PAUS, 7)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.PAUS, 8)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.PAUS, 9)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.PAUS, 10)));
		
		assertTrue(cartas.contains(Carta.getCarta(Nipe.COPAS, 1)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.COPAS, 2)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.COPAS, 3)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.COPAS, 4)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.COPAS, 5)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.COPAS, 6)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.COPAS, 7)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.COPAS, 8)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.COPAS, 9)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.COPAS, 10)));
		
		assertTrue(cartas.contains(Carta.getCarta(Nipe.ESPADA, 1)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.ESPADA, 2)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.ESPADA, 3)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.ESPADA, 4)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.ESPADA, 5)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.ESPADA, 6)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.ESPADA, 7)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.ESPADA, 8)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.ESPADA, 9)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.ESPADA, 10)));
		
		assertTrue(cartas.contains(Carta.getCarta(Nipe.OURO, 1)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.OURO, 2)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.OURO, 3)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.OURO, 4)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.OURO, 5)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.OURO, 6)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.OURO, 7)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.OURO, 8)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.OURO, 9)));
		assertTrue(cartas.contains(Carta.getCarta(Nipe.OURO, 10)));
	}

}
