package enttities;

import interfaces.Figuras;
import interfaces.Visitor;

public class Trapezio implements Figuras{
	private double baseMenor;
	private double baseMaior;
	private double altura;
	
	public Trapezio(double baseMaior, double baseMenor,  double altura) {
		if((baseMenor < 0) || (baseMaior < 0) || (altura < 0)) {
			throw new IllegalArgumentException("Dados inválidos!");
		}
		this.baseMenor = baseMenor;
		this.baseMaior = baseMaior;
		this.altura = altura;
	}

	public void setBaseMenor(double baseMenor) {
		this.baseMenor = baseMenor;
	}

	public void setBaseMaior(double baseMaior) {
		this.baseMaior = baseMaior;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getBaseMenor() {
		return baseMenor;
	}


	public double getBaseMaior() {
		return baseMaior;
	}


	public double getAltura() {
		return altura;
	}

	@Override
	public double aceitaVisita(Visitor visitor) {
		return visitor.visitaTrapezio(this);
	}


	@Override
	public String toString() {
		return "Trapezio: baseMenor=" + baseMenor + ", baseMaior=" + baseMaior + ", altura=" + altura;
	}
	
}
