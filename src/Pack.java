package uva.poo.entrega2;
import java.util.ArrayList;

/**
 * 
 * @author alvvela
 * @author javhelg
 *
 */
public class Pack implements Vendible {


	private boolean vendible = false;
	public void setNoVendible(){
		vendible = false;
	}
	public void setVendible(){
		vendible = true;
	}
	public boolean getVendible(){
		return vendible;
	}

	private ArrayList<Producto> pack;
	private String name; 
	
	
	public void Pack(String pack_name){
		name = pack_name;
	}
	
	public String getNombrePack(){
		return name;
	}
	
	protected void setProductoEnPack(Producto p){
		pack.add(p);
		if (pack.size()<2) setNoVendible(); else  setVendible();
	}
		
	public  String getProductosDelPack(){
		String prod2str = "";
		for (int p=0; p<pack.size(); p++){
			prod2str += pack.get(p).getNombre() + " ";
		}
		return prod2str;
	}

	public int getNumeroProductosPack(){
		return pack.size();
	}
	
	public double getPrecio(){
		double precio=0;
		for (int p=0; p<pack.size(); p++){
			precio += pack.get(p).getPVP();
		}
		return (precio*0.8);
	}
	
	public boolean contains(Producto producto){
		for (int p=0; p<pack.size(); p++){
			if (producto.equals(p))	return true;
		}
		return false;
	}
	
	
	
}
