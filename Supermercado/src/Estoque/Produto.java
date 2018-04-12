package Estoque;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Produto {

	Scanner scan = new Scanner(System.in);

	private int codigo;
	private int quantidade;
	private String descricao;	
	private double unidadeDeMedida;
	private double preçoMedio;
	private double saldoMinimo;
	private double saldoMaximo;
	private double loteEconomicoDeCompra;
	private int localNaPrateleira;
	private Date dataDaPrimeiraCompra;
	private Date dataDaUltimaCompra;
	private String observacao;
	private static List<Produto> produtoSaldo = new ArrayList<>();
	private static List<Produto> produtoSaida = new ArrayList<>();
	private static List<Produto> produtoEntrada = new ArrayList<>();
	private static int quantidadeInstancias;
	private static int saidasDeProdutos;

	// Getters and Setters -------------------------------------------------------------------------------------
	public int getCodigo() {return codigo;}
	public void setCodigo(int codigo) {this.codigo = codigo;}

	public double getQuantidade() {return quantidade;}
	public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}

	// Métodos --------------------------------------------------------------------------------------------------
	@Override
	public String toString() {return "Produto [descricao: " + descricao + " Quantidade: " + quantidade + "]";}

	// 1 - CADASTRAR OK
	public void cadastrar(Produto p) {			
		//se a lista estiver vazia
		if(produtoEntrada.isEmpty() && produtoSaldo.isEmpty()){
			produtoEntrada.add(p);
			
			Produto pS = new Produto();
			pS.descricao = p.descricao;
			pS.quantidade = p.quantidade;
			produtoSaldo.add(pS);
			
			System.out.println("Primeiro Produto Cadastrado!");
			quantidadeInstancias++;
		}
		
		else {			
			//Atualiza Saldo
			for(Produto pSaldo : produtoSaldo) {
				if(pSaldo.descricao.equals(p.descricao)) {					
					pSaldo.descricao = p.descricao;
					pSaldo.quantidade += p.quantidade;
					
					produtoEntrada.add(p);
					
					System.out.println("Produto já existe, foi Atualizado!");
					quantidadeInstancias++;
					break;
				}
			}
					//Produto Novo
					boolean t = false;
				
					for (Produto pEntrada : produtoEntrada) {						
						if(pEntrada.descricao.equals(p.descricao)) {
							t = true;														
						}
					}
						
					if(t == false) {
					for (Produto pEntrada : produtoEntrada) {	
						if(!pEntrada.descricao.equals(p.descricao)) {
							produtoEntrada.add(p);
							
							Produto pS = new Produto();
							pS.descricao = p.descricao;
							pS.quantidade = p.quantidade;
							produtoSaldo.add(pS);
							System.out.println("Produto Cadastrado!");
							quantidadeInstancias++;
							break;
						}
					}
					}
				}
	}//cadastrar

	// 2 - TODAS AS ENTRADAS REGRISTRADAS - OK
	public void entradasEstoque() {
		System.out.println("Quantidade de produtos cadastrados: " + quantidadeInstancias);
		for (Produto pEntrada : produtoEntrada) {
			System.out.println(pEntrada);
		}
		System.out.println("\n\n");
	}

	// 3 - TODAS AS SAIDAS REGRISTRADAS - OK
	public void saidasEstoque() {
		System.out.println("Quantidade de saidas de estoque: " + saidasDeProdutos);
		for (Produto pSaidas : produtoSaida) {
			System.out.println(pSaidas);
		}
		System.out.println("\n\n");
	}

	// 4 - SALDO ATUAL - OK
	public void saldoEstoque() {
		System.out.println("Saldo Estoque: ");
		for (Produto pSaldo : produtoSaldo) {
		System.out.println(pSaldo);
		}
	}

	// 5 - RETIRADAS DE PRODUTOS - OK
	public void requisicaoEstoque(String descricao, int qtd) {
		boolean r = false;
		for (Produto produto : produtoSaldo) {
			if (produto.descricao.equals(descricao)) {
				if (produto.quantidade > 0 && produto.quantidade >= qtd) {
					
					Produto pSaida = new Produto();
					pSaida.setDescricao(produto.getDescricao());
					pSaida.setQuantidade(qtd);
					produtoSaida.add(pSaida);
					
					produto.quantidade -= qtd;
					
					
					System.out.println(pSaida);
					System.out.println("Produto requisitado");
					saidasDeProdutos++;
					r = true;
					break;
				} else {
					System.out.println("Produto Existe, mas não temos em estoque!");
					break;
				}
			} else if (r == false){
				System.out.println("Não existe produto com esse nome");
			}
		}

	}

	// 6 - DEVOLUÇÃO DE PRODUTOS
	public void devolver() {
		System.out.println("escolha um produto requisitado para devolver: ");
		for (Produto produto : produtoSaida) {
			System.out.println(produto);
		}
		// System.out.println(produtoSaida + "\n");
	}

	// 7 - CONSULTA ESTOQUE - OK
	public void consultaProdutosAtivos(String descricao) {
		boolean achou = false;
		for (Produto produto : produtoSaldo) {
			if (produto.descricao.equals(descricao)) {
				System.out.println(produto);
				achou = true;
				break;
			}
		}
		if (achou == false) {
			System.out.println("NÃO EXISTE! ");
		}

	}

	// 8 - EXCLUIR PRODUTO
	public void excluir(String exclusao) {
		
		for (Produto excluirEntrada : produtoEntrada) {
			if(excluirEntrada.descricao.equals(exclusao)) {
				produtoEntrada.remove(excluirEntrada);
			}
		}
		
	}
}
