package mock_object;
import java.util.ArrayList;
import dominio.*;


public class CamadaDadosMock {
	
	private static ArrayList<Usuario> usuarios;
	
	public static ArrayList<Usuario> buscarUsuarios()
	{
		ArrayList <Usuario> usuarios =  UsuarioFinderMock.buscarTodos();
		return usuarios;
	}

}
