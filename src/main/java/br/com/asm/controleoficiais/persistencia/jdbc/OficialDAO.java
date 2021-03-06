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
	 * @param oficial � um objeto que cont�m os dados referentes ao oficial que ser� cadastrado.
	 */
	public void cadastrar(Oficial oficial) {
		String sql = "INSERT INTO \"tbl_Oficial\" (\"of_Matricula\", \"of_Nome\", \"of_Senha\") VALUES (?,?,MD5(?))";
		try {
			//Criando um Statement
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, oficial.getOfMatricula());
			preparador.setString(2, oficial.getOfNome());
			preparador.setString(3, oficial.getOfSenha());
			preparador.execute();
			//Fechando o objeto preparador
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Altera os dados do oficial no banco de dados.
	 * @param oficial � um objeto que cont�m os dados referentes ao oficial que ser� alterado.
	 */
	public void alterar(Oficial oficial) {
		// Alterando o oficial
		String sql = "UPDATE \"tbl_Oficial\" set \"of_Nome\" = ?, \"of_Senha\" = MD5(?) WHERE \"of_Matricula\" = ?";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			preparador.setString(1, oficial.getOfNome());
			preparador.setString(2, oficial.getOfSenha());
			preparador.setString(3, oficial.getOfMatricula());
			//Executando o comando SQL no banco
			preparador.execute();
			//Fechando o objeto preparador
			preparador.close();
		} catch (SQLException e) {
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
	 * @param oficial � um objeto que cont�m os dados referentes ao oficial que ser� apagado.
	 */
	public void excluir(Oficial oficial) {
		String sql = "DELETE FROM \"tbl_Oficial\" WHERE \"of_Matricula\" = ?";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			preparador.setString(1, oficial.getOfMatricula());
			//Executando o comando SQL no banco
			System.out.println(preparador);
			preparador.execute();
			//Fechando o objeto preparador
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
/**
 * Busca de um registro no banco de dados pelo n�mero da matr�cula do oficial.
 * @param matricula � uma string que representa a matr�cula de um oficial.
 * @return Retorna um objeto com os dados do oficial que tem a matr�cula; quando n�o encontra, retorna null.
 */
	public Oficial buscarPorMatricula(String matricula) {
		//Criando objeto de retorno do m�todo
		Oficial oficialretorno = null;
		
		String sql = "SELECT * FROM \"tbl_Oficial\" WHERE \"of_Matricula\" = ?";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
				preparador.setString(1, matricula);
				//Retorno da consulta em Resultset
				ResultSet resultado = preparador.executeQuery();
				// Se tem registro
				if (resultado.next()) {
					oficialretorno = new Oficial();
					oficialretorno.setOfMatricula(resultado.getString("of_Matricula"));
					oficialretorno.setOfNome(resultado.getString("of_Nome"));	
				}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return (oficialretorno);
	}
	
	/**
	 * Realiza a busca de todos os registros da tabela de oficiais.
	 * @return Uma lista de objeto oficial, contendo zero elementos quando n�o encontrar registros ou n 
	 * elementos quando encontrar.
	 */
	public List<Oficial> buscarTodos() {
		// Criando objeto de retorno do m�todo
		List<Oficial> listaoficiais = new ArrayList<Oficial>();
		String sql = "SELECT * FROM \"tbl_Oficial\"";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
				// Retorno da consulta em Resultset
				ResultSet resultado = preparador.executeQuery();
				// Procura os oficiais que retornaram
				while (resultado.next()) {
					Oficial oficialretorno = new Oficial();
					oficialretorno.setOfMatricula(resultado.getString("of_Matricula"));
					oficialretorno.setOfNome(resultado.getString("of_Nome"));	
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
	 * @param oficialconsultado � o objeto contendo os dados informados do oficial que dever� ser autenticado.
	 * @return Objeto contendo os dados do oficial que foi autenticado; caso n�o seja encontrado, retorna null.
	 */
	public Oficial autenticar(Oficial oficialconsultado) {
		String sql = "SELECT * FROM \"tbl_Oficial\" WHERE \"of_Matricula\" = ? AND \"of_Senha\" = MD5(?)";

		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
				preparador.setString(1, oficialconsultado.getOfMatricula());
				preparador.setString(2, oficialconsultado.getOfSenha());
				//Retorno da consulta em Resultset
				ResultSet resultado = preparador.executeQuery();
				// Se tem registro
				if (resultado.next()) {
					Oficial oficialretorno = new Oficial();
					oficialretorno.setOfMatricula(resultado.getString("of_Matricula"));
					oficialretorno.setOfNome(resultado.getString("of_Nome"));
					return oficialretorno;
				}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
}
