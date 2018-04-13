package Estoque;

import java.util.Date;
import java.util.Scanner;

public class Menu {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		int opcao = 0;

		do {
			Produto pNovo = new Produto();
			EntradaDeMateriais eM = new EntradaDeMateriais();
			ControleDeEstoque cE = new ControleDeEstoque();
			ControleDeVenda cV = new ControleDeVenda();
			
			System.out.println("*********** Menu Opções *************");
			System.out.println("** 1 - Cadastro de Produtos        **");
			System.out.println("** 2 - Entradas de Estoque         **");
			System.out.println("** 3 - Saídas de Estoque           **");
			System.out.println("** 4 - Saldos de Estoque           **");
			System.out.println("** 5 - Requisições de Estoque      **");
			System.out.println("** 6 - Devoluções de Estoque       **");
			System.out.println("** 7 - Consulta de Produtos Ativos **");
			System.out.println("** 8 - Exclusão de Produtos        **");
			System.out.println("** 0 - Sair                        **");
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
					pNovo.setPreco(scan.nextDouble() / pNovo.getQuantidade());
					
					Date data = new Date();					
					pNovo.setDataDaPrimeiraCompra(data);//arrumar
					
					eM.cadastrar(pNovo);
					break;
				case 2:		
					System.out.println("2 - Entradas de Estoque\n");
					eM.entradasEstoque();
					break;					
				case 3:
					System.out.println("3 - Saídas de Estoque");
					cV.saidasEstoque();
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
						if(produtoSaida.isDevolucao() == false) {
							System.out.println(produtoSaida + " - Devolvido: " + produtoSaida.isDevolucao());
							ControleDeEstoque.dev++;
						}
					}
					
					if(ControleDeEstoque.dev <= 0) {System.out.println("Não existe produtos requisitados");break;}
					
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
				case 0:
					System.out.println("Você saiu..");
					System.exit(0);
				default:
					System.out.println("Opção inválida!");
				}
			} while (opcao >= 9);
		} while (opcao != 0);
	}

}