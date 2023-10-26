package bsu.edu.cs222;



public class User {
    public String startingPage;
    public String endingPage;
    public String startingURL;
    public String endingURL;

    public void setStartingPage(String startingPage){
        this.startingPage=startingPage;
    }
    public void setEndingURL(String endingURL) {
        URLConnection URL = new URLConnection();
        this.endingURL = URL.makeConnection(endingURL);
    }
    public void setStartingURL(String startingPage){
        URLConnection URL = new URLConnection();
        this.startingURL=URL.makeConnection(startingPage);
    }
    public void setEndingPage(String endingPage) {
        this.endingPage = endingPage;
    }
    public String getStartingURL(){
        return startingURL;
    }

    public String getEndingPage() {
        return endingPage;
    }

    public String getEndingURL() {
        return endingURL;
    }
    public String getStartingPage(){
        return startingPage;
    }
}
