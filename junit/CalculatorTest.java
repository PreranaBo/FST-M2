package examples;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    static Calculator calc;

    @BeforeAll
    public static void setUp(){
        calc=new Calculator();
    }
    @Test
    public void addMethodTest(){
        int result1=calc.add(10,5);
        int result2=calc.add(10,9);
        System.out.println(result1);
        assertAll(
                ()-> assertEquals(15,result1),
                ()-> assertEquals(15,result2)
        );
    }
}
