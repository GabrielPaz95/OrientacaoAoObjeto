package Estoque;

public class ControleDeVenda {
	Produto pVenda = new Produto();

	// 4 - TODAS AS VENDAS REGISTRADAS - OK
	public void saidasVendas() {
		System.out.println("Quantidade de Vendas: " + Produto.nfSaidaContador);
		if (Produto.nfSaidaContador != 0) {
			for (Produto pSaidasVendas : Produto.produtoSaida) {
				if (pSaidasVendas.getVenda().equals("venda")) {
					System.out.println(pSaidasVendas + "Nota Saida: " + pSaidasVendas.getNotaFiscalSaida());
					System.out.println("------------------------------------------------------------");
				}
			}
		}
		else System.out.println("Não existe vendas cadastradas");
		System.out.println("\n\n");
	}

	// CONTROLE DE VENDAS
	public void controleDeVenda(int codProduto, int qtdProduto) {

		boolean r = false;

		System.out.println(" - Controle de vendas - ");

		for (Produto produtoVenda : Produto.produtoSaldo) {
			if (produtoVenda.getCodigo() == codProduto) {
				if (produtoVenda.getQuantidade() > 0 && produtoVenda.getQuantidade() >= qtdProduto) {

					Produto proVenda = new Produto();
					proVenda.setDescricao(produtoVenda.getDescricao());
					proVenda.setQuantidade(qtdProduto);
					proVenda.setCodigo(produtoVenda.getCodigo());
					proVenda.setNotaFiscalSaida(Produto.nfSaidaContador);
					proVenda.setVenda("venda");
					proVenda.setPreco(produtoVenda.getPreco());
					proVenda.setUnidadeDeMedida(produtoVenda.getUnidadeDeMedida());
					proVenda.setLocalNaPrateleira(produtoVenda.getLocalNaPrateleira());
					Produto.produtoSaida.add(proVenda);

					int qtdVendida = produtoVenda.getQuantidade() - qtdProduto;
					produtoVenda.setQuantidade(qtdVendida);

					System.out.println(proVenda);
					System.out.println("Produto Confirmado\n");
					Produto.saidasDeProdutos++;
					r = true;
					break;
				} else if (produtoVenda.getCodigo() == codProduto && produtoVenda.getQuantidade() != qtdProduto) {
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
