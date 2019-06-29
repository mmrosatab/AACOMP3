package mock_object;
import java.util.ArrayList;

import dominio.Administrador;
import dominio.Gestor;
import dominio.Usuario;

public class UsuarioFinderMock {
	
	public static ArrayList <Usuario> buscarTodos()
	{
		ArrayList <Usuario> usuarios = new ArrayList();
		Usuario u1 = new Gestor("Joao Mock", "1234567890", "senhamock");
		Usuario u2 = new Administrador("Zezinho Mock", "0987654321", "outrasenhamock");
		
		usuarios.add(u1);
		usuarios.add(u2);
		
		return usuarios;
	}

}
