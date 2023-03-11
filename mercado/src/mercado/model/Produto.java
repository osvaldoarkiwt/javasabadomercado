package mercado.model;

import java.util.Objects;

public class Produto {
	
	private Long codigo;
	
	private String nome;
	
	private Double preco;
	
	public Produto() {}

	public Produto(Long codigo, String nome, Double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nome, other.nome)
				&& Objects.equals(preco, other.preco);
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", preco=" + preco + "]";
	}
}
