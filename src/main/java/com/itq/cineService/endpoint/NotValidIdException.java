/**
 * 
 */
package com.itq.cineService.endpoint;

/**
 * @author edugo
 *
 */
public class NotValidIdException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6330899204892262654L;
	
	public NotValidIdException(String mensaje)
	{
		super(mensaje);
	}
}
