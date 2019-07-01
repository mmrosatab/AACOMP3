package apresentacao;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.UsuarioFinder;
import dominio.Usuario;

/**
 * Servlet implementation class Index
 */

@WebServlet("/index")
public class Index extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");

	    if (cpf.isEmpty()|| senha.isEmpty()) 
	    {
	        System.out.println("Todos os campos devem ser preenchidos");
	        response.sendRedirect("index.jsp");
	        
        }else
        {	
        	
        	Usuario user = null;
        	ArrayList<Usuario> usuarios;  	
        	boolean macth = false;
			UsuarioFinder usuarioFinder = new UsuarioFinder();
			
			usuarios = usuarioFinder.buscarTodos();
			
			System.out.println(usuarios.get(0).getNome());
			
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
				// TODO: handle exception
				System.out.println("Usuario não encontrado");
			}
			
			if (macth)
			{
				response.sendRedirect("ListarOpcoes.jsp");
			
			}else
			{
				System.out.println("Voce não esta cadastrado no sistema");
				response.sendRedirect("index.jsp");
			}
 
        }
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{

	}
	
}
