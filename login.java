package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String USUARIO = "usuario";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	     PrintWriter resposta = response.getWriter();
	       resposta.write("<html><body>");
	       String nomeUsuario = request.getParameter(USUARIO);
	       String senhaUsuario = request.getParameter("senha");
	       
	 

	       if (autenticar(nomeUsuario, senhaUsuario)) {
	              HttpSession sessao = request.getSession();
	              sessao.setAttribute(USUARIO, nomeUsuario);
	              resposta.write("Bem vindo, " + nomeUsuario);
	              
	              resposta.write("<html>");
	              resposta.write("<head>");
	              resposta.write("<title>Dados Profissionais</title>");
	              resposta.write("</head>");
	              resposta.write("<body>");
	              resposta.write("<BR><Preencha seus dados profissionais:");
	              resposta.write("<form action=\"atividade1\">");
	              resposta.write("Empresa:<input type=\"hiden\" name=\"empresa\"> <BR>");
	              resposta.write("Endereço profissional:<BR>");
	              resposta.write("Rua: <input type=\"hiden\" name=\"ruaEmpresa\">");
	              resposta.write("Complemento:<input type=\"text\" name=\"complementoEmpresa\"><BR>");
	              resposta.write("Cidade:<input type=\"text\" name=\"cidadeEmpresa\">");
	              resposta.write("CEP:<input type=\"text\" name=\"cepEmpresa\">");
	              resposta.write("Estado:<input type=\"text\" name=\"estadoEmpresa\"><BR>");
	              resposta.write("<input type=\"submit\" value=\"Confirmar\"><BR>");
	              resposta.write("</form>");
	              resposta.write("</body></html>");
	           
	       } else {
	              resposta.write("Usuário e senha inválidos");
	       }
	       resposta.write("</body></html>");
	}
	
	private boolean autenticar(String nomeUsuario, String senhaUsuario) {
	       
	       return !("".equals(nomeUsuario) || "".equals(senhaUsuario)
	                     || nomeUsuario == null || senhaUsuario == null);
	}

    
}
