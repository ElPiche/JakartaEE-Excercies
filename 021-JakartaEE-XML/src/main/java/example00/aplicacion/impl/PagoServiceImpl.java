package example00.aplicacion.impl;

import java.util.ArrayList;
import java.util.List;

import example00.aplicacion.PagoService;
import example00.dominio.*;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PagoServiceImpl implements PagoService {
	List<Pago> pagos;
	
	@PostConstruct
	private void inicializar() {
		System.out.println("Inicializando Pagos");
		this.pagos = new ArrayList<Pago>();
		pagos.add(new Pago(1,1000));
		pagos.add(new Pago(2,2000));
	}
	
	@Override
	public int realizarPago(int monto) {
		int idPago = pagos.size() + 1;
		Pago pago = new Pago(idPago, monto);
		
		pagos.add(pago);
		return idPago;
	}

	@Override
	public List<Pago> obtenerPagos() {
		System.out.println("Devolviendo Pagos");
		return this.pagos;
		
		
	}
	
	//LT
	@Override
	public int montoTotal() {
		int montos = 0;
		List<Pago> pagosASumar = obtenerPagos();
		for(Pago pagos : pagosASumar) {
			montos = montos + pagos.getMonto();
		}
		
		return montos;
	}

}
