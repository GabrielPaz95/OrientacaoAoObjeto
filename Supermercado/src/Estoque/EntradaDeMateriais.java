package Estoque;

import java.util.Date;

public class EntradaDeMateriais {
	Produto pNovo = new Produto();
	
	/* Entrada de Materiais: permitir o apontamento de nf e gerar como resultado a
inserção de produto no estoque atualizando a quantidade e o preço médio do
produto. */

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
//			pE.setPrecoMedio(p.);
			Produto.produtoEntrada.add(pE);

			Produto pS = new Produto();
			pS.setDescricao(p.getDescricao());
			pS.setQuantidade(p.getQuantidade());
			pS.setDataDaPrimeiraCompra(new Date()); // ARRUMAR
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
					pSaldo.setDataDaUltimaCompra(p.getDataDaUltimaCompra());//arrumar
					
					p.setCodigo(pSaldo.getCodigo());					
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
						
						Produto pEentrada = new Produto();
						pEentrada.setCodigo(cod);
						pEentrada.setDescricao(p.getDescricao());
						pEentrada.setQuantidade(p.getQuantidade());
						pEntrada.setDataDaPrimeiraCompra(p.getDataDaPrimeiraCompra());
						pEntrada.setPreco(p.getPreco());
						Produto.produtoEntrada.add(pEentrada);

						Produto pSaldo = new Produto();
						pSaldo.setCodigo(cod);
						pSaldo.setDescricao(p.getDescricao());
						pSaldo.setQuantidade(p.getQuantidade());
						pSaldo.setDataDaPrimeiraCompra(p.getDataDaPrimeiraCompra());
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
			System.out.println(pEntrada + "\n - PrimeiraCompra: " + pNovo.getDataDaPrimeiraCompra()
			+ "\n------------------------------------------------");
		}
		System.out.println("\n\n");
	}

}
