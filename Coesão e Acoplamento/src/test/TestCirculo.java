package test;

import exceptions.ExceptionValorNegativoOuZero;
import figures.Circulo;
import figures.FiguraGeometrica;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TestCirculo {
    static FiguraGeometrica circuloTeste2;
    /*Formata valores decimais.
    Se baseando em padroes estabelecidos para determinar como os mesmos valores serão formatados.*/

    DecimalFormat df = new DecimalFormat("#.00");
    BigDecimal circuloteste;

    @BeforeAll
    public static void setUp() {
        try {
            circuloTeste2 = new Circulo(3);
        }
        catch (ExceptionValorNegativoOuZero exceptionValorNegativo) {
            exceptionValorNegativo.printStackTrace();
        }
    }

    @Test
    public void testGetAreaCirculo() {
        /*Teste com a area do circulo
    	Especifica um comportamento de arredondamento para os operados numericos capazes de descartar precisao.
        Modo de arredondamento para arredondar para o "vizinho mais proximo", a menos que ambos
        os vizinhos sejam equidistantes; nesse caso, arredondar para o vizinho par.*/

        circuloteste = new BigDecimal(circuloTeste2.getArea()).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(28.27, circuloteste.doubleValue());
        assertEquals(28.27, circuloTeste2.getArea(), 1);
    }

    @Test
    public void testGetPerimetroCirculo() {
        //Teste com o perimetro do circulo
        //RoundingMode.HALF_EVEN arredonda para o próximo número
        circuloteste = new BigDecimal(circuloTeste2.getPerimetro()).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(18.85 , circuloteste.doubleValue());
    }

    @Test
    public void testGetCirculoException() {
        //teste para excessão com numero negativo
        assertThrows(ExceptionValorNegativoOuZero.class, () -> {
            Circulo circuloFail = new Circulo(-2);
        });
    }

    @Test
    public void testGetCirculoException2() {
        //teste para excessão com numero negativo
        assertThrows(ExceptionValorNegativoOuZero.class, () -> {
            Circulo circuloFail = new Circulo(0);
        });
    }
}
