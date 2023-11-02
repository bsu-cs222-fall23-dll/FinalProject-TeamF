package bsu.edu.cs222;

public class URLConnection{

    public String makeConnection(String site){
        String searchableTitle = makeSearchable(site);
        String URL = "https://en.wikipedia.org/"+searchableTitle;
        return URL;
    }
    public String makeSearchable(String startingSite){
        String searchableTitle="";
        for (char c: startingSite.toCharArray()){
            if (Character.isWhitespace(c)){
                searchableTitle = searchableTitle + "_";
            }else{
                searchableTitle = searchableTitle + c;
            }

        }
        return searchableTitle;
    }
}
