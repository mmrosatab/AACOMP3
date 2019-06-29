package mock_object;
import java.util.ArrayList;
import java.util.Date;

import dominio.SolicitacaoMuseuMD;

public class SolicitacaoFinderMock {
	
	public ArrayList<SolicitacaoMuseuMD> buscarTodos()
	{
		ArrayList<SolicitacaoMuseuMD> solicitacoes = new ArrayList<SolicitacaoMuseuMD>();
		
		SolicitacaoMuseuMD sol1 = new SolicitacaoMuseuMD("Andressa", "data1", "NI", "RJ", "Dudu", "14610164795", "ai.Quesenha");
		SolicitacaoMuseuMD sol2 = new SolicitacaoMuseuMD("Mayara", "data2", "NI", "SP", "Rex", "socor.ro", "11111111111");
		
		solicitacoes.add(sol1);
		solicitacoes.add(sol2);
		
		return solicitacoes;
		
	}

}
