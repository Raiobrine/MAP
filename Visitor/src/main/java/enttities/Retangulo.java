package enttities;

import interfaces.Figuras;
import interfaces.Visitor;

public class Retangulo implements Figuras{
	private double altura;
	private double largura;
	
	
	public Retangulo(double altura, double largura) {
		if(altura < 0 || largura < 0) {
			throw new IllegalArgumentException("Dados inválidos!");
		}
		this.altura = altura;
		this.largura = largura;
	}

	@Override
	public double aceitaVisita(Visitor visitor) {
		return visitor.visitaRetangulo(this);
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getAltura() {
		return altura;
	}
	public double getLargura() {
		return largura;
	}

	@Override
	public String toString() {
		return "Retangulo: altura=" + altura + ", largura=" + largura ;
	}
	
	
}
