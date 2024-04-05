package ejemplo07.dominio;

import java.util.List;

public interface AutoRepositorio {
	
	List<Auto> findAll();
	void agregar(Auto  autinho);
}
