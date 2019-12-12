package lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestVariant5 {
    public static double EPS = 0.0000001;

    @Test
    public void MassTest(){
        assertEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }


    @Test(dataProvider = "inputProvider")
    public void inputTest(int a, Variant5.TwoNumbers p) {
        assertEquals(new Variant5().inputOutputTask(a), p);
    }

    @DataProvider
    public Object[][] inputProvider() {
        return new Object[][] { {2, new Variant5.TwoNumbers(24, 8)}, { 3, new Variant5.TwoNumbers(54, 27) } };
    }


   ////////////////////////////////////////////////

    @Test(dataProvider = "integerProvider")
    public void integerTest(int p1, int p2, int p3) {
      assertEquals(new Variant5().integerNumbersTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 10, 9, 1 }, { 4, 2, 0 }, { 15, 2, 1 } };
    }


    ////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, boolean p3) {
        assertEquals(new Variant5().booleanTask(p1,  p2), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 2, -3, true }, { 0, 1, true }, { -3, 5 , false } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3, Variant5.TwoNumbers p4) {
        assertEquals(new Variant5().ifTask(p1, p2, p3), p4);
    }
    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 5, 9, -2, new Variant5.TwoNumbers(2, 1) },
                { -3, 7, 2, new Variant5.TwoNumbers(2, 1) } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, int p2, int p3, int p4) {
        assertEquals(new Variant5().switchTask(p1, p2, p3), p4);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 3, 2, 4, 1 }, { 6, 2, 2, 4 } };
    }



    ///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int n, double p2) {
        assertEquals(new Variant5().forTask(n), p2);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 3, 0.3, 0.6, 0.9, 1.2, 1.5, 1.8, 2.1, 2.4, 2.7, 3 } };
    }

    ///////////////////////////////////////////////////

    //////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int a, int b) {
        assertEquals(new Variant5().whileTask(a), b);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 8, 3 }, { 2, 1 }, { 16, 4} };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
    public void negativeWhileTest(int a) {
        new Variant5().whileTask(a);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][] { { -2 }, { 0} };
    }

    //////////////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int n, int[] value) {
        assertEquals(new Variant5().arrayTask(n), value);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { {3, new int[] { 1, 1, 2 } }, {5, new int[] { 1, 1, 2, 3, 5 }}};
    }



    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[] input, int from, int to,int d, int[][] output) {
        assertEquals(new Variant5().twoDimensionArrayTask(input, from, to, d), output);
    }
    @DataProvider
    public Object[][] matrixProvider() {
        int[] input = {2, -4, 34};

        int[][] input23 = {{2, 4, 6, 8},
                {-4, -2, 0, 2},
                {34,36, 38, 40}};

        int[][] input14 = {{-98, -94, -90, -86},
                {-4, 0, 4, 8},
                {34, 38, 42, 46}};

        return new Object[][] { {input, 4, 3, 2, input23}, { input, 4,3, 4, input14 } };

    }



}