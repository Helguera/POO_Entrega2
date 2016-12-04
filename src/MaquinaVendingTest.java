package uva.poo.entrega2;

import static org.junit.Assert.*;
import org.junit.Test;
import fabricante.externo.tarjetas.TarjetaMonedero;

/**
 * 
 * @author alvvela
 * @author javhelg
 *
 */
public class MaquinaVendingTest {

	public static final double ERROR = 0.00001;
	

	/*
	 * IMPLEMENTACION VALIDA
	 */
	
	@Test
	public void testImplementacionMaquinaVending_Valida_ProductoEnPrimeraFila_CompraValida() {
		MaquinaVending maq = new MaquinaVending (2);
		Producto patatas = new Producto ("00000000005", "Lays", 0);
		TarjetaMonedero card = new TarjetaMonedero ("A156Bv09_1zXo894", 0.01);
		
		maq.setProductosEnFila(0, patatas, 0);	// setProducto en extremo inferior								
		maq.setUnidades(0, 1);					// setUnidades en extremo inferior
		maq.setPrecio(0, 0.01);					// setPrecio en extremo inferior
		assertEquals(maq.getNombreProductoDeLaFila(0), "Lays");
		assertEquals(maq.getPrecio(0), 0.01, ERROR);
		assertEquals(maq.getUnidadesDisponiblesDeLaFila(0), 1);
		assertTrue(maq.comprarProductoDeLaFila(0, card, "6Z1y00Nm31aA-571"));
	}
	
	@Test
	public void testImplementacionMaquinaVending_Valida_ProductoEnUltimaFila_CompraValida() {
		MaquinaVending maq = new MaquinaVending (6);
		Producto patatas = new Producto ("00000000001", "Pringles", 0);
		TarjetaMonedero card = new TarjetaMonedero ("A156Bv09_1zXo894", 0.01);
		
		maq.setProductosEnFila(5, patatas, 0);  // setProducto en extremo superior
		maq.setUnidades(5, 1);					// setUnidades en extremo superior
		maq.setPrecio(5, 0.01);					// setPrecio en extremo superior
		assertEquals(maq.getNombreProductoDeLaFila(5), "Pringles");
		assertEquals(maq.getPrecio(5), 0.01, ERROR);
		assertEquals(maq.getUnidadesDisponiblesDeLaFila(5), 1);
		assertTrue(maq.comprarProductoDeLaFila(5, card, "6Z1y00Nm31aA-571"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testImplementacionMaquinaVending_NoValida() {
		MaquinaVending maq = new MaquinaVending (0);
	}
	
	/*
	 * COMPRA NO VALIDA
	 */
	
	@Test
	public void testCompra_NoValida_NoQuedanUnidades(){
		MaquinaVending maq = new MaquinaVending (6);
		TarjetaMonedero card = new TarjetaMonedero ("A156Bv09_1zXo894", 0.01);
		assertFalse(maq.comprarProductoDeLaFila(0, card, "6Z1y00Nm31aA-571"));
	}
	
	
	@Test
	public void testCompra_NoValida_NoHaySaldo(){
		MaquinaVending maq = new MaquinaVending (6);
		Producto cerveza = new Producto ("00000000003", "Estrella Galicia", 0.01);
		maq.setProductosEnFila(0, cerveza, 1);
		
		TarjetaMonedero card = new TarjetaMonedero ("A156Bv09_1zXo894", 0);
		assertFalse(maq.comprarProductoDeLaFila(0, card, "6Z1y00Nm31aA-571"));
	}
	

	@Test (expected = IllegalArgumentException.class)
	public void testCompra_NoValida_FilaNoExiste_Negativa(){
		MaquinaVending maq = new MaquinaVending (2);
		TarjetaMonedero card = new TarjetaMonedero ("A156Bv09_1zXo894", 0.01);									
		// Aqui salta la excepcion. La fila es incorecta:
		maq.comprarProductoDeLaFila(-1, card, "6Z1y00Nm31aA-571");
	}


	@Test (expected = IllegalArgumentException.class)
	public void testCompra_NoValida_FilaNoExiste_DemasiadoGrande(){
		MaquinaVending maq = new MaquinaVending (2);
		TarjetaMonedero card = new TarjetaMonedero ("A156Bv09_1zXo894", 0.01);								
		// Aqui salta la excepcion. La fila es incorecta:
		maq.comprarProductoDeLaFila(2, card, "6Z1y00Nm31aA-571");
	}
	
	
	/*
	 * SET UNIDADES NO VALIDA
	 */
	
	@Test (expected = IllegalArgumentException.class)
	public void test_setUnidades_NoValida_UnidadesNegativas(){
		MaquinaVending maq = new MaquinaVending (2);								
		// Aqui salta la excepcion. Unidades negativas:
		maq.setUnidades(0, -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_setUnidades_NoValida_FilaNoExiste_Negativa(){
		MaquinaVending maq = new MaquinaVending (2);								
		// Aqui salta la excepcion. Fila negativas:
		maq.setUnidades(-1, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_setUnidades_NoValida_FilaNoExiste_DemasiadoGrande(){
		MaquinaVending maq = new MaquinaVending (2);								
		// Aqui salta la excepcion. No hay tantas filas:
		maq.setUnidades(2, 0);
	}
	
	
	/*
	 * SETPRODUCTOSENLAFILA NO VALIDA
	 */
	
	@Test (expected = IllegalArgumentException.class)
	public void test_setProductos_NoValida_UnidadesNegativas(){
		MaquinaVending maq = new MaquinaVending (2);	
		Producto agua = new Producto ("00000000002", "Cruzcampo", 0);
		// Aqui salta la excepcion. Unidades negativas:
		maq.setProductosEnFila(0, agua, -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_setProductos_NoValida_FilaNoExiste_Negativa(){
		MaquinaVending maq = new MaquinaVending (2);	
		Producto agua = new Producto ("00000000002", "Cruzcampo", 0);
		// Aqui salta la excepcion. Fila negativa:
		maq.setProductosEnFila(0, agua, -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_setProductos_NoValida_FilaNoExiste_DemasiadoGrande(){
		MaquinaVending maq = new MaquinaVending (2);	
		Producto agua = new Producto ("00000000002", "Cruzcampo", 0);
		// Aqui salta la excepcion. Fila demasiado grande:
		maq.setProductosEnFila(2, agua, 0);
	}
	

	/*
	 * SETPRECIO NO VALIDA
	 */
	
	@Test (expected = IllegalArgumentException.class)
	public void test_setPrecio_NoValido_PrecioNegativo(){
		MaquinaVending maq = new MaquinaVending (2);	
		Producto smartphone = new Producto ("00000000003", "iPhone 36 Plus", 0);
		// Aqui salta la excepcion. Unidades negativas:
		maq.setPrecio(0, -0.01);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_setPrecio_NoValido_FilaNoExiste_Negativa(){
		MaquinaVending maq = new MaquinaVending (2);	
		// Aqui salta la excepcion. Fila negativa:
		maq.setPrecio(-1, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_setPrecio_NoValido_FilaNoExiste_DemasiadoGrande(){
		MaquinaVending maq = new MaquinaVending (2);	
		// Aqui salta la excepcion. Fila demasiado grande:
		maq.setPrecio(2, 0);
	}
	

}
