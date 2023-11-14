package bsu.edu.cs222;

import org.junit.jupiter.api.Test;

public class ScoreboardTest extends Scoreboard {
    @Test
    public void TestScoreboard(){
        User user = new User();
        user.setStartingPage("cat");
        user.setEndingPage("dog");
        user.setClicks(10);
        user.setSeconds(50);
        addToRoster(user);
        User user2 = new User();
        user2.setStartingPage("cat");
        user2.setEndingPage("dog");
        user2.setClicks(1);
        user2.setSeconds(40);
        System.out.println(scoreKeeper());

    }

}
