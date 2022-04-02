package visitors;

import enttities.Circulo;
import enttities.Retangulo;
import enttities.Trapezio;
import enttities.Triangulo;
import interfaces.Visitor;

public class VisitorCalcularArea implements Visitor{
	
	@Override
	public double visitaRetangulo(Retangulo retangulo) {
		return retangulo.getAltura()*retangulo.getLargura();
	}
	
	@Override
	public double visitaTriangulo(Triangulo triangulo) {
		double ladoa = triangulo.getLado1();
		double ladob = triangulo.getLado2();
		double ladoc = triangulo.getLado3();
		double perimetro = ladoa + ladob + ladoc;
		double semip = perimetro/2;
		double resultado = Math.sqrt(semip*(semip-ladoa)*(semip-ladob)*(semip-ladoc));
		return resultado;
	}
	
	@Override
	public double visitaCirculo(Circulo circulo) {
		return 3.14 * circulo.getRaio() *  circulo.getRaio();
	}
	
	@Override
	public double visitaTrapezio(Trapezio trapezio) {
		return ((trapezio.getBaseMaior() + trapezio.getBaseMenor())*trapezio.getAltura()) / 2;
	}
	
}
