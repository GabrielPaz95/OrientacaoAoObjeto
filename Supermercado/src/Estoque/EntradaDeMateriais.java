package Estoque;

public class EntradaDeMateriais {
	Produto pNovo = new Produto();
	// 1 - CADASTRAR OK
	public void cadastrar(Produto p) {		
		int cod = Produto.codigoGeral++;
		int localPrateleira = Produto.LocalPrateleiraGeral++;
		
		// se a lista estiver vazia
		if (Produto.produtoEntrada.isEmpty() && Produto.produtoSaldo.isEmpty()) {
			Produto pE = new Produto();
			pE.setCodigo(cod);
			pE.setDescricao(p.getDescricao());
			pE.setQuantidade(p.getQuantidade());
			pE.setDataDaPrimeiraCompra(p.getDataDaPrimeiraCompra());
			pE.setPreco(p.getPreco());
			double precoMedio = (((pE.getQuantidade() * pE.getPreco()) + (p.getQuantidade() * p.getPreco())) / (p.getQuantidade()));
			pE.setPrecoMedio(precoMedio);
			pE.setNotaFiscalEntrada(p.getNotaFiscalEntrada());
			pE.setUnidadeDeMedida(p.getUnidadeDeMedida());
			pE.setLocalNaPrateleira(localPrateleira);
			pE.setObservacao(p.getObservacao());
			Produto.produtoEntrada.add(pE);

			Produto pS = new Produto();
			pS.setCodigo(cod);
			pS.setDescricao(p.getDescricao());
			pS.setQuantidade(p.getQuantidade());
			pS.setDataDaPrimeiraCompra(p.getDataDaPrimeiraCompra());
			pS.setDataDaUltimaCompra(p.getDataDaUltimaCompra());
			pS.setPreco(p.getPreco());
			precoMedio = (((pS.getQuantidade() * pS.getPreco()) + (p.getQuantidade() * p.getPreco())) / (p.getQuantidade()));
			pS.setPrecoMedio(precoMedio);
			pS.setUnidadeDeMedida(p.getUnidadeDeMedida());
			pS.setLocalNaPrateleira(localPrateleira);
			pS.setObservacao(p.getObservacao());
			Produto.produtoSaldo.add(pS);

			System.out.println("Primeiro Produto Cadastrado!\n");
			Produto.quantidadeInstancias++;
		}
		else {
			// Atualiza Saldo
			for (Produto pSaldo : Produto.produtoSaldo) {				
				int qtd = 0;
				
				if (pSaldo.getDescricao().equals(p.getDescricao())) {
					pSaldo.setCodigo(pSaldo.getCodigo());
					pSaldo.setDescricao(p.getDescricao());
					qtd = pSaldo.getQuantidade() + p.getQuantidade();
					pSaldo.setQuantidade(qtd);
					pSaldo.setDataDaUltimaCompra(p.getDataDaUltimaCompra());
					pSaldo.setPreco(p.getPreco());
					double precoMedio = (((pSaldo.getQuantidade() * pSaldo.getPreco()) + (p.getQuantidade() * p.getPreco())) / (qtd));
					pSaldo.setPrecoMedio(precoMedio);
					pSaldo.setUnidadeDeMedida(p.getUnidadeDeMedida());
					pSaldo.setLocalNaPrateleira(pSaldo.getLocalNaPrateleira());
					pSaldo.setObservacao(p.getObservacao());
					
					Produto pNovo = new Produto();
					pNovo.setCodigo(pSaldo.getCodigo());
					pNovo.setDescricao(p.getDescricao());
					pNovo.setQuantidade(p.getQuantidade());
					pNovo.setNotaFiscalEntrada(p.getNotaFiscalEntrada());
					pNovo.setDataDaPrimeiraCompra(pNovo.getDataDaPrimeiraCompra());					
					pNovo.setPreco(p.getPreco());
					precoMedio = (((pNovo.getQuantidade() * pNovo.getPreco()) + (p.getQuantidade() * p.getPreco())) / (qtd));
					pNovo.setPrecoMedio(precoMedio);
					pNovo.setNotaFiscalEntrada(p.getNotaFiscalEntrada());
					pNovo.setUnidadeDeMedida(p.getUnidadeDeMedida());
					pNovo.setDataDaPrimeiraCompra(p.getDataDaPrimeiraCompra());
					pNovo.setLocalNaPrateleira(pSaldo.getLocalNaPrateleira());
					pNovo.setObservacao(p.getObservacao());
					Produto.produtoEntrada.add(pNovo);

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
						Produto pEntrada1 = new Produto();
						pEntrada1.setCodigo(cod);
						pEntrada1.setDescricao(p.getDescricao());
						pEntrada1.setQuantidade(p.getQuantidade());
						pEntrada1.setDataDaPrimeiraCompra(p.getDataDaPrimeiraCompra());
						pEntrada1.setPreco(p.getPreco());
						double precoMedio = (((pEntrada1.getQuantidade() * pEntrada1.getPreco()) + (p.getQuantidade() * p.getPreco())) / (p.getQuantidade()));
						pEntrada1.setPrecoMedio(precoMedio);
						pEntrada1.setNotaFiscalEntrada(p.getNotaFiscalEntrada());
						pEntrada1.setUnidadeDeMedida(p.getUnidadeDeMedida());
						pEntrada1.setLocalNaPrateleira(localPrateleira);
						pEntrada1.setObservacao(p.getObservacao());
						Produto.produtoEntrada.add(pEntrada1);
						
						precoMedio = 0;

						Produto pSaldo = new Produto();
						pSaldo.setCodigo(cod);
						pSaldo.setDescricao(p.getDescricao());
						pSaldo.setQuantidade(p.getQuantidade());
						pSaldo.setDataDaPrimeiraCompra(p.getDataDaPrimeiraCompra());
						pSaldo.setDataDaUltimaCompra(p.getDataDaUltimaCompra());
						precoMedio = (((pSaldo.getQuantidade() * pSaldo.getPreco()) + (p.getQuantidade() * p.getPreco())) / (p.getQuantidade()));
						pSaldo.setPrecoMedio(precoMedio);
						pSaldo.setPreco(p.getPreco());
						pSaldo.setUnidadeDeMedida(p.getUnidadeDeMedida());
						pSaldo.setLocalNaPrateleira(localPrateleira);
						pSaldo.setObservacao(p.getObservacao());
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
			System.out.println(pEntrada + "- Nota Fiscal: " + pEntrada.getNotaFiscalEntrada() + "\nPrimeiraCompra: "
					+ pEntrada.getDataDaPrimeiraCompra() + "\n------------------------------------------------");
		}
		System.out.println("\n\n");
	}
}