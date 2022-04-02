package visitors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import interfaces.Visitor;
import enttities.Trapezio;
import enttities.Triangulo;
import enttities.Circulo;
import enttities.Retangulo;

class TesteVisitorDesenho {

	static Visitor DE;

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
        
        DE = new VisitorDesenho();
        
    }
	
	@Test
	public void testeDesenhoTrapezio() {
		assertEquals(1,tra.aceitaVisita(DE));
	}
	@Test
	public void testeDesenhoTriangulo() {
		assertEquals(1,tri.aceitaVisita(DE));
	}
	@Test
	public void testeDesenhoCirculo() {
		assertEquals(1,c.aceitaVisita(DE));
	}
	@Test
	public void testeDesenhoRetangulo() {
		assertEquals(1,r.aceitaVisita(DE));
	}

}
