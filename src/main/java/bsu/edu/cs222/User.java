package bsu.edu.cs222;



public class User{
    public String startingPage;
    public String endingPage;
    public int clicks;
    public int time;

    public User(String start, String end, int clicks, int time) {
        this.startingPage=start;
        this.endingPage=end;
        this.clicks=clicks;
        this.time=time;

    }

    public String toString(){
        return this.startingPage+ " "
                + this.endingPage + " "
                + this.clicks + " "
                + this.time + " ";
    }
}


