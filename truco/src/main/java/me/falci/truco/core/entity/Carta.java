package me.falci.truco.core.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;

public class Carta implements Comparable<Carta> {

	private static List<Carta> cartas = new ArrayList<>(40);
	
	private final Nipe nipe;
	private final Integer valor;
	private Boolean mania = Boolean.FALSE;
	
	public static Carta getCarta(Nipe nipe, Integer valor){
		Carta carta = new Carta(nipe, valor);
		if(!cartas.contains(carta)){
			cartas.add(carta);
			return carta;
		}
		
		int i = cartas.indexOf(carta);
		return cartas.get(i);
	}
	
	
	private Carta(Nipe nipe, Integer valor) {
		Preconditions.checkNotNull(valor);
		Preconditions.checkArgument(valor > 0 && valor <= 10, "O valor da carta precisa ser entre 1 e 10");
		
		this.nipe = Preconditions.checkNotNull(nipe);
		this.valor = valor;
	}

	public Nipe getNipe() {
		return nipe;
	}

	public String getTexto() {
		switch (valor) {
			case 1: return "4";
			case 2: return "5";
			case 3: return "6";
			case 4: return "7";
			case 5: return "Q";
			case 6: return "J";
			case 7: return "K";
			case 8: return "A";
			case 9: return "2";
			case 10: return "3"; 
		}
		
		throw new IllegalArgumentException("Impossível determinar o valor da carta");
	}

	public Integer getValor() {
		return valor;
	}
	
	public Boolean isMania() {
		return mania;
	}
	
	public void setMania(Boolean mania) {
		this.mania = mania;
	}

	public void setMania(Carta vira) {
		int v = vira.getValor();
		if(v == 10){
			v = 0;
		}
		
		this.mania = v+1 == valor; 
		
	}

	public int compareTo(Carta o) {
		if(isMania()){
			// mania contra carta normal: ganha mania
			if(!o.isMania()){
				return 1;
			}
			
			// Duas manias: ganha nipe mais alto
			return nipe.getValor().compareTo(o.getNipe().getValor());
		}
		
		// Carta normal contra mania: ganha mania
		if(o.isMania()){
			return -1;
		}
		
		// Duas cartas normais: ganha quem tiver maior valor
		return getValor().compareTo(o.getValor());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nipe == null) ? 0 : nipe.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Carta other = (Carta) obj;
		if (nipe != other.nipe) {
			return false;
		}
		if (!valor.equals(other.valor)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString(){
		return String.format("%s de %s", getTexto(), nipe);
	}
	
}
