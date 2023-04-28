package model;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private float preco;
	private int quantidade;
<<<<<<< HEAD
=======

>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
	
	public Produto() {
		id = -1;
		nome = "";
		descricao = "";
		preco = 0.00F;
		quantidade = 0;
<<<<<<< HEAD
		nome = "";
	}

	public Produto(int id, String nome, float preco, int quantidade, String descricao) {
=======

	}

	public Produto(int id, String nome, String descricao, float preco, int quantidade) {
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
		setId(id);
		setNome(nome);
		setDescricao(descricao);
		setPreco(preco);
		setQuantidade(quantidade);
<<<<<<< HEAD
		setNome(nome);
=======
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
	}		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
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
<<<<<<< HEAD
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
=======

>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3

	/**
	 * Método sobreposto da classe Object. É executado quando um objeto precisa
	 * ser exibido na forma de String.
	 */
	@Override
	public String toString() {
<<<<<<< HEAD
		return "Produto: " + descricao + "   Preço: R$" + preco + "   Quantidade.: " + quantidade;
=======
		return nome + "Descrição: " + descricao + "   Preço: R$" + preco + "   Quantidade.: " + quantidade;
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getId() == ((Produto) obj).getId());
	}	
}