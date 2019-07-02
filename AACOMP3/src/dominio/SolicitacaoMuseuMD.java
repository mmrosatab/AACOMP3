package dominio;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.SolicitacaoFinder;
import dados.UsuarioFinder;
import dados.UsuarioGateway;
import dados.SolicitacaoGateway;
import dominio.exception.CpfInvalidoException;
import dominio.exception.DadosFaltandoException;
import dominio.exception.DadosUsuarioException;
import dominio.exception.GestorException;
import dominio.exception.SenhaInvalidaException;
import dominio.exception.UsuarioAssociadoException;
import mockobject.CamadaDadosMock;
import mockobject.SolicitacaoFinderMock;
import mockobject.SolicitacaoGatewayMock;
import mockobject.UsuarioGatewayMock;
import util.Cpf;
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
		
	
	public String getDataCriacao() {
		return dataCriacao;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getSenhaGestor() {
		return senhaGestor;
	}

	public String getCpfGestor() {
		return cpfGestor;
	}

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
		return this.nome;
	}
	
	public String getData() {
		return this.dataCriacao;
	}
	
	public void checarCpf() throws  GestorException, UsuarioAssociadoException
	{
		UsuarioFinder us = new UsuarioFinder();
		ArrayList <Usuario> usuarios = us.buscarTodos();
		for(Usuario user:usuarios)
		{
			if(user.getCpf() == this.cpfGestor)
			{
				if(user.getClass().getName().equalsIgnoreCase("dominio.Gestor"))
				{
					System.out.println(user.getClass().getName() + " " +user.getCpf());
					throw new GestorException();
				}

				else
				{
					throw new UsuarioAssociadoException();
				}
			}
		}
	}

	private static void buscarSolicitacoes()
	{
		SolicitacaoFinder finder = new SolicitacaoFinder();
		solicitacoes 			 = finder.buscarTodos();
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
			System.out.println("Tô setando a solicitacao!");
			System.out.println("solicitacao " + solicitacao.getNome());
			System.out.println("Tamanho da chave é: " + chave.length);
	
			if(chave.length == 2)
			{
				try
				{
					if(solicitacao.nome.equalsIgnoreCase(chave[1]) && solicitacao.dataCriacao.equalsIgnoreCase(chave[0]))
					{
						System.out.println("entrei no if");
						
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
					System.out.println("Tô setando a solicitacao");
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
			System.out.println("tamanho = "+ senha.length());
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
		
		if(teste.equalsIgnoreCase("Iniciar Solicitacao"))
		{
			System.out.println("Vou criar a solicitacao e tentar inserir, tô no doPost");
			
			SolicitacaoMuseuMD mySolicitacao = new SolicitacaoMuseuMD(request.getParameter("nome"),
					request.getParameter("dataCriacao"),request.getParameter("cidade"),
					request.getParameter("estado"),request.getParameter("nomeGestor"),
					request.getParameter("cpf"),request.getParameter("senhaGestor"));
			
			SolicitacaoGateway us = new SolicitacaoGateway();
			us.inserir(mySolicitacao);
			
			request.getRequestDispatcher("ListarOpcoes.jsp").forward(request, response);
		}
		
		if(teste.equalsIgnoreCase("ok"))
		{
			String sol 	   = request.getParameter("opcoes");
			String [] data = sol.split("_");
			System.out.println(sol);
			setarSolicitacao(data);
			
			request.setAttribute("meu_nome", this.nome);
			System.out.println("No servlet meu_nome =" + this.nome);
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
					verificarDadosUsuario(this.nomeGestor, this.senhaGestor);
					checarCpf();
					System.out.println("gestor novo");
				
					/* CRIAR GESTOR, CRIAR MUSEU, E ADD GESTOR AO MUSEU E DEPOIS INSERIR NO BANCO */
					
					Gestor gestor 			= new Gestor(this.nomeGestor, this.cpfGestor, this.senhaGestor);
					MuseuMD meuMuseu 		= new MuseuMD(this.nome, this.dataCriacao, this.cidade, this.estado, gestor);
					UsuarioGateway gateway 	= new UsuarioGateway();
					gateway.inserir(meuMuseu);
					response.sendRedirect("DiaFeliz.jsp");
				}
				catch(CpfInvalidoException e)
				{
					System.out.println("Cpf é inválido!");
					
				} catch (DadosUsuarioException e)
				{
					System.out.println("Nome ou senha faltando.");
					
				} catch (SenhaInvalidaException e)
				{
					System.out.println("Senha inválida!");
				}
				catch(GestorException e)
				{
					System.out.println("O usuário já é um gestor.");
				}
				catch(UsuarioAssociadoException e)
				{
					/* TROCAR TIPO DO USUÁRIO PRA GESTOR */
					
					System.out.println("Usuario associado");
					
					UsuarioGateway gateway 	  = new UsuarioGateway();
					Gestor gt 		      	  = new Gestor(this.nomeGestor, this.cpfGestor, this.senhaGestor);
					gateway.atualizar(this.cpfGestor, 0);
					
					MuseuMD meuMuseu = new MuseuMD(this.nome, this.dataCriacao, this.cidade, this.estado, gt);
	
					gateway.inserir(meuMuseu);
					response.sendRedirect("DiaFeliz.jsp");
				}
			}
			catch(DadosFaltandoException e)
			{
				System.out.println("A exceção funcionou! Preencha os campos!");
				response.sendRedirect("CriarMuseu.jsp");
			}	
		}	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{

	}

}