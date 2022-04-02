package example;

import static org.junit.Assert.*;
import org.junit.Test;

public class TriangleTest { 
    // -----------------------------------------------------------------------------Lados válidos

    @Test                                           //Maior lado = soma dos menores lados
    public void violatesTriangleInequalityOk() throws Exception { 
        boolean thrown = false;
        try {
            new Triangle(7, 8, 15);
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
            new Triangle(8, 0, 4);
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
            new Triangle(4, 4, -5);
       } catch (TriangleException e) {
            thrown = true;
        } 
        assertTrue(thrown);

    }

    @Test                                               //Todos os lados < 0
    public void allNegativeSideTriangle() throws Exception { 
        boolean thrown = false;
        try {
            new Triangle(-3, -4, -5);
       } catch (TriangleException e) {
            thrown = true;
        } 
        assertTrue(thrown);
    }


    @Test                                                           //Maior lado < soma dos 2 menores
    public void analysisTriangleSizeNotOk() throws Exception { 
        boolean thrown = false;
        try {
            new Triangle(8, 13, 8);
       } catch (TriangleException e) {
            thrown = true;
        } 
        assertTrue(thrown);
    } 
    
    // -------------------------------------------------------------------------------EQUILÁTERO: todos os lados iguais

    @Test
    public void equilateralTriangleHaveEqualSidesTest() throws Exception { 
        Triangle triangle = new Triangle(6, 6, 6);
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind()); 
    }

    @Test
    public void equilateralTriangleHaveEqualSides2() throws Exception { 
        Triangle triangle = new Triangle(6, 6, 6);
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
        assertNotEquals(TriangleKind.ISOSCELES, triangle.getKind()); 
        assertNotEquals(TriangleKind.SCALENE, triangle.getKind());
        triangle.getKind();

    }

    // -------------------------------------------------------------------------------ISOSCELES: 2 lados iguais

    @Test
    public void isoscelesTriangleHaveTwoEqualSides() throws Exception { 
        Triangle triangle = new Triangle(3, 3, 4);
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void isoscelesTriangleHaveTwoEqualSides2() throws Exception { 
        Triangle triangle = new Triangle(4, 3, 3);
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void isoscelesTriangleHaveTwoEqualSides3() throws Exception { 
        Triangle triangle = new Triangle(3, 4, 3);
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
        assertNotEquals(TriangleKind.EQUILATERAL, triangle.getKind());
        assertNotEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    // ------------------------------------------------------------------------------ESCALENO: todos os lados diferentes
    @Test
    public void scaleneTriangleHasNoEqualSides() throws Exception { 
        Triangle triangle = new Triangle(5, 12, 13);
        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Test
    public void scaleneTriangleHasNoEqualSides2() throws Exception {
        Triangle triangle = new Triangle(5, 6, 3);
        assertEquals(TriangleKind.SCALENE, triangle.getKind());
        assertNotEquals(TriangleKind.EQUILATERAL, triangle.getKind());
        assertNotEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @Test
    public void scaleneTriangleHasNoEqualSides3() throws Exception { 
        Triangle triangle = new Triangle(6, 2, 4);
        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }
    

}