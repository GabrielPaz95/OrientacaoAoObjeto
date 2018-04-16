package Estoque;

public class EntradaDeMateriais {
	Produto pNovo = new Produto();

	/*
	 * Entrada de Materiais: permitir o apontamento de nf e gerar como resultado a
	 * inserção de produto no estoque atualizando a quantidade e o preço médio do
	 * produto.
	 */
	
	//FALTA PREÇO MEDIO

	// 1 - CADASTRAR OK
	public void cadastrar(Produto p) {
		// se a lista estiver vazia
		if (Produto.produtoEntrada.isEmpty() && Produto.produtoSaldo.isEmpty()) {

			int cod = Produto.codigoGeral++;

			Produto pE = new Produto();
			pE.setDescricao(p.getDescricao());
			pE.setQuantidade(p.getQuantidade());
			pE.setDataDaPrimeiraCompra(p.getDataDaPrimeiraCompra());
			pE.setCodigo(cod);
			pE.setPreco(p.getPreco());
			pE.setPrecoMedio(p.getPreco());
			pE.setNotaFiscalEntrada(p.getNotaFiscalEntrada());
			Produto.produtoEntrada.add(pE);

			Produto pS = new Produto();
			pS.setDescricao(p.getDescricao());
			pS.setQuantidade(p.getQuantidade());
			pS.setDataDaPrimeiraCompra(p.getDataDaPrimeiraCompra());
			pS.setDataDaUltimaCompra(p.getDataDaUltimaCompra());
			pS.setCodigo(cod);
			pS.setPreco(p.getPreco());
			Produto.produtoSaldo.add(pS);

			System.out.println("Primeiro Produto Cadastrado!\n");
			Produto.quantidadeInstancias++;
		}

		else {
			// Atualiza Saldo
			for (Produto pSaldo : Produto.produtoSaldo) {
				if (pSaldo.getDescricao().equals(p.getDescricao())) {
					pSaldo.setDescricao(p.getDescricao());
					int qtd = pSaldo.getQuantidade() + p.getQuantidade();
					pSaldo.setQuantidade(qtd);
					pSaldo.setCodigo(pSaldo.getCodigo());
					pSaldo.setPreco(p.getPreco());
					double precoMedio = (((qtd * pSaldo.getPreco()) + (qtd + pSaldo.getPreco())) / (qtd + ) )
					pSaldo.setPrecoMedio(precoMedio);
					pSaldo.setDataDaUltimaCompra(p.getDataDaUltimaCompra());

					p.setCodigo(pSaldo.getCodigo());
					p.setDataDaPrimeiraCompra(pSaldo.getDataDaPrimeiraCompra());
					p.setNotaFiscalEntrada(p.getNotaFiscalEntrada());
					Produto.produtoEntrada.add(p);

					System.out.println("Produto já existe, foi Atualizado!\n");
					Produto.quantidadeInstancias++;
					break;
				}
			}
			// Produto Novo
			boolean t = false;

			for (Produto pEntrada : Produto.produtoEntrada) {
				if (pEntrada.getDescricao().equals(p.getDescricao())) {
					t = true;
				}
			}

			if (t == false) {
				for (Produto pEntrada : Produto.produtoEntrada) {
					if (!pEntrada.getDescricao().equals(p.getDescricao())) {

						int cod = Produto.codigoGeral++;

						Produto pEntrada1 = new Produto();
						pEntrada1.setCodigo(cod);
						pEntrada1.setDescricao(p.getDescricao());
						pEntrada1.setQuantidade(p.getQuantidade());
						pEntrada1.setDataDaPrimeiraCompra(p.getDataDaPrimeiraCompra());
						pEntrada1.setPreco(p.getPreco());
						pEntrada1.setNotaFiscalEntrada(p.getNotaFiscalEntrada());
						Produto.produtoEntrada.add(pEntrada1);

						Produto pSaldo = new Produto();
						pSaldo.setCodigo(cod);
						pSaldo.setDescricao(p.getDescricao());
						pSaldo.setQuantidade(p.getQuantidade());
						pSaldo.setDataDaPrimeiraCompra(p.getDataDaPrimeiraCompra());
						pSaldo.setDataDaUltimaCompra(p.getDataDaUltimaCompra());
						pSaldo.setPreco(p.getPreco());
						Produto.produtoSaldo.add(pSaldo);

						System.out.println("Produto Cadastrado!\n");
						Produto.quantidadeInstancias++;
						break;
					}
				}
			}
		}
	}

	// 2 - TODAS AS ENTRADAS REGISTRADAS - OK
	public void entradasEstoque() {
		System.out.println("Quantidade de produtos cadastrados: " + Produto.quantidadeInstancias);
		for (Produto pEntrada : Produto.produtoEntrada) {
			System.out.println(pEntrada + "\n - Nota Fiscal: " + pEntrada.getNotaFiscalEntrada() + " - PrimeiraCompra: "
					+ pEntrada.getDataDaPrimeiraCompra() + "\n------------------------------------------------");
		}
		System.out.println("\n\n");
	}

}
