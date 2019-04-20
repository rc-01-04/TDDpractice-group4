import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CustomCalculatorTest {
    private  CustomCalculator cal = new CustomCalculator();

    @Test
    public void addTest(){
        int result = cal.add(3,4);
        assertTrue(result == 7);
    }
    @Test
    public void minusTest(){
        int result = cal.subtract(3,4);
        assertTrue(result == -1);
    }
}