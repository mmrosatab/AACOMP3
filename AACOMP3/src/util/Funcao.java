package util;

import dominio.Administrador;
import dominio.Usuario;

public class Funcao 
{
	public Funcao() 
	{
		
	}
	
	public static String funcao(Usuario usuario)
	{
		
		if (usuario instanceof Administrador)
		{
			System.out.println("entrei");
			return "Administrador";
		}else
		{
			return "Gestor";
		}
	}
}

