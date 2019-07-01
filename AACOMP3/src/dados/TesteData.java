package dados;

import java.util.ArrayList;
import java.util.Iterator;

import dominio.Administrador;
import dominio.Gestor;
import dominio.MuseuMD;
import dominio.SolicitacaoMuseuMD;
import dominio.Usuario;

public class TesteData 
{
	public static void main(String[] args) throws ClassNotFoundException 
	{	
		
		/* Inserir Usuario */
		
		/*
		UsuarioGateway ug = new UsuarioGateway();
		Usuario u = new Administrador("Joana Dark","19793524097","jona10");
		ug.inserir(u, 0);
		*/
		
		/* Inserir solicitacao */
		
		/*
		SolicitacaoGateway sg = new SolicitacaoGateway();
		SolicitacaoMuseuMD smd = new SolicitacaoMuseuMD("", "", "", "", "", "", "");
		sg.inserir(smd);
		*/
		
		/* Buscar usuarios */
		
		
		UsuarioFinder uf = new UsuarioFinder();
		ArrayList<Usuario> usuarios = uf.buscarTodos();
		
		for(Usuario us: usuarios)
		{
			System.out.println(us.getNome());
		}
		
		
		/* Buscar solicitacoes */
		
		/*
		SolicitacaoFinder sf = new SolicitacaoFinder();
		ArrayList<SolicitacaoMuseuMD> solicitacoes = sf.buscarTodos();
		
		for(SolicitacaoMuseuMD s: solicitacoes)
		{
			System.out.println(s.getNome());
		}
		*/	
	}
}
