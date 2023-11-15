package bsu.edu.cs222;

import org.junit.jupiter.api.Test;

public class ScoreboardTest extends Scoreboard {

    @Test
    public void TestScoreboard(){
        User user = new User("cat","dog",5,10);
        System.out.println(scoreKeeper(user));

    }

}
