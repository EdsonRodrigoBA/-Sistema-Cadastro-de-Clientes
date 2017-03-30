package br.sistema.crud.jdbc.bo;


import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class ValidaCamposPessoasBO extends PlainDocument {
	

	private static final long serialVersionUID = 5649489410014769260L;
	
	public void insertString(int offSet, String str, AttributeSet attr)throws BadLocationException{
		 super.insertString(offSet, str.replaceAll("[^a-z|^A-Z |^ ]",""), attr);
	}
	
	public void nome(int offSet, String str,javax.swing.text.AttributeSet attr)throws BadLocationException{
		 super.insertString(offSet, str.replaceAll("[^a-z|^A-Z]",""), attr);

	}

}
