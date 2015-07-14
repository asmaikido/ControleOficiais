package jar.persistencia.jdbc;

import jar.persistencia.entidade.Oficial;

public class OficialDAO {

	public void cadastrar(Oficial oficial) {
		
		private Connection conexao = ConexaoFactory.getConnection();
		
		String sql = "insert into oficial (of_matricula, of_nome) values (?,?)";
		
		
	}

}
