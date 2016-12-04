package uva.poo.entrega2;


/**
 * 
 * @author alvvela
 * @author javhelg
 *
 */
public class Producto {

	private String nombre;
	private String UPC;
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
		if (code.length() != 11) {
			throw new IllegalArgumentException("El codigo debe ser de 11 digitos.");
		}
		if (pvp < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo.");
		}

		this.UPC = setUPC(code);
		this.nombre = nombre;
		this.pvp = pvp;
	}

	/**
	 * Implementation of the UPC code. Private because nobodies can change UPC.
	 * 
	 * @param code
	 *            [String] UPC code.
	 * @throws IllegalArgumentException
	 *             Code must be 11 digits.
	 * 		 	   Code must be all numbers
	 * 				
	 */
	private String setUPC(String code) throws IllegalArgumentException {

		if (code.length() != 11) {
			throw new IllegalArgumentException("El codigo debe ser de 11 digitos.");
		}
		for(int i=0;i<11;i++){
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
		strUPC = strUPC + Integer.toString(last_digito);
		return strUPC;
	}

	/**
	 * 
	 * @return [String] UPC product code
	 */
	public String getUPC() {
		return UPC;
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

	/**
	 * 
	 * @return [double] Product price
	 */
	public double getPVP() {
		return pvp;
	}

	/**
	 * 
	 * @return [String] Product name.
	 */
	public String getNombre() {
		return nombre;
	}

}
