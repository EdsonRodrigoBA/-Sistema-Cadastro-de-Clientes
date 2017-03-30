package br.sistema.crud.jdbc.dao;

import java.util.List;

import br.sistema.crud.jdbc.exception.PersistenciaExcpetion;

public interface GenericoDAO<T> {
	
	void inserir(T objc) throws PersistenciaExcpetion;
	void atualizar(T objc)throws PersistenciaExcpetion;
	
	void deletar(Integer idPessoa)throws PersistenciaExcpetion;
	
	List<T> listarTodos()throws PersistenciaExcpetion;
	
	T buscarPorId(Integer idPessoa)throws PersistenciaExcpetion;

}
