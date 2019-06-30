package exception;

public class DadosSolicitacaoException extends Exception {

	private static final long serialVersionUID = 1L;
	private String msg;
	
	public DadosSolicitacaoException(String msg)
	{
		this.msg = msg;
	}

}
