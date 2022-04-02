package visitors;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import interfaces.Visitor;
import enttities.Trapezio;
import enttities.Triangulo;
import enttities.Circulo;
import enttities.Retangulo;

class TesteVisitorCalcularArea {

	static Visitor CA;

	static Trapezio tra;
	static Triangulo tri;
	static Circulo c;
	static Retangulo r;
    	
	@BeforeAll
		public static void setUp() {
        
        tra = new Trapezio(20,10,15);
        tri = new Triangulo(3,4,5);
        c = new Circulo(15);
        r = new Retangulo(10,10);
        
        CA = new VisitorCalcularArea();
        
    }
	
	@Test
	public void testeAreaTrapezio() {
		assertEquals(225,tra.aceitaVisita(CA));
	}
	@Test
	public void testeAreaTriangulo() {
		assertEquals(6,tri.aceitaVisita(CA));
	}
	@Test
	public void testeAreaCirculo() {
		assertEquals(706.5,c.aceitaVisita(CA));
	}
	@Test
	public void testeAreaRetangulo() {
		assertEquals(100,r.aceitaVisita(CA));
	}

}
