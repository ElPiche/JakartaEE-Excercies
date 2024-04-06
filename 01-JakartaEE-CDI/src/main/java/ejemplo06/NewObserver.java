package ejemplo06;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped

//Este observador escucha un nuevo evento

public class NewObserver {
	public void accept(@Observes Evento2 evento) {
        System.out.println("Soy un nuevo observador escuchando al evento 2 " + evento.getDescripcion());
	}
}
