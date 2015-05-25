package teste;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa {
	@Id
	private Long id;
	private String nome;

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	
}
