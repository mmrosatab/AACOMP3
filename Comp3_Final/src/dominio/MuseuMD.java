package dominio;

import java.util.Date;

public class MuseuMD {
	private String nome;
	private String dataCriacao;
	private String cidade;
	private String estado;
	private Gestor gestor;
	
	public MuseuMD(String nome, String dataCriacao, String cidade, String estado, Gestor gt)
	{
		this.nome 		 = nome;
		this.dataCriacao = dataCriacao;
		this.cidade 	 = cidade;
		this.estado		 = estado;
		this.gestor 	 = gt;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public String getDataCriacao()
	{
		return this.dataCriacao;
	}
	
	public String getCidade()
	{
		return this.cidade;
	}
	public String getEstado()
	{
		return this.estado;
	}
	
	public Gestor getGestor()
	{
		return this.gestor;
	}

}
