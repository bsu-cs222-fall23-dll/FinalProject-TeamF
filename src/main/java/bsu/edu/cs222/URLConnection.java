package bsu.edu.cs222;

public class URLConnection extends User{
    public String startingURL(){
        String search = getStartingPage();
        String startingURL = makeConnection(search);
        return startingURL;
    }
    public String makeConnection(String startingSite){
        String searchableTitle = makeSearchable(startingSite);
        String URL = "https://en.wikipedia.org/"+searchableTitle;
        return URL;
    }
    public String makeSearchable(String startingSite){
        String searchableTitle="";
        for (char c: startingSite.toCharArray()){
            if (Character.isWhitespace(c)){
                searchableTitle = searchableTitle +"_";
            }else{
                searchableTitle = searchableTitle + c;
            }

        }
        return searchableTitle;
    }
}
