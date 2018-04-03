package Estoque;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
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

					System.out.println("Digite a quantidade: ");
					p.setQuantidade(scan.nextInt());
					System.out.println("Digite o nome do Produto: ");
					p.setDescricao(scan.next());

					p.cadastrar(new Produto());

					System.out.println("Produto cadastrado!");

					break;

				case 2:
					p.listarQuantidade();
					break;
				case 3:
					System.out.println("opcao 3");
					break;
				case 4:
					System.out.println("opcao 4");
					break;
				case 5:
					System.out.println("opcao 5");
					break;
				case 6:
					System.out.println("opcao 6");
					break;
				case 7:
					p.listar();
					break;
				case 8:
					p.excluir(p);
					break;
				case 0:
					System.out.println("Você saiu!");
					System.exit(0);
				default:
					System.out.println("Opção inválida!");
				}
			} while (opcao >= 9);
		} while (opcao != 0);
	}

}