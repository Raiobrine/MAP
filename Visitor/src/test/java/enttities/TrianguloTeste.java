package enttities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import interfaces.Visitor;
import visitors.VisitorCalcularArea;
import visitors.VisitorCalcularPerimetro;
import visitors.VisitorDesenho;
import visitors.VisitorMaximizar;

class TrianguloTeste {
	
	static Triangulo trianguloTeste;
	static Triangulo trianguloMaximizar;
    static Visitor visitorCalcularArea;
    static Visitor visitorDesenhar;
    static Visitor visitorCalcularPerimetro;
    static Visitor visitorMaximizar;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		trianguloTeste = new Triangulo(10, 10, 12);
		trianguloMaximizar = new Triangulo(2,2,4);

		visitorCalcularArea = new VisitorCalcularArea();
		visitorDesenhar = new VisitorDesenho();
		visitorCalcularPerimetro = new VisitorCalcularPerimetro();
		visitorMaximizar = new VisitorMaximizar();
	}
	
	@Test
    public void testArea() {
        assertEquals(48, trianguloTeste.aceitaVisita(visitorCalcularArea));
    }

    @Test
    public void testPerimetro(){
        assertEquals(32, trianguloTeste.aceitaVisita(visitorCalcularPerimetro));
    }

    @Test
    public void testDesenho(){
        assertEquals(1, visitorDesenhar.visitaTriangulo(trianguloTeste));
    }

    @Test
    public void testMaximizarLado1() {
    	visitorMaximizar.visitaTriangulo(trianguloMaximizar);
        assertEquals(4.0, trianguloMaximizar.getLado1()); 
    }
    
    @Test
    public void testMaximizarLado2() {
        assertEquals(4.0, trianguloMaximizar.getLado2()); 
    }
    
    @Test
    public void testMaximizarLado3() {
        assertEquals(8.0, trianguloMaximizar.getLado3()); 
    }
	
	@Test
	void testLadoNegativo() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
			Triangulo circuloLadoNegativo = new Triangulo(-1,10,12);
		});
		
		assertEquals(exception.getMessage(),"Dados inválidos!");
	}
	
	@Test
	void testGetLado1() {
		assertEquals(trianguloTeste.getLado1(),10);
	}
	
	@Test
	void testGetLado2() {
		assertEquals(trianguloTeste.getLado2(),10);
	}
	
	@Test
	void testGetLado3() {
		assertEquals(trianguloTeste.getLado3(),12);
	}

	@Test
	void testToStringTriangulo() {
		assertEquals(trianguloTeste.toString(),"Triangulo: lado1=10.0, lado2=10.0, lado3=12.0");
	}

}
