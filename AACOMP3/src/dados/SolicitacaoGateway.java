package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dominio.SolicitacaoMuseuMD;

public class SolicitacaoGateway 
{
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_URL = "jdbc:derby:/home/andressa/MyDB;create=true";
	private Connection conn;
	
	public SolicitacaoGateway()
	
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro com DRIVER no banco de dados.");
		}
	}
    
	public void inserir(SolicitacaoMuseuMD solicitacao)
	{
		
		try 
		{	
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) 
			{
				String query = "insert into museuEsquema.solicitacao"
						+ "(nome,dataCriacao,cpf,cidade,estado,nomeGestor, senhaGestor) values (?,?,?,?,?,?,?)";
				
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, solicitacao.getNome());
				ps.setString(2, solicitacao.getData());
				ps.setString(3, solicitacao.getCpfGestor());
				ps.setString(4, solicitacao.getCidade());
				ps.setString(5, solicitacao.getEstado());
				ps.setString(6, solicitacao.getCpfGestor());
				ps.setString(7, solicitacao.getSenhaGestor());
				
				ps.executeUpdate();
			}
			
			this.conn.close();
			
			
		} catch (SQLException e) 
		{
			 System.out.println("Erro ao conectar com o banco de dados");
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
	}
}
