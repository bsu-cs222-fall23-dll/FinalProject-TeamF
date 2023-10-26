package bsu.edu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConnectionTest extends URLConnection{
    @Test
    public void searchableNameTest(){
        String result = makeSearchable("this test");
        Assertions.assertEquals("this_test", result);
    }
}
