package bsu.edu.cs222;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreboardComparatorTest extends ScoreBoardComparator {

    @Test
    public void TestScoreboard(){
        ArrayList<User> ar = new ArrayList<>();
        ar.add(new User("cat","dog",5,10));
        ar.add(new User("bird","fish",2,10));
        ar.add(new User("United States","Obesity",1,5));
        System.out.println("Unsorted");

        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));
        Collections.sort(ar, new ScoreBoardComparator());
        System.out.println("\nSorted");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));
    }
}

