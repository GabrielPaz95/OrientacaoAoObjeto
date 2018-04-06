package Estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {

	Scanner scan = new Scanner(System.in);

	private static int codigo;
	public int quantidade;
	public String descricao;
	private static List<Produto> produtoLista = new ArrayList<>();
	private static int quantidadeDeProdutos;
	private static int saidasDeProdutos;
	
	// Getters and Setters
	public static int getCodigo() {return codigo;}	
	public static void setCodigo(int codigo) {Produto.codigo = codigo;}
	
	public double getQuantidade() {return quantidade;}
	public void setQuantidade(int quantidade) {this.quantidade = quantidade;}
	
	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}

	// M�todos
	//1
	public void cadastrar(Produto p) {
		this.produtoLista.add(p);
		quantidadeDeProdutos++;
	}
	
	//2
	public void entradasEstoque() {
		System.out.println();
		System.out.println("Quantidade de produtos cadastrados: " + this.quantidadeDeProdutos);
	}
	
	//3
	public void saidasEstoque() {
		System.out.println("Quantidade de saidas de estoque: " + this.saidasDeProdutos);
	}
	
	//4
	public void saldoEstoque() {
		
	}
	
	//5
	public void requisicaoEstoque() {
		
	}
	
	//6
	public void devolver() {

	}
	
	//7
	@Override
	public String toString() {
		return "Produto [quantidade=" + quantidade + ", descricao=" + descricao + "]";
	}

	public void consultaProdutosAtivos() {
		for (Produto produtos : produtoLista) {
			System.out.println(produtos);
		}
	}

	public void excluir(Produto p) {

		this.produtoLista.remove(p);
		quantidadeDeProdutos--;
		saidasDeProdutos++;
		
	}
}
