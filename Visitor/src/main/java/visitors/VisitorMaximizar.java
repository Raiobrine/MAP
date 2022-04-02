package visitors;

import enttities.Circulo;
import enttities.Retangulo;
import enttities.Trapezio;
import enttities.Triangulo;
import interfaces.Visitor;

public class VisitorMaximizar implements Visitor{
	
	@Override
    public double visitaCirculo(Circulo circulo) {
        circulo.setRaio(2 * circulo.getRaio());
        return 1;
    }

    @Override
    public double visitaTriangulo(Triangulo triangulo) {
    	triangulo.setLado1(2 * triangulo.getLado1());
        triangulo.setLado2(2 * triangulo.getLado2());
        triangulo.setLado3(2 * triangulo.getLado3());
        return 1;
    }

    @Override
    public double visitaRetangulo(Retangulo retangulo) {
        retangulo.setAltura(2 * retangulo.getAltura());
        retangulo.setLargura(2 * retangulo.getLargura());
        
        return 1;
    }

    @Override
    public double visitaTrapezio(Trapezio trapezio) {
    	trapezio.setAltura(2 * trapezio.getAltura());
        trapezio.setBaseMenor(2 * trapezio.getBaseMenor());
        trapezio.setBaseMaior(2 * trapezio.getBaseMaior());
        return 1;
    }
    
}
