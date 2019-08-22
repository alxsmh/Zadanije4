/**
 * Exception for not finding the object
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 * @see Exception
 */
package exceptions;

public class ElementNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String cargo;
	
	public ElementNotFoundException(String cargo)
	{
		super("No elements found "+ cargo);
		
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

}
