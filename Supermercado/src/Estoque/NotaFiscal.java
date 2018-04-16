package Estoque;

public class NotaFiscal {
	
	

	public void notaFiscalEntrada(int pesqNF) {
		
		System.out.println(" - Entradas de materiais - ");
		for (Produto pNotaEntrada : Produto.produtoEntrada) {
			if (pNotaEntrada.getNotaFiscalEntrada() == pesqNF) {
				System.out.println(pNotaEntrada + "Nota Fiscal: " + pNotaEntrada.getNotaFiscalEntrada());
				System.out.println("------------------------------------------------");
			}
		}
		System.out.println("\n\n");

	}

	public void notaFiscalSaida(int pesqNF) {

		System.out.println("Quantidade de Vendas: " + (Produto.nfSaidaContador));
		for (Produto pNotaSaida : Produto.produtoSaida) {
			if (pNotaSaida.getNotaFiscalSaida() == pesqNF) {
				System.out.println(pNotaSaida + "Nota Fiscal: " + pNotaSaida.getNotaFiscalSaida());
			}
		}
		System.out.println("\n\n");
	}

	public void vendasEstoque() {
		System.out.println("Quantidade de Vendas: " + Produto.saidasDeProdutos);
		for (Produto pSaidas : Produto.produtoSaida) {
			System.out.println(pSaidas + "Nota Fiscal: " + pSaidas.getNotaFiscalSaida());
		}
		System.out.println("\n\n");
	}
}
