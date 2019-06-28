package dominio;

import java.util.Date;

public class MuseuMD {
	private String nome;
	private Date dataCriacao;
	private String cidade;
	private Gestor gestor;
	
	public MuseuMD(String nome, Date dataCriacao, String cidade, Gestor gt)
	{
		this.gestor = gt;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public Date getDataCriacao()
	{
		return this.dataCriacao;
	}
	
	public String cidade()
	{
		return this.cidade;
	}
	
	public Gestor getGestor()
	{
		return this.gestor;
	}

}
