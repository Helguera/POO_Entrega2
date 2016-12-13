package uva.poo.entrega2;

import java.util.ArrayList;

/**
 * 
 * @author alvvela
 * @author javhelg
 *
 */
public class Pack extends Vendible {

	public double getPVP() {
		double precio = 0;
		for (Producto p: pack) {
			precio += p.getPVP();
		};
		int p = (int) (precio*100*0.8);
		return precio = (double) p/100;
	}

	// PROPIO DEL PACK

	private ArrayList<Producto> pack = new ArrayList<Producto>();
	
	public Pack(String pack_name, String identificador, Producto[] lista_pack) {
		nombre = pack_name;
		this.identificador = identificador;
		if (lista_pack.length>2){
			add(lista_pack);
		}
	}
	
	public void add (Producto[] p ){
		for (Producto prd: p){
			add(prd);
		}
	}
	
	
	
	public void add (Producto p)throws IllegalArgumentException {
		if (pack.contains(p)) throw new IllegalArgumentException("Hay productos repetidos en el pack.");
		pack.add(p);
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

	public void remove(Producto producto)throws IllegalArgumentException {
		if (contains(producto)){
			for (int i=0; i<pack.size(); i++){
				if (producto.equals(pack.get(i)))
					pack.remove(i);
			}
		}
		if (pack.size()<3) throw new IllegalArgumentException("Asegurese de que el pack tenga siempre 3 o mas productos.");
	}
}
