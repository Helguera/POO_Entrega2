package uva.poo.entrega2;
import java.util.ArrayList;
/**
 *
 * @author alvvela
 * @author javhelg
 *
 */
public class Pack extends Vendible {

	public static int id_pack=42; // Pack ID starts at 42.
	private ArrayList<Producto> pack = new ArrayList<Producto>();
	
	// IMPLEMENTADO DEBIDO A VENDIBLE.
	
	/**
	 * @return <double> price.
	 */
	@Override
	public double getPVP() {
		double precio = 0;
		for (Producto p: pack) {
			precio += p.getPVP();
		};
		int p = (int) (precio*100*0.8);
		return precio = (double) p/100;
	}

	// PROPIO DEL PACK
	
	/**
	 * 
	 * @param name:
	 * 				<String> Pack name.
	 * @param identificador:
	 * 				<String> Pack identification.
	 * @param lista_pack:
	 * 				<Producto[]> Pack initial product.
	 */
	public Pack(String name, Producto[] lista_pack) throws IllegalArgumentException {
		if (lista_pack.length<2) throw new IllegalArgumentException ("El pack debe tener 2 o mas productos.\n");
		if (name.length() == 0) throw new IllegalArgumentException ("El pack debe tener un nombre");
		add(lista_pack);
		nombre = name;
		setIdentificador();
	}
	
	/**
	 * 
	 * @param p:
	 * 			<Producto[]> Product list to add.
	 */
	public void add (Producto[] p ) throws IllegalArgumentException{
		if (p.length == 0) throw new IllegalArgumentException("No se ha añadido ningun producto.");
		for (Producto prd: p){
			add(prd);
		}
	}	
	
	/**
	 * 
	 * @param p:
	 * 			<Producto> Product to add at pack. 
	 * @throws IllegalArgumentException
	 * 			The product p can not be two times in the pack.
	 */
	public void add (Producto p)throws IllegalArgumentException {
		if (pack.contains(p)) throw new IllegalArgumentException("Hay productos repetidos en el pack.");
		else pack.add(p);
	}

	/**
	 * 
	 * @return <String> Pack products list.
	 */
	public String getProductosDelPack() {
		String prod2str = "";
		for (int p = 0; p < pack.size(); p++) {
			if (p != pack.size()-1) prod2str += pack.get(p).getNombre() + " + ";
			else prod2str += pack.get(p).getNombre() + ".";
		}
		return prod2str;
	}

	/**
	 * 
	 * @return <int> Pack size.
	 */
	public int size() {
		return pack.size();
	}

	/**
	 * 
	 * @param producto:
	 * 				<Producto> Product that we want to know if is in the pack.
	 * @return <boolean> True = producto is in the pack.
	 */
	public boolean contains(Producto producto) {
		// for (int p=0; p<pack.size(); p++){
		for (Producto p : pack) {
			if (producto.equals(p))
				return true;
		}
		return false;
	}

	/**
	 *  
	 * @param producto:
	 * 				<Producto> Product to remove.
	 * @throws IllegalArgumentException
	 * 				Pack must be 2 or more products.
	 * 
	 */
	public void remove(Producto producto)throws IllegalArgumentException {
		if (contains(producto)){
			for (int i=0; i<pack.size(); i++){
				if (producto.equals(pack.get(i)))
					pack.remove(i);
			}
		}
		if (pack.size()<2) throw new IllegalArgumentException("Asegurese de que el pack tenga siempre 2 o mas productos.");
	}

	/**
	 * Set the product ID.
	 */
	private void setIdentificador(){
		identificador=Integer.toString(id_pack);
		id_pack++;
	}
	
}
