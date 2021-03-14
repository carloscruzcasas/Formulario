package Formulario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Formulario.entity.Personas;

//Con la anotación @Repository logramos tomar los métodos CRUD para asi realizar la implementación del servicio.
@Repository
public interface IPersonaRepository extends CrudRepository<Personas, String>{
	// Se traen desde la clase Personas la información del tipo de atributo del id, en este caso nombre que es un String.	
}
