package me.falci.truco.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import me.falci.truco.core.entity.Jogador;
import me.falci.truco.core.entity.JogadorMock;

import org.easymock.EasyMock;
import org.junit.Test;

public class TrucoTest {
	
	@Test
	public void testRecomecarPartida() {
		Truco truco = new Truco();
		truco.getEquipe1().getJogadores().add(new JogadorMock());
		truco.getEquipe2().getJogadores().add(new JogadorMock());
		
		truco.comecar();
		
		try{
			truco.comecar();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Já existe um jogo em andamento!", e.getMessage());
		}
			
	}
	
	@Test
	public void testJogadorErrado() {
		Truco truco = new Truco();
		truco.getEquipe1().getJogadores().add(new JogadorMock());
		truco.getEquipe2().getJogadores().add(new JogadorMock());
		
		truco.comecar();
		
		try{
			truco.jogar(new JogadorMock(), null);
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Não é a vez deste jogador!", e.getMessage());
		}
		
	}
	
	@Test
	public void testJogadaSemPartidaEmAndamento() {
		try{
			new Truco().jogar(null, null);
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Jogada inválida. Chame Truco.comecar()", e.getMessage());
		}
	}
	
	@Test
	public void testComecarSemJogadores() {
		try{
			new Truco().comecar();
			fail();
		} catch(Exception e){
			assertEquals("Não há jogadores na equipe 1", e.getMessage());
		}
	}
	
	@Test
	public void testComecarComApenas1Jogador() {
		Jogador jogador = EasyMock.createMock(Jogador.class);
		EasyMock.replay(jogador);
		
		Truco truco = new Truco();
		truco.getEquipe1().getJogadores().add(jogador);
		
		try{
			truco.comecar();
			fail();
		} catch(Exception e){
			assertEquals("As equipes tem quantidade diferentes de jogadores", e.getMessage());
		}
	}
	
	@Test
	public void testComecarComMaisDe3PorEquipe() {
		Truco truco = new Truco();
		List<Jogador> jogadores = truco.getEquipe1().getJogadores();
		
		jogadores.add(null);
		jogadores.add(null);
		jogadores.add(null);
		jogadores.add(null);
		
		try{
			truco.comecar();
			fail();
		} catch(Exception e){
			assertEquals("É permitido apenas 3 jogadores por equipe", e.getMessage());
		}
	}

}
