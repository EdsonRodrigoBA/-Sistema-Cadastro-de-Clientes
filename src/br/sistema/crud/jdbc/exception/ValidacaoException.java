package br.sistema.crud.jdbc.exception;

public class ValidacaoException extends Exception{
	
	private static final long serialVersionUID = -8916895283914218760L;
	
	public ValidacaoException(String msg) {
		super(msg);
	}
	
	public ValidacaoException(String msg, Exception exception ) {
		super(msg, exception);
	}
}
