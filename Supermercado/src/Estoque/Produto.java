package Estoque;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Produto {
	
	/*Os atributos de produto são: código, quantidade, unidade de medida, preço médio, saldo
mínimo, saldo máximo, lote econômico de compra, local na prateleira, data da primeira
compra, data da ultima compra, descrição e observação.*/

	private int codigo;
	private int quantidade;
	private String descricao;	
	private double unidadeDeMedida;
	private double preco;
	private double precoMedio;
	private double saldoMinimo;
	private double saldoMaximo;
	private double loteEconomicoDeCompra;
	private int localNaPrateleira;
	private Date dataDaPrimeiraCompra;
	private Date dataDaUltimaCompra;
	private String observacao;
	private boolean devolucao = false;
	
	public static List<Produto> produtoEntrada = new ArrayList<>();
	public static List<Produto> produtoSaldo = new ArrayList<>();
	public static List<Produto> produtoSaida = new ArrayList<>();
	
	public static int quantidadeInstancias;
	public static int saidasDeProdutos;
	public static int codigoGeral = 0001;

	// Getters and Setters -------------------------------------------------------------------------------------
	public boolean isDevolucao() {return devolucao;}
	public void setDevolucao(boolean devolucao) {this.devolucao = devolucao;}
	
	public int getCodigo() {return codigo;}
	public void setCodigo(int codigo) {this.codigo = codigo;}

	public int getQuantidade() {return quantidade;}
	public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}
	
	//apartir daqui, falta inserir no sistema
	public double getUnidadeDeMedida() {return unidadeDeMedida;}
	public void setUnidadeDeMedida(double unidadeDeMedida) {this.unidadeDeMedida = unidadeDeMedida;}
	
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

	// Métodos --------------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		String Produt = "Codigo: " + codigo + 
				"\nDescricao: " + descricao + " - Quantidade: " + quantidade + 
				"\nPreço Unitário:  " + preco + " - Preço Medio: " + precoMedio +
				"\nUnidade de Medida: " + unidadeDeMedida + " - Local na Prateleira: " + localNaPrateleira +
				"\nObservação: " + observacao + " - ";
		
		return Produt;
		}

}