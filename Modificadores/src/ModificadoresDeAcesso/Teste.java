package ModificadoresDeAcesso;

public class Teste {

	public static void main(String[] args) {
		
		//Erro, classe abstract não pode ser instaciada
		//ClasseMae m = new ClasseMae();
		
		ClasseMae f = new ClasseFilha();
		ClasseMae f2 = new ClasseFilhaDois();
		
		f.setEndereco("Americana");
		f2.setEndereco("SBO");
		
		//m.setNome("Gabriel");
		f.setNome("Mellyssa");
		f2.setNome("Teste");
		
		//System.out.println(f.obterEndereco());
		//System.out.println(f2.obterEndereco());
		
		f.ImprimirEndereco();
		f2.ImprimirEndereco();
		
		System.out.println(ClasseFinal.email);
		System.out.println(ClasseFinal.nome);

		
		
		
		
	}

}
