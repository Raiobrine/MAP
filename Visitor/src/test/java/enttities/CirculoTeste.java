package enttities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import interfaces.Visitor;
import visitors.VisitorCalcularArea;
import visitors.VisitorCalcularPerimetro;
import visitors.VisitorDesenho;
import visitors.VisitorMaximizar;

class CirculoTeste {
	
	
	
	static Circulo circuloTeste;
	static Circulo circulo2;
    static Visitor visitorCalcularArea;
    static Visitor visitorDesenhar;
    static Visitor visitorCalcularPerimetro;
    static Visitor visitorMaximizar;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		circuloTeste = new Circulo(15);
		circulo2 = new Circulo(5);
		visitorCalcularArea = new VisitorCalcularArea();
		visitorDesenhar = new VisitorDesenho();
		visitorCalcularPerimetro = new VisitorCalcularPerimetro();
		visitorMaximizar = new VisitorMaximizar();
	}
	
	@Test
    public void testArea() {
        assertEquals(78.5, circulo2.aceitaVisita(visitorCalcularArea));
    }

    @Test
    public void testPerimetro(){
        assertEquals(94.2, circuloTeste.aceitaVisita(visitorCalcularPerimetro));
    }

    @Test
    public void testDesenhar(){
        assertEquals(1, visitorDesenhar.visitaCirculo(circulo2));
    }

    @Test
    public void testMaximizar() {

    	visitorMaximizar.visitaCirculo(circulo2);
        assertEquals(10.0, circulo2.getRaio()); 
    }
	
	@Test
	void testRaioNegativo() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
			Circulo circulo = new Circulo(-1);
		});
		
		assertEquals(exception.getMessage(),"Dados inválidos!");
	}
	

		@Test
		void testToString() {
			
			assertEquals(circuloTeste.toString(),"Circulo: raio=15.0");
		}

	

	@Test
	void testGetRaio() {
		
		assertEquals(circuloTeste.getRaio(),15);
	}

}
