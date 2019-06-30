package dominio;

import java.util.InputMismatchException;

import exception.CpfInvalidoException;

public class Cpf {
	
	public static void validar(String CPF) throws CpfInvalidoException
	{
		boolean retorno;
		
		if(CPF.equals("00000000000") || CPF.equals("11111111111") 
			     ||CPF.equals("22222222222") || CPF.equals("33333333333") 
				 || CPF.equals("44444444444") || CPF.equals("55555555555") 
				 || CPF.equals("66666666666") || CPF.equals("77777777777") 
				 || CPF.equals("88888888888") || CPF.equals("99999999999") 
				 || (CPF.length() != 11)) throw new CpfInvalidoException();
				
				char dig10, dig11; 
				int total, i, r, num, n; 
					
				try { 
					
					// Primeiro Dígito
					total = 0; 
					n = 10; 
					for (i=0; i<9; i++) { 
						
						num = (int)(CPF.charAt(i) - 48);	
						total = total + (num * n); 
						n --;		
					}
					
					r = 11 - (total % 11);
					
					if ((r == 10) || (r == 11))					
						dig10 = '0';
					else
						dig10 = (char)(r + 48); 
					
					// Segundo Dígito
					    total = 0;
						n = 11;
						
					for(i=0; i<10; i++) 
					{ 
							num = (int)(CPF.charAt(i) - 48);
							total = total + (num * n); 
							n--;
							
					} 
							r = 11 - (total % 11);
							
					if ((r == 10) || (r == 11)) 
						dig11 = '0';
					else dig11 = (char)(r + 48); 
					
					 
					if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) 
					{
						retorno = true;
			
					}

					else { 
						throw new CpfInvalidoException();
					}
					} catch (InputMismatchException erro)
					{
						//return(false);
						retorno = false;
						throw new CpfInvalidoException();
							
					} 
		
	}

}
