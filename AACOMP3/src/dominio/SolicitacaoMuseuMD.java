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

import mock_object.CamadaDadosMock;
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
	
	public String getCidade()
	{
		return cidade;
	}
	public String getEstado()
	{
		return estado;
	}
	public String getNomeGestor()
	{
		return nomeGestor;
	}
	public String getCpfGestor()
	{
		return cpfGestor;
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String sol 	   = request.getParameter("opcoes");
		System.out.println(sol);
		String [] data = sol.split("-");
		
		for(SolicitacaoMuseuMD solicitacao:solicitacoes)
		{
			if(solicitacao.nome.equalsIgnoreCase(data[1]) && solicitacao.dataCriacao.equalsIgnoreCase(data[0]))
			{
				System.out.println("ifao");
				this.nome 		 = solicitacao.nome;
				this.dataCriacao = solicitacao.dataCriacao;
				this.cidade 	 = solicitacao.cidade;
				this.estado 	 = solicitacao.estado;
				this.nomeGestor  = solicitacao.nomeGestor;
				this.senhaGestor = solicitacao.senhaGestor;
				this.cpfGestor 	 = solicitacao.cpfGestor;
				System.out.println(this.cpfGestor);
			}
		}
		
		System.out.println("Há usuário associado? " +checarCpf());		
	}

}
