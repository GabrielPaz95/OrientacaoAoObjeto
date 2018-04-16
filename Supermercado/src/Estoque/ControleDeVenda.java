package Estoque;

public class ControleDeVenda {
	
	/* Controle de Venda: permitir a venda e debitar do estoque produtos que tenham sido
vendidos. */
	
	Produto pVenda = new Produto();

	// 4 - TODAS AS VENDAS REGISTRADAS - OK
	public void saidasVendas() {
		System.out.println("Quantidade de Vendas: " + Produto.nfSaidaContador);
		for (Produto pSaidasVendas : Produto.produtoSaida) {
			if(pSaidasVendas.getVenda().equals("venda")) {
				System.out.println(pSaidasVendas);
				System.out.println("------------------------------------------------------------");
			}
		}
		System.out.println("\n\n");
	}
	
	//CONTROLE DE VENDAS
	public void controleDeVenda(int codProduto, int qtdProduto) {
		
		boolean r = false;
		
		System.out.println(" - Controle de vendas - ");

		for (Produto produtoVenda : Produto.produtoSaldo) {
			if (produtoVenda.getCodigo() == codProduto) {
				if (produtoVenda.getQuantidade() > 0 && produtoVenda.getQuantidade() >= qtdProduto) {
					
					int notaSaida = Produto.nfSaidaContador++;

					Produto proVenda = new Produto();
					proVenda.setDescricao(produtoVenda.getDescricao());
					proVenda.setQuantidade(qtdProduto);
					proVenda.setCodigo(produtoVenda.getCodigo());
					proVenda.setNotaFiscalSaida(notaSaida);
					proVenda.setVenda("venda");
					Produto.produtoSaida.add(proVenda);

					int qtdVendida = produtoVenda.getQuantidade() - qtdProduto;
					produtoVenda.setQuantidade(qtdVendida);

					System.out.println(proVenda);
					System.out.println("Produto Vendido\n");
					Produto.saidasDeProdutos++;
					r = true;
					break;
				} else if (produtoVenda.getCodigo() == codProduto && produtoVenda.getQuantidade() != qtdProduto){
					System.out.println("Produto Existe, mas não temos essa quantidade!\n");
					System.out.println("Repita o processo\n");
					r = true;
					break;
				}
			}
		}
		if (r == false) {
			System.out.println("Não existe produto com esse nome\n");
		}

		
		
	}

}
