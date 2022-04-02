package visitors;

import enttities.Circulo;
import enttities.Retangulo;
import enttities.Trapezio;
import enttities.Triangulo;
import interfaces.Visitor;

public class VisitorCalcularPerimetro implements Visitor{
	
		@Override
		public double visitaRetangulo(Retangulo retangulo) {
			double resultado = (retangulo.getAltura() + retangulo.getLargura())*2;
			return resultado;
		}
		
		@Override
		public double visitaTriangulo(Triangulo triangulo) {
			double resultado = triangulo.getLado1() + triangulo.getLado2() + triangulo.getLado3();
			return resultado;
		}
		
		@Override
	    public double visitaCirculo(Circulo circulo) {
			double resultado = 2.0 * 3.14 * circulo.getRaio(); 
	        return resultado;
	    }
		
		@Override
	    public double visitaTrapezio(Trapezio trapezio) {
			double resultado = trapezio.getBaseMaior() + trapezio.getBaseMenor() + 2.0 * trapezio.getAltura();
	        return resultado;
	    }
		
}
