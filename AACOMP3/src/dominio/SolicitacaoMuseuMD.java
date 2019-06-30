package dominio;

import mock_object.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.CpfInvalidoException;
import exception.DadosFaltandoException;
import exception.DadosUsuarioException;
import exception.SenhaInvalidaException;
import mock_object.CamadaDadosMock;
import net.bytebuddy.asm.Advice.This;
@WebServlet("/solicitarCriacaoMuseu")

public class SolicitacaoMuseuMD extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String dataCriacao;
	private String cidade;
	private String estado;
	private String nomeGestor;
	private String senhaGestor;
	private String cpfGestor;
	private static ArrayList <SolicitacaoMuseuMD> solicitacoes = new ArrayList<SolicitacaoMuseuMD>();
	
	public SolicitacaoMuseuMD(String nome, String data, String cid, String est, String nomeG, String cpf, String senha)
	{
		this.nome			= nome;
		this.dataCriacao 	= data;
		this.cidade 		= cid;
		this.estado 		= est;
		this.nomeGestor 	= nomeG;
		this.cpfGestor		= cpf;
		this.senhaGestor 	= senha;
	}
	
	public SolicitacaoMuseuMD()
	{
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getData() {
		return dataCriacao;
	}
	
	public boolean checarCpf()
	{
		ArrayList <Usuario> usuarios = CamadaDadosMock.buscarUsuarios();
		for(Usuario user:usuarios)
		{
			if(user.getCpf() == this.cpfGestor)
			{
				return true;
			}
		}
		return false;
	}

	private static void buscarSolicitacoes()
	{
		SolicitacaoFinderMock finder = new SolicitacaoFinderMock();
		solicitacoes 			 	 = finder.buscarTodos();
	}
	public static ArrayList <SolicitacaoMuseuMD> listarSolicitacoes()
	{
		buscarSolicitacoes();
		return solicitacoes;		
	}
	
	private void setarSolicitacao(String [] chave)
	{
		for(SolicitacaoMuseuMD solicitacao:solicitacoes)
		{
			if(chave.length == 2)
			{
				try
				{
					if(solicitacao.nome.equalsIgnoreCase(chave[1]) && solicitacao.dataCriacao.equalsIgnoreCase(chave[0]))
					{
						this.nome 		 = solicitacao.nome;
						this.dataCriacao = solicitacao.dataCriacao;
						this.cidade 	 = solicitacao.cidade;
						this.estado 	 = solicitacao.estado;
						this.nomeGestor  = solicitacao.nomeGestor;
						this.senhaGestor = solicitacao.senhaGestor;
						this.cpfGestor 	 = solicitacao.cpfGestor;
					}
				}
				catch(NullPointerException e)
				{
					this.nome 		 = solicitacao.nome;
					this.dataCriacao = solicitacao.dataCriacao;
					this.cidade 	 = solicitacao.cidade;
					this.estado 	 = solicitacao.estado;
					this.nomeGestor  = solicitacao.nomeGestor;
					this.senhaGestor = solicitacao.senhaGestor;
					this.cpfGestor 	 = solicitacao.cpfGestor;
				}
				
			}			
		}
	}
	
	private void verificarDadosSolicitacao(String nome, String data, String cidade, String nomeG, String cpf) throws DadosFaltandoException
	{
		if(nome == null || data == null || cidade == null || nomeG == null || cpf == null)
		{
			throw new DadosFaltandoException("Ausência de dados da solicitacao");
		}
		if(nome.isEmpty() || data.isEmpty() || cidade.isEmpty() || nomeG.isEmpty() || cpf.isEmpty())
		{
			throw new DadosFaltandoException("Ausência de dados da solicitacao.");
		}
		if(nome.equalsIgnoreCase(" ") || data.equalsIgnoreCase(" ") ||
				cidade.equalsIgnoreCase(" ") || nomeG.equalsIgnoreCase(" ") || cpf.equalsIgnoreCase(" "))
		{
			throw new DadosFaltandoException("Ausência de dados da solicitacao.");
		}
	}
	
	private void verificarDadosUsuario(String nome, String senha) throws DadosUsuarioException, SenhaInvalidaException
	{
		if(nome == null || senha == null)
		{
			throw new DadosUsuarioException();
		}
		if(nome.isEmpty() || senha.isEmpty())
		{
			throw new DadosUsuarioException();
		}
		if(nome.equalsIgnoreCase(" ") || senha.equalsIgnoreCase(" "))
		{
			throw new DadosUsuarioException();
		}
		if(!ehValida(senha))
		{
			throw new SenhaInvalidaException();
		}
	}
	
	private boolean ehValida(String senha)
	{
		if(senha.length() != 6)
		{
			return false;
		}
		for(int i=0; i < senha.length(); i++)
		{
			if(senha.charAt(i) == '.' || senha.charAt(i) == '/' || senha.charAt(i) == '\\' ||
					senha.charAt(i) == ';' || senha.charAt(i) == '@' || senha.charAt(i) == '#' ||
					senha.charAt(i) == '$' || senha.charAt(i) == '%' || senha.charAt(i) == '*' ||
					senha.charAt(i) == '(' || senha.charAt(i) == ')' || senha.charAt(i) == '!' || senha.charAt(i) == '?')
			{
				return false;
			}
		}
		return true;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String teste = request.getParameter("cmd");
		
		if(teste.equalsIgnoreCase("ok"))
		{
			String sol 	   = request.getParameter("opcoes");
			String [] data = sol.split("-");
			setarSolicitacao(data);
			
			request.setAttribute("meu_nome", this.nome);
			request.setAttribute("dataCriacao", this.dataCriacao);
			request.setAttribute("cidade", this.cidade);
			request.setAttribute("cpf", this.cpfGestor);
			request.setAttribute("nomeGestor", this.nomeGestor);
			request.getRequestDispatcher("CriarMuseu.jsp").forward(request, response);
		}
		
		if(teste.equalsIgnoreCase("criar museu"))
		{
			/* VERIFICAR DADOS DA SOLICITACAO */
			try
			{
				verificarDadosSolicitacao(this.nome, this.dataCriacao, this.cidade, this.nomeGestor, this.cpfGestor);
				try
				{
					Cpf.validar(this.cpfGestor);
					verificarDadosUsuario(this.nomeGestor, this.cpfGestor);
				}
				catch(CpfInvalidoException e)
				{
					System.out.println("A exceção funcionou! O cpf é inválido!");
				} catch (DadosUsuarioException e) {
					System.out.println("Nome ou senha faltando.");
				} catch (SenhaInvalidaException e) {
					System.out.println("Senha inválida!");
				}
			}
			catch(DadosFaltandoException e)
			{
				System.out.println("A exceção funcionou! Preencha os campos!");
			}
			
			response.sendRedirect("CriarMuseu.jsp");
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{

	}

}
