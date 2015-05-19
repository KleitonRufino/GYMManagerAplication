package teste;

import javax.persistence.Persistence;

public class GerarTabela {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("dev");
	}
}
