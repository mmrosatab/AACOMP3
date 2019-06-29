package dominio;

public class Administrador extends Usuario{

	public Administrador (String nome, String cpf, String senha)
	{
		super(nome, cpf, senha);
	}

	@Override
	protected void dizerQuemSou() {
		// TODO Auto-generated method stub
		System.out.println("Olá, sou um Admin");
		
	}
}
