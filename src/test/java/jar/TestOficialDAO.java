package jar;

import jar.persistencia.entidade.Oficial;
import jar.persistencia.jdbc.OficialDAO;

public class TestOficialDAO {

	public static void main(String[] args) {
		
		// Criando oficial
		Oficial oficial = new Oficial();
		oficial.setOf_nome("Edilene Neix Machado");
		oficial.setOf_matricula("111111");
		
		// Cadastrando oficial no banco de dados
		OficialDAO oficialDAO = new OficialDAO();
		oficialDAO.cadastrar(oficial);
		
		System.out.println("Cadastrado com sucesso.");
		
		
	}

}
