package enttities;


import enttities.Circulo;
import interfaces.Figuras;
import interfaces.Visitor;




public class Circulo implements Figuras{
	private double raio;
	
	public Circulo(double raio) {
		if(raio < 0 ) {
			throw new IllegalArgumentException("Dados inválidos!");
		}
		this.raio = raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}

	public double getRaio() {
		return raio;
	}
	
	@Override
	public double aceitaVisita(Visitor visitor) {
		return visitor.visitaCirculo(this);
	}

	@Override
	public String toString() {
		return "Circulo: raio=" + raio;
	}
	
}
