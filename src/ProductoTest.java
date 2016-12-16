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
	
	/* --------- INICIALIZACIÓN VALIDA -------------*/
	
	@Test
	public void testInicializacionArgumentoValido() {
		Producto p = new Producto ("666666666662", "Lays", 0);
		assertEquals(p.getIdentificador(), "666666666662");
		assertEquals(p.getNombre(), "Lays");
		assertEquals(p.getPVP(), 0, 0.001);
	}
	
	/*---------- INICIALIZACION NO VALIDA ---------- */
	

	@Test (expected = IllegalArgumentException.class)
	public void testInicializacioNoValido_CodeAlPrincipio(){
		Producto p = new Producto ("/6666666666", "Pringles", 0.35);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testInicializacioNoValido_CodeFinal(){
		Producto p = new Producto ("66666666666:", "Pringles", 0.35);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInicializacioNoValido_Code_MenosDe12(){
		Producto p = new Producto ("66666666666", "Pringles", 0.35);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInicializacioNoValido_Code_MasDe11(){
		Producto p = new Producto ("666666666666", "Pringles", 0.35);
	}
	
	// Por el nombre
	
	@Test (expected = IllegalArgumentException.class)
	public void testInicializacioNoValido_NombreVacio(){
		Producto p = new Producto ("666666666662", "", 0.35);
	}

	// Por el precio:
	
	@Test (expected = IllegalArgumentException.class)
	public void testInicializacioNoValido_PrecioNegativo(){
		Producto p = new Producto ("666666666662", "Kalise", -0.01);
	}
	
	/* ------------ setPVP() --------------*/
	
	// NO VALIDO
	@Test (expected = IllegalArgumentException.class)
	public void test_setPVP_NoValido_PrecioNegativo(){
		Producto p = new Producto ("666666666662", "Kalise", 0);
		p.setPVP(-0.01);
	}
	
	// VALIDO
	public void test_setPVP_Valido_PrecioNegativo(){
		Producto p = new Producto ("666666666662", "Kalise", 0);
		p.setPVP(0.01);
	}
	
	
}
