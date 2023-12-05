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
        return addArr(links);

    }
    private List<String> addArr(List<String> links ){
        Iterator<String> sortLinks = links.iterator();
        List <String> combined= new ArrayList<>();
        while (sortLinks.hasNext()){
            String link = sortLinks.next();
            if (link.startsWith("/wiki/")
                    &&!link.startsWith("/wiki/File")
                    &&!link.startsWith("/wiki/Special")
                    &&!link.endsWith("(identifier)")
                    &&!link.startsWith("/wiki/Category")
                    &&!link.startsWith("/wiki/Help")
                    &&!link.startsWith("/wiki/Wikipedia")
                    &&!link.startsWith("/wiki/Talk")
                    &&!link.startsWith("/wiki/Main_Page")
                    &&!link.startsWith("/wiki/Template")
                    &&!link.startsWith("/wiki/Portal")){
                String title= link.replace("/wiki/","");
                title= title.replace("_"," ");
                title= title.replace("#"," ");
                title= title.replace("%26","&");
                title= title.replace("%27","'");
                title= title.replace("%C3%A1","a");
                title= title.replace("%C3%A9","e");
                title= title.replace("%E2%80%93","-");

                combined.add(title);
                combined.add(link);
            }
        }
        return combined;
    }

    public String findFinalRedirect(String URL) {
        try {
            URL = Jsoup.connect(URL)
                    .followRedirects(true)
                    .execute().url().toExternalForm();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return URL;
    }
}