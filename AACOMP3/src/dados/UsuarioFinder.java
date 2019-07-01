package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Administrador;
import dominio.Gestor;
import dominio.Usuario;

public class UsuarioFinder 
{
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_URL = "jdbc:derby:/home/andressa/MyDB;create=true";
	
	private Connection conn;
	private Statement stm;
	
	public UsuarioFinder() //throws ClassNotFoundException 
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro com DRIVER no banco de dados.");
		}
	}

	public Usuario buscar(String cpf)
	{	
		String query =
		         "select cpf, nome, senha, tipo, nomeMu, dataCriacao, cidade, estado" +
		         "  from museuEsquema.usuario" +
		         "  where cpf =" + "'"+ cpf +"'" ;
		try 
		{	
		
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) 
			{
				System.out.println("Connectado com sucesso");
			}
			
			this.stm = conn.createStatement();
			
			
			ResultSet res = this.stm.executeQuery(query);
			
			
			Usuario usuario = null;
			
			res.next();
			
			
			if (res.getInt(4) == 0)
			{
				
				usuario =  new Gestor(res.getString(2),res.getString(1),res.getString(3));
			}
	
			this.conn.close();
            res.close();
			this.stm.close();
			
			return usuario;
		
		} catch (SQLException e) 
		{
			 System.out.println("Erro ao conectar com o banco de dados.");
		}
		return null;
		
	}
	
	public ArrayList<Usuario> buscarTodos() 
	{
		
		String query = "select * from museuEsquema.usuario";
		
		try 
		{	
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) 
			{
				System.out.println("Connectado com sucesso");
			}
			
			this.stm = conn.createStatement();
			
			ResultSet res = this.stm.executeQuery(query);
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

			 while(res.next())
	         {
				 
				 Usuario usuario = null;
				 
				 if (res.getInt(4) == 0)
				 {
					usuario = new Gestor(res.getString(2),res.getString(1),res.getString(3));
					
				 }else
				 {
					 usuario = new Administrador(res.getString(2),res.getString(1),res.getString(3));
				 }
		
				 usuarios.add(usuario);
	         }
			 
		   this.conn.close();
           res.close();
           this.stm.close();
			
           return usuarios;
			
		} catch (SQLException e) 
		{
			 System.out.println("Erro ao conectar com o banco de dados.");
		}
		return null;
	
	}
	
}
