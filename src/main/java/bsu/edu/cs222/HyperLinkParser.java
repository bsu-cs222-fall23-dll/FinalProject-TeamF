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
        }
        return addAtrr(links);

    }
    private List<String> addAtrr(List<String> links ){
        Iterator sortLinks = links.iterator();
        List <String> combined= new ArrayList<>();
        while (sortLinks.hasNext()){
            String link = (String) sortLinks.next();
            if (link.startsWith("/wiki/")
                    &&!link.startsWith("/wiki/File")
                    &&!link.startsWith("/wiki/Special")
                    &&!link.endsWith("(identifier)")
                    &&!link.startsWith("/wiki/Category")
                    &&!link.startsWith("/wiki/Help")
                    &&!link.startsWith("/wiki/Wikipedia")
                    &&!link.startsWith("/wiki/Talk")
                    &&!link.startsWith("/wiki/Portal")){
                String title= link.replace("/wiki/","");
                combined.add(title);
                combined.add(link);
            }
        }
        return combined;
    }
    public void gameEnd(String URL, String endingURL){
        Boolean target = false;
        if (URL.equals(endingURL)){
            target = true;
        }else{
            target = false;
        }
    }

}