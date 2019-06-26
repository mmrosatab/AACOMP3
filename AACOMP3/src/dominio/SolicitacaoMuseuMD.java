package dominio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EfetuarEmprestimoRT
 */
@WebServlet("/solicitarCriacaoMuseu")
public class SolicitacaoMuseuMD extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.getRequestDispatcher("InformeSolicitacao.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String cmd = (String) request.getParameter("cmd");
		if (cmd == null) {
			doGet(request,response);
		} else {
			int idLeitor;
			
			try {
				idLeitor = (Integer) request.getSession().getAttribute("idLeitor");
			}catch (NullPointerException e) {
				try {
					idLeitor = Integer.parseInt(request.getParameter("idLeitor"));
				}catch (NumberFormatException e1) {
					idLeitor = -1;
					request.getRequestDispatcher("LeitorNaoInformado.jsp").forward(request, response);
				}
			}

			if (!response.isCommitted())
			{
				try 
				{
		
					switch (cmd) 
					{
						case "Iniciar Solicitacao":
	
							//request.setAttribute("situacaoLeitor", st);
							//request.getSession().setAttribute("idLeitor", idLeitor);
							//request.getRequestDispatcher("InformeLivro.jsp").forward(request, response);
							break;
						
						default:
							doGet(request,response);
							break;
					} 
				} catch (LeitorNaoExisteException e) 
				{
					request.getRequestDispatcher("LeitorNaoExiste.jsp").forward(request, response);	
				} 
			}
			
		}
		*/
	}

}
