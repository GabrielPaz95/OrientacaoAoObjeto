package ModificadoresDeAcesso;

public class ClasseFilha extends ClasseMae{

		int tel;

		public String obterEndereco() {
			String s = "Endere�o da Filha: ";
			s = s + super.getEndereco();
			//ou
			//s += super.getEndereco();			
			return s;
			}

		public void ImprimirEndereco() {
			
			System.out.println(this.obterEndereco());
			
		}		
		
}
