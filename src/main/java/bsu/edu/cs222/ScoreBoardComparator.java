package bsu.edu.cs222;

import java.util.Comparator;

public class ScoreBoardComparator implements
        Comparator<User> {
    @Override
    public int compare(User userOne, User userTwo){
        return userOne.clicks - userTwo.clicks;
    }
}
