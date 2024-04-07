package example00.aplicacion;

import java.util.List;

import example00.dominio.*;

public interface PagoService {
	public int realizarPago(int monto);
	public List<Pago> obtenerPagos();
	//LT
	public int montoTotal();
}
