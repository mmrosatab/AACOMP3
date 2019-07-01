package mockobject;

import dominio.SolicitacaoMuseuMD;

public class SolicitacaoGateway {
	
	public void inserir(SolicitacaoMuseuMD solicitacao)
	{
		System.out.println("Solicitacao " + solicitacao.getNome() + " " + "inserida");
	}

}
