package ModificadoresDeAcesso;

public class ClasseFilhaDois extends ClasseMae {

	public String obterEndereco() {
		String s = "Endere�o da FilhaDois: ";
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
