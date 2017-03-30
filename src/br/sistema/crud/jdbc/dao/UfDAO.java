package br.sistema.crud.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sistema.crud.jdbc.ConexaoUtil;
import br.sistema.crud.jdbc.dto.UfDTO;
import br.sistema.crud.jdbc.exception.NegocioException;
import br.sistema.crud.jdbc.exception.PersistenciaExcpetion;

public class UfDAO {
	
	
	public List<UfDTO> listaEstado() throws  PersistenciaExcpetion{
	
	List<UfDTO> lista = new ArrayList<>();
	try{
		Connection connection = ConexaoUtil.getInstance().getConnection();
		
		String sql = "select * from tb_uf";
		PreparedStatement preparedstatmente = connection.prepareStatement(sql);
	
		ResultSet resultado = 	preparedstatmente.executeQuery();
		while(resultado.next()){
			UfDTO ufDTO = new UfDTO();
			ufDTO.setIdUF(resultado.getInt(1));
			ufDTO.setSiglaUF(resultado.getString(2));
			ufDTO.setDescrcao(resultado.getString(3));
			lista.add(ufDTO);
		}
		connection.close();
	}catch(Exception e){
		e.printStackTrace();
		throw new PersistenciaExcpetion(e.getMessage(), e);
	}
	
		return lista;
	}

}
