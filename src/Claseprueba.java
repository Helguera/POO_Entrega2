package uva.poo.entrega2;
import java.util.ArrayList;
public class Claseprueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto pro1 = new Producto("666666666662", "patatas", 0.29);
		Producto pro2 = new Producto("666666666662", "pringles", 1.80);
		Producto pro3 = new Producto("666666666662", "pring", 1.30);
		Producto pro4 = new Producto("666666666662", "SanMiguel", 0.54);
		Producto pro5 = new Producto("666666666662", "Zanahoria", 1.80);
		Producto pro6 = new Producto("666666666662", "Tomate", 1.30);
		
		Producto[] lista_pack = {pro1, pro2, pro3};
		Producto[] lista_pack2 = {pro4, pro5, pro5};
		
		Pack pack1 = new Pack("pck1", lista_pack);
		Pack pack2 = new Pack("pck2", lista_pack);
		
		ArrayList<Vendible> maq = new ArrayList<Vendible>();
		maq.add(pack1);
		//maq.add(pack2);
		for (Vendible v: maq){
			System.out.println("Nombre: " + v.getNombre() + "\tPrecio: " + v.getPVP() + " €\tIdentificador: " + v.getIdentificador());
		}
		
		
		/**
		 * Probamos si cambia el preciod el pack al cambiar
		 * el precio de un producto de su interior.
		 */
		pro3.setPVP(0.25);
		for (Vendible v: maq){
			System.out.println("Nombre: " + v.getNombre() + "\tPrecio: " + v.getPVP() + " €\tIdentificador: " + v.getIdentificador());
		}
		
	}

}
