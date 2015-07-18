package br.com.asm.controleoficiais.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asm.controleoficiais.persistencia.entidade.Oficial;
import br.com.asm.controleoficiais.persistencia.jdbc.OficialDAO;

//http://localhost:8080/ControleOficiais/ofcontroller.do
@WebServlet(name = "ofcontroller", urlPatterns = {"/ofcontroller.do"})
public class OficialController extends HttpServlet {
	
	public OficialController() {
		System.out.println("Construtor ...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Init ...");
		super.init();
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy ...");
		super.destroy();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		String acao = req.getParameter("acao");
				
		if (acao.equals("excluir")) {
			
			String matricula = req.getParameter("matricula");
			Oficial oficial = new Oficial();
			oficial.setOf_matricula(matricula);
			OficialDAO oficialDAO = new OficialDAO();
			oficialDAO.excluir(oficial);
			//resp.getWriter().print("<b>Oficial excluído com sucesso!<b>");
			resp.sendRedirect("ofcontroller.do?acao=listar");
		} else if (acao.equals("listar")) {
			
			// Implementar a lista
			OficialDAO oficialDAO = new OficialDAO();
			List<Oficial> lista = oficialDAO.buscarTodos();
			req.setAttribute("listaoficiais", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listaoficiais.jsp");
			dispatcher.forward(req, resp);
		} else if
		System.out.println("Chamou o GET!");
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String nome = req.getParameter("nome");
		String matricula = req.getParameter("matricula");
		
		Oficial oficial = new Oficial();
		oficial.setOf_nome(nome);
		oficial.setOf_matricula(matricula);
		
		OficialDAO oficialDAO = new OficialDAO();
		oficialDAO.cadastrar(oficial);
		
		resp.getWriter().print("<b>Oficial cadastrado com sucesso!<b>");
	}
}
