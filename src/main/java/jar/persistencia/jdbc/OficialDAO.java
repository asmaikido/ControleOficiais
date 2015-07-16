package jar.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jar.persistencia.entidade.Oficial;

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
	
}
