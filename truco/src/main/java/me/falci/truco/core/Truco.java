package me.falci.truco.core;

import me.falci.truco.core.entity.Baralho;
import me.falci.truco.core.entity.Carta;
import me.falci.truco.core.entity.Equipe;
import me.falci.truco.core.entity.Jogador;
import me.falci.truco.core.exception.EquipeInvalidaException;

import com.google.common.base.Preconditions;

/**
 * Representa um jogo, com jogadores, pontuação e mão
 * @author Falci
 */
public class Truco {
	
	private final Equipe equipe1 = new Equipe();
	private final Equipe equipe2 = new Equipe();
	private final Baralho baralho = Baralho.getInstance();
	private int proximo = 0;
	private Mao maoAtual = null;
	
	public Equipe getEquipe1() {
		return equipe1;
	}
	
	public Equipe getEquipe2() {
		return equipe2;
	}

	public void comecar() {
		Preconditions.checkArgument(maoAtual == null, "Já existe um jogo em andamento!");
		
		validar();
		zerarPontuacao();
		
		baralho.embaralhar();
		distribuirCartas();

		maoAtual = new Mao(this);		
		getProximo().avisarVez();
	}

	private void distribuirCartas() {
		Carta vira = baralho.getProximaCarta();
		baralho.setVira(vira);
		
		for(int i=0; i<equipe1.getJogadores().size(); i++){
			equipe1.getJogadores().get(i).receberCartas(vira, baralho.getProximaCarta(3));
			equipe2.getJogadores().get(i).receberCartas(vira, baralho.getProximaCarta(3));
		}
		
	}

	private void incrementarProximo() {
		proximo++;
		
		if(Math.floor(proximo/2) == equipe1.getJogadores().size()){
			proximo = 0;
		}
	}

	private Jogador getProximo() {
		Equipe e = (proximo%2 == 0)? equipe1 : equipe2;
		int i = (int) Math.floor(proximo/2);
		
		Jogador prox = e.getJogadores().get(i);
		return prox;
	}

	private void zerarPontuacao() {
		equipe1.setPontos(0);
		equipe2.setPontos(0);
	}

	private void validar() {
		if(equipe1.getJogadores().isEmpty()){
			throw new EquipeInvalidaException("Não há jogadores na equipe 1");
		}
		
		if(equipe1.getJogadores().size() > 3){
			throw new EquipeInvalidaException("É permitido apenas 3 jogadores por equipe");
		}
		
		if(equipe1.getJogadores().size() != equipe2.getJogadores().size()){
			throw new EquipeInvalidaException("As equipes tem quantidade diferentes de jogadores");
		}
	}

	public void jogar(Jogador jogador, Carta carta) {
		Preconditions.checkNotNull(maoAtual, "Jogada inválida. Chame Truco.comecar()");
		Preconditions.checkArgument(getProximo().equals(jogador), "Não é a vez deste jogador!");
		
	}

}
