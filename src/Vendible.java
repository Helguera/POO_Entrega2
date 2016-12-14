package uva.poo.entrega2;


/**
 * 
 * @author alvvela
 * @author javhelg
 *
 */
public abstract class Vendible {
	String identificador;
	String nombre;
	double getPVP;
	
	String getNombre(){
		return nombre;
	}
	
	String getIdentificador(){
		return identificador;
	}
	
	abstract double getPVP();


	
	
}
