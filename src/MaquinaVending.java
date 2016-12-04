package uva.poo.entrega2;
import fabricante.externo.tarjetas.TarjetaMonedero;


/**
 * 
 * @author alvvela
 * @author javhelg
 *
 */
public class MaquinaVending {
	
	private int num_filas;
	private Producto productoDeLaFila[];
	private int unidadesDeLaFila[];
	
	/**
	 * MaquinaVending CONSTRUCTOR
	 * 
	 * @param num_filas 
	 * 				[int] row number of the machine.
	 * @throws IllegalArgumentException
	 * 				row must be bigger than 0.
	 * 
	 */
	public MaquinaVending (int num_filas) throws IllegalArgumentException {
		if (num_filas<1){ throw new IllegalArgumentException ("La filas minimas son 1.");}
		this.num_filas=num_filas;
		productoDeLaFila = new Producto[num_filas];
		unidadesDeLaFila = new int [num_filas];
		for (int i = 0; i<(num_filas); i++){
				productoDeLaFila[i] = new Producto ("00000000000", "vacio", 0);
				unidadesDeLaFila[i] = 0;
		}
	}

	/**
	 * Dada una fila, se untroducen unidades de un determinado producto.
	 * 
	 * @param fila
	 * 				[int] Fila en la que se desea operar. [0, num_fila-1]
	 * @param producto
	 * 				[Producto] Contiene las características de un determinado producto.
	 * @param unidades
	 * 				[int] Unidades que se van a introducir de ese determinado producto.
	 * @throws IllegalArgumentException 
	 * 				La fila tiene que estar en el dominio [0, num_filas)
	 * 				Las unidades no pueden ser negativas.
	 * 
	 */
	public void setProductosEnFila (int fila, Producto producto, int unidades) throws IllegalArgumentException{
		if (fila>=num_filas || fila<0){	throw new IllegalArgumentException ("Las filas posibles estan en [0, " + num_filas + "].\n");	}
		if (unidades < 0){			throw new IllegalArgumentException ("Debe introducir alguna unidad entera positiva.\n");		}
		unidadesDeLaFila[fila] = unidades;
		productoDeLaFila[fila] = producto;		
	}
	
	/**
	 * Metodo que cambia las unidades de una determinada fila.
	 * 
	 * @param fila 
	 * 				[int] Numero de fila en la que se desea operar. [0, num_filas)
	 * @param unidades 
	 * 				[int] Cantidad que queremos introducir.
	 * @throws IllegalArgumentException 
	 * 				La fila tiene que estar en el dominio [0, num_filas)
	 * 				Las unidades no pueden ser negativas.
	 * 
	 */
	public void setUnidades(int fila, int unidades) throws IllegalArgumentException {
		if (num_filas<=fila || fila<0){ 	throw new IllegalArgumentException ("Las filas posibles estan en [0, " + num_filas + ").\n");	}
		if (unidades < 0){					throw new IllegalArgumentException ("Debe introducir alguna unidad entera positiva.\n");		}
		unidadesDeLaFila[fila] = unidades;
	}

	/**
	 * 
	 * @param fila
	 * 				[int] Numero de la fila en la que se desea operar. [0, num_filas)
	 * @return [int] Unidades de esa fila.
	 * @throws IllegalArgumentException 
	 * 				La fila tiene que estar en el dominio [0, num_filas)
	 */
	public int getUnidadesDisponiblesDeLaFila(int fila) throws IllegalArgumentException {
		if (num_filas<=fila || fila<0){ 	throw new IllegalArgumentException ("Las filas posibles estan en [0, " + num_filas + ").\n");	}
		return unidadesDeLaFila[fila];
	}
	
	/**
	 * Metodo que cambia el precio de una determinada fila.
	 * 
	 * @param fila
	 * 				[int] Numero de la fila en la que se desea operar. [0, num_filas)
	 * @param precio
	 * 				[double] Nuevo coste para esa fila.
	 * @throws IllegalArgumentException
	 *  			La fila tiene que estar en el dominio: [0, num_filas)
	 *  			El precio no puede ser menor que 0.
	 *  
	 */
	public void setPrecio (int fila, double precio) throws IllegalArgumentException {
		if (num_filas<=fila || fila<0){ 	throw new IllegalArgumentException ("Las filas posibles estan en [0, " + num_filas + ").\n");	}
		if (precio<0) { 					throw new IllegalArgumentException ("El precio no puede ser negativo");							}
		
		productoDeLaFila[fila].setPVP(precio);
	}
	
	/**
	 * Devuelve el precio de una unidad de una determinada fila.
	 * 
	 * @param fila
	 * 				[int] Numero de la fila en la que se desea operar. [0, num_filas)
	 * @return [double] Precio de esa fila.
	 * @throws IllegalArgumentException
	 * 				La fila tiene que estar en el dominio [0, num_filas)
	 * 
	 */
	public double getPrecio (int fila)  throws IllegalArgumentException {
		if (num_filas<=fila || fila<0){ 	throw new IllegalArgumentException ("Las filas posibles estan en [0, " + num_filas + ").\n");	}
		return productoDeLaFila[fila].getPVP();
	}
	
	/**
	 * Devuelve el nombre del producto que hay en una determinada fila.
	 * 
	 * @param fila
	 * 				[int] Numero de la fila en la que se desea operar. [0, num_filas)
	 * @return [String] Nombre del producto
	 * @throws IllegalArgumentException
	 * 				La fila tiene que estar en el dominio [0, num_filas)
	 */
	public String getNombreProductoDeLaFila(int fila)  throws IllegalArgumentException {
		if (num_filas<=fila || fila<0){ 	throw new IllegalArgumentException ("Las filas posibles estan en [0, " + num_filas + ").\n");	}
		return productoDeLaFila[fila].getNombre();
	}
	
	/**
	 * Implementacion que intenta efectuar una compra.
	 * 
	 * @param fila
	 * 				[int] Numero de la fila en la que se desea operar. [0, num_filas)
	 * @param tarjeta
	 * 				[TarjetaMonedero] Tarjeta con la que se desea operar.
	 * @param credencial
	 * 				[String] Codigo de la tarjeta que permite descontar saldo de ella.
	 * @return [boolean] Devuelve true si se puede realizar la compra.
	 * @throws IllegalArgumentException
	 * 				La fila tiene que estar en el dominio [0, num_filas)
	 * 
	 */
	public boolean comprarProductoDeLaFila(int fila, TarjetaMonedero tarjeta, String credencial)   throws IllegalArgumentException {
		if (num_filas<=fila || fila<0){ 	throw new IllegalArgumentException ("Las filas posibles estan en [0, " + num_filas + ").\n");	}
		boolean compra = false;
		if (unidadesDeLaFila[fila]>0){
			if (productoDeLaFila[fila].getPVP() <= tarjeta.getSaldoActual()){
				unidadesDeLaFila[fila]-=1;
				tarjeta.descontarDelSaldo(credencial, productoDeLaFila[fila].getPVP());
				compra = true;
			}
		}
		return compra;
	}		

}
