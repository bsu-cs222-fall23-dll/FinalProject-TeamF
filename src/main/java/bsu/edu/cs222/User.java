package bsu.edu.cs222;



public class User{
    public String startingPage;
    public String endingPage;
    public String startingURL;
    public String endingURL;
    public int clicks;
    public int time;

    public User(String start, String end, int clicks, int time) {
        this.startingPage=start;
        //setStartingURL(startingPage);
        this.endingPage=end;
        //setEndingURL(endingPage);
        this.clicks=clicks;
        this.time=time;

    }

    public void getStartInfo(){
        getStartingURL();
        getEndingURL();
    }


    public void setEndingURL(String ending) {
        URLConnection URL = new URLConnection();
        this.endingURL = URL.makeConnection(endingURL);
    }
    public void setStartingURL(String startingPage){
        URLConnection URL = new URLConnection();
        this.startingURL=URL.makeConnection(startingPage);
    }
    public String getStartingURL(){
        return startingURL;
    }

    public String getEndingURL() {
        return endingURL;
    }

    public String toString(){
        return this.startingPage+ " "
                + this.endingPage + " "
                + this.clicks + " "
                + this.time + " ";
    }
}
