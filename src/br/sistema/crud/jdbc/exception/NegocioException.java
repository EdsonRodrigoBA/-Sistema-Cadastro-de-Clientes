package br.sistema.crud.jdbc.exception;

public class NegocioException extends Exception{
	
	private static final long serialVersionUID = -8916895283914218760L;
	
	public NegocioException(String msg) {
		super(msg);
	}
	
	public NegocioException(String msg, Exception exception ) {
		super(msg, exception);
	}
}
