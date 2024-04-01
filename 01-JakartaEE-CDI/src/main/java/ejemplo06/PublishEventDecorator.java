package ejemplo06;

import jakarta.annotation.Priority;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@Decorator
@Priority(1) //para habilitar el uso del Decorador
public class PublishEventDecorator implements PublishEventInterface{

	@Inject
	@Delegate
	private PublicadorEvento eventPublisherDecorator;

	@Override
	public void publicarEvento(String descEvento) {
		System.out.println("Agregando funcionalidades al metodo del publicador usando un decorator: " + descEvento);
		eventPublisherDecorator.publicarEvento(descEvento);
		
	}

	@Override
	public void publishEvent(String eventDescritption) {
		System.out.println("Agregando funcionalidades al metodo del publicador creado por lucas usando un decorator: " + eventDescritption);
		eventPublisherDecorator.publishEvent(eventDescritption);
		
	}
	
	
}
