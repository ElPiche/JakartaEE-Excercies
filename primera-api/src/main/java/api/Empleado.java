package api;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	private String cedula;

	@Transient
	private List<Tarea> tareasEmpleado;
	
	public Empleado() {
		
	}
	
	public Empleado(Integer id, String nombre, String cedula, List<Tarea> tareasEmpleado) {
		this.nombre = nombre;
		this.id = id;
		this.cedula = cedula;
		this.tareasEmpleado = tareasEmpleado;
	}
	
	public Empleado(Integer id) {
		this.id = id;
	}

	public List<Tarea> getTareasEmpleado() {
		return tareasEmpleado;
	}

	public void setTareasEmpleado(List<Tarea> tareasEmpleado) {
		this.tareasEmpleado = tareasEmpleado;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public void agregarTarea(Tarea tarea) {
		if(tareasEmpleado == null){
			tareasEmpleado = new ArrayList<>(); //inicializacion de la lista de tareas en caso de ser vacía
		}
	
		tareasEmpleado.add(tarea);
	}
	
	@Override
	public String toString() {
		return "Empleado [id:" + id + "\nNombre:" + nombre + "\nCedula:" + cedula + "\nTareas:" + tareasEmpleado + "]\n";
	}	
	
}
