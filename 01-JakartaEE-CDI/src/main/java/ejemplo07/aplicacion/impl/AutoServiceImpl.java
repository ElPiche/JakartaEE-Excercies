package ejemplo07.aplicacion.impl;

import java.util.List;

import ejemplo07.aplicacion.AutoServices;
import ejemplo07.dominio.Auto;
import ejemplo07.dominio.AutoRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AutoServiceImpl implements AutoServices{
	
	
	@Inject
	private AutoRepositorio autoRepo;

	
	@Override
	public void agregarAuto(Integer id, String marca, String modelo) {
		System.out.println("Agregando auto nuevo");
		
		Auto nuevoAuto = new Auto (id, marca, modelo);
		autoRepo.agregar(nuevoAuto);
	}

	@Override
	public List<Auto> obtenerAutos() {
		System.out.println("Lista de autos del sistema");
		return autoRepo.findAll();
	}

}
