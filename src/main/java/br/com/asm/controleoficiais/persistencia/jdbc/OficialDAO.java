package br.com.asm.controleoficiais.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.asm.controleoficiais.persistencia.entidade.Oficial;

public class OficialDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	public void cadastrar(Oficial oficial) {
		String sql = "INSERT INTO \"tbl_Oficial\" (\"of_Matricula\", \"of_Nome\") VALUES (?,?)";
		System.out.println("Conectado...");
		try {
			//Criando um Statement
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, oficial.getOf_matricula());
			preparador.setString(2, oficial.getOf_nome());
			//Executando o comando SQL no banco
			System.out.println(preparador);
			preparador.execute();
			//Fechando o objeto preparador
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void alterar(Oficial oficial) {
		// Alterando o oficial
		String sql = "UPDATE \"tbl_Oficial\" set \"of_Nome\" = ? WHERE \"of_Matricula\" = ?";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			preparador.setString(1, oficial.getOf_nome());
			preparador.setString(2, oficial.getOf_matricula());
			//Executando o comando SQL no banco
			System.out.println(preparador);
			preparador.execute();
			//Fechando o objeto preparador
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluir(Oficial oficial) {
		String sql = "DELETE FROM \"tbl_Oficial\" WHERE \"of_Matricula\" = ?";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			preparador.setString(1, oficial.getOf_matricula());
			//Executando o comando SQL no banco
			System.out.println(preparador);
			preparador.execute();
			//Fechando o objeto preparador
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void salvar(Oficial oficial) {
		if(oficial.getOf_matricula()!=null){
			alterar(oficial);
		} else {
			cadastrar(oficial);
		}
	}

	public Oficial buscarPorMatricula(String matricula) {
		//Criando objeto de retorno do método
		Oficial oficialretorno = null;
		
		String sql = "SELECT * FROM \"tbl_Oficial\" WHERE \"of_Matricula\" = ?";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
				preparador.setString(1, matricula);
				
				//Retorno da consulta em Resultset
				ResultSet resultado = preparador.executeQuery();
				// Se tem registro
				if (resultado.next()) {
					oficialretorno = new Oficial();
					oficialretorno.setOf_matricula(resultado.getString("of_Matricula"));
					oficialretorno.setOf_nome(resultado.getString("of_Nome"));		
				}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return oficialretorno;
	}
	
}
