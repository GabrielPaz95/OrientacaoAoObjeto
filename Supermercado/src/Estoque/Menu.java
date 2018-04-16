package Estoque;

import java.util.Date;
import java.util.Scanner;

public class Menu {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		int opcao = 0;
		int opcaoInicio = 0;
		
		Produto pNovo = new Produto();
		EntradaDeMateriais eM = new EntradaDeMateriais();
		ControleDeEstoque cE = new ControleDeEstoque();
		ControleDeVenda cV = new ControleDeVenda();
		NotaFiscal nF = new NotaFiscal();
		
		do {
			System.out.println("*********** Menu Opções - Principal **");
			System.out.println("** 1 - Vendas                       **");
			System.out.println("** 2 - Estoque                      **");
			System.out.println("** 3 - Consulta Notas vendas        **");
			System.out.println("** 4 - Vendas                       **");		
			System.out.println("** 0 - Sair                         **");
			System.out.println("**************************************");

			do {
				System.out.println("Escolha uma opção: ");
				opcaoInicio = scan.nextInt();

				switch (opcaoInicio) {
				case 1:

					for (Produto produtoSaldo : Produto.produtoSaldo) {
							System.out.println("Codigo: " + produtoSaldo.getCodigo() + " - Descrição: " + produtoSaldo.getDescricao() + " - Qtd: " + produtoSaldo.getQuantidade()
							+ " - Preço Unitário: R$" + produtoSaldo.getPreco());
						}
					
					System.out.println("Digite o codigo do produto: ");
					int codProduto = scan.nextInt();
					System.out.println("Quantidade: ");
					int qtdProduto = scan.nextInt();
					
					for(Produto pConfirma : Produto.produtoSaldo) {
						if(pConfirma.getCodigo() == codProduto) {
							System.out.println("Codigo: " + pConfirma.getCodigo() + " - Descrição: " + pConfirma.getDescricao() + " - Qtd: " + qtdProduto
							+ " - Preço Unitário: R$" + pConfirma.getPreco());
						}
					}
					System.out.println("Confirma(1 - SIM || 2- NÃO): ");
					int confirma = scan.nextInt();
					
					if(confirma == 1) {	cV.controleDeVenda(codProduto, qtdProduto); }
					else System.out.println("Cancelado");				
					break;
					
				case 2:
					do {

						System.out.println("*********** Menu Opções - Estoque ***");
						System.out.println("** 1 - Cadastro de Produtos        **");
						System.out.println("** 2 - Entradas de Estoque         **");
						System.out.println("** 3 - Saídas de Estoque           **");
						System.out.println("** 4 - Saldos de Estoque           **");
						System.out.println("** 5 - Requisições de Estoque      **");
						System.out.println("** 6 - Devoluções de Estoque       **");
						System.out.println("** 7 - Consulta de Produtos Ativos **");
						System.out.println("** 8 - Exclusão de Produtos        **");
						System.out.println("** 9 - Consulta Notas Entradas     **");
						System.out.println("** 10 - Voltar ao menu principal   **");
						System.out.println("*************************************");

						do {
							System.out.println("Escolha uma opção: ");
							opcao = scan.nextInt();

							switch (opcao) {
							case 1:
								System.out.println("1 - Cadastro de Produtos\n");
								System.out.println("Digite a quantidade: ");
								pNovo.setQuantidade(scan.nextInt());
								System.out.println("Digite o nome do Produto: ");
								pNovo.setDescricao(scan.next());
								System.out.println("Digite o preço total:");
								pNovo.setPrecoTotal(scan.nextDouble());
								pNovo.setPreco(scan.nextDouble() / pNovo.getQuantidade());
								System.out.println("Digite o numero da Nota Fiscal: ");
								pNovo.setNotaFiscalEntrada(scan.nextInt());

								Date data = new Date();
								pNovo.setDataDaPrimeiraCompra(data);
								Date dataSaldo = new Date();
								pNovo.setDataDaUltimaCompra(dataSaldo);

								eM.cadastrar(pNovo);
								break;
							case 2:
								System.out.println("2 - Entradas de Estoque\n");
								eM.entradasEstoque();
								break;
							case 3:
								System.out.println("3 - Saídas de Estoque");
								cE.saidasEstoque();
								break;
							case 4:
								System.out.println("4 - Saldos de Estoque");
								cE.saldoEstoque();
								break;
							case 5:
								System.out.println("5 - Requisições de Estoque \n");
								System.out.println("Produto: ");
								String requisitar = scan.next();
								System.out.println("Quantidade: ");
								int qtd = scan.nextInt();
								cE.requisicaoEstoque(requisitar, qtd);
								break;
							case 6:
								System.out.println("6 - Devoluções de Estoque \n");
								System.out.println("Produtos Requisitados: ");

								ControleDeEstoque.dev = 0;

								for (Produto produtoSaida : Produto.produtoSaida) {
									if (produtoSaida.isDevolucao() == false) {
										System.out
												.println(produtoSaida + " - Devolvido: " + produtoSaida.isDevolucao());
										ControleDeEstoque.dev++;
									}
								}

								if (ControleDeEstoque.dev <= 0) {
									System.out.println("Não existe produtos requisitados");
									break;
								}

								System.out.println("Produto a devolver: ");
								String devolucao = scan.next();
								System.out.println("Quantidade: ");
								int qtdDevolucao = scan.nextInt();
								cE.devolver(devolucao, qtdDevolucao);
								break;

							case 7:
								System.out.println("7 - Consulta de Produtos Ativos \n");
								System.out.println("Digite o nome do produto a ser pesquisado no estoque: ");
								String consulta = scan.next();
								cE.consultaProdutosAtivos(consulta);
								break;

							case 8:
								System.out.println("8 - Exclusão de Produtos \n");
								System.out.println("Digite o nome do produto a ser excluido no estoque: ");
								String exclusao = scan.next();
								cE.excluir(exclusao);
								break;
							case 9:
								System.out.println("Consulta Notas Entradas");
								System.out.println("Digite o numero da notaFiscal: ");
								int pesqNF = scan.nextInt();
								
								nF.notaFiscalEntrada(pesqNF);
								break;	
								
							case 10:
								System.out.println("Menu Inicial");
								break;
							default:
								System.out.println("Opção inválida!");
							}
						} while (opcao >= 11);
					} while (opcao != 10);
					break;
					
				case 3:
					System.out.println("Consulta Notas Vendas");
					System.out.println("Digite o numero da notaFiscal: ");
					int pesqNF = scan.nextInt();
					
					nF.notaFiscalSaida(pesqNF);
					break;		
					
				case 4:
					cV.saidasVendas();
					break;
				case 0:
					System.out.println("Você saiu.. inicio");
					System.exit(0);
				default:
					System.out.println("Opção inválida!");
				}
			} while (opcaoInicio >= 5);
		} while (opcaoInicio != 0);
	}
}