package bsu.edu.cs222;

public class URLConnection{
    public String makeSearchable(String startingSite){
        StringBuilder searchableTitle= new StringBuilder();
        for (char c: startingSite.toCharArray()){
            if (Character.isWhitespace(c)){
                searchableTitle.append("_");
            }else{
                searchableTitle.append(c);
            }
        }
        return searchableTitle.toString();
    }
}
