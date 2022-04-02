package figures;

import exceptions.ExceptionValorNegativoOuZero;

public class Quadrado implements FiguraGeometrica {
    private double lado;
    //excessão para lado menor ou igual a zero

    public Quadrado(double lado) throws ExceptionValorNegativoOuZero {
        if (lado <= 0) throw new ExceptionValorNegativoOuZero();
        this.lado = lado;
    }

    //get e set
    public double getLado() {
        return this.lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    //O perimetro do quadrado é a multiplicação do lado por 4
    public double getPerimetro(){
        return 4 * lado;
    }

    @Override
    //A area do quadrado é a multiplicação do lado por ele mesmo
    public double getArea() {
        return lado * lado;
    }

    @Override
    public String toString() {
        return "O quadrado criado tem lados de tamanho: " + this.lado;
    }
}
