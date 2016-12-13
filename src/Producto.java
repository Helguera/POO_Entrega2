package uva.poo.entrega2;


/**
 * 
 * @author alvvela
 * @author javhelg
 *
 */
public class Producto extends Vendible {

	
	 // IMPLEMENTADO DEBIDO A VENDIBLE
	
	/**
	 * 
	 * @return [double] Product price
	 */
	public double getPVP() {
		return pvp;
	}
	
	/**
	 * 
	 * @return [String] UPC product code
	 */
	
	 // PROPIO DE PRODUCTO
	
	private double pvp = 0;

	/**
	 * 
	 * @param code:
	 *            [String] Necessary to make UPC code
	 * @param nombre:
	 *            [String] Product name.
	 * @param pvp:
	 *            [double] Product price.
	 *
	 * @throws IllegalArgumentException
	 *			   String name cannot be empty.
	 *             Code length must be 11
	 *             PVP must be positive
	 */
	public Producto(String code, String nombre, double pvp) throws IllegalArgumentException {
		if (nombre.length() == 0) {
			throw new IllegalArgumentException("Inserte un nombre para el producto.");
		}
		if (code.length() != 12) {
			throw new IllegalArgumentException("El codigo debe ser de 12 digitos.");
		}
		if (pvp < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo.");
		}

		setIdentificador(code);
		this.nombre = nombre;
		this.pvp = pvp;
	}

	/**
	 * Function checks and sets UPC code.
	 * 
	 * @param code
	 *            Necessary to calculate UPC code.
	 * @return UPC code.
	 * @throws IllegalArgumentException
	 *             Code must be 12 digits and numbers.
	 * 		 
	 * 				
	 */
	private void setIdentificador(String code) throws IllegalArgumentException {

		if (code.length() != 12) {
			throw new IllegalArgumentException("El codigo debe ser de 12 digitos.");
		}
		for(int i=0;i<12;i++){
			if(code.charAt(i)<48 || code.charAt(i)>57){
				throw new IllegalArgumentException("El codigo tiene que ser numeros.");
			}
		}

		String strUPC = code;
		int last_digito = ((strUPC.charAt(0) - 48) * 3) + (strUPC.charAt(1) - 48) + ((strUPC.charAt(2) - 48) * 3)
				+ (strUPC.charAt(3) - 48) + ((strUPC.charAt(4) - 48) * 3) + (strUPC.charAt(5) - 48)
				+ ((strUPC.charAt(6) - 48) * 3) + (strUPC.charAt(7) - 48) + ((strUPC.charAt(8) - 48) * 3)
				+ (strUPC.charAt(9) - 48) + ((strUPC.charAt(10) - 48) * 3);
		int m = ((last_digito / 10) + 1) * 10;
		last_digito = m - last_digito;
		//strUPC = strUPC + Integer.toString(last_digito);
		if (last_digito!=(strUPC.charAt(11)-48)){
			throw new IllegalArgumentException("El codigo UPC es incorrecto");
		} else { identificador = strUPC; }
	}

	/**
	 * 
	 * Change product price
	 * 
	 * @param pvp
	 *			[int] new product price
	 * @throws IllegalArgumentException
	 *			Price must be positive.
	 */
	public void setPVP(double pvp) throws IllegalArgumentException {
		if (pvp < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo.");
		}
		this.pvp = pvp;
	}

}
