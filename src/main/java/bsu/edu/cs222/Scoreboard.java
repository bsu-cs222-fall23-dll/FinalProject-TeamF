package bsu.edu.cs222;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scoreboard {
    static List<User> scoreBoard = new ArrayList<>();

    public static String scoreKeeper(User user){
        scoreBoard.add(user);
        Collections.sort(scoreBoard, new ScoreBoardComparator());
        return scoreBoard.toString();
    }

    public static String scoreCollection(){
        return scoreBoard.toString();
    }
}
