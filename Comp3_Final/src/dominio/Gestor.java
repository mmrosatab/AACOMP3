package dominio;

public class Gestor extends Funcionario {
	
	public Gestor (String nome, String cpf, String senha)
	{
		super(nome, cpf, senha);
	}

	@Override
	public void dizerQuemSou() {
		// TODO Auto-generated method stub
		System.out.println("Olá, eu sou um gestor!");
		
	}

	


}
