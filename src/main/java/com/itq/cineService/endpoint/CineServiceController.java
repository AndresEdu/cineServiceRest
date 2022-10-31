/**
 * 
 */
package com.itq.cineService.endpoint;

import javax.validation.Valid;

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

	@GetMapping("/cine/sala")
	public Sala readSala(@RequestParam(name = "id") String id)
	{
		Sala sala = new Sala();
		sala.setCantColumnas(3);
		sala.setCantFilas(3);
		sala.setEstado("Disponible");
		sala.setIdSala(Integer.parseInt(id));
		
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
		
		return funcion;
	}
	@PostMapping(value = "/cine/sala", consumes = ("application/json"), produces = ("application/json"))
	public Ack createSala(@Valid @RequestBody() Sala sala)
	{
		Ack ack = new Ack();

		ack.setCode(0);
		ack.setDescripcion("Sala creada");
		
		return ack;
	}
	
	@PostMapping(value = "/cine/funcion", consumes = ("application/json"), produces = ("application/json"))
	public Ack createFuncion(@Valid @RequestBody() Funcion funcion)
	{
		Ack ack = new Ack();

		ack.setCode(0);
		ack.setDescripcion("Funcion creada");
		
		return ack;
	}
	
	@PutMapping(value = "/cine/putEstado", consumes = ("application/json"), produces = ("application/json"))
	public Ack putEstadoFuncion(@Valid @RequestBody Funcion funcion)
	{
		Ack ack = new Ack();

		ack.setCode(0);
		ack.setDescripcion("Estado modificado");
		
		return ack;
	}
}
