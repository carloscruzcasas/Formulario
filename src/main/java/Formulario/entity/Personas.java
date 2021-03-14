package Formulario.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Desde esta clase se realiza la asignación de los datos al usuario a registrar.

@Entity
@Table(name ="Personas")
public class Personas {
	
	//Con la anotación de @Id, se identifica el atributo que será el principal dentro de cada objeto.
	@Id
	private String nombre;
	private String apellido;
	private Boolean procesado;
	public Personas(String nombre, String apellido, Boolean procesado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.procesado = procesado;
	}
	public Personas() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Boolean getProcesado() {
		return procesado;
	}
	public void setProcesado(Boolean procesado) {
		this.procesado = procesado;
	}
	@Override
	public String toString() {
		return "Personas [nombre=" + nombre + ", apellido=" + apellido + ", procesado=" + procesado + "]";
	}
	
	
}
