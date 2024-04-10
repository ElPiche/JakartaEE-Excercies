package api.aplicacion.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import api.Empleado;
import api.Tarea;
import api.aplicacion.IControladorService;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ControladorServiceImpl implements IControladorService {

	List<Empleado> empleados;
	List<Tarea> tareas;
	
	
	@PostConstruct
	public void inicializar() {
		inicializarEmpleados();
		inicializarTareas();
	}
	
	public void inicializarEmpleados() {
		System.out.println("Invocando PostConstruct");
		this.empleados = new ArrayList<Empleado>();
		empleados.add(new Empleado(1,"Luis", "1.321.321-5", null));
		empleados.add(new Empleado(2,"Mirta", "2.321.515-8", null));
		empleados.add(new Empleado(3,"Pepe", "4.236.565-5", null));
		empleados.add(new Empleado(4,"Juan", "5.985.582-3", null));

	}

	public void inicializarTareas() {
        this.tareas = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now();
        
        // Aquí podrías agregar tareas ficticias manualmente
        tareas.add(new Tarea(1, "Hacer informe", fechaActual , fechaActual.plusDays(10)));
        tareas.add(new Tarea(2, "Revisar correos", fechaActual , fechaActual.plusDays(20)));
        tareas.add(new Tarea(3, "Preparar presentación", fechaActual , fechaActual.plusDays(30)));     
    }
	
	
	@Override
	public void agregarEmpleados(Integer id, String nombre, String cedula) {
		empleados.add(new Empleado(id,nombre,cedula, null));
		
	}

	@Override
	public void borrarEmpleados(Integer id) {
		Empleado empleadoABorrar = obtenerEmpleado(id);
		if(empleadoABorrar.getTareasEmpleado() == null) {
			empleados.remove(empleadoABorrar);			
		}
		
	}

	@Override
	public List<Empleado> listarEmpleados() {
		return this.empleados;
	}

	@Override
	public Empleado obtenerEmpleado(Integer id) {
		
		for(int i = 0; i < this.empleados.size(); i++) {
			if(this.empleados.get(i).getId().equals(id)) {
				return this.empleados.get(i);
			}
		}	
		return null;
	}
	
	@Override
	public Tarea obtenerTarea(Integer id) {
		
		for(int i = 0; i < this.tareas.size(); i++) {
			if(this.tareas.get(i).getId().equals(id)) {
				return this.tareas.get(i);
			}
		}
		
		return null;
	}

	@Override
	public void agregarTareaEmpleado(Integer idEmpleado, Integer idTarea) {
		Empleado empleado = obtenerEmpleado(idEmpleado);
		
		Tarea tarea = obtenerTarea(idTarea);
		
		empleado.agregarTarea(tarea);
	
	}

	@Override
	public List<Tarea> listarTareas() {
		return this.tareas;
	}
	
	@Override
	public List<Tarea> listaTareasEmpleado(Integer idEmpleado) {
		
		for(int i = 0; i < this.empleados.size(); i++) {
			if(this.empleados.get(i).getId().equals(idEmpleado)) {
				return this.empleados.get(i).getTareasEmpleado();
			}
		}
		
		return null;
	}

}
