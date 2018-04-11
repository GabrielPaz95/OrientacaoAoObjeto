package Estoque;

import java.util.Scanner;

public class Menu {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		int opcao = 0;

		do {
			Produto p = new Produto();
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
					p.setQuantidade(scan.nextInt());
					System.out.println("Digite o nome do Produto: ");
					p.setDescricao(scan.next());
					
					p.cadastrar(p);
					break;
				case 2:		
					System.out.println("2 - Entradas de Estoque\n");
					p.entradasEstoque();
					break;					
				case 3:
					System.out.println("3 - Saídas de Estoque");
					p.saidasEstoque();
					break;
				case 4:
					System.out.println("4 - Saldos de Estoque");
					p.saldoEstoque();
					break;
				case 5:
					System.out.println("5 - Requisições de Estoque \n");
					System.out.println("Produto: ");
					String requisitar = scan.next();
					System.out.println("Quantidade: ");
					int qtd = scan.nextInt();
					p.requisicaoEstoque(requisitar, qtd);
					break;
				case 6:
					System.out.println("6 - Devoluções de Estoque \n");
					p.devolver();
					break;
				case 7:	
					System.out.println("7 - Consulta de Produtos Ativos \n");
					System.out.println("Digite o nome do produto a ser pesquisado no estoque: ");
					String consulta = scan.next();
					p.consultaProdutosAtivos(consulta);
					break;
						
				case 8:
					System.out.println("8 - Exclusão de Produtos \n");
					System.out.println("Digite o nome do produto a ser excluido no estoque: ");
					String exclusao = scan.next();
					p.excluir(exclusao);
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