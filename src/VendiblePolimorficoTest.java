package uva.poo.entrega2;

import static org.junit.Assert.*;

import org.junit.Test;

public class VendiblePolimorficoTest {


	@Test
	public void test_Creacion_Polimorfica(){
		Vendible vProd1 = new Producto("111111111117", "Vendible1", 0.35);
		Vendible vProd2 = new Producto("222222222224", "Vendible2", 1.80);
		Producto[] lista = {(Producto)vProd1, (Producto)vProd2};
		Vendible vPack = new Pack ("Vendible3", lista);
	}

	@Test
	public void test_Uso_Polimorfismo(){
		
		Producto Prod1 = new Producto("111111111117", "Vendible1", 0.35);
		Producto Prod2 = new Producto("222222222224", "Vendible2", 1.80);
		
		Producto[] lista = {Prod1, Prod2};
		Pack Pack = new Pack ("Vendible3", lista);
		
		Vendible[] maquina = {Prod1, Prod2, Pack};
		
		assertEquals(maquina[0].getPVP(), 0.35, 0.01);
		assertEquals(maquina[1].getPVP(), 1.80, 0.01);
		assertEquals(maquina[2].getPVP(), (0.35+1.80)*0.8, 0.01);
		
		assertEquals(maquina[0].getNombre(), "Vendible1");
		assertEquals(maquina[1].getNombre(), "Vendible2");
		assertEquals(maquina[2].getNombre(), "Vendible3");
		
		assertEquals(maquina[0].getIdentificador(), "111111111117");
		assertEquals(maquina[1].getIdentificador(), "222222222224");
		assertEquals(maquina[2].getIdentificador(), "43");
		
	}
}
