/**
 * 
 */
package com.itq.cineService.endpoint;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	SalaRepository salaRespository;
	@Autowired
	FuncionRepository funcionRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	Date date = new Date();

	@GetMapping("/cine/sala")
	public Sala readSala(@RequestParam(name = "id") String id) {
		int idSala = Integer.parseInt(id);
		Sala sala = salaRespository.findById(idSala).get();

		logger.debug("Se ha leido la sala con el id: " + id);
		logger.info("La sala con el ID: " + id + " se ha creado con exito. Fecha:  " + date);

		return sala;
	}

	@GetMapping("/cine/funcion")
	public Funcion readFuncion(@RequestParam(name = "id") String id) {
		int idFuncion = Integer.parseInt(id);
		Funcion funcion = funcionRepository.findById(idFuncion).get();
		logger.debug("Se ha leido la funcion con el id: " + id);
		logger.info("La funcion con el ID: " + id + " se ha creado con exito. Fecha:  " + date);

		return funcion;
	}

	@PostMapping(value = "/cine/sala", consumes = ("application/json"), produces = ("application/json"))
	public Ack createSala(@Valid @RequestBody() Sala sala) {
		Ack ack = new Ack();

		salaRespository.save(sala);
		ack.setCode(0);
		ack.setDescripcion("Sala creada, ID: " + sala.getIdSala());
		logger.debug("Se ha creado la sala exitosamente");
		logger.info("La sala se ha creado con exito. ID:" + sala.getIdSala() + ", Fecha:  " + date);

		return ack;
	}

	@PostMapping(value = "/cine/funcion", consumes = ("application/json"), produces = ("application/json"))
	public Ack createFuncion(@Valid @RequestBody() Funcion funcion) {
		Ack ack = new Ack();

		funcionRepository.save(funcion);
		ack.setCode(0);
		ack.setDescripcion("Funcion creada");
		logger.debug("Se ha creado la funcion exitosamente");
		logger.info("La funcion se ha creado con exito. ID: " + funcion.getIdFuncion() + ", Fecha:  " + date);

		return ack;
	}

	@PutMapping(value = "/cine/funcion/estado", consumes = ("application/json"), produces = ("application/json"))
	public Ack putEstadoFuncion(@Valid @RequestBody EstadoFuncionBody funcion) throws NotValidIdException
	{
		Ack ack = new Ack();
		if(funcionRepository.existsById(funcion.getId()))
		{
			funcionRepository.setEstadoFuncionById(funcion.getEstado(), funcion.getId());
			ack.setCode(200);
			ack.setDescripcion("Estado modificado");
			logger.debug("ID funcion:"+ funcion.getId()+"nuevo estado: "+funcion.getEstado().toString());
			logger.info("La funcion con ID: "+ funcion.getId()+" se ha modificado con exito., Fecha:  "+ date );			
		}
		else
		{
			throw new NotValidIdException("ID no valido");
		}
		
		return ack;
	}
}
