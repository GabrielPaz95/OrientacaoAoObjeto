package Estoque;

import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
		
		controleEstoque ce = new controleEstoque();

		Scanner scan = new Scanner(System.in);
		int opcao = 0;

		while (opcao == 0) {
			System.out.println("*********** Menu Op��es *************");
			System.out.println("** 1 - Cadastro de Produtos        **");
			System.out.println("** 2 - Entradas de Estoque         **");
			System.out.println("** 3 - Sa�das de Estoque           **");
			System.out.println("** 4 - Saldos de Estoque           **");
			System.out.println("** 5 - Requisi��es de Estoque      **");
			System.out.println("** 6 - Devolu��es de Estoque       **");
			System.out.println("** 7 - Consulta de Produtos Ativos **");
			System.out.println("** 8 - Exclus�o de Produtos        **");
			System.out.println("** 0 - Sair                        **");
			System.out.println("*************************************");
			
			do {
				System.out.println("Escolha uma op��o: ");
				opcao = scan.nextInt();			

			switch (opcao) {
			case 1:	ce.cadastrar();break;
			case 2:	System.out.println("opcao 2");break;
			case 3:	System.out.println("opcao 3");break;
			case 4:	System.out.println("opcao 4");break;
			case 5:	System.out.println("opcao 5");break;
			case 6:	System.out.println("opcao 6");break;
			case 7:	System.out.println("opcao 7");break;
			case 8:	System.out.println("opcao 8");break;
			case 0: System.out.println("Voc� saiu!");System.exit(0);
			default:System.out.println("Op��o inv�lida!");
			} 
			}while (opcao >= 9);
		};
	}

}
