package enttities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import interfaces.Visitor;
import visitors.VisitorCalcularArea;
import visitors.VisitorDesenho;
import visitors.VisitorCalcularPerimetro;
import visitors.VisitorMaximizar;

class TesteRetangulo {
	static Visitor CA;
    static Visitor DE;
    static Visitor CP;
    static Visitor MA;

	static Retangulo r;
	static Retangulo r1;
	static Retangulo r2;
	static Retangulo r3;
    	
	@BeforeAll
		public static void setUp() {
        
        r = new Retangulo(10,10);
        r1 = new Retangulo(10,10);
        r2 = new Retangulo(10,10);
        
        CA = new VisitorCalcularArea();
        DE = new VisitorDesenho();
        CP = new VisitorCalcularPerimetro();
        MA = new VisitorMaximizar();
    }
	
	@Test
	public void testeArea() {
		assertEquals(100,r.aceitaVisita(CA));
	}
	
	@Test
	public void testePerimetro() {
		assertEquals(40,r1.aceitaVisita(CP));
	}
	@Test
	public void testeDesenho() {
		assertEquals(1,r.aceitaVisita(DE));
	}
	@Test
	public void testeMaximizar1() {
		MA.visitaRetangulo(r);
		assertEquals(20, r.getLargura());
	}
	@Test
	public void testeMaximizar2() {
		MA.visitaRetangulo(r2);
		assertEquals(20, r2.getAltura());
	}
	@Test
	public void testeGetLargura() {
		assertEquals(10,r1.getLargura());
	}
	@Test
	public void testeGetAltura() {
		assertEquals(10,r1.getAltura());
	}
	
	@Test
	public void testeRaioNegativo() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
			r3 = new Retangulo(-2,10);
		});
		assertEquals(exception.getMessage(),"Dados inválidos!");
	}

}
