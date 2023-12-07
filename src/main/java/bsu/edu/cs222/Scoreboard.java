package bsu.edu.cs222;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Scoreboard {
    static List<User> scoreBoard = new ArrayList<>();

    public static String scoreKeeper(User user) {
        scoreBoard.add(user);
        scoreBoard.sort(new ScoreBoardComparator());
        return joinWithNewline(scoreBoard);
    }

    public static String scoreCollection() {
        return joinWithNewline(scoreBoard);
    }

    private static String joinWithNewline(List<User> userList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (User user : userList) {
            joiner.add(user.toString());
        }
        return joiner.toString();
    }
}