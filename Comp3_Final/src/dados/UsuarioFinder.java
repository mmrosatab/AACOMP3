package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioFinder 
{
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_URL = "jdbc:derby:/home/mmrosa/MyDB2;create=true";
	//private static final String JDBC_URL = "jdbc:derby:/home/andressa/MyDB;create=true";
	
	private Connection conn;
	private Statement stm;
	
	public UsuarioFinder()
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro com DRIVER no banco de dados.");
		}
	}

	public UsuarioGateway buscar(String cpf)
	{	
		String query =
		         "select cpf, nome, senha, tipo, nomeMu, dataCriacao, cidade, estado" +
		         "  from museuEsquema.usuario" +
		         "  where cpf =" + "'"+ cpf +"'" ;
		try 
		{	
		
			this.conn = DriverManager.getConnection(JDBC_URL);
			UsuarioGateway usuario = null;
			
			if (this.conn != null) 
			{
				System.out.println("Conectado com sucesso");
				this.stm = conn.createStatement();			
				ResultSet res = this.stm.executeQuery(query);
				
				res.next();
				
				usuario = new UsuarioGateway(res.getString(1),
						 res.getString(2),
						 res.getString(3),
						 res.getInt(4),
						 res.getString(5),
						 res.getString(6),
						 res.getString(7),
						 res.getString(8));
			
				res.close();
			}
			
			this.stm.close();			
			return usuario;
		
		} catch (SQLException e) 
		{
			 System.out.println("Erro ao conectar com o banco de dados.");
		}
		finally
		{
			try {
				this.conn.close();
			} catch (SQLException e) {
				System.out.println("Não foi possível encerrar a conexão com o banco de dados.");
			}
			
		}
		return null;
		
	}
	
	public ArrayList<UsuarioGateway> buscarTodos() 
	{
		
		String query = "select * from museuEsquema.usuario";
		
		try 
		{	
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			ArrayList<UsuarioGateway> usuarios = new ArrayList<UsuarioGateway>();
			
			if (this.conn != null) 
			{
				System.out.println("Conectado com sucesso");
				this.stm = conn.createStatement();
				
				ResultSet res = this.stm.executeQuery(query);
			
				 while(res.next())
		         {
					 
					 UsuarioGateway usuario = new UsuarioGateway(res.getString(1),
							 res.getString(2),
							 res.getString(3),
							 res.getInt(4),
							 res.getString(5),
							 res.getString(6),
							 res.getString(7),
							 res.getString(8));
				
			
					 usuarios.add(usuario);
		         }
				 res.close();
			}
			
			
			 
		   this.conn.close();
           this.stm.close();
			
           return usuarios;
			
		} catch (SQLException e) 
		{
			 System.out.println("Erro ao conectar com o banco de dados.");
			 e.printStackTrace();
		}
		finally
		{
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erro ao encerrar a conexão com o banco de dados.");
			}
		}
		return null;
	
	}
	
}
