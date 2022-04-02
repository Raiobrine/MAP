package interfaces;

import enttities.Circulo;
import enttities.Retangulo;
import enttities.Trapezio;
import enttities.Triangulo;

public interface Visitor {
	public double visitaRetangulo(Retangulo retangulo);
	public double visitaTriangulo(Triangulo triangulo);
	public double visitaCirculo(Circulo circulo);
	public double visitaTrapezio(Trapezio trapezio);
}
