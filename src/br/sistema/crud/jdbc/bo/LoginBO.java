package br.sistema.crud.jdbc.bo;

import br.sistema.crud.jdbc.dao.LoginDAO;
import br.sistema.crud.jdbc.dao.PessoaDAO;
import br.sistema.crud.jdbc.dto.LoginDTO;
import br.sistema.crud.jdbc.dto.PessoaDTO;
import br.sistema.crud.jdbc.exception.NegocioException;

public class LoginBO {
	
	public boolean logar(LoginDTO loginDTO) throws NegocioException{
		boolean resultado = false;
		try{
			if(loginDTO.getNome() == null || "".equals(loginDTO)){
				throw new NegocioException("Logn Obrigatorio");
			}else if(loginDTO.getSenha() == null || "".equals(loginDTO.getSenha())){
				throw new NegocioException("Logn Obrigatorio");

			}else{
				LoginDAO loginDAO = new LoginDAO();
				resultado= loginDAO.logar(loginDTO);
					
				}
			
		}catch(Exception e){
			e.printStackTrace();
			throw new NegocioException(e.getMessage(),e);
		}
		return resultado;
	}

}
