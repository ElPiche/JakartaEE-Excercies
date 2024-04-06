package ejemplo06;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
public class PublicadorEvento  implements PublishEventInterface{
	
	@Inject
	private Event<Evento> eventoConcreto;
	
	public void publicarEvento(String descEvento) {
		
		//Disparo evento
		//Observar que el Notificador/Publicador no conoce (no está acoplado de ninguna manera)
		//a los escuchas)
		Evento e = new Evento(descEvento);
		eventoConcreto.fire(e);
		
		System.out.println("Notificando evento: " + descEvento);
	}
	
	@Inject
	private Event<Evento2> newEvent;
	
	public void publishEvent(String eventDescription) {
		
		Evento2 e2 = new Evento2(eventDescription);
		newEvent.fire(e2);
		System.out.println("Notificando nuevo evento creado por Lucas para todos los observadores: " + eventDescription);
		
	}
	 
}



