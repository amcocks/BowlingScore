package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import main.*;

public class BowlingTest {
    @Test
    public void allOnes () {
        int[] rolls = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0};
        game testGame = new game(rolls);
        assertEquals(20, testGame.scoreGame());
    }
    @Test
    public void mixedNumbersNoSpecials () {
        int[] rolls = new int[]{1,3,2,4,3,5,4,5,3,4,2,5,3,4,3,5,4,0,2,4,0};
        game testGame = new game(rolls);
        assertEquals(66, testGame.scoreGame());
    }
    @Test
    public void spares () {
        int[] rolls = new int[]{1,9,2,4,2,8,5,3,2,4,3,1,3,7,5,2,4,3,3,3,0};
        game testGame = new game(rolls);
        assertEquals(86, testGame.scoreGame());
    }
    @Test
    public void strikes () {
        int[] rolls = new int[]{10,0,2,3,4,5,10,0,7,2,3,5,3,5,3,5,4,3,5,3,0};
        game testGame = new game(rolls);
        assertEquals(96, testGame.scoreGame());
    }
    @Test
    public void pickupSpare () {
        int[] rolls = new int[]{10,0,2,3,4,5,0,10,7,2,3,5,3,5,3,5,4,3,5,3,0};
        game testGame = new game(rolls);
        assertEquals(94, testGame.scoreGame());
    }
    @Test
    public void bonusRoll () {
        int[] rolls = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9,10};
        game testGame = new game(rolls);
        assertEquals(38, testGame.scoreGame());
    }
    @Test
    public void perfectGame () {
        int[] rolls = new int[]{10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,10,10};
        game testGame = new game(rolls);
        assertEquals(300, testGame.scoreGame());
    }
}
