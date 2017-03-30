package br.sistema.crud.jdbc.bo;

import java.util.ArrayList;
import java.util.List;

import br.sistema.crud.jdbc.dao.UfDAO;
import br.sistema.crud.jdbc.dto.UfDTO;
import br.sistema.crud.jdbc.exception.NegocioException;

public class UfBO {
	
	public List<UfDTO> listaUfs() throws NegocioException{
		List<UfDTO> lista = null;
		
		try{
			UfDAO ufDAO = new UfDAO();
			lista = ufDAO.listaEstado();
			
		}catch (Exception e){
			throw new NegocioException(e.getMessage(),e);
		}
		return lista;
		
		
		
	}

}
