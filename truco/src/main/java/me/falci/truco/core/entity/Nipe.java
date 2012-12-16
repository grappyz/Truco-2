package me.falci.truco.core.entity;

import java.util.HashMap;
import java.util.Map;

public enum Nipe {

	PAUS(4),
	COPAS(3),
	ESPADA(2),
	OURO(1);
	
	private Integer valor;
	private static Map<Integer, Nipe> map = new HashMap<>();

	static {
		for (Nipe item : values()) {
			map.put(item.valor, item);
		}
	}

	Nipe(Integer valor){
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}
	
	static Nipe fromValue(Integer value){
		return map.get(value);
	}
	
}
