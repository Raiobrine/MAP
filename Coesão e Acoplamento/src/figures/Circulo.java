package figures;
import exceptions.ExceptionValorNegativoOuZero;

public class Circulo implements FiguraGeometrica {
    private double raio;

    //excessão para raio menor ou igual a zero
    public Circulo(double raio) throws ExceptionValorNegativoOuZero {
        if (raio <= 0) throw new ExceptionValorNegativoOuZero();
        this.raio = raio;
    }

    //get e set
    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double raio) throws ExceptionValorNegativoOuZero {
        this.raio = raio;
    }

    @Override
    //O perimetro do circulo é a multiplicação 2 vezes pi vezes o raio
    public double getPerimetro() {
        return 2 * Math.PI * this.raio;
    }

    @Override
    //A area do circulo é a multiplicação do raio quadrado vezes pi
    public double getArea() {
        return Math.PI * Math.pow(this.raio, 2);
    }

    @Override
    public String toString() {
        return "O circulo criado tem raio de tamanho: " + this.raio;
    }
}
