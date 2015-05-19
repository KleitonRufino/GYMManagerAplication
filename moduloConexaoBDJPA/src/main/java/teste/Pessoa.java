package teste;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue
	public int id;
	public String nome;

	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}

}
