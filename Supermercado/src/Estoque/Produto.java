package Estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {

	Scanner scan = new Scanner(System.in);

	private static int codigo;
	public int quantidade;
	public String descricao;
	public static int qtsProdutos;
	private List<Produto> produtoLista = new ArrayList<>();

	// Getters and Setters
	public static int getCodigo() {
		return codigo;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	// Métodos
	public void cadastrar(Produto p) {
		this.produtoLista.add(p);

	}

	public void pesquisar() {


	}

	public void requisitar() {

	}

	public void devolver() {

	}

	public void escluir() {

	}

	public void listar() {
		for (Produto produtos : produtoLista) {
			System.out.println(produtos);
		}

	}
}
