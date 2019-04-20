import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UpperCaseCounterTest {
    private  UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    @Test
    public void checkNull(){
        String str = null;
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertTrue(result == 0);
    }

    @Test
    public void emptyCheck(){
        String str = "";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        assertTrue(result == 0);
    }

    @Test
    public void Upper_ABC(){
        String str = "ABC";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        System.out.println("result :: " + result);
        assertTrue(result == 3);
    }

    @Test
    public void UpperLower_ABCdef(){
        String str = "ABCdef";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        System.out.println("result :: " + result);
        assertTrue(result == 3);
    }

}
