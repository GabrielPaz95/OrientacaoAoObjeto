package ModificadoresDeAcesso;

public class ClasseFilhaDois extends ClasseMae {

	public String obterEndereco() {
		String s = "Endereço da FilhaDois: ";
		s += super.getEndereco();
		//ou
		//s += super.getEndereco();	
		return s;
		}


	public void ImprimirEndereco() {
		System.out.println("Imprimindo End da FilhaDois");
		System.out.println(this.obterEndereco());
		
		
	}
	
}
