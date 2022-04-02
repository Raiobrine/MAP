package visitors;

import enttities.Circulo;
import enttities.Retangulo;
import enttities.Trapezio;
import enttities.Triangulo;
import interfaces.Visitor;

public class VisitorDesenho implements Visitor{
	
	@Override
    public double visitaCirculo(Circulo circulo) {
        System.out.println(circulo.toString());
        return 1;
    }

    @Override
    public double visitaTriangulo(Triangulo triangulo) {
        System.out.println(triangulo.toString());
        return 1;
    }

    @Override
    public double visitaRetangulo(Retangulo r) {
        System.out.println(r.toString());
        return 1;
    }

    @Override
    public double visitaTrapezio(Trapezio trapezio) {
        System.out.println(trapezio.toString());
        return 1;
    }
}