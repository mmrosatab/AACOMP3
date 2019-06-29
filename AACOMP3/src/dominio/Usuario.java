package dominio;

public abstract class Usuario {
	private String nome;
	private String cpf;
	private String senha;
	
	public Usuario(String nome, String cpf, String senha)
	{
		this.nome 	= nome;
		this.cpf 	= cpf;
		this.senha 	= senha;
	}
	
	protected String getNome()
	{
		return this.nome;
	}
	
	protected String getCpf()
	{
		return this.cpf;
	}
	
	protected String getSenha()
	{
		return this.senha;
	}
	
	protected abstract void dizerQuemSou();
}
