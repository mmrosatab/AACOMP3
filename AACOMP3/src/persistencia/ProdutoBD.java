package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoBD 
{
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	
	//String de conexao Andressa
	// private static final String JDBC_URL = "jdbc:derby:/home/mmrosa/MyDB2;create=true";
	
	//String de conexao Mayara
	private static final String JDBC_URL = "jdbc:derby:/home/mmrosa/MyDB2;create=true";
	
	private Connection conn;
	private Statement stm;
	
	public void conectar() throws ClassNotFoundException 
	{
		Class.forName(DRIVER);
		
		try 
		{	
		
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) 
			{
				System.out.println("Connectado com sucesso");
			}
		} catch (SQLException e) 
		{
			 e.printStackTrace();
		}
	}
	
	public void desconectar()
	{
		try 
		{
			this.conn.close();

			System.out.println("Desconectado");
			
		} catch (SQLException e) 
		{
			System.out.println("Falha em desconectar");
		}
	}
	

	public void inserirProduto(int id, double preco, String nomeProduto)
	{
		try 
		{
			this.stm = conn.createStatement();
			
			//System.out.println("insert into " + "mercearia.produtos" + " values (" +
                   // id + "," + preco + ",'" + nomeProduto +"')");
			
			stm.execute("insert into " + "mercearia.produtos" + " values (" +
                    id + "," + preco + ",'" + nomeProduto +"')");
            
			stm.close();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void listarProdutos()
	{
		try 
		{
			this.stm = conn.createStatement();
			
			ResultSet res = stm.executeQuery("select *from mercearia.produtos");
			
            ResultSetMetaData rsmd = res.getMetaData();
            
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n-------------------------------------------------");

            while(res.next())
            {
                int id = res.getInt(1);
                double preco = res.getDouble(2);
                String nomeProduto = res.getString(3);
                System.out.println(id + "\t\t" + preco + "\t\t" + nomeProduto);
            }
			
            res.close();
			stm.close();
			
			System.out.println();
			
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
