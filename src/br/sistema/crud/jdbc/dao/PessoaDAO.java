package br.sistema.crud.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.sistema.crud.jdbc.ConexaoUtil;
import br.sistema.crud.jdbc.dto.EnderecoDTO;
import br.sistema.crud.jdbc.dto.PessoaDTO;
import br.sistema.crud.jdbc.dto.UfDTO;
import br.sistema.crud.jdbc.exception.PersistenciaExcpetion;

public class PessoaDAO implements GenericoDAO<PessoaDTO> {

	@Override
	public void inserir(PessoaDTO pessoaDTO) throws PersistenciaExcpetion {
		try {
			int chaveEnd = insereEndreco(pessoaDTO.getEnderecoDTO());

			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO TB_PESSOA(NOME, CPF,  SEXO, DT_NASC, COD_ENDERECO) " +
					"VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setLong(2, pessoaDTO.getCpf());
			//statement.setString(3, pessoaDTO.getEndereco());
			statement.setString(3, String.valueOf(pessoaDTO.getSexo()));
			statement.setDate(4, new Date(pessoaDTO.getDtNascimento().getTime()));
			statement.setInt(5, chaveEnd);
			
			statement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
	}
	
	private int insereEndreco(EnderecoDTO enderecoDTO) throws PersistenciaExcpetion{
		int chave = 0;
		try {
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO TB_Endereco(LOGADOURO, BAIRRO, CIDADE, NUMERO, CEP, COD_UF) " +
					"VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, enderecoDTO.getLogadouro());
			statement.setString(2, enderecoDTO.getBairro());
			statement.setString(3, enderecoDTO.getCidade());
			statement.setLong(4, enderecoDTO.getNumero());
			statement.setInt(5, enderecoDTO.getCep());
			statement.setInt(6, enderecoDTO.getUfDTO().getIdUF());
			statement.execute();
			ResultSet result = statement.getGeneratedKeys();
			if(result.next()){
			
				chave = result.getInt(1);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		return chave;
		
	}

	@Override
	public void atualizar(PessoaDTO pessoaDTO) throws PersistenciaExcpetion {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE TB_PESSOA " +
					" SET NOME = ?, " +
					" CPF = ?," +
					" SEXO = ?," +
					" DT_NASC = ? " +
					" WHERE ID_PESSOA = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setLong(2, pessoaDTO.getCpf());
			//statement.setString(3, pessoaDTO.getEndereco());
			statement.setString(3, String.valueOf(pessoaDTO.getSexo()));
			statement.setDate(4, new Date(pessoaDTO.getDtNascimento().getTime()));
			statement.setInt(5, pessoaDTO.getIdPessoa());
			
			statement.execute();
			connection.close();
			//ATUALIZA AGORA O relacionamento da pessoa
			atualizaEndereco(pessoaDTO.getEnderecoDTO());
		} catch(Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
	}

	@Override
	public void deletar(Integer idPessoa) throws PersistenciaExcpetion {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM TB_PESSOA WHERE ID_PESSOA = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idPessoa);
			
			statement.execute();
			connection.close();
			
			//faz a deleção do endereco correspondente ao cadastro
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
	}
	
	public void deletarEndereco(Integer idEndereco) throws PersistenciaExcpetion{
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM TB_endereco WHERE ID_endereco = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idEndereco);
			
			statement.execute();
			connection.close();
		} catch(Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
	}
	
	private void atualizaEndereco(EnderecoDTO enderecoDTO) throws PersistenciaExcpetion{
		
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE TB_ENDERECO " +
			" SET LOGADOURO =  ?," +
			" BAIRRO = ?," +
			" CIDADE = ?," +
			" NUMERO = ?," +
			" CEP = ?," +
			" COD_UF = ?"+
			" WHERE ID_ENDERECO = ? ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, enderecoDTO.getLogadouro());
			preparedStatement.setString(2, enderecoDTO.getBairro());
			preparedStatement.setString(3, enderecoDTO.getCidade());
			preparedStatement.setLong(4,enderecoDTO.getNumero());
			preparedStatement.setInt(5, enderecoDTO.getCep());
			preparedStatement.setInt(6, enderecoDTO.getUfDTO().getIdUF());
			preparedStatement.setInt(7, enderecoDTO.getIdEndereco());
			preparedStatement.execute();
			connection.close();
		}catch (Exception e){
			throw new PersistenciaExcpetion(e.getMessage(),e);
		}
		
	}
	
