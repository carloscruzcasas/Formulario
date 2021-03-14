package Formulario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Formulario.entity.Personas;
import Formulario.repository.IPersonaRepository;
import Formulario.service.PersonaService;

@RestController
@RequestMapping("/formulario")
public class PersonasController {

	//Se llama a la clase PersonaService, para poder tomar los métodos que allí estan establecidos.
	@Autowired
	private PersonaService personaService;
	
	//Se enlaza el metodo de ver a todas las persona con la operación CRUD  GET y asi lograr tomar la información.
	@GetMapping("/verTodasPersonas")
	public List<Personas> getAllPersonas(){
		 List<Personas> personas0 = null;
		 personas0 = (List<Personas>) personaService.getAllPersonas();
		return personas0;
	}
	
	//Se enlaza el metodo que nos permite crear un nuevo usuario con un la operación CRUD POST.
	@PostMapping("/crearRegistro")
	//RequesyBody nos toma la información en un formato en especifico para cargar y crear la misma.
	public Personas crearNuevaPersona(@RequestBody Personas personas) {
		personas.setProcesado(false);
		return this.personaService.crearNuevaPersona(personas);
	}

	//Se enlaza el metodo que nos permite modificar el campo en especifico con un la operación CRUD PUT, de igual manera se debe de escribir el nombre para que identifique el usuario y cambio el estado.
	@PutMapping("/Procesado/{nombre}")
	public ResponseEntity<Personas> cambiarProcesado(@PathVariable(value ="nombre")String nombre){
		return this.personaService.cambiarProcesado(nombre);
		}
	
	//Se llama al método que retorna un solo registro con el método GET.
	@GetMapping("/Nombre/{nombre}")
	public Optional<Personas> getPersonasPorNombre(@PathVariable(value ="nombre")String nombre){
		 return personaService.tomarPorNombre(nombre);
	}
	
}
