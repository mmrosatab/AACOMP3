package mockobject;
import java.util.ArrayList;

import dominio.Administrador;
import dominio.Gestor;
import dominio.Usuario;

public class UsuarioFinderMock {
	
	public static ArrayList <Usuario> buscarTodos()
	{
		ArrayList <Usuario> usuarios = new ArrayList();
		Usuario u1 = new Administrador("Dudu", "14610164795", "ai1234");
		Usuario u2 = new Gestor("Rex", "11111111111", "socor.ro");
		Usuario u3 = new Gestor("Zezinho Mock", "0987654321", "outrasenhamock");
		
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		
		return usuarios;
	}

}
