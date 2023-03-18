package model;

import java.util.Objects;

public class Cliente {
	
	private Long id;
	private String nome;
	private String agencia;
	private String conta;
	
	public Cliente() {
	
	}

	public Cliente(Long id, String nome, String agencia, String conta) {
		
		this.id = id;
		this.nome = nome;
		this.agencia = agencia;
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia, conta, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(agencia, other.agencia) && Objects.equals(conta, other.conta)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", agencia=" + agencia + ", conta=" + conta + "]";
	}

}
