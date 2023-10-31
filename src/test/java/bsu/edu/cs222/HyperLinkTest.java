package bsu.edu.cs222;

import org.junit.Test;

import java.io.IOException;

import java.util.List;


public class HyperLinkTest extends HyperLinkParser{
    @Test
    public void hyperLinkTests() throws IOException {
        List<String> testSet= findHyper("https://en.wikipedia.org/wiki/Cat");
        for (String s : testSet) {
            System.out.println(s);
        }

    }

}
