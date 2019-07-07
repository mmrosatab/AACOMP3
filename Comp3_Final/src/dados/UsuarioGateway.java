package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dominio.MuseuMD;
import dominio.Usuario;

public class UsuarioGateway 
{
	
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_URL = "jdbc:derby:/home/mmrosa/MyDB2;create=true";
	//private static final String JDBC_URL = "jdbc:derby:/home/andressa/MyDB;create=true";
	private Connection conn;
	
	private String cpf;
	private String nome;
	private String senha;
	private int tipo; 
	private String nomeMu; 
	private String dataCriacao; 
	private String cidade; 
	private String estado;
	
	public UsuarioGateway()
	{
		
	}
			
	public UsuarioGateway(String cpf, String nome, String senha, int tipo, String nomeMu, 
			String dataCriacao, String cidade, String estado)
	
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) 
		{
			System.out.println("Erro com DRIVER no banco de dados.");
		}
		
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
		this.tipo = tipo;
		this.nomeMu = nomeMu;
		this.dataCriacao = dataCriacao;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getCpf() 
	{
		return cpf;
	}


	public String getNome() 
	{
		return nome;
	}


	public String getSenha() 
	{
		return senha;
	}


	public int getTipo() 
	{
		return tipo;
	}

	public String getNomeMu() 
	{
		return nomeMu;
	}

	public String getDataCriacao() 
	{
		return dataCriacao;
	}

	public String getCidade() 
	{
		return cidade;
	}

	public String getEstado() 
	{
		return estado;
	}

	
	public void inserir()
	{
		try 
		{	
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) 
			{
				String query = "insert into museuEsquema.usuario "
						+ "(cpf,nome,senha,tipo,nomeMu,dataCriacao,cidade,estado) values (?,?,?,?,?,?,?,?)";
				
				PreparedStatement ps = this.conn.prepareStatement(query);
				
				ps.setString(1, this.cpf);
				ps.setString(2, this.nome);
				ps.setString(3, this.senha);
				ps.setInt(4, this.tipo);
				ps.setString(5, this.nomeMu);
				ps.setString(6, this.dataCriacao);
				ps.setString(7, this.cidade);
				ps.setString(8, this.estado);
				ps.executeUpdate();
			}
			
			this.conn.close();		
			
		} catch (SQLException e) 
		{
			 System.out.println("Erro ao conectar com o banco de dados.");
			 e.printStackTrace();
		}
		finally
		{
			try {
				this.conn.close();
			} catch (SQLException e) 
			{
				System.out.println("Não foi possível encerrar a conexão com o banco de dados.");
			}
			
		}
	}

	public void atualizar(String cpfBusca, int tipo)
	{
		try 
		{	
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) 
			{
				String query = "update museuEsquema.usuario set tipo = ? where cpf = "+"'"+ cpfBusca +"'"; 
				
				PreparedStatement ps = this.conn.prepareStatement(query);
				ps.setInt(1, tipo);
				ps.executeUpdate();
			}
			this.conn.close();
			
		} catch (SQLException e) 
		{
			 System.out.println("Erro ao conectar com o banco de dados.");
		}
		finally
		{
			try {
				this.conn.close();
			} catch (SQLException e) 
			{
				System.out.println("Não foi possível encerrar a conexão com o banco de dados.");
			}
			
		}
	}
	
	
	public void deletar(String cpfBusca)
	{
		try 
		{	
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) 
			{
				String query = "delete from museuEsquema.usuario where cpf = "+"'"+ cpfBusca +"'"; 
				
				PreparedStatement ps = this.conn.prepareStatement(query);
				ps.executeUpdate();
			}
			this.conn.close();
			
		} catch (SQLException e) 
		{
			 System.out.println("Erro ao conectar com o banco de dados.");
		}
		finally
		{
			try {
				this.conn.close();
			} catch (SQLException e) 
			{
				System.out.println("Não foi possível encerrar a conexão com o banco de dados.");
			}
			
		}
	}

}
