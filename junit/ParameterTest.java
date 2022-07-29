package examples;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterTest {
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5,5,10",
            "10,50, 60"
    })
    public void addMethod(int num1, int num2, int answer){
        Calculator calc=new Calculator();
        int result=calc.add(num1,num2);
        System.out.println(result);
        assertEquals(answer,result);

    }
}
