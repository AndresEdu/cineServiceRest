/**
 * 
 */
package com.itq.cineService.endpoint;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itq.cineService.dto.Ack;
import com.itq.cineService.dto.Funcion;
import com.itq.cineService.dto.Sala;


/**
 * @author edugo
 *
 */

@RestController
public class CineServiceController {

	private final Logger logger  = LoggerFactory.getLogger(this.getClass());
    Date date = new Date();

	
	@GetMapping("/cine/sala")
	public Sala readSala(@RequestParam(name = "id") String id)
	{
		Sala sala = new Sala();
		sala.setCantColumnas(3);
		sala.setCantFilas(3);
		sala.setEstado("Disponible");
		sala.setIdSala(Integer.parseInt(id));
		
		logger.debug("Se ha leido la sala con el id: " + id);
		logger.info("La sala con el ID: "+id+" Fecha:  "+ date );
		logger.error("No se pudo leer la sala");
		
		return sala;
	}
	
	@GetMapping("/cine/funcion")
	public Funcion readFuncion(@RequestParam(name = "id") String id)
	{
		Funcion funcion = new Funcion();
		funcion.setCostoBoleto(50);
		funcion.setEstado("Disponible");
		funcion.setFecha("12/06/2022");
		funcion.setHora("12:30");
		funcion.setIdFuncion(1);
		funcion.setIdPelicula(1);
		funcion.setIdSala(Integer.parseInt(id));
		
		logger.debug("Se ha leido la funcion con el id: " + id);
		logger.info("La funcion con el ID: "+id+" Fecha:  "+ date );
		logger.error("No se pudo leer la funcion");
		
		return funcion;
	}
	@PostMapping(value = "/cine/sala", consumes = ("application/json"), produces = ("application/json"))
	public Ack createSala(@Valid @RequestBody() Sala sala)
	{
		Ack ack = new Ack();

		ack.setCode(0);
		ack.setDescripcion("Sala creada");
		logger.debug("Se ha creado la sala exitosamente");
		logger.info("La sala se ha creado con exito. Fecha:  "+ date );
		logger.error("No se pudo crear la sala");
		
		return ack;
	}
	
	@PostMapping(value = "/cine/funcion", consumes = ("application/json"), produces = ("application/json"))
	public Ack createFuncion(@Valid @RequestBody() Funcion funcion)
	{
		Ack ack = new Ack();

		ack.setCode(0);
		ack.setDescripcion("Funcion creada");
		logger.debug("Se ha creado la funcion exitosamente");
		logger.info("La funcion se ha creado con exito. Fecha:  "+ date );
		logger.error("No se pudo crear la funcion");
		
		return ack;
	}
	
	@PutMapping(value = "/cine/putEstado", consumes = ("application/json"), produces = ("application/json"))
	public Ack putEstadoFuncion(@Valid @RequestBody Funcion funcion)
	{
		Ack ack = new Ack();

		ack.setCode(0);
		ack.setDescripcion("Estado modificado");
		logger.debug("Se ha modificado el estado de la funcion exitosamente");
		logger.info("La funcion se ha modificado con exito. Fecha:  "+ date );
		logger.error("No se pudo modificar el estado de la funcion ");
		
		return ack;
	}
}
