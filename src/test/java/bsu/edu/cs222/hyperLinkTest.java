package bsu.edu.cs222;

import org.junit.Test;

import java.io.IOException;

import java.util.Iterator;
import java.util.List;


public class hyperLinkTest extends HyperLinkParser{
    @Test
    public void hyperLinkTest() throws IOException {
        List<String> testSet= findHyper("https://en.wikipedia.org/wiki/Cat");
        Iterator iterator = testSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
