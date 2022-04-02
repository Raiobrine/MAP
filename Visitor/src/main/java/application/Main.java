package application;

import interfaces.Visitor;
import visitors.VisitorCalcularArea;
import visitors.VisitorCalcularPerimetro;
import visitors.VisitorDesenho;
import visitors.VisitorMaximizar;
import enttities.Retangulo;
import enttities.Circulo;
import enttities.Triangulo;
import enttities.Trapezio;

public class Main {
	public static void main(String[] args) {
		Visitor visitorCA = new VisitorCalcularArea();
		Visitor visitorCP = new VisitorCalcularPerimetro();
		Visitor visitorDE = new VisitorDesenho();
		Visitor visitorMA = new VisitorMaximizar();
		
		Retangulo retangulo = new Retangulo(10, 10);
		Circulo circulo = new Circulo(15);
		Triangulo triangulo = new Triangulo(3, 4, 5);
        Trapezio trapezio = new Trapezio(20, 10, 15);
        
        System.out.println("Desenho:");
		retangulo.aceitaVisita(visitorDE);
		circulo.aceitaVisita(visitorDE);
		triangulo.aceitaVisita(visitorDE);
		trapezio.aceitaVisita(visitorDE);
        
		System.out.println("Area:");
		System.out.println("Area do retangulo: " + retangulo.aceitaVisita(visitorCA));
		System.out.println("Area do círculo: " + circulo.aceitaVisita(visitorCA));
		System.out.println("Area do triangulo: " + triangulo.aceitaVisita(visitorCA));
		System.out.println("Area do trapezio: " + trapezio.aceitaVisita(visitorCA));
		
		System.out.println("Perimetro:");
		System.out.println("Perímetro do retangulo: " + trapezio.aceitaVisita(visitorCP));
		System.out.println("Perímetro do circulo: " + circulo.aceitaVisita(visitorCP));
		System.out.println("Perímetro do triangulo: " + triangulo.aceitaVisita(visitorCP));
		System.out.println("Perímetro do trapezio: " + trapezio.aceitaVisita(visitorCP));
		
		System.out.println("Maximizar:");
		retangulo.aceitaVisita(visitorMA);
		circulo.aceitaVisita(visitorMA);
		triangulo.aceitaVisita(visitorMA);
		trapezio.aceitaVisita(visitorMA);
		
		System.out.println("Desenho:");
		retangulo.aceitaVisita(visitorDE);
		circulo.aceitaVisita(visitorDE);
		triangulo.aceitaVisita(visitorDE);
		trapezio.aceitaVisita(visitorDE);
		
	}
}
