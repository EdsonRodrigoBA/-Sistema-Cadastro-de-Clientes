package br.sistema.crud.jdbc;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import br.sistema.crud.jdbc.dto.PessoaDTO;


public class ConexaoUtil {
	
	private static ResourceBundle config; //Classe responsavel por recupera dos arquivo properties
	
	private ConexaoUtil() {
		config = ResourceBundle.getBundle("config"); //metodo pra recupera o config
	}
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static ConexaoUtil conexaoUtil;
	public static ConexaoUtil getInstance(){
		if(conexaoUtil == null){
			conexaoUtil = new ConexaoUtil();
		}
		return conexaoUtil;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(config.getString("br.edu.devmedia.drive.mysql"));
		return DriverManager.getConnection(config.getString("br.edu.devmedia.url.conexao"),
				config.getString("br.edu.devmedia.bd.usuario"), config.getString("br.edu.devmedia.bd.senha"));
	}
	
	

}
