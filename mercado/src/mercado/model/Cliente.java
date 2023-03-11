package mercado.model;

import java.util.Objects;

public class Cliente {

	private Long id;
	
	private String cpf;
	
	private String nome;
	
	private String telefone;

	public Cliente() {}
	
	public Cliente(Long id, String cpf, String nome, String telefone) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id, nome, telefone);
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
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + "]";
	}
}
