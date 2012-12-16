package me.falci.truco.core.exception;

public class TrucoException extends RuntimeException {
	private static final long serialVersionUID = 1112388860664454590L;
	
	public TrucoException(String mensagem) {
		super(mensagem);
	}
	
}
