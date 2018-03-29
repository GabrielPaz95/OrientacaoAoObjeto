package Estoque;

import java.util.ArrayList;

public class produto {
	
	private static int codigo;
	public double quantidade;
	public String descricao;
	
	//Getters and Setters
	public static int getCodigo() {
		return codigo;
	}
	public static void setCodigo(int codigo) {
		produto.codigo = codigo;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

}
