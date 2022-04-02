package visitors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import interfaces.Visitor;
import enttities.Trapezio;
import enttities.Triangulo;
import enttities.Circulo;
import enttities.Retangulo;

class TesteVIsitorCalcularPerimetro {

	static Visitor CE;

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
        
        CE = new VisitorCalcularPerimetro();
        
    }
	
	@Test
	public void testePerimetroTrapezio() {
		assertEquals(60,tra.aceitaVisita(CE));
	}
	@Test
	public void testePerimetroTriangulo() {
		assertEquals(12,tri.aceitaVisita(CE));
	}
	@Test
	public void testePerimetroCirculo() {
		assertEquals(94.2,c.aceitaVisita(CE));
	}
	@Test
	public void testePerimetroRetangulo() {
		assertEquals(40,r.aceitaVisita(CE));
	}

}
