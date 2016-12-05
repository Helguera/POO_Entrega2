package uva.poo.entrega2;

import java.util.ArrayList;

/**
 * 
 * @author alvvela
 * @author javhelg
 *
 */
public class Pack implements Vendible {

	// IMPLEMENTADO DEBIDO A VENDIBLE

	public void setNoVendible() {
		vendible = false;
	}

	public void setVendible() {
		vendible = true;
	}

	public boolean getVendible() {
		return vendible;
	}

	public String getNombre() {
		return name;
	}

	public double getPVP() {
		double precio = 0;
		for (int p = 0; p < pack.size(); p++) {
			precio += pack.get(p).getPVP();
		}
		return (precio * 0.8);
	}

	public String getIdentificador() {
		return IDdelPack;
	}

	// PROPIO DEL PACK

	private ArrayList<Producto> pack;
	private String name;
	private String IDdelPack;
	private boolean vendible = false;

	public Pack(String pack_name, String identificador) {
		name = pack_name;
		IDdelPack = identificador;
	}

	protected void add(Producto p) throws IllegalArgumentException {
		if (pack.contains(p))
			throw new IllegalArgumentException("Inserte un nombre para el producto.");
		else
			pack.add(p);
		if (pack.size() < 2)
			setNoVendible();
		else
			setVendible();
	}

	public String getProductosDelPack() {
		String prod2str = "";
		for (int p = 0; p < pack.size(); p++) {
			prod2str += pack.get(p).getNombre() + " ";
		}
		return prod2str;
	}

	public int size() {
		return pack.size();
	}

	public boolean contains(Producto producto) {
		// for (int p=0; p<pack.size(); p++){
		for (Producto p : pack) {
			if (producto.equals(p))
				return true;
		}
		return false;
	}

	public void remove(Producto producto){
		if (contains(producto)){
			for (int i=0; i<pack.size(); i++){
				if (producto.equals(pack.get(i)))
					pack.remove(i);
			}
		}
	}
}
