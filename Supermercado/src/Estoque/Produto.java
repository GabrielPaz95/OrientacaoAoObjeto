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
	private double pre�oMedio;
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
	private boolean devolucao = false;
	static int d = 0;

	// Getters and Setters -------------------------------------------------------------------------------------
	public int getCodigo() {return codigo;}
	public void setCodigo(int codigo) {this.codigo = codigo;}

	public double getQuantidade() {return quantidade;}
	public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}
	
	public static List<Produto> getProdutoSaida() {return produtoSaida;}
	public static void setProdutoSaida(List<Produto> produtoSaida) {Produto.produtoSaida = produtoSaida;}
	
	public boolean isDevolucao() {return devolucao;}
	public void setDevolucao(boolean devolucao) {this.devolucao = devolucao;
	}
	// M�todos --------------------------------------------------------------------------------------------------
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
			
			System.out.println("Primeiro Produto Cadastrado!\n");
			quantidadeInstancias++;
		}
		
		else {			
			//Atualiza Saldo
			for(Produto pSaldo : produtoSaldo) {
				if(pSaldo.descricao.equals(p.descricao)) {					
					pSaldo.descricao = p.descricao;
					pSaldo.quantidade += p.quantidade;
					
					produtoEntrada.add(p);
					
					System.out.println("Produto j� existe, foi Atualizado!\n");
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
							System.out.println("Produto Cadastrado!\n");
							quantidadeInstancias++;
							break;
						}
					}
					}
				}
	}

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
			System.out.println(pSaidas + " - Devolvido: " + pSaidas.devolucao);
		}
		System.out.println("\n\n");
	}

	// 4 - SALDO ATUAL - OK
	public void saldoEstoque() {
		System.out.println("Saldo Estoque: ");
		for (Produto pSaldo : produtoSaldo) {
		System.out.println(pSaldo + "\n");
		}
	}

	// 5 - REQUISI��O DE PRODUTOS - OK
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
					System.out.println("Produto requisitado\n");
					saidasDeProdutos++;
					r = true;
					break;
				} else {
					System.out.println("Produto Existe, mas n�o temos em estoque!\n");
					break;
				}
			} else if (r == false){
				System.out.println("N�o existe produto com esse nome\n");
			}
		}

	}

	// 6 - DEVOLU��O DE PRODUTOS - OK
	public void devolver(String devolucao, int qtdDevolucao) {			
		for (Produto produto : produtoSaida) {
			if(produto.quantidade == qtdDevolucao && produto.descricao.equals(devolucao)
					&& produto.devolucao == false) {
				produto.setDevolucao(true);
				
				for(Produto pSaldo : produtoSaldo) {
					if(pSaldo.descricao.equals(devolucao)) {					
						pSaldo.descricao = devolucao;
						pSaldo.quantidade += qtdDevolucao;
					}
					
				System.out.println("Produto Devolvido\n");
				}				
				break;
			}
			else if(produto.quantidade != qtdDevolucao && produto.descricao.equals(devolucao)&& produto.devolucao == false) {
				System.out.println("Quantidade diferente da requisitada, porfavor refa�a a devolucao correta\n");break;}
			else{System.out.println("Produto n�o consta na lista de requisitados!\n");break;}
		}	
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
			System.out.println("N�O EXISTE! ");
		}

	}

	// 8 - EXCLUIR PRODUTO - OK
	public void excluir(String exclusao) {
	if(produtoEntrada.size() > 0) {
	int excluirEntradaContador = 0;
	
	do{
		for (Produto excluirEntrada : produtoEntrada) {
			if(excluirEntrada.descricao.equals(exclusao)) {
				produtoEntrada.remove(excluirEntrada);
				quantidadeInstancias--;
				break;
			}
		}
		excluirEntradaContador++;
	}while(excluirEntradaContador <= produtoEntrada.size());
	
	System.out.println("Excluido ProdutoEntrada");
	}
	
	if(produtoSaldo.size() > 0) {
	int excluirSaldoContador = 0;
	
	do{
		for (Produto excluirSaldo : produtoSaldo) {
			if(excluirSaldo.descricao.equals(exclusao)) {
				produtoSaldo.remove(excluirSaldo);
				break;
			}
		}
		excluirSaldoContador++;
	}while(excluirSaldoContador <= produtoSaldo.size());
	
	System.out.println("Excluido ProdutoSaldo");
	}
	
	if(produtoSaida.size() > 0) {	
	int excluirSaidaContador = 0;
	
	do{
		for (Produto excluirSaida : produtoSaida) {
			if(excluirSaida.descricao.equals(exclusao)) {
				produtoSaida.remove(excluirSaida);
				saidasDeProdutos--;
				break;
			}
		}
		excluirSaidaContador++;
	}while(excluirSaidaContador <= produtoSaida.size());
	
	System.out.println("Excluido ProdutoSaida");	
		
	}
	}
}