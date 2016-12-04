package uva.poo.entrega2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author alvvela
 * @author javhelg
 *
 */
public class ProductoTest {
	
	@Test
	public void testInicializacionArgumentoValido() {
		Producto p = new Producto ("66666666666", "Lays", 0);
		assertEquals(p.getUPC(), "666666666662");
		assertEquals(p.getNombre(), "Lays");
		assertEquals(p.getPVP(), 0, 0.001);
	}
	
	// INICIALIZACION NO VALIDA
	/* ------------- POR EL CODE ------------------- */
	@Test (expected = IllegalArgumentException.class)
	public void testInicializacioNoValido_CodeAlPrincipio(){
		Producto p = new Producto ("/666666666", "Pringles", 0.35);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testInicializacioNoValido_CodeFinal(){
		Producto p = new Producto ("6666666666:", "Pringles", 0.35);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInicializacioNoValido_Code_MenosDe11(){
		Producto p = new Producto ("6666666666", "Pringles", 0.35);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInicializacioNoValido_Code_MasDe11(){
		Producto p = new Producto ("666666666666", "Pringles", 0.35);
	}
	
	/* ------------- POR EL NOMBRE ------------------- */
	@Test (expected = IllegalArgumentException.class)
	public void testInicializacioNoValido_NombreVacio(){
		Producto p = new Producto ("666666666666", "", 0.35);
	}

	/* ------------- POR EL PRECIO ------------------- */
	@Test (expected = IllegalArgumentException.class)
	public void testInicializacioNoValido_PrecioNegativo(){
		Producto p = new Producto ("666666666666", "Kalise", -0.01);
	}
	
	// PRUEBA CON SETPVP
	@Test (expected = IllegalArgumentException.class)
	public void test_setPVP_NoValido_PrecioNegativo(){
		Producto p = new Producto ("666666666666", "Kalise", 0);
		p.setPVP(-0.01);
	}

}
