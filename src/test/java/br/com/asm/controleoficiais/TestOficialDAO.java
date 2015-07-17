package br.com.asm.controleoficiais;

import br.com.asm.controleoficiais.persistencia.entidade.Oficial;
import br.com.asm.controleoficiais.persistencia.jdbc.OficialDAO;

public class TestOficialDAO {

	public static void main(String[] args) {
		
		testBuscarPorMatricula("109673");
		
		
	}
	
	public static void testExcluir() {
		// Alterando oficial
				Oficial oficial = new Oficial();
				oficial.setOf_matricula("999999");
				
				// Cadastrando oficial no banco de dados
				OficialDAO oficialDAO = new OficialDAO();
				oficialDAO.excluir(oficial);
				
				System.out.println("Excluído com sucesso.");
	}
	
	public static void testAlterar() {
		// Alterando oficial
				Oficial oficial = new Oficial();
				oficial.setOf_nome("Edilene Neix Machado");
				oficial.setOf_matricula("123456");
				
				// Cadastrando oficial no banco de dados
				OficialDAO oficialDAO = new OficialDAO();
				oficialDAO.alterar(oficial);
				
				System.out.println("Alterado com sucesso.");
	}

	
	public static void testCadastrar() {
		// Criando oficial
				Oficial oficial = new Oficial();
				oficial.setOf_nome("Grazieli Machado");
				oficial.setOf_matricula("999999");
				
				// Cadastrando oficial no banco de dados
				OficialDAO oficialDAO = new OficialDAO();
				oficialDAO.cadastrar(oficial);
				
				System.out.println("Cadastrado com sucesso.");
	}
	
	public static void testSalvar() {
		// Salvando oficial
				Oficial oficial = new Oficial();
				oficial.setOf_nome("Deputado Tiririca");
				oficial.setOf_matricula("456789");
				
				// Cadastrando oficial no banco de dados
				OficialDAO oficialDAO = new OficialDAO();
				oficialDAO.salvar(oficial);
				
				System.out.println("Salvado com sucesso.");
	}
	
	
	public static void testBuscarPorMatricula(String matricula) {
		// Buscando oficial
				Oficial oficial = new Oficial();
				oficial.setOf_nome("Deputado Tiririca");
				oficial.setOf_matricula("456789");
				
				// Cadastrando oficial no banco de dados
				OficialDAO oficialDAO = new OficialDAO();
				oficialDAO.buscarPorMatricula(matricula);
				
				System.out.println("Salvado com sucesso.");
	}
	

}
