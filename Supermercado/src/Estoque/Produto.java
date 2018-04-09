package Estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {

	Scanner scan = new Scanner(System.in);

	private static int codigo;
	public int quantidade;
	public String descricao;
	boolean requisitado = false;
	private static List<Produto> produtoLista = new ArrayList<>();
	private static List<Produto> produtoSaida = new ArrayList<>();
	private static List<Produto> produtoEntrada = new ArrayList<>();
	private static int quantidadeDeProdutos;
	private static int saidasDeProdutos;
	
	// Getters and Setters
	public static int getCodigo() {return codigo;}	
	public static void setCodigo(int codigo) {Produto.codigo = codigo;}
	
	public double getQuantidade() {return quantidade;}
	public void setQuantidade(int quantidade) {this.quantidade = quantidade;}
	
	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}

	public boolean isRequisitado() {return requisitado;}
	public void setRequisitado(boolean requisitado) {this.requisitado = requisitado;}
	
	// Métodos
	@Override
	public String toString() {
		return "Produto [descricao: " + descricao + " Quantidade: " + quantidade + " Requisitado: " + requisitado + "]";
	}
	
	//1
	public void cadastrar(Produto p) {
		this.produtoLista.add(p);
		this.produtoEntrada.add(p);
		quantidadeDeProdutos++;
	}
	
	//2
	public void entradasEstoque() {
		System.out.println("Quantidade de produtos cadastrados: " + this.quantidadeDeProdutos);		
		for (Produto produtos : produtoEntrada) {
			System.out.println(produtos);
		}
	}
	
	//3
	public void saidasEstoque() {
		System.out.println("Quantidade de saidas de estoque: " + this.saidasDeProdutos);
		for (Produto saidas : produtoSaida) {
			System.out.println(saidas);
		}
	}
	
	//4
	public void saldoEstoque() {

		
	}
	
	//5
	public void requisicaoEstoque(String descricao, int qtd) {
		boolean r = false;
		for(Produto produto : produtoEntrada) {
			if(produto.descricao.equals(descricao)) {
				produto.setRequisitado(true);				
				System.out.println("Produto requisitado");
				r = true;
				break;
			}
		}
		if(r == false)
		System.out.println("Não existe produto com esse nome");
	}
	
	
	//6
	public void devolver() {
		System.out.println("escolha um produto requisitado para devolver: ");
		for (Produto produto : produtoLista) {
		 if(produto.isRequisitado() == true){
//			 System.out.println(produto);	
			 produtoSaida.add(produto);
		 }
		 System.out.println(produtoLista + "\n");
		}
		

		
	 

	}
	
	//7
	public void consultaProdutosAtivos(String descricao) {		
		boolean achou = true;
		for (Produto produto : produtoLista) {
			if (produto.descricao.equals(descricao)) {
				System.out.println(produto);
				achou = true;
				break;
			}
		}
		if(achou == false) {
			System.out.println("NÃO EXISTE! ");
		}
		
	}

	//8
	public void excluir(String exclusao) {
		
		for (Produto produto : produtoLista) {
			if (produto.descricao.equals(exclusao)) {
				System.out.println(produto);
				this.produtoLista.remove(produto);
				System.out.println("Produto excluido!");
				break;
			}
			else {
				System.out.println("não");
				break;
			}
		}

		this.produtoLista.remove(exclusao);
		quantidadeDeProdutos--;
		saidasDeProdutos++;
		
	}
}
