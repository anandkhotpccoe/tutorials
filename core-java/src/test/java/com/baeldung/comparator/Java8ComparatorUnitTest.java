package com.baeldung.comparator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Java8ComparatorUnitTest {

    List<Player> footballTeam;

    @Before
    public void setUp() {
        footballTeam = new ArrayList<Player>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);
    }

    @Test
    public void whenComparing_UsingJava8_thenSorted() {
        System.out.println("************** Java 8 Comaparator **************");
        Comparator<Player> byRanking = new Comparator<Player>() {

            @Override
            public int compare(Player player1, Player player2) {
                return player1.getRanking() - player2.getRanking();
            }
        };

        System.out.println("Before Sorting : " + footballTeam);
        Collections.sort(footballTeam, byRanking);
        System.out.println("After Sorting : " + footballTeam);
        assertEquals(footballTeam.get(0)
            .getName(), "Steven");
        assertEquals(footballTeam.get(2)
            .getRanking(), 67);
    }

    @Test
    public void whenComparing_UsingComparatorComparing_thenSorted() {
        System.out.println("********* Comaparator.comparing method *********");
        Comparator<Player> byRanking =
            (Player player1, Player player2)->player1.getRanking()-player2.getRanking();

        System.out.println("Before Sorting : " + footballTeam);
        Collections.sort(footballTeam, byRanking);
        System.out.println("After Sorting : " + footballTeam);
        assertEquals(footballTeam.get(0)
            .getName(), "Steven");
        assertEquals(footballTeam.get(2)
            .getRanking(), 67);
    }

}
