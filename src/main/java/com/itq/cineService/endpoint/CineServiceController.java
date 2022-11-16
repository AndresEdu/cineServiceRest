/**
 * 
 */
package com.itq.cineService.endpoint;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itq.cineService.dto.Ack;
import com.itq.cineService.dto.EstadoFuncionBody;
import com.itq.cineService.dto.Funcion;
import com.itq.cineService.dto.Sala;
import com.itq.cineService.repository.*;

/**
 * @author edugo
 *
 */

@RestController
public class CineServiceController {
	@Autowired
	SalaRepository salaRepository;
	@Autowired
	FuncionRepository funcionRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	Date date = new Date();

	@GetMapping("/cine/sala")
	public Sala readSala(@RequestParam(name = "id") String id) throws NotValidIdException {
		
		logger.debug("Iniciando método readSala. Fecha: " + date);
		int idSala = Integer.parseInt(id);
		Sala sala = null;
		logger.debug("Se intento leer el Id sala: " + idSala +"Fecha: " + date);
		
		//Revisar si existe una sala en la base de datos con el id ingreso
		if (salaRepository.existsById(idSala)) {
			//Obtener la sala de la base de datos
			sala = salaRepository.findById(idSala).get();
			logger.debug("Sala con ID: "+ idSala +" recuperada con exito de la base de datos.");			
			logger.info("Se leyo con exito la sala con el ID: " + id +".");
		} else {
			logger.debug("Se leyo sin exito la sala con el ID: " + id + "Fecha: "+ date);
			//Levantar una excepción si el id no se encuentra en la base de datos
			throw new NotValidIdException("ERROR: Id no encontrado en la base de datos.");
		}
		logger.debug("Termina método readSala. Fecha: " + date);
		// Regresar la sala como response 
		return sala;
	}

	@GetMapping("/cine/funcion")
	public Funcion readFuncion(@RequestParam(name = "id") String id) throws NotValidIdException {
		
		logger.debug("Iniciando método readFuncion. Fecha: " + date);
		
		int idFuncion = Integer.parseInt(id);
		logger.debug("Iniciando a leer la funcion con el idFuncion: "+idFuncion);
		
		Funcion funcion = null;
		//Verificar que exista la función en la base de datos
		if (funcionRepository.existsById(idFuncion)) {
			//Obtener la función de la base de datos
			funcion = funcionRepository.findById(idFuncion).get();
			logger.debug("Funcion con ID: "+ idFuncion+" recuperada de la base de datos.");
			logger.info("Se leyo la funcion con el ID: " + idFuncion +".");
		} else {
			logger.debug("No se ha podido encontrar la funcion con el idFuncion: "+idFuncion+". Fecha: " + date);
			logger.info("No existe la funcion con el ID: " + idFuncion);
			//Levantar una excepción si la función no se encuentra 
			throw new NotValidIdException("ERROR: Id no encontrado en la base de datos");
		}
		logger.debug("Termina método readFuncion. Fecha: " + date);
		//Regresar la función como response
		return funcion;
	}

	@PostMapping(value = "/cine/sala", consumes = ("application/json"), produces = ("application/json"))
	public Ack createSala(@Valid @RequestBody() Sala sala) throws NotValidIdException {
		
		logger.debug("DEBUG: Iniciando método createSala. Fecha: " + date);
		
		Ack ack = new Ack();

		int idSala = sala.getIdSala();
		//Verificar que no existe una sala con ese id
		if (!salaRepository.existsById(idSala)) {
			//Guardar la sala en la base de datos
			salaRepository.save(sala);			
			ack.setCode(200);
			ack.setDescripcion("Sala creada");
			logger.debug("Nueva sala:\n"
					+ "ID: " + Integer.toString(sala.getIdSala()) 
					+ "CantFilas" + Integer.toString(sala.getCantFilas())
					+ "CantColumnas" + Integer.toString(sala.getCantColumnas())
					+ "Estado:" + sala.getEstado());
			logger.info("La sala se ha creado con exito");
		} else {			
			logger.debug("No se pudo crear la sala. Fecha: " + date);
			//Levantar excepción cuando ya existe el ID
			throw new NotValidIdException("Ya existe una sala con ese ID");
		}
		logger.debug("Termina método createSala. Fecha: " + date);
		// Regresar mensaje exitoso como response
		return ack;
	}

	@PostMapping(value = "/cine/funcion", consumes = ("application/json"), produces = ("application/json"))
	public Ack createFuncion(@Valid @RequestBody() Funcion f) {
		
		logger.debug("Iniciando método createFuncion. Fecha: " + date);
		
		Ack ack = new Ack();
		//Guardar función en la base de datos
		Funcion funcion = funcionRepository.save(f);
		ack.setCode(200);
		ack.setDescripcion("Función creada");
		logger.debug("Nueva función creada:\n"
				+ "ID " + Integer.toString(funcion.getIdFuncion())
				+ "Fecha: "+ f.getFecha()
				+ "Hora: "+ f.getHora()
				+ "IdPelicula: "+ Integer.toString(f.getIdPelicula())
				+ "IdSala: "+ Integer.toString(f.getIdSala())
				+ "CostoBoleto: "+	Float.toString(f.getCostoBoleto())
				+ "Estado: "+ f.getEstado());
		logger.info("La función con id"+ funcion.getIdFuncion() + "se ha creado con exito.");
		logger.debug("Termina método createFuncion. Fecha: " + date);
		// Regresar mensaje exitoso como response
		return ack;
	}

	@PutMapping(value = "/cine/funcion/estado", consumes = ("application/json"), produces = ("application/json"))
	public Ack putEstadoFuncion(@Valid @RequestBody EstadoFuncionBody funcion) throws NotValidIdException {
		Ack ack = new Ack();
		logger.debug("Iniciando método putEstadoFuncion. Fecha: " + date);
		int idFuncion = funcion.getIdFuncion();
		logger.debug("ID funcion: " + idFuncion);
		logger.debug("Nuevo estado: " + funcion.getEstado());
		
		//Verificar que la función exista en la base de datos
		if (funcionRepository.existsById(idFuncion)) {
			//Cambiar el estado de la función
			funcionRepository.setEstadoFuncionById(funcion.getEstado(), idFuncion);
			ack.setCode(200);
			ack.setDescripcion("Estado modificado");
			logger.debug("ID funcion:" + idFuncion + "nuevo estado: " + funcion.getEstado().toString());
			logger.info("La funcion con ID: " + idFuncion + " se ha modificado con exito, Fecha:  " + date);
		} else {			
			logger.debug("La funcion con ID: " + idFuncion + "no se ha encontrado en la base de datos. Fecha " + date);
			//Levantar excepción si no existe la función
			throw new NotValidIdException("ERROR: Id no encontrado en la base de datos");
		}
		logger.debug("Termina método putEstadoFuncion, Fecha: " + date);
		//Regresar mensaje de exito como response
		return ack;
	}
}
