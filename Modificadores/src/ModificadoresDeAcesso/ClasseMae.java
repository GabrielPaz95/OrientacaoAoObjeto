package ModificadoresDeAcesso;

public abstract class ClasseMae {
	
	private String nome;
	private int idade;
	private String endereco;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
//	//Constructor
//		ClasseMae(String nome, int idade){
//		this.nome = nome;
//		this.idade = idade;	
//	}
	
	public abstract String obterEndereco();
	
	public abstract void ImprimirEndereco();
	
}
