package bsu.edu.cs222;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;


public class HyperLinkParser extends URLConnection{

    public List<String> findHyper(String URL) throws IOException {
        List<String> links = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        Document doc = Jsoup.connect(URL)
                .data("query","Java")
                .userAgent("Mozilla")
                .cookie("auth","token")
                .timeout(3000)
                .get();
        Elements elements = doc.select("a[href]");
        for (Element element : elements){
            links.add(element.attr("href"));
            titles.add(element.attr("title"));

        }
        List<String> combined = addAtrr(links,titles);
        return combined;

    }
    private List<String> addAtrr(List<String> links , List<String> titles){
        Iterator sortLinks = links.iterator();
        Iterator sortNames = titles.iterator();
        List <String> combined= new ArrayList<>();
        while (sortLinks.hasNext()){
            if (sortNames.hasNext()){
                combined.add((String) sortNames.next());
            }
            combined.add((String) sortLinks.next());
        }
        return combined;
    }


}