package com.hsenid.scientificCalculator;

import com.hsenid.scientificCalculator.model.CalculatorOperatons;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Vidu on 12/13/2016.
 */
public class CalculatorTest {
    double result;
    String expression;
    private static CalculatorOperatons operatons = new CalculatorOperatons();

    @Test
    public void testExpressions(){
        expression = "7 + ( 8 * 8 ) / 4 - 15";
        result = operatons.evaluate(expression,0);

        assertEquals(8.0, result);
        System.out.println("testExpressions PASS");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void divideByZeroTest() throws Exception{
        expression = "5 + ( 5 / 0 ) * 3";
        result = operatons.evaluate(expression,0);
    }

    @Test
    public void testLargeValue(){
        expression = "9999 + ( 58642 * 145 ) / 2 - 7855";
        result = operatons.evaluate(expression,0);
        assertEquals(4253689.0, result);
        System.out.println("testLargeValue PASS");
    }

    @Test
    public void testEmptyExpressions(){
        expression = "0 + ( 0 * 0 )  - 0";
        result = operatons.evaluate(expression,0);
        assertEquals(0.0, result);
        System.out.println("testEmptyExpressions PASS");
    }
}
