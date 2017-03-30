package br.edu.devmedia.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.devmedia.jdbc.ConexaoUtil;
import br.edu.devmedia.jdbc.dto.PessoaDTO;
import br.edu.devmedia.jdbc.exception.PersistenciaExcpetion;

public class PessoaDAO implements GenericoDAO<PessoaDTO> {

	@Override
	public void inserir(PessoaDTO pessoaDTO) throws PersistenciaExcpetion {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "INSERT INTO TB_PESSOA(NOME, CPF, ENDERECO, SEXO, DT_NASC) " +
					"VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setLong(2, pessoaDTO.getCpf());
			statement.setString(3, pessoaDTO.getEndereco());
			statement.setString(4, String.valueOf(pessoaDTO.getSexo()));
			statement.setDate(5, new Date(pessoaDTO.getDtNascimento().getTime()));
			
			statement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
	}

	@Override
	public void atualizar(PessoaDTO pessoaDTO) throws PersistenciaExcpetion {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE TB_PESSOA " +
					" SET NOME = ?, " +
					" CPF = ?," +
					" ENDERECO = ?," +
					" SEXO = ?," +
					" DT_NASC = ? " +
					" WHERE ID_PESSOA = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setLong(2, pessoaDTO.getCpf());
			statement.setString(3, pessoaDTO.getEndereco());
			statement.setString(4, String.valueOf(pessoaDTO.getSexo()));
			statement.setDate(5, new Date(pessoaDTO.getDtNascimento().getTime()));
			statement.setInt(6, pessoaDTO.getIdPessoa());
			
			statement.execute();
			connection.close();
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
				pessoaDTO.setDtNascimento(resultSet.getDate("dt_nasc"));
				pessoaDTO.setEndereco(resultSet.getString("endereco"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
				
				listaPessoas.add(pessoaDTO);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		return listaPessoas;
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
				pessoaDTO.setEndereco(resultSet.getString("endereco"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
		return pessoaDTO;
	}
	
	public List<PessoaDTO> filtraPessoa(String nome, Long cpf, String sexo) throws PersistenciaExcpetion {
		List<PessoaDTO> lista = new ArrayList<PessoaDTO>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM TB_PESSOA ";
			if (nome != null && !nome.equals("")) {
				sql += " WHERE NOME = ?";
			}
			
			if (cpf != null && !cpf.equals("")) {
				sql += " AND CPF = ?";
			}
			
			if (sexo != null && !sexo.equals("")) {
				sql += " AND SEXO = ?";
			}
			
			PreparedStatement statement = connection.prepareStatement(sql);
			if (nome != null && !nome.equals("")) {
				statement.setString(1, nome);
			}
			
			if (cpf != null && !cpf.equals("")) {
				statement.setLong(2, cpf);
			}
			
			if (sexo != null && !sexo.equals("")) {
				statement.setString(3, sexo);
			}
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getLong("cpf"));
				pessoaDTO.setDtNascimento(resultSet.getDate("dt_nasc"));
				pessoaDTO.setEndereco(resultSet.getString("endereco"));
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