	public void deletarTudo() throws PersistenciaExcpetion {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM TB_PESSOA";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.execute();
			connection.close();
		} catch(Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		
	}

	@Override
	public List<PessoaDTO> listarTodos() throws PersistenciaExcpetion {
		List<PessoaDTO> listaPessoas = new ArrayList<PessoaDTO>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM TB_PESSOA";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getLong("cpf"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
				pessoaDTO.setDtNascimento(resultSet.getDate("dt_nasc"));
				pessoaDTO.setEnderecoDTO(buscaEnderecoPorId(resultSet.getInt("cod_endereco")));
				
				listaPessoas.add(pessoaDTO);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		return listaPessoas;
	}
	
	public EnderecoDTO buscaEnderecoPorId(Integer idEndereco) throws PersistenciaExcpetion{
		EnderecoDTO enderecoDTO = null;
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "select * from tb_endereco where id_endereco = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idEndereco);
			ResultSet result = preparedStatement.executeQuery();
			if(result.next()){
				enderecoDTO = new EnderecoDTO();
				enderecoDTO.setIdEndereco(result.getInt(1));
				enderecoDTO.setLogradouro(result.getString(2));
				enderecoDTO.setBairro(result.getString(3));
				enderecoDTO.setCidade(result.getString(4));
				enderecoDTO.setNumero(result.getLong(5));
				enderecoDTO.setCep(result.getInt(6));
				enderecoDTO.setUfDTO(buscaUFPorId(result.getInt(7)));
		
			}
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		return enderecoDTO;
		
	}
	
	private UfDTO buscaUFPorId(Integer idUf) throws PersistenciaExcpetion{
		
		UfDTO ufDTO = null;
		try{
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "select * from tb_uf where id_uf = ?";
			PreparedStatement preparedStatment = connection.prepareStatement(sql);
			preparedStatment.setInt(1, idUf);
		
			ResultSet result = preparedStatment.executeQuery();
			
			if(result.next()){
				ufDTO = new UfDTO();
				ufDTO.setIdUF(result.getInt(1));
				ufDTO.setSiglaUF(result.getString(2));
				ufDTO.setDescrcao(result.getString(3));
			}
			
		}catch(Exception e){
			throw new PersistenciaExcpetion(e.getMessage(), e);
		} 
		return ufDTO;
	}

	@Override
	public PessoaDTO buscarPorId(Integer id) throws PersistenciaExcpetion {
		PessoaDTO pessoaDTO = null;
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM TB_PESSOA WHERE ID_PESSOA = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getLong("cpf"));
				pessoaDTO.setDtNascimento(resultSet.getDate("dt_nasc"));
				//pessoaDTO.setEndereco(resultSet.getString("endereco"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
				pessoaDTO.setEnderecoDTO(buscaEnderecoPorId(resultSet.getInt("cod_endereco")));
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		return pessoaDTO;
	}
	
	public List<PessoaDTO> filtraPessoa(String nome, Long cpf, String sexo, String orderBy) throws PersistenciaExcpetion {
		List<PessoaDTO> lista = new ArrayList<PessoaDTO>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM TB_PESSOA ";
			boolean ultimo = false;
			if (nome != null && !nome.equals("")) {
				sql += " WHERE NOME LIKE ?";
				ultimo = true;
			}
			
			if (cpf != null && !cpf.equals("")) {
				if (ultimo) {
					sql += " AND ";
				} else {
					sql += " WHERE ";
					ultimo = true;
				}
				sql += " CPF LIKE ?";
			}
			
			if (sexo != null && !sexo.equals("")) {
				if (ultimo) {
					sql += " AND ";
				} else {
					sql += " WHERE ";
				}
				sql += " SEXO = ?";
			}
			sql += " ORDER BY " + orderBy;
			
			PreparedStatement statement = connection.prepareStatement(sql);
			int cont = 0;
			if (nome != null && !nome.equals("")) {
				statement.setString(++cont, "%" + nome + "%");
			}
			
			if (cpf != null && !cpf.equals("")) {
				statement.setString(++cont, "%" + cpf + "%");
			}
			
			if (sexo != null && !sexo.equals("")) {
				statement.setString(++cont, sexo);
			}
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getLong("cpf"));
				pessoaDTO.setDtNascimento(resultSet.getDate("dt_nasc"));
				//pessoaDTO.setEndereco(resultSet.getString("endereco"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
				
				lista.add(pessoaDTO);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		return lista;
	}
	
	
	
}
