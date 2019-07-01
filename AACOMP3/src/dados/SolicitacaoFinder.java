package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.SolicitacaoMuseuMD;

public class SolicitacaoFinder 
{
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_URL = "jdbc:derby:/home/andressa/MyDB;create=true";
	
	private Connection conn;
	private Statement stm;
	
	public SolicitacaoFinder() throws ClassNotFoundException 
	{
		Class.forName(DRIVER);
	}

	public SolicitacaoMuseuMD buscar(String nome, String dataCriacao)
	{
	
		String query =
		         "select nome, dataCriacao, cpf, cidade, estado, nomeGestor, senhaGestor "
		         + "from museuEsquema.solicitacao" +
		         "  where nome =" + "'"+ nome +"'"+"AND dataCriacao ="+"'"+ dataCriacao +"'";
		try 
		{	
		
			this.conn 			  = DriverManager.getConnection(JDBC_URL);
			SolicitacaoMuseuMD us = null;
			if (this.conn != null) 
			{
				System.out.println("Connectado com sucesso");
				this.stm = conn.createStatement();
				
				ResultSet res = this.stm.executeQuery(query);
				
				res.next();
				
				us = new SolicitacaoMuseuMD(res.getString(1),
						res.getString(2),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getString(3),
						res.getString(7));
						res.close();
			}
			
			this.conn.close();
            this.stm.close();
			
			return us;
		
		} catch (SQLException e) 
		{
			System.out.println("Erro ao conectar com o banco de dados.");
		}
		return null;
	}
	
	public ArrayList<SolicitacaoMuseuMD> buscarTodos() 
	{
		
		String query = "select * from museuEsquema.solicitacao";
		
		try 
		{	
		
			this.conn 			  = DriverManager.getConnection(JDBC_URL);
			SolicitacaoMuseuMD us = null;
			ArrayList<SolicitacaoMuseuMD > solicitacoes = null;
			
			if (this.conn != null) 
			{
				System.out.println("Connectado com sucesso");
				
				this.stm = conn.createStatement();
				
				ResultSet res = this.stm.executeQuery(query);
				solicitacoes  = new ArrayList<SolicitacaoMuseuMD>();

				 while(res.next())
		         {
					 us = new SolicitacaoMuseuMD(res.getString(1),
								res.getString(2),
								res.getString(4),
								res.getString(5),
								res.getString(6),
								res.getString(3),
								res.getString(7));
					 
					 solicitacoes.add(us);
		         }
				 res.close();
			}
				
		   this.conn.close();
           this.stm.close();
           return solicitacoes;
			
		} catch (SQLException e) 
		{
			 System.out.println("Erro ao conectar com o banco de dados.");
		}
		return null;
	
	}
	
}
