package Estoque;

public class ControleDeVenda {
	
	/* Controle de Venda: permitir a venda e debitar do estoque produtos que tenham sido
vendidos. */

	// 3 - TODAS AS SAIDAS REGRISTRADAS - OK
	public void saidasEstoque() {
		System.out.println("Quantidade de saidas de estoque: " + Produto.saidasDeProdutos);
		for (Produto pSaidas : Produto.produtoSaida) {
			System.out.println(pSaidas + " - Devolvido: " + pSaidas.isDevolucao());
		}
		System.out.println("\n\n");
	}

}
