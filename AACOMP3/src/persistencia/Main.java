package persistencia;

public class Main 
{

	public static void main(String[] args) throws ClassNotFoundException 
	{
		ProdutoBD pbd = new ProdutoBD();
		pbd.conectar();
		pbd.inserirProduto(2, 5.50, "AcaiDoEgito");
		pbd.listarProdutos();
		pbd.desconectar();
	}

}
