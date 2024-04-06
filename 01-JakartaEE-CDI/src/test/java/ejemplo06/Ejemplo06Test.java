package ejemplo06;

import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

@EnableAutoWeld
@AddPackages(Evento.class)
class Ejemplo06Test {

	@Inject 
	private PublicadorEvento pulicadorEvento;
	
	@Test
	void test() {
		//Primer evento 3 observadores (a,b y c)
		pulicadorEvento.publicarEvento("Algo nuevo ha sucedido");
		//segundo evento 1 observador (NewObserver)
		pulicadorEvento.publishEvent("Nuevo evento creado");
	}

}
