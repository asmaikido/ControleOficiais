package br.com.asm.controleoficiais.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.asm.controleoficiais.persistencia.entidade.Oficial;
import br.com.asm.controleoficiais.persistencia.jdbc.OficialDAO;

/**
 * Servlet implementation class AutenticadorController
 */
@WebServlet(name = "autcontroller.do", urlPatterns = {"/autcontroller.do"})
public class AutenticadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticadorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
	    if (sessao != null) {
	    	sessao.invalidate();
	    }
	    response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
        //resp.setContentType("text/html");
	    String acao = request.getParameter("acao");	
		String matricula = request.getParameter("matricula");
		String senha = request.getParameter("senha");
					
		if (acao.equals("autenticar")) {
		    Oficial oficial = new Oficial();
		    oficial.setOfMatricula(matricula);
		    oficial.setOfSenha(senha);
		    OficialDAO oficialDAO = new OficialDAO();
		    oficial = oficialDAO.autenticar(oficial);
		    if (oficial != null) {
		    	HttpSession sessao = request.getSession();
		    	sessao.setMaxInactiveInterval(3000);
				sessao.setAttribute("oficial", oficial);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("login.html");
			}	
		} 
		
		// doGet(request, response);
	}

}
