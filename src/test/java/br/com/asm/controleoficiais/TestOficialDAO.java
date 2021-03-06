package br.com.asm.controleoficiais;

import java.util.List;

import br.com.asm.controleoficiais.persistencia.entidade.Oficial;
import br.com.asm.controleoficiais.persistencia.jdbc.OficialDAO;

public class TestOficialDAO {

	public static void main(String[] args) {
		
		testBuscarPorMatricula();	
		testBuscarTodos();
		testAutenticar();
	
		
		
	}
	
	public static void testExcluir() {
		// Alterando oficial
				Oficial oficial = new Oficial();
				oficial.setOfMatricula("999999");
				
				// Cadastrando oficial no banco de dados
				OficialDAO oficialDAO = new OficialDAO();
				oficialDAO.excluir(oficial);
				
				System.out.println("Exclu�do com sucesso.");
	}
	
	public static void testAlterar() {
		// Alterando oficial
				Oficial oficial = new Oficial();
				oficial.setOfNome("Edilene Neix Machado");
				oficial.setOfMatricula("123456");
				
				// Cadastrando oficial no banco de dados
				OficialDAO oficialDAO = new OficialDAO();
				oficialDAO.alterar(oficial);
				
				System.out.println("Alterado com sucesso.");
	}

	
	public static void testCadastrar() {
		// Criando oficial
				Oficial oficial = new Oficial();
				oficial.setOfNome("Grazieli Machado");
				oficial.setOfMatricula("999999");
				
				// Cadastrando oficial no banco de dados
				OficialDAO oficialDAO = new OficialDAO();
				oficialDAO.cadastrar(oficial);
				
				System.out.println("Cadastrado com sucesso.");
	}
	
		
	public static void testBuscarPorMatricula() {
		// Buscando oficial
												
				// Cadastrando oficial no banco de dados
				OficialDAO oficialDAO = new OficialDAO();
				Oficial oficial = oficialDAO.buscarPorMatricula("109673");
				
				System.out.println("Resultado: " + oficial);
	}
	
	private static void testBuscarTodos() {
		// Buscando oficial
												
		OficialDAO oficialDAO = new OficialDAO();
		List<Oficial> lista = oficialDAO.buscarTodos();
		for (Oficial of: lista){
			System.out.println(of);
		}		
	}
	
	private static void testAutenticar() {
		// Buscando oficial									
		OficialDAO oficialDAO = new OficialDAO();
		Oficial oficial = new Oficial();
		oficial.setOfSenha("123456");
		oficial.setOfMatricula("111111");
		
		Oficial oficialretorno = oficialDAO.autenticar(oficial);
		
		System.out.println(oficialretorno);
		
	}		
}

