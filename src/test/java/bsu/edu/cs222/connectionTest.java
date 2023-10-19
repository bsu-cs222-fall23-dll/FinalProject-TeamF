package bsu.edu.cs222;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class connectionTest extends URLConnection{
    @Test
    public void searchableNameTest(){
        String result = makeSearchable("this test");
        Assertions.assertEquals("this_test", result);
    }
}
