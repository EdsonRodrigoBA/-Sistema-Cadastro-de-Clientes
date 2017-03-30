package br.sistema.crud.jdbc.bo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.sistema.crud.jdbc.dao.PessoaDAO;
import br.sistema.crud.jdbc.dto.EnderecoDTO;
import br.sistema.crud.jdbc.dto.PessoaDTO;
import br.sistema.crud.jdbc.exception.NegocioException;
import br.sistema.crud.jdbc.exception.ValidacaoException;

public class PessoaBO {

	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public void cadastrar(PessoaDTO pessoaDTO) throws NegocioException {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.inserir(pessoaDTO);
		} catch(Exception exception) {
			exception.printStackTrace();
			throw new NegocioException(exception.getMessage());
		}
	}
	
	public String[][] listagem(List<Integer> idsPessoas) throws NegocioException {
		int numCols = 10;
		String[][] listaRetorno = null;
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			
			List<PessoaDTO> lista = pessoaDAO.listarTodos();
			listaRetorno = new String[lista.size()][numCols];
			
			for (int i = 0; i < lista.size(); i++) {
				PessoaDTO pessoa = lista.get(i);
				EnderecoDTO enderecoDTO = pessoa.getEnderecoDTO();
				listaRetorno[i][0] = pessoa.getIdPessoa().toString();
				idsPessoas.add(pessoa.getIdPessoa());
				listaRetorno[i][1] = pessoa.getNome();
				listaRetorno[i][2] = pessoa.getCpf().toString();
				listaRetorno[i][3] = pessoa.getSexo() == 'M' ? "Masculino" : "Feminino";
				listaRetorno[i][4] = dateFormat.format(pessoa.getDtNascimento());
				listaRetorno[i][5] = enderecoDTO.getLogadouro();
				listaRetorno[i][6] = enderecoDTO.getUfDTO().toString();
				listaRetorno[i][7] = enderecoDTO.getCep().toString();
				listaRetorno[i][8] = "ALTER";
				listaRetorno[i][9] = "DEL";
			}
		} catch(Exception exception) {
			throw new NegocioException(exception.getMessage());
		}
		return listaRetorno;
	}
	
	public boolean validaNome(String nome) throws ValidacaoException {
		boolean ehValido = true;
		if (nome == null || nome.equals("")) {
			ehValido = false;
			throw new ValidacaoException("Campo nome é obrigatório!");
		} else if (nome.length() > 30) {
			ehValido = false;
			throw new ValidacaoException("Campo nome comporta no máximo 30 chars!");
		}
		return ehValido;
	}
	
	public boolean validaCpf(String cpf) throws ValidacaoException {
		boolean ehValido = true;
		if (cpf == null || cpf.equals("")) {
			ehValido = false;
			throw new ValidacaoException("Campo CPF é obrigatório!");
		} else if (cpf.length() != 11) {
			ehValido = false;
			throw new ValidacaoException("Campo CPF deve ter 11 dígitos!");
		} else {
			char[] digitos = cpf.toCharArray();
			for (char digito : digitos) {
				if (!Character.isDigit(digito)) {
					ehValido = false;
					throw new ValidacaoException("Campo CPF é somente numérico!");
				}
			}
		}
		return ehValido;
	}
	
	public boolean validaEndereco(EnderecoDTO enderecoDTO) throws ValidacaoException {
		boolean ehValido = true;
		if (enderecoDTO.getLogadouro() == null || enderecoDTO.getLogadouro().equals("")) {
			ehValido = false;
			throw new ValidacaoException("Campo Logradouro é obrigatório!");
		} else if (enderecoDTO.getBairro() == null || enderecoDTO.getBairro().equals("")) {
			ehValido = false;
			throw new ValidacaoException("Bairro Obrigatorio");
		} else if (enderecoDTO.getNumero() == null || enderecoDTO.getNumero().equals(0)) {
			ehValido = false;
			throw new ValidacaoException("Numero Obrigatorio");
		}else if (enderecoDTO.getCep() == null || enderecoDTO.getCep().equals(0)) {
			ehValido = false;
			throw new ValidacaoException("CEP Obrigatorio");
		}
	

		return ehValido;
	}
	
	public boolean validaDtNasc(String dtNasc) throws ValidacaoException {
		boolean ehValido = true;
		if (dtNasc == null || dtNasc.equals("")) {
			ehValido = false;
			throw new ValidacaoException("Campo Dt. Nasc. é obrigatório!");
		} else {
			ehValido = false;
			try {
				dateFormat.parse(dtNasc);
			} catch (ParseException e) {
				throw new ValidacaoException("Formato inválido de data!");
			}
		}
		return ehValido;
	}
	
	public String[][] listaConsulta(String nome, Long cpf, char sexo, String orderBy) throws NegocioException {
		int numCols = 6;
		String[][] listaRetorno = null;
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			
			List<PessoaDTO> lista = pessoaDAO.filtraPessoa(nome, cpf, String.valueOf(sexo), orderBy);
			listaRetorno = new String[lista.size()][numCols];
			
			for (int i = 0; i < lista.size(); i++) {
				PessoaDTO pessoa = lista.get(i);
				listaRetorno[i][0] = pessoa.getIdPessoa().toString();
				listaRetorno[i][1] = pessoa.getNome();
				listaRetorno[i][2] = pessoa.getCpf().toString();
				//listaRetorno[i][3] = pessoa.getEndereco();
				listaRetorno[i][4] = pessoa.getSexo() == 'M' ? "Masculino" : "Feminino";
				listaRetorno[i][5] = dateFormat.format(pessoa.getDtNascimento());
			}
		} catch(Exception exception) {
			throw new NegocioException(exception.getMessage());
		}
		return listaRetorno;
	}
	
	public void removePessoa(Integer idPessoa, Integer idEndereco) throws NegocioException {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.deletar(idPessoa);
			pessoaDAO.deletarEndereco(idEndereco);
		} catch(Exception exception) {
			throw new NegocioException(exception.getMessage());
		}
	}

	public void removeTudo() throws NegocioException {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.deletarTudo();
			
		} catch(Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	public PessoaDTO buscaPorId(Integer idPessoa) throws NegocioException{
		PessoaDTO pessoaDTO = null;
		
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDTO = pessoaDAO.buscarPorId(idPessoa);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage(), e);
			
		}
		return pessoaDTO;
	}
	
}
