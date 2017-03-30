package br.sistema.crud.jdbc.exception;

public class PersistenciaExcpetion extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8916895283914218760L;
	public PersistenciaExcpetion(String msg) {
		super(msg);
	}
	
	public PersistenciaExcpetion(String msg, Exception exception ) {
		super(msg, exception);
	}

}
