package uva.poo.entrega2;
import java.util.ArrayList;
public class Claseprueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto pro1 = new Producto("666666666662", "patatas", 0.35);
		Producto pro2 = new Producto("666666666662", "pringles", 1.80);
		Pack pack = new Pack("pck1", "12");
		pack.add(pro1);
		pack.add(pro2);
		ArrayList<Producto> maq = new ArrayList<Producto>();
		//maq.add(pack);
		maq.add(pro1);
		
		for (Vendible vnd: maq){
			System.out.println(vnd.getPVP);
		}
	
		
	}

}
