package example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TriangleTest { 
    // -----------------------------------------------------------------------------Lados válidos

    @Test                                           //Maior lado = soma dos menores lados
    public void violatesTriangleInequalityOk() throws Exception { 
        boolean thrown = false;
        try {
            new Triangle(5, 11, 6);
       } catch (TriangleException e) {
            thrown = true;
        } 
        assertTrue(thrown);
    }
    
    // ------------------------------------------------------------------------------Lados inválidos

    @Test                                        //Algum lado = 0
    public void zeroSideTriangle() throws Exception { 
        boolean thrown = false;
        try {
            new Triangle(0, 2, 10);
       } catch (TriangleException e) {
            thrown = true;
        } 
        assertTrue(thrown);
    }

    @Test                                           //Todos os lados = 0
    public void withoutSidesTriangle() throws Exception { 
        boolean thrown = false;
        try {
            new Triangle(0, 0, 0);
       } catch (TriangleException e) {
            thrown = true;
        } 
        assertTrue(thrown);
    }

    @Test                                           //Algum lado < 0
    public void negativeSideTriangle() throws Exception { 
        boolean thrown = false;
        try {
            new Triangle(3, -2, 9);
       } catch (TriangleException e) {
            thrown = true;
        } 
        assertTrue(thrown);

    }

    @Test                                               //Todos os lados < 0
    public void allNegativeSideTriangle() throws Exception { 
        boolean thrown = false;
        try {
            new Triangle(-2, -2, -2);
       } catch (TriangleException e) {
            thrown = true;
        } 
        assertTrue(thrown);
    }


    @Test                                                           //Maior lado < soma dos 2 menores
    public void analysisTriangleSizeNotOk() throws Exception { 
        boolean thrown = false;
        try {
            new Triangle(5, 13, 6);
       } catch (TriangleException e) {
            thrown = true;
        } 
        assertTrue(thrown);
    } 
    
    // -------------------------------------------------------------------------------EQUILÁTERO: todos os lados iguais

    @Test
    public void equilateralTriangleHaveEqualSidesTest() throws Exception { 
        Triangle triangle = new Triangle(2, 2, 2);
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind()); 
    }

    @Test
    public void equilateralTriangleHaveEqualSides2() throws Exception { 
        Triangle triangle = new Triangle(2, 2, 2);
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
        assertNotEquals(TriangleKind.ISOSCELES, triangle.getKind()); 
        assertNotEquals(TriangleKind.SCALENE, triangle.getKind());
        triangle.getKind();

    }

    // -------------------------------------------------------------------------------ISOSCELES: 2 lados iguais

    @Test
    public void isoscelesTriangleHaveTwoEqualSides() throws Exception { 
        Triangle triangle = new Triangle(2, 2, 3);
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void isoscelesTriangleHaveTwoEqualSides2() throws Exception { 
        Triangle triangle = new Triangle(3, 2, 2);
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void isoscelesTriangleHaveTwoEqualSides3() throws Exception { 
        Triangle triangle = new Triangle(2, 3, 2);
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
        assertNotEquals(TriangleKind.EQUILATERAL, triangle.getKind());
        assertNotEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    // ------------------------------------------------------------------------------ESCALENO: todos os lados diferentes
    @Test
    public void scaleneTriangleHasNoEqualSides() throws Exception { 
        Triangle triangle = new Triangle(2, 9, 10);
        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Test
    public void scaleneTriangleHasNoEqualSides2() throws Exception {
        Triangle triangle = new Triangle(7, 8, 5);
        assertEquals(TriangleKind.SCALENE, triangle.getKind());
        assertNotEquals(TriangleKind.EQUILATERAL, triangle.getKind());
        assertNotEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @Test
    public void scaleneTriangleHasNoEqualSides3() throws Exception { 
        Triangle triangle = new Triangle(11, 4, 8);
        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }
    

}