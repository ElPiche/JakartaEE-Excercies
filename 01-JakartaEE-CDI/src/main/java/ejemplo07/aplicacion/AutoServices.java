package ejemplo07.aplicacion;

import java.util.List;

import ejemplo07.dominio.Auto;

public interface AutoServices {

	public void agregarAuto(Integer id, String marca, String modelo);
	public List<Auto> obtenerAutos();

}
