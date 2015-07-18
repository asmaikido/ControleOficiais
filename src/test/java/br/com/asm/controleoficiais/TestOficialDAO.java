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
		oficial.setOf_nome("Alexandre da Silva Machado");
		oficial.setOf_matricula("109673");
		
		Oficial oficialretorno = oficialDAO.autenticar(oficial);
		
		System.out.println(oficialretorno);
		
	}		
}

