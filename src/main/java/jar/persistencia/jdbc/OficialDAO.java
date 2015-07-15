package jar.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jar.persistencia.entidade.Oficial;

public class OficialDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	public void cadastrar(Oficial oficial) {
		String sql = "insert into oficial (of_matricula, of_nome) values (?,?)";
		
		try {
			//Criando um Statement
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, oficial.getOf_nome());
			preparador.setString(2, oficial.getOf_matricula());
			//Executando o comando SQL no banco
			preparador.execute();
			//Fechando o objeto preparador
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
