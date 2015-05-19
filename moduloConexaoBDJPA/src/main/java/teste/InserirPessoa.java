package teste;

import com.reuso.service.GenericService;
import com.reuso.service.impl.GenericServiceImpl;

public class InserirPessoa {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa("Jose");
		GenericService<Pessoa> service = new GenericServiceImpl<Pessoa>();
		service.save(pessoa);
	}
}
