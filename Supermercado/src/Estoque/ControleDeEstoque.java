package Estoque;
public class ControleDeEstoque {
	Produto pNovo = new Produto();
	public static int dev = 0;

	// 3 - TODAS AS SAIDAS REGISTRADAS - OK
	public void saidasEstoque() {
		System.out.println("Quantidade de Saidas de estoque: " + Produto.saidasDeProdutos);
		for (Produto pSaidas : Produto.produtoSaida) {
			if (pSaidas.isDevolucao() == true) {
				System.out.println(pSaidas + "Devolução: " + pSaidas.isDevolucao());
				System.out.println("\n------------------------------------------------");
			}
			System.out.println("\n\n");
		}
	}
	// 4 - SALDO ATUAL - OK
	public void saldoEstoque() {
		System.out.println("Saldo Estoque: ");
		for (Produto pSaldo : Produto.produtoSaldo) {
			System.out.println(pSaldo + "- Ultima Compra: " + pSaldo.getDataDaUltimaCompra());
			System.out.println("\n------------------------------------------------");
		}
	}
	// 5 - REQUISIÇÃO DE PRODUTOS - OK
	public void requisicaoEstoque(String descricao, int qtd) {
		boolean r = false;
		for (Produto produto : Produto.produtoSaldo) {
			if (produto.getDescricao().equals(descricao)) {
				if (produto.getQuantidade() > 0 && produto.getQuantidade() >= qtd) {

					Produto pSaida = new Produto();
					pSaida.setDescricao(produto.getDescricao());
					pSaida.setQuantidade(qtd);
					pSaida.setCodigo(produto.getCodigo());
					Produto.produtoSaida.add(pSaida);

					int qtdRequistado = produto.getQuantidade() - qtd;
					produto.setQuantidade(qtdRequistado);

					System.out.println(pSaida);
					System.out.println("Produto requisitado\n");
					Produto.saidasDeProdutos++;
					r = true;
					break;
				} else if (produto.getDescricao().equals(descricao) && produto.getQuantidade() != qtd) {
					System.out.println("Produto Existe, mas não temos em estoque!\n");
					r = true;
					break;
				}
			}
		}
		if (r == false) {
			System.out.println("Não existe produto com esse nome\n");
		}

	}
	// 6 - DEVOLUÇÃO DE PRODUTOS - OK
	public void devolver(String devolucao, int qtdDevolucao) {
		boolean devEstoque = false;

		for (Produto produtoSaida : Produto.produtoSaida) {
			if (produtoSaida.getQuantidade() == qtdDevolucao && produtoSaida.getDescricao().equals(devolucao)
					&& produtoSaida.isDevolucao() == false) {
				produtoSaida.setDevolucao(true);
				produtoSaida.setVenda("devolucao");

				for (Produto pSaldo : Produto.produtoSaldo) {
					if (pSaldo.getDescricao().equals(devolucao)) {
						pSaldo.setDescricao(devolucao);
						int qtd = pSaldo.getQuantidade() + qtdDevolucao;
						pSaldo.setQuantidade(qtd);
					}
					devEstoque = true;

					System.out.println("Produto Devolvido\n");
					break;
				}
				break;
			} else if (produtoSaida.getQuantidade() != qtdDevolucao && produtoSaida.getDescricao().equals(devolucao)
					&& produtoSaida.isDevolucao() == false) {
				System.out.println("Quantidade diferente da requisitada, porfavor refaça a devolucao correta\n");
				devEstoque = true;
			}
		}

		if (devEstoque == false) {
			System.out.println("Produto não consta na lista de requisitados!\n");
		}
	}
	// 7 - CONSULTA ESTOQUE - OK
	public void consultaProdutosAtivos(String descricao) {
		boolean achou = false;
		for (Produto produto : Produto.produtoSaldo) {
			if (produto.getDescricao().equals(descricao)) {
				System.out.println(produto);
				achou = true;
				break;
			}
		}
		if (achou == false) {
			System.out.println("NÃO EXISTE! ");
		}
	}
	// 8 - EXCLUIR PRODUTO - OK
	public void excluir(String exclusao) {
		if (Produto.produtoEntrada.size() > 0) {
			int excluirEntradaContador = 0;

			do {
				for (Produto excluirEntrada : Produto.produtoEntrada) {
					if (excluirEntrada.getDescricao().equals(exclusao)) {
						Produto.produtoEntrada.remove(excluirEntrada);
						Produto.quantidadeInstancias--;
						break;
					}
				}
				excluirEntradaContador++;
			} while (excluirEntradaContador <= Produto.produtoEntrada.size());

			System.out.println("Excluido ProdutoEntrada");
		}
		if (Produto.produtoSaldo.size() > 0) {
			int excluirSaldoContador = 0;

			do {
				for (Produto excluirSaldo : Produto.produtoSaldo) {
					if (excluirSaldo.getDescricao().equals(exclusao)) {
						Produto.produtoSaldo.remove(excluirSaldo);
						break;
					}
				}
				excluirSaldoContador++;
			} while (excluirSaldoContador <= Produto.produtoSaldo.size());

			System.out.println("Excluido ProdutoSaldo");
		}
		if (Produto.produtoSaida.size() > 0) {
			int excluirSaidaContador = 0;
			do {
				for (Produto excluirSaida : Produto.produtoSaida) {
					if (excluirSaida.getDescricao().equals(exclusao)) {
						Produto.produtoSaida.remove(excluirSaida);
						Produto.saidasDeProdutos--;
						break;
					}
				}
				excluirSaidaContador++;
			} while (excluirSaidaContador <= Produto.produtoSaida.size());
			System.out.println("Excluido ProdutoSaida");
		}
	}
}