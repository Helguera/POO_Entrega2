package uva.poo.entrega2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PackTest {

	Producto pro1 = new Producto("111111111117", "Producto1", 0.35);
	Producto pro2 = new Producto("222222222224", "Producto2", 1.80);
	Producto pro3 = new Producto("333333333331", "Producto3", 1.30);
	Producto pro4 = new Producto("444444444448", "Producto4", 0.20);
	Producto pro5 = new Producto("555555555555", "Producto5", 0.25);
	Producto pro6 = new Producto("666666666662", "Producto6", 0.60);

	Producto[] lista1 = { pro1, pro2 };
	double lista1_precio = (pro1.getPVP() + pro2.getPVP()) * 0.8;

	Producto[] lista2 = { pro4, pro5 };
	double lista2_precio = (pro4.getPVP() + pro5.getPVP()) * 0.8;

	/* ------------- VALIDO ------------------*/
	
	/**
	 * La inicializacion valida debe ser mediante un array de Productos, no
	 * pudiendo haber dos iguales en el mismo pack.
	 */
	@Test
	public void testInicializacion_Valido() {

		Pack pck1 = new Pack("P", lista1);
		assertEquals(pck1.getIdentificador(), "43");
		assertEquals(pck1.getNombre(), "P");
		assertEquals(pck1.getPVP(), lista1_precio, 0.01);
		assertEquals(pck1.getProductosDelPack(), "Producto1 + Producto2.");

	}

	/**
	 * 
	 * Test sobre la posibilidad de a�adir una lista de productos 
	 * a un pack  ya creado.
	 * 
	 */
	@Test
	public void test_AddLista_Valido() {

		Pack pck2 = new Pack("Come y Bebe", lista1);
		Producto[] lista = {pro4};
		
		assertEquals(pck2.size(), 2);
		assertFalse(pck2.contains(pro4));

		pck2.add(lista);

		assertEquals(pck2.size(), 3);
		assertTrue(pck2.contains(pro4));
		
		assertEquals(pck2.getNombre(), "Come y Bebe");
		assertEquals(pck2.getPVP(), (lista1_precio + pro4.getPVP()*0.8), 0.01);
		assertEquals(pck2.getProductosDelPack(), "Producto1 + Producto2 + Producto4.");
	}

	/**
	 * 
	 * Test sobre la posibilidad de a�adir un solo producto a un pack ya creado.
	 */
	@Test
	public void test_AddProducto_Valido() {
		Pack pck3 = new Pack("C", lista1);
		assertEquals(pck3.size(), 2);

		pck3.add(pro3);
		assertEquals(pck3.size(), 3);
		assertEquals(pck3.getNombre(), "C");
		assertEquals(pck3.getPVP(), lista1_precio + pro3.getPVP() * 0.8, 0.01); 
		assertEquals(pck3.getProductosDelPack(), "Producto1 + Producto2 + Producto3.");
	}

	/**
	 * 
	 * Test sobre la posibilidad de eliminar un producto de un pack de 3 o m�s.
	 * 
	 */
	@Test
	public void test_Remove_HabiendoProducto_Valido() {
		Pack pck4 = new Pack("R", lista1);

		pck4.add(pro3);
		assertEquals(pck4.size(), 3);
		assertEquals(pck4.getProductosDelPack(), "Producto1 + Producto2 + Producto3.");

		pck4.remove(pro1);
		assertEquals(pck4.size(), 2);
		assertEquals(pck4.getProductosDelPack(), "Producto2 + Producto3.");

	}

	/**
	 * 
	 * En caso de que se quiera eliminar un producto que no est� en el pack, no pasa nada.
	 * 
	 */
	@Test
	public void test_Remove_ProductoQueNoHay() {
		Pack pck5 = new Pack("r", lista1);
		assertEquals(pck5.size(), 2);
		assertEquals(pck5.getProductosDelPack(), "Producto1 + Producto2.");

		pck5.remove(pro5);
		assertEquals(pck5.size(), 2);
		assertEquals(pck5.getProductosDelPack(), "Producto1 + Producto2.");
	}

	/* ----------- NO VALIDO -----------------*/
	
	/**
	 * 
	 * El pack debe tener alg�n nombre.
	 * 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_Inicializacion_NombreNoValido(){
		Pack p1 = new Pack ("", lista1);
	}
	
	/**
	 * 
	 * Un pack no existir� si no tiene como minimo 2 productos.
	 * 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_Inicializacion_UnProducto_NoValido(){
		Producto [] unico_producto = {pro1}; 
		Pack p1 = new Pack ("p", unico_producto);
	}
	
	/**
	 * 
	 * En el pack no puede haber dos veces el mismo producto.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_AddLista_HayProductoRepetido_NoValida(){

		Producto[] lista = {pro1};
		Pack p1 = new Pack ("p", lista1);
		p1.add(lista);
	}

	/**
	 * 
	 * No se puede insertar una lista vac�a al pack.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_AddListaVacia_NoValida(){
		Pack p1 = new Pack ("0", lista1);
		Producto [] lista = {};
		p1.add(lista);
	}
	
	/**
	 * 
	 * No puede haber un producto repetido en el pack.
	 * 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_AddProducto_HayProductoRepetido_NoValido(){
		Pack p1 = new Pack ("p", lista1);
		p1.add(pro1);
	}
	
	/**
	 * 
	 * En el caso de eliminar un producto de un pack que solo ten�a dos,
	 * se lanza la excepci�n debido a que no puede existir un pack de menos
	 * de dos productos.
	 * 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_Remove_PackDeDosProductos_NoValido(){

		Pack p1 = new Pack ("p", lista1);
		p1.remove(pro1);
	}
	
}