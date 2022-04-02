package main;
import exceptions.ExceptionValorNegativoOuZero;
import figures.Circulo;
import figures.FiguraGeometrica;
import figures.Quadrado;
import figures.Retangulo;

public class BrincandoComAsFigurasGeometricas {
    public static void main(String[] args) {
        try{
            //Criando Figuras Geometricas:
            FiguraGeometrica circulo = new Circulo(4);                  //definindo o raio do circulo
            FiguraGeometrica quadrado = new Quadrado(4);                //definindo os lados do quadrado
            FiguraGeometrica retangulo = new Retangulo(4, 5);     //definindo a altura e o tamanho do retangulo

            /*----------------------------------Circulo-------------------------------------------*/
            System.out.println("\n"+circulo.toString());
            System.out.printf("Perimetro do circulo: %.2f\n",circulo.getPerimetro());
            System.out.printf("Area do circulo: %.2f\n", circulo.getArea());

            /*----------------------------------Quadrado-------------------------------------------*/
            System.out.println("\n"+quadrado.toString());
            System.out.printf("Perimetro do quadrado: %.2f\n", quadrado.getPerimetro());
            System.out.printf("Area do quadrado: %.2f\n", quadrado.getArea());

            /*-----------------------------------Retangulo----------------------------------------- */
            System.out.println("\n"+retangulo.toString());
            System.out.printf("Perimetro do retangulo: %.2f\n", retangulo.getPerimetro());
            System.out.printf("Area do retangulo: %.2f\n", retangulo.getArea());
        }

        //Excessão para valores negativos ou zero
        catch (ExceptionValorNegativoOuZero exceptionValorNegativo) {
            exceptionValorNegativo.printStackTrace();
        }
    }
}
