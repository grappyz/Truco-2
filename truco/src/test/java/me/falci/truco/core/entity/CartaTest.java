package me.falci.truco.core.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CartaTest {
	
	@Test(expected=NullPointerException.class)
	public void testNipeNull(){
		Carta.getCarta(null, 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorInvalido1(){
		Carta.getCarta(Nipe.PAUS, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorInvalido2(){
		Carta.getCarta(Nipe.PAUS, -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorInvalido4(){
		Carta.getCarta(Nipe.PAUS, 11);
	}
	
	@Test(expected=NullPointerException.class)
	public void testValorInvalido5(){
		Carta.getCarta(Nipe.PAUS, null);
	}
		
	@Test
	public void testGetTexto(){
		assertEquals("A", Carta.getCarta(Nipe.PAUS, 8).getTexto());
		assertEquals("2", Carta.getCarta(Nipe.PAUS, 9).getTexto());
		assertEquals("3", Carta.getCarta(Nipe.PAUS, 10).getTexto());
		assertEquals("4", Carta.getCarta(Nipe.PAUS, 1).getTexto());
		assertEquals("5", Carta.getCarta(Nipe.PAUS, 2).getTexto());
		assertEquals("6", Carta.getCarta(Nipe.PAUS, 3).getTexto());
		assertEquals("7", Carta.getCarta(Nipe.PAUS, 4).getTexto());
		assertEquals("Q", Carta.getCarta(Nipe.PAUS, 5).getTexto());
		assertEquals("J", Carta.getCarta(Nipe.PAUS, 6).getTexto());
		assertEquals("K", Carta.getCarta(Nipe.PAUS, 7).getTexto());
	}

	@Test
	public void testCompareToManiaENaoMania() {
		Carta carta4O = Carta.getCarta(Nipe.OURO, 1);
		Carta carta3P = Carta.getCarta(Nipe.PAUS, 10);
		
		carta3P.setMania(false);
		carta4O.setMania(true);
		assertEquals(1, carta4O.compareTo(carta3P));
	}
	
	@Test
	public void testCompareToDuasManias() {
		Carta carta3C = Carta.getCarta(Nipe.COPAS, 10);
		Carta carta3P = Carta.getCarta(Nipe.PAUS, 10);
		
		carta3C.setMania(true);
		carta3P.setMania(true);
		assertEquals(1, carta3P.compareTo(carta3C));
	}
	
	@Test
	public void testCompareToNaoManiaEMania() {
		Carta carta4O = Carta.getCarta(Nipe.OURO, 1);
		Carta carta3P = Carta.getCarta(Nipe.PAUS, 10);
		
		carta4O.setMania(true);
		assertEquals(-1, carta3P.compareTo(carta4O));
	}
	
	@Test
	public void testCompareToDuasNaoMania() {
		Carta carta3P = Carta.getCarta(Nipe.PAUS, 10);
		Carta carta2P = Carta.getCarta(Nipe.PAUS, 9);
		
		assertEquals(1, carta3P.compareTo(carta2P));
	}
	
	@Test
	public void testCompareToEmpachar() {
		Carta carta3P = Carta.getCarta(Nipe.PAUS, 10);
		Carta carta3C = Carta.getCarta(Nipe.COPAS, 10);
		
		carta3P.setMania(false);
		carta3C.setMania(false);
		
		assertEquals(0, carta3P.compareTo(carta3C));
	}

}
