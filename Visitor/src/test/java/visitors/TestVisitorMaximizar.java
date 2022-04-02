package visitors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import enttities.Circulo;
import enttities.Retangulo;
import enttities.Trapezio;
import enttities.Triangulo;
import interfaces.Visitor;

class TestVisitorMaximizar {
	
	static Visitor visitorMaximizar;
	static Retangulo retanguloTeste;
	static Circulo circuloTeste;
	static Triangulo trianguloTeste;
	static Trapezio trapezioTeste;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		visitorMaximizar = new VisitorMaximizar();
		trapezioTeste = new Trapezio(20, 10, 15);
		retanguloTeste = new Retangulo(10, 20);
		circuloTeste = new Circulo(5);
		trianguloTeste = new Triangulo(2,2,4);
		
	}
	
	@Test
    public void testMaximizarLado1TrapezioBaseMenor() {
    	visitorMaximizar.visitaTrapezio(trapezioTeste);
        assertEquals(20.0, trapezioTeste.getBaseMenor()); 
    }
	
	@Test
    public void testMaximizarLado2TrapezioBaseMaior() {
        assertEquals(20.0, trapezioTeste.getBaseMaior()); 
    }
	
	@Test
    public void testMaximizarLado3TrapezioAltura() {
        assertEquals(30.0, trapezioTeste.getAltura()); 
    }
	
	 @Test
    public void testMaximizarLado1Quadrado() {
    	visitorMaximizar.visitaTriangulo(trianguloTeste);
        assertEquals(4.0, trianguloTeste.getLado1()); 
    }
    
    @Test
    public void testMaximizarLado2Quadrado() {
        assertEquals(4.0, trianguloTeste.getLado2()); 
    }
    
    @Test
    public void testMaximizarLado3Quadrado() {
        assertEquals(8.0, trianguloTeste.getLado3()); 
    }
	
	@Test
    public void testMaximizarRetanguloLado1() {
    	visitorMaximizar.visitaRetangulo(retanguloTeste);
        assertEquals(20.0, retanguloTeste.getAltura()); 
    }
	
	@Test
    public void testMaximizarRetanguloLado2() {
        assertEquals(40.0, retanguloTeste.getLargura()); 
    }
	
	
	@Test
    public void testMaximizarCirculo() {
    	visitorMaximizar.visitaCirculo(circuloTeste);
        assertEquals(10.0, circuloTeste.getRaio()); 
    }
	


	

}
