package mockobject;
import java.util.ArrayList;
import java.util.Date;
import dominio.*;
public class CamdaApresentacaoMock {
	
	public boolean criarUsuario(String nome, String cpf, String senha)
	{
		// Criar uma exception pra isso
		//Cpf.validar(cpf);
		
		return true;
	}

	public void confirmarCriacao()
	{
		Date data 			   = new Date(28062019);
		SolicitacaoMuseuMD sol = new SolicitacaoMuseuMD();
		//sol.checarCpf();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
