package Estoque;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Produto {
	private int codigo;
	private int quantidade;
	private String descricao;	
	private String unidadeDeMedida;
	private double preco;
	private double precoMedio;
	private double saldoMinimo;
	private double saldoMaximo;
	private double loteEconomicoDeCompra; //não sei o que fazer
	private int localNaPrateleira;
	private Date dataDaPrimeiraCompra;
	private Date dataDaUltimaCompra;
	private String observacao;
	private boolean devolucao = false;
	private String venda;
	private int notaFiscalEntrada;
	private int notaFiscalSaida;
	
	public static List<Produto> produtoEntrada = new ArrayList<>();
	public static List<Produto> produtoSaldo = new ArrayList<>();
	public static List<Produto> produtoSaida = new ArrayList<>();
	
	public static int quantidadeInstancias;
	public static int saidasDeProdutos;
	public static int nfSaidaContador = 0;
	public static int codigoGeral = 1;
	public static int LocalPrateleiraGeral = 1;

	// Getters and Setters -------------------------------------------------------------------------------------
	
	public int getCodigo() {return codigo;}
	public void setCodigo(int codigo) {this.codigo = codigo;}

	public int getQuantidade() {return quantidade;}
	public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}	
	
	public String getUnidadeDeMedida() {return unidadeDeMedida;}
	public void setUnidadeDeMedida(String unidadeDeMedida) {this.unidadeDeMedida = unidadeDeMedida;}
	
	public double getPreco() {return preco;}
	public void setPreco(double preco) {this.preco = preco;}
	
	public double getPrecoMedio() {return precoMedio;}
	public void setPrecoMedio(double precoMedio) {this.precoMedio = precoMedio;}
	
	public double getSaldoMinimo() {return saldoMinimo;}
	public void setSaldoMinimo(double saldoMinimo) {this.saldoMinimo = saldoMinimo;}
	
	public double getSaldoMaximo() {return saldoMaximo;}
	public void setSaldoMaximo(double saldoMaximo) {this.saldoMaximo = saldoMaximo;}
	
	public double getLoteEconomicoDeCompra() {return loteEconomicoDeCompra;}
	public void setLoteEconomicoDeCompra(double loteEconomicoDeCompra) {this.loteEconomicoDeCompra = loteEconomicoDeCompra;}
	
	public int getLocalNaPrateleira() {return localNaPrateleira;}
	public void setLocalNaPrateleira(int localNaPrateleira) {this.localNaPrateleira = localNaPrateleira;}
	
	public Date getDataDaPrimeiraCompra() {return dataDaPrimeiraCompra;}
	public void setDataDaPrimeiraCompra(Date dataDaPrimeiraCompra) {this.dataDaPrimeiraCompra = dataDaPrimeiraCompra;}
	
	public Date getDataDaUltimaCompra() {return dataDaUltimaCompra;}
	public void setDataDaUltimaCompra(Date dataDaUltimaCompra) {this.dataDaUltimaCompra = dataDaUltimaCompra;}
	
	public String getObservacao() {return observacao;}
	public void setObservacao(String observacao) {this.observacao = observacao;}
	
	public int getNotaFiscalEntrada() {return notaFiscalEntrada;}
	public void setNotaFiscalEntrada(int notaFiscalEntrada) {this.notaFiscalEntrada = notaFiscalEntrada;}
	
	public int getNotaFiscalSaida() {return notaFiscalSaida;}
	public void setNotaFiscalSaida(int notaFiscalSaida) {this.notaFiscalSaida = notaFiscalSaida;}
	
	public static int getNfSaidaContador() {return nfSaidaContador;}
	public static void setNfSaidaContador(int nfSaidaContador) {Produto.nfSaidaContador = nfSaidaContador;}

	public String getVenda() {return venda;}
	public void setVenda(String venda) {this.venda = venda;}
	
	public boolean isDevolucao() {return devolucao;}
	public void setDevolucao(boolean devolucao) {this.devolucao = devolucao;}
	
	// Métodos --------------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		String Produt = "Codigo: " + codigo + 
				"\nDescricao: " + descricao + " - Quantidade: " + quantidade + 
				"\nPreço Unitário:  R$" + preco + " - Preço Medio: R$" + precoMedio +
				"\nUnidade de Medida: " + unidadeDeMedida + " - Local na Prateleira: " + localNaPrateleira +
				"\nObservação: " + observacao + " - ";
		
		return Produt;
		}
}
