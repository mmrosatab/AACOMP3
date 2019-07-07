package mockobject;

import dominio.SolicitacaoMuseuMD;

public class SolicitacaoGatewayMock {
	
	public void inserir(SolicitacaoMuseuMD solicitacao)
	{
		System.out.println("Solicitacao " + solicitacao.getNome() + " " + "inserida");
	}

}
