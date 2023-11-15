package bsu.edu.cs222;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scoreboard {
    List<User> scoreBoard = new ArrayList<>();

    public String scoreKeeper(User user){
        scoreBoard.add(user);
        Collections.sort(scoreBoard);
        String scoreboardString = scoreBoard.toString();
        return scoreboardString;
    }

}
