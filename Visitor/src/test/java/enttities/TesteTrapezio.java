package enttities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import interfaces.Visitor;
import visitors.VisitorCalcularArea;
import visitors.VisitorDesenho;
import visitors.VisitorCalcularPerimetro;
import visitors.VisitorMaximizar;

class TesteTrapezio {
	static Visitor CA;
    static Visitor DE;
    static Visitor CP;
    static Visitor MA;

	static Trapezio t;
	static Trapezio t1;
	static Trapezio t2;
	static Trapezio t3;
    	
	@BeforeAll
		public static void setUp() {
        
        t = new Trapezio(20,10,15);
        t1 = new Trapezio(20,10,15);
        t2 = new Trapezio(20,10,15);
        
        CA = new VisitorCalcularArea();
        DE = new VisitorDesenho();
        CP = new VisitorCalcularPerimetro();
        MA = new VisitorMaximizar();
    }
	
	@Test
	public void testeArea() {
		assertEquals(225,t.aceitaVisita(CA));
	}
	
	@Test
	public void testePerimetro() {
		assertEquals(60,t1.aceitaVisita(CP));
	}
	@Test
	public void testeDesenho() {
		assertEquals(1,t1.aceitaVisita(DE));
	}
	@Test
	public void testeMaximizarBaseMaior() {
		MA.visitaTrapezio(t2);
		assertEquals(40, t2.getBaseMaior());
	}
	@Test
	public void testeMaximizarBaseMenor() {
		MA.visitaTrapezio(t2);
		assertEquals(20, t1.getBaseMaior());
	}
	@Test
	public void testeMaximizarAltura() {
		MA.visitaTrapezio(t2);
		assertEquals(20, t1.getBaseMaior());
	}
	@Test
	public void testeGetBaseMaior() {
		assertEquals(20,t1.getBaseMaior());
	}
	@Test
	public void testeGetBaseMenor() {
		assertEquals(10,t1.getBaseMenor());
	}
	@Test
	public void testeGetAltura() {
		assertEquals(15,t1.getAltura());
	}
	
	@Test
	public void testeLadoNegativo() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
			t3 = new Trapezio(-2,10,15);
		});
		assertEquals(exception.getMessage(),"Dados inválidos!");
	}

}
