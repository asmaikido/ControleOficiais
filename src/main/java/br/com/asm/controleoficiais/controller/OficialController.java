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
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void destroy() {
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
			
		} else if (acao.equals("alterar")) {
			
			String matricula = req.getParameter("matricula");
			OficialDAO oficialDAO = new OficialDAO();
			Oficial oficial = oficialDAO.buscarPorMatricula(matricula);
			req.setAttribute("oficial", oficial);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formoficial.jsp");
			dispatcher.forward(req, resp);
			
		}		
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//resp.setContentType("text/html");
		String acao = req.getParameter("acao");	
		String matricula = req.getParameter("matricula");
		String nome = req.getParameter("nome");
		String senha = req.getParameter("senha");
			
		if (acao.equals("autenticar")) {
			Oficial oficial = new Oficial();
			oficial.setOf_matricula(matricula);
			oficial.setOf_senha(senha);
			OficialDAO oficialDAO = new OficialDAO();
			oficial = oficialDAO.autenticar(oficial);
			if (oficial != null) {
				resp.sendRedirect("ofcontroller.do?acao=listar");
			} else {
				req.setAttribute("oficial", oficial);
				RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formcadoficial.jsp");
				dispatcher.forward(req, resp);
			}	
		} else if (acao.equals("cadastrar")) {
			Oficial oficial = new Oficial();
			oficial.setOf_matricula(matricula);
			oficial.setOf_nome(nome);
			oficial.setOf_senha(senha);
			OficialDAO oficialDAO = new OficialDAO();
			oficialDAO.cadastrar(oficial);
			resp.sendRedirect("login.html");
		} 
				
		//Oficial oficial = new Oficial();
		//oficial.setOf_nome(nome);
		//oficial.setOf_matricula(matricula);
		
		//OficialDAO oficialDAO = new OficialDAO();
		//oficialDAO.salvar(oficial);
		
		//resp.getWriter().print("<b>Oficial cadastrado com sucesso!<b>");
	}
}
