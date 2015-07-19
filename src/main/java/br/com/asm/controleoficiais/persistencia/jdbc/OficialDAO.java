package br.com.asm.controleoficiais.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.asm.controleoficiais.persistencia.entidade.Oficial;

public class OficialDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Cadastra um oficial no banco de dados.
	 * @param oficial É um objeto que contém os dados referentes ao oficial que será cadastrado.
	 */
	public void cadastrar(Oficial oficial) {
		String sql = "INSERT INTO \"tbl_Oficial\" (\"of_Matricula\", \"of_Nome\") VALUES (?,?)";
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

	/**
	 * Altera os dados do oficial no banco de dados.
	 * @param oficial É um objeto que contém os dados referentes ao oficial que será alterado.
	 */
	public void alterar(Oficial oficial) {
		// Alterando o oficial
		String sql = "UPDATE \"tbl_Oficial\" set \"of_Nome\" = ?, \"of_Matricula\" = ? WHERE \"of_Matricula\" = ?";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			preparador.setString(1, oficial.getOf_nome());
			preparador.setString(2, oficial.getOf_matricula());
			preparador.setString(3, oficial.getOf_matricula());
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
		// Salvando o oficial
		if (oficial != null) {
			alterar(oficial);
		} else {
			cadastrar(oficial);
		}			
	}
	
	/**
	 * Deleta os dados do oficial no banco de dados.
	 * @param oficial É um objeto que contém os dados referentes ao oficial que será apagado.
	 */
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
		
/**
 * Busca de um registro no banco de dados pelo número da matrícula do oficial.
 * @param matricula É uma string que representa a matrícula de um oficial.
 * @return Retorna um objeto com os dados do oficial que tem a matrícula; quando não encontra, retorna null.
 */
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
		return (oficialretorno);
	}
	
	/**
	 * Realiza a busca de todos os registros da tabela de oficiais.
	 * @return Uma lista de objeto oficial, contendo zero elementos quando não encontrar registros ou n 
	 * elementos quando encontrar.
	 */
	public List<Oficial> buscarTodos() {
		// Criando objeto de retorno do método
		List<Oficial> listaoficiais = new ArrayList<Oficial>();
		String sql = "SELECT * FROM \"tbl_Oficial\"";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
				// Retorno da consulta em Resultset
				ResultSet resultado = preparador.executeQuery();
				// Procura os oficiais que retornaram
				while (resultado.next()) {
					Oficial oficialretorno = new Oficial();
					oficialretorno.setOf_matricula(resultado.getString("of_Matricula"));
					oficialretorno.setOf_nome(resultado.getString("of_Nome"));	
					// Adicionando oficial na lista
					listaoficiais.add(oficialretorno);
				}
				return listaoficiais;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Autentica o oficial, confirmando se existe no banco de dados.
	 * @param oficialconsultado É o objeto contendo os dados informados do oficial que deverá ser autenticado.
	 * @return Objeto contendo os dados do oficial que foi autenticado; caso não seja encontrado, retorna null.
	 */
	public Oficial autenticar(Oficial oficialconsultado) {
		String sql = "SELECT * FROM \"tbl_Oficial\" WHERE \"of_Matricula\" = ? AND \"of_Nome\" = ?";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
				preparador.setString(2, oficialconsultado.getOf_nome());
				preparador.setString(1, oficialconsultado.getOf_matricula());
				//Retorno da consulta em Resultset
				ResultSet resultado = preparador.executeQuery();
				// Se tem registro
				if (resultado.next()) {
					Oficial oficialretorno = new Oficial();
					oficialretorno.setOf_matricula(resultado.getString("of_Matricula"));
					oficialretorno.setOf_nome(resultado.getString("of_Nome"));
					return oficialretorno;
				}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
}
