package mockobject;
import java.util.ArrayList;
import java.util.Date;

import dominio.SolicitacaoMuseuMD;

public class SolicitacaoFinderMock {
	
	public ArrayList<SolicitacaoMuseuMD> buscarTodos()
	{
		ArrayList<SolicitacaoMuseuMD> solicitacoes = new ArrayList<SolicitacaoMuseuMD>();
		
		SolicitacaoMuseuMD sol1 = new SolicitacaoMuseuMD("Andressa", "data1", "NI", "RJ", "Dudu", "14610164795", "ai1234");
		SolicitacaoMuseuMD sol2 = new SolicitacaoMuseuMD("Mayara", "data2", "NI", "SP", "Rex", "11111111111", "socor.ro");
		
		solicitacoes.add(sol1);
		solicitacoes.add(sol2);
		
		return solicitacoes;
		
	}

}
