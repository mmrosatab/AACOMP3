package dados;

import java.util.ArrayList;

import dominio.Administrador;
import dominio.Gestor;
import dominio.MuseuMD;
import dominio.SolicitacaoMuseuMD;
import dominio.Usuario;

public class FachadaDados 
{
	public static void alterarTipo(String cpf, int tipo)
	{

		UsuarioGateway ug = new UsuarioGateway();
		ug.atualizar(cpf, tipo);
	}
	
	public static void armazenar(Usuario usuario)
	{
		int tipo = 2;
		
		if(usuario.getClass().getName().equalsIgnoreCase("dominio.gestor"))
		{
			tipo = 0;
		}
		UsuarioGateway ug = new UsuarioGateway(usuario.getCpf(), usuario.getNome(), usuario.getSenha(),
				tipo, null,null,null,null);
		ug.inserir();
		
	}
	
	public static ArrayList<SolicitacaoMuseuMD> buscarSolicitacoes()
	{
		SolicitacaoFinder uf = new SolicitacaoFinder();
		ArrayList<SolicitacaoMuseuMD> solicitacoes = new ArrayList<SolicitacaoMuseuMD>();
		
		for(SolicitacaoGateway sol: uf.buscarTodos())
		{
			SolicitacaoMuseuMD s = new SolicitacaoMuseuMD(sol.getNome(),sol.getDataCriacao(), sol.getCidade(),
					sol.getEstado(), sol.getNomeGestor(), sol.getCpfGestor(), sol.getSenhaGestor());
			
			solicitacoes.add(s);
		}
		
		/*
		
		for(SolicitacaoMuseuMD s: solicitacoes)
		{
			System.out.println(s.getNome());
		}
		*/
		
		return solicitacoes;
	}
	
	
	public static void armazenar(MuseuMD museu)
	{
		UsuarioGateway ug = new UsuarioGateway(museu.getGestor().getCpf(), museu.getGestor().getNome(),
				museu.getGestor().getSenha(),0, museu.getNome(), museu.getDataCriacao(),museu.getCidade(), museu.getEstado());
		
		ug.inserir();
	}
	
	public static void criarSolicitacao(String nome, String dataCriacao, String cpf, String cidade, String estado, String nomeGestor, String senhaGestor)
	{
		SolicitacaoGateway sg = new SolicitacaoGateway(nome, dataCriacao, cpf, cidade, estado, nomeGestor, senhaGestor);
		sg.inserir();
	}
	
	public static ArrayList<Usuario> buscarUsuarios()
	{
		UsuarioFinder uf = new UsuarioFinder();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		for(UsuarioGateway ug: uf.buscarTodos())
		{
			switch (ug.getTipo()) 
			{
				case 0:
					
					Gestor gestor = new Gestor(ug.getNome(),ug.getCpf(),ug.getSenha());
					usuarios.add(gestor);
					break;
				case 1:
					
					Administrador adm = new Administrador(ug.getNome(),ug.getCpf(),ug.getSenha());
					usuarios.add(adm);
					break;
	
				default:
					break;
			}
		}
		
		/*
		for(Usuario u: usuarios)
		{
			System.out.println(u.getNome());
		}
		*/
		
		return usuarios;
	}
	
	public static void main(String[] args) 
	{
		//FachadaDados.buscarUsuarios();
		//FachadaDados.buscarSolicitacoes();
		
		/* Passar o museu*/
		//Usuario usuario = new Gestor("Mayara","08424162005","333aaa");
		//FachadaDados.armazenar(usuario);
		
		/* se for gestor tem que passar o museu passar o museu*/
		/*
		Usuario usuario = new Gestor("Willian","20508021022","111aaa");
		FachadaDados.armazenar(usuario);
		*/
		
		//FachadaDados.alterarTipo("20508021022", 2);
		
		/*
		Gestor gestor = new Gestor("Mario","75411318068","zzz123");
		MuseuMD museu =  new MuseuMD("Museu da rural","01/01/2001","Seropedica","RJ",gestor);
		FachadaDados.armazenar(museu);
		*/
		/*
		FachadaDados.criarSolicitacao("Museu da pavuna",
				"20/07/1992", "16584682013", "Sao Joao", "RJ", "Otavio", "345kkk");*/
		
	}
	
}
