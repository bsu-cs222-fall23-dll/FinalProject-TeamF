package bsu.edu.cs222;



public class User implements Comparable<User>{
    public String startingPage;
    public String endingPage;
    public String startingURL;
    public String endingURL;
    public int clicks;
    public int time;

    public User(String start, String end, int clicks, int time) {
        this.startingPage=start;
        this.endingPage=end;
        this.clicks=clicks;
        this.time=time;

    }

    public void getStartInfo(){
        getStartingURL();
        getEndingURL();
    }

    public int getClicks() {
        return clicks;
    }

    public int getTime() {
        return time;
    }

    public void setEndingURL(String endingPage) {
        URLConnection URL = new URLConnection();
        this.endingURL = URL.makeConnection(endingPage);
    }
    public void setStartingURL(String startingPage){
        URLConnection URL = new URLConnection();
        this.startingURL=URL.makeConnection(startingPage);
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
    @Override
    public int compareTo(User otherUser){
        return Integer.compare(getClicks(),otherUser.getClicks());
    }
}
