package ejemplo07.infraestructura.persistencia;

import java.util.ArrayList;
import java.util.List;

import ejemplo07.dominio.Auto;
import ejemplo07.dominio.AutoRepositorio;
import ejemplo07.dominio.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JpaAutoRepositorio implements AutoRepositorio{

	private List<Auto> autinhos;
	
	@PostConstruct
	public void Cargar() {
		autinhos = new ArrayList<Auto>();
		autinhos.add(new Auto(0,"Fiat","Uno"));
		autinhos.add(new Auto(1,"Fiat","Cronos"));
		autinhos.add(new Auto(2,"Renault","Fluence"));

	}
	
	
	@Override
	public List<Auto> findAll() {
		return autinhos;
	}

	@Override
	public void agregar(Auto autinho) {
		autinhos.add(autinho);
		
	}

}
