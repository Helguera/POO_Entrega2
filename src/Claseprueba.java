package uva.poo.entrega2;
import java.util.ArrayList;
public class Claseprueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto pro1 = new Producto("666666666662", "patatas", 0.35);
		Producto pro2 = new Producto("666666555553", "pringles", 1.80);
		Producto pro3 = new Producto("666666444444", "pring", 1.30);
		Producto pro4 = new Producto("666666333335", "SanMiguel", 0.54);
		Producto pro5 = new Producto("666666222226", "doritos", 5);

		Producto[] lista_pack = {pro1, pro2, pro3};

		Pack pack1 = new Pack("pck1", lista_pack);
		pack1.add(pro5);
		Pack pack2 = new Pack("pck2", lista_pack);

		ArrayList<Vendible> maq = new ArrayList<Vendible>();
		maq.add(pack1);
		maq.add(pack2);
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
