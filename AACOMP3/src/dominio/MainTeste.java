package dominio;

public class MainTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Funcionario gestor = new Gestor("Andressa", "1461018892", "aiQue.absurdo");
		gestor.dizerQuemSou();

		System.out.println(Cpf.validar("14610164793"));

	}

}
