package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dominio.SolicitacaoMuseuMD;

public class SolicitacaoGateway 
{
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_URL = "jdbc:derby:/home/mmrosa/MyDB2;create=true";
	//private static final String JDBC_URL = "jdbc:derby:/home/andressa/MyDB;create=true";
	private Connection conn;
	
	private String nome;
	private String dataCriacao;
	private String cidade;
	private String estado;
	private String nomeGestor;
	private String senhaGestor;
	private String cpfGestor;
	
	
	public SolicitacaoGateway(String nome, String dataCriacao, String cpf, String cidade, String estado,
			String nomeGestor, String senhaGestor)
	
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) 
		{
			System.out.println("Erro com DRIVER no banco de dados.");
		}
		
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.cpfGestor = cpf;
		this.cidade = cidade;
		this.estado = estado;
		this.nomeGestor = nomeGestor;
		this.senhaGestor = senhaGestor;
		
	}
    
	public String getNome() 
	{
		return nome;
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

	public String getSenhaGestor() 
	{
		return senhaGestor;
	}

	public String getCpfGestor() 
	{
		return cpfGestor;
	}
	
	public String getNomeGestor()
	{
		return nomeGestor;
	}

	public void inserir()
	{
		
		try 
		{	
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) 
			{
				String query = "insert into museuEsquema.solicitacao"
						+ "(nome,dataCriacao,cpf,cidade,estado,nomeGestor, senhaGestor) values (?,?,?,?,?,?,?)";
				
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, this.nome);
				ps.setString(2, this.dataCriacao);
				ps.setString(3, this.cpfGestor);
				ps.setString(4, this.cidade);
				ps.setString(5, this.estado);
				ps.setString(6, this.nomeGestor);
				ps.setString(7, this.senhaGestor);
				
				ps.executeUpdate();
			}
			
			this.conn.close();
			
			
		} catch (SQLException e) 
		{
			 System.out.println("Erro ao conectar com o banco de dados");
		}
		finally
		{
			try {
				this.conn.close();
			} catch (SQLException e) {
				System.out.println("Não foi possível encerrar a conexão com o banco de dados.");
			}
			
		}
	}
	
	public void atualizar(String nomeBusca, String dataCriacaoBusca, String cpf, String cidade, String estado,
			String nomeGestor, String senhaGestor)
	{
		try 
		{	
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) 
			{
				String query = "update museuEsquema.solicitacao set nome = ?, dataCriacao = ?,"
						+ " cpf = ?, cidade = ?, estado = ?, nomeGestor = ?, senhaGestor = ?  where nome = "+"'"+ nomeBusca +"'" + "and dataCriacao = " + "'"+dataCriacaoBusca+"'"; 
				
				PreparedStatement ps = this.conn.prepareStatement(query);
				
				ps.setString(1, nomeBusca);
				ps.setString(2, dataCriacaoBusca);
				ps.setString(3, cpf);
				ps.setString(4, cidade);
				ps.setString(5, estado);
				ps.setString(6, nomeGestor);
				ps.setString(7, senhaGestor);
				
				ps.executeUpdate();
				
			}
			this.conn.close();
			
		} catch (SQLException e) 
		{
			 System.out.println("Erro ao conectar com o banco de dados");
		}
		finally
		{
			try {
				this.conn.close();
			} catch (SQLException e) {
				System.out.println("Não foi possível encerrar a conexão com o banco de dados.");
			}
			
		}
	}
	
	public void deletar(String nome, String dataCriacao)
	{
		try 
		{	
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) 
			{
				String query = "delete from museuEsquema.solicitacao "
						+ "where nome = "+"'"+ nome +"'"+"and dataCriacao =" +"'"+ dataCriacao+"'"; 
				
				PreparedStatement ps = this.conn.prepareStatement(query);
				ps.executeUpdate();
				
			}
			this.conn.close();
			
		} catch (SQLException e) 
		{
			System.out.println("Erro ao conectar com o banco de dados");
		}
		finally
		{
			try {
				this.conn.close();
			} catch (SQLException e) {
				System.out.println("Não foi possível encerrar a conexão com o banco de dados.");
			}
			
		}
	}
}
