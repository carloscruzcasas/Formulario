package Formulario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Formulario.entity.Personas;
import Formulario.repository.IPersonaRepository;

//Desde esta clase se crean los métodos CRUD para que desde el controlador los podamos llamar desde el frontend y realizar el consumo del servicio.
@Service
public class PersonaService {
	
	//Llamamos a la interfaz para poder obtener las operaciones CRUD.
	@Autowired
	private IPersonaRepository iPersonaRepository;

	//Método que permite llamar la lista de los usuarios registrados.
	public List<Personas> getAllPersonas() {
		return (List<Personas>) iPersonaRepository.findAll();
	}
	
	//Método que permite realizar la creación de un nuevo objeto del tipo Persona.
	public Personas crearNuevaPersona(Personas personas) {
		return iPersonaRepository.save(personas);
	}
	
	//Método que permite cambiar el estado de "procesado" dentro del usuario de FALSE a TRUE
	public ResponseEntity<Personas> cambiarProcesado(String nombre) {
		ResponseEntity<Personas> persona1 = null;
		//Desde un try catch se toma la información para que se pueda realizar la modificación de la información.
		try {
			//Primero se busca el usuario con el nombre (dato que es el id del mismo).
			Personas personn = iPersonaRepository.findById(nombre).orElseThrow();
			//Se modifica directamente el campo y se almacena.
			personn.setProcesado(true);
			final Personas actualizarPersonas = iPersonaRepository.save(personn);
			//Se actualiza la información dentro de la lista de usuarios.
			persona1 = ResponseEntity.ok(actualizarPersonas);
		} catch (Exception e) {
		}
		return persona1;
		
	}

	//Método que llama directamente a un usuario conociendo el nombre directamente.
	public Optional<Personas> tomarPorNombre(String nombre) {
		return this.iPersonaRepository.findById(nombre);
	}
}
