package apresentacao;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.FachadaDados;
import dados.UsuarioFinder;
import dominio.Usuario;
import util.Funcao;

/**
 * Servlet implementation class Index
 */

@WebServlet("/index")
public class Index extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static String nome;
	public static String funcao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cpf 	 = request.getParameter("cpf");
        String senha = request.getParameter("senha");

        if (cpf.isEmpty()|| senha.isEmpty()) 
	    {
	        request.setAttribute("mensagem", "Todos os campos devem ser preenchidos.");
			request.getRequestDispatcher("Erro.jsp").forward(request, response);
	        
        }else
        {	
        	
        	Usuario user = null;
        	ArrayList<Usuario> usuarios;  	
        	boolean macth = false;
	
			usuarios = FachadaDados.buscarUsuarios();
			
			try {
				
				for (Usuario us : usuarios) 
	        	{
					if(us.getCpf().equalsIgnoreCase(cpf) && us.getSenha().equalsIgnoreCase(senha))
					{
						user = us;
						macth = true;
						break;
					}
				}
				
			} catch (NullPointerException e) {
				
			
				request.setAttribute("mensagem", "Usuário não encontrado.");
				request.getRequestDispatcher("Erro.jsp").forward(request, response);
			}
			
			if(macth)
			{
				Index.nome 	 = user.getNome();
				Index.funcao = Funcao.funcao(user);
				request.setAttribute("nome", user.getNome());
				request.setAttribute("funcao", Funcao.funcao(user));
				request.getRequestDispatcher("ListarOpcoes.jsp").forward(request, response);
			
			}else
			{
			
				request.setAttribute("mensagem", "Você não está cadastrado no sistema!");
				request.getRequestDispatcher("Erro.jsp").forward(request, response);
			}
        }
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{

	}
	
}
