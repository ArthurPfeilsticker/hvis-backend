package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private float preco;
	private int quantidade;

	
	public Produto() {
		id = -1;
		nome = "";
		descricao = "";
		preco = 0.00F;
		quantidade = 0;

	}

	public Produto(int id, String nome, String descricao, float preco, int quantidade) {
		setId(id);
		setNome(nome);
		setDescricao(descricao);
		setPreco(preco);
		setQuantidade(quantidade);
	}		
	
	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNome() {
		return nome;
	}

	public void setNome(int nome) {
		this.nome = nome;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	/**
	 * Método sobreposto da classe Object. É executado quando um objeto precisa
	 * ser exibido na forma de String.
	 */
	@Override
	public String toString() {
		return nome + "Descrição: " + descricao + "   Preço: R$" + preco + "   Quantidade.: " + quantidade;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getID() == ((Produto) obj).getID());
	}	
}