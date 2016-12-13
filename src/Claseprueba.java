package uva.poo.entrega2;
import java.util.ArrayList;
public class Claseprueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto pro1 = new Producto("666666666662", "patatas", 0.35);
		Producto pro2 = new Producto("666666666662", "pringles", 1.80);
		Producto pro3 = new Producto("666666666662", "pring", 1.30);
		Producto pro4 = new Producto("666666666662", "SanMiguel", 0.54);
		
		Producto[] lista_pack = {pro1, pro2, pro3};
		
		Pack pack1 = new Pack("pck1", "12", lista_pack);
		
		ArrayList<Vendible> maq = new ArrayList<Vendible>();
		maq.add(pack1);
		maq.add(pro1);
		maq.add(pro2);
		maq.add(pro3);
		
		pack1.add(pro4);
		pack1.remove(pro3);
		
		for (Vendible v: maq){
			System.out.println("Nombre: " + v.getNombre() + "\tPrecio: " + v.getPVP() + " €\tIdentificador: " + v.getIdentificador());
		}
		
	}

}
