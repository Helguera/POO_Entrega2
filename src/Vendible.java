package uva.poo.entrega2;


/**
 * 
 * @author alvvela
 * @author javhelg
 *
 */
public abstract class Vendible {
	protected String identificador;
	protected String nombre;
	protected double getPVP;
	
	/**
	 * 
	 * @return [String] Name
	 */
	String getNombre(){
		return nombre;
	}
	
	/**
	 * 
	 * @return [String] ID
	 */
	String getIdentificador(){
		return identificador;
	}
	
	/**
	 * 
	 * @return [double] Price
	 */
	abstract double getPVP();

}
