package bsu.edu.cs222;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scoreboard extends User{
    List<User> scoreBoard = new ArrayList<>();
    public void addToRoster(User user){
        scoreBoard.add(user);
    }
    public String scoreKeeper(){
        Collections.sort(scoreBoard);
        String scoreboardString = scoreBoard.toString();
        return scoreboardString;
    }

}
