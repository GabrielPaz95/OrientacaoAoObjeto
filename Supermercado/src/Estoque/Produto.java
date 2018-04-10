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
	private static List<Produto> produtoSaldo = new ArrayList<>();
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
		return "Produto [descricao: " + descricao + " Quantidade: " + quantidade + "]";
	}
	
	//1 - OK
	public void cadastrar(Produto p) {
		this.produtoSaldo.add(p);
		this.produtoEntrada.add(p);
		quantidadeDeProdutos++;
	}
	
	//2 - TODAS AS ENTRADAS REGRISTRADAS - OK
	public void entradasEstoque() {
		System.out.println("Quantidade de produtos cadastrados: " + this.quantidadeDeProdutos);		
		for (Produto produtos : produtoEntrada) {
			System.out.println(produtos);
		}
	}
	
	//3 - TODAS AS SAIDAS REGRISTRADAS - OK
	public void saidasEstoque() {
		System.out.println("Quantidade de saidas de estoque: " + this.saidasDeProdutos);
		for (Produto saidas : produtoSaida) {
			System.out.println(saidas);
		}
	}
	
	//4 - SALDO ATUAL
	public void saldoEstoque() {

		
	}
	
	//5 - RETIRADAS DE PRODUTOS
	public void requisicaoEstoque(String descricao, int qtd) {
		boolean r = false;
		for(Produto produto : produtoSaldo) {
			if(produto.descricao.equals(descricao)) {
				if(produto.quantidade > 0 && produto.quantidade >= qtd) {
					produto.setRequisitado(true);
				
					Produto pAuxiliar = new Produto();
					pAuxiliar.setDescricao(produto.getDescricao());
					pAuxiliar.setQuantidade(qtd);
					produtoSaida.add(pAuxiliar);
					
					System.out.println("Produto requisitado");
					saidasDeProdutos++;
					r = true;
					break;
				}
				System.out.println("Produto Existe, mas não temos em estoque!");
				break;
			}
			
			else {
				System.out.println("Não existe produto com esse nome");
				}
		}
		
		
	}
	
	
	//6 - DEVOLUÇÃO DE PRODUTOS
	public void devolver() {
		System.out.println("escolha um produto requisitado para devolver: ");
		for (Produto produto : produtoSaida) {
		 System.out.println(produto);
		 }
//		 System.out.println(produtoSaida + "\n");
		}
	
	//7 - CONSULTA ESTOQUE - OK
	public void consultaProdutosAtivos(String descricao) {		
		boolean achou = true;
		for (Produto produto : produtoSaldo) {
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

	//8 - EXCLUIR PRODUTO - OK
	public void excluir(String exclusao) {
		
		for (Produto produto : produtoSaldo) {
			if (produto.descricao.equals(exclusao)) {
				System.out.println(produto);
				this.produtoSaldo.remove(produto);
				this.produtoEntrada.remove(produto);
				this.produtoSaida.remove(produto);
				quantidadeDeProdutos--;
				saidasDeProdutos++;
				System.out.println("Produto excluido totalmente do sistema!");
				break;
			}
			else {
				System.out.println("não existe esse produto");
				break;
			}
		}		
	}
}
