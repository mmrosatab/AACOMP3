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
	private static final String JDBC_URL = "jdbc:derby:/home/andressa/MyDB;create=true";
	private Connection conn;
	
	
	public UsuarioGateway() throws ClassNotFoundException
	
	{
		Class.forName(DRIVER);
	}
	
	
	public void inserir(MuseuMD museu)
	{
		try 
		{	
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) 
			{
				String query = "insert into museuEsquema.usuario "
						+ "(cpf,nome,senha,tipo,nomeMu,dataCriacao,cidade,estado) values (?,?,?,?,?,?,?,?)";
				
				PreparedStatement ps = this.conn.prepareStatement(query);
				
				ps.setString(1, museu.getGestor().getCpf());
				ps.setString(2, museu.getGestor().getNome());
				ps.setString(3,museu.getGestor().getSenha());
				ps.setInt(4, 0);
				ps.setString(5, museu.getNome());
				ps.setString(6, museu.getDataCriacao());
				ps.setString(7, museu.getCidade());
				ps.setString(8, museu.getEstado());
				ps.executeUpdate();
				this.conn.close();
			}
			
			
		} catch (SQLException e) 
		{
			 e.printStackTrace();
		}
	}
	

	public void inserir(Usuario usuario, int tipo)
	{
		try 
		{	
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) 
			{
				String query = "insert into museuEsquema.usuario "
						+ "(cpf,nome,senha,tipo,nomeMu,dataCriacao,cidade,estado) values (?,?,?,?,?,?,?,?)";
				
				PreparedStatement ps = this.conn.prepareStatement(query);
				
				ps.setString(1, usuario.getCpf());
				ps.setString(2, usuario.getNome());
				ps.setString(3, usuario.getSenha());
				ps.setInt(4, tipo);
				ps.setString(5, "");
				ps.setString(6, "");
				ps.setString(7, "");
				ps.setString(8, "");
				ps.executeUpdate();
				this.conn.close();
			}
			
			
		} catch (SQLException e) 
		{
			 e.printStackTrace();
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
				
				this.conn.close();
			}
			
			
		} catch (SQLException e) 
		{
			 e.printStackTrace();
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
				this.conn.close();
			}
			
			
		} catch (SQLException e) 
		{
			 e.printStackTrace();
		}
	}

}
