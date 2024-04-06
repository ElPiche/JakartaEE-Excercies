package ejemplo06;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
//este observador escucha una nueva instancia, pero del mismo evento.
public class ObserverEventC {
	
	public void eventC(@Observes Evento event){
		System.out.println("Soy un nuevo observador C y he recibido un evento: " + event.getDescripcion());
	}	
}
