package mockobject;

import dominio.Usuario;

public class UsuarioGatewayMock {
	
	public void trocaTipo(Usuario usuario)
	{
		if(usuario.getClass().getName().equalsIgnoreCase("dominio.Gestor"))
		{
			System.out.println("Troquei o tipo");
		}
		
	}

}
