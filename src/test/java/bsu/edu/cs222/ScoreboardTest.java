package bsu.edu.cs222;

import org.junit.jupiter.api.Test;


public class ScoreboardTest extends Scoreboard {
    User user1 = new User("cat","dog",5,10);
    User user3 = new User("bird","fish",2,10);
    User user2 = new User("United States","Obesity",1,5);

    @Test
    public void scoreKeeperTest(){
        System.out.println(scoreKeeper(user1)+ "\n");
        System.out.println(scoreKeeper(user2)+ "\n");
        System.out.println(scoreKeeper(user3)+ "\n");
    }
}
