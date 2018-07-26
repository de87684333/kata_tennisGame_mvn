package org.exercise.kata;
import junit.framework.TestCase;

public class FunctionalTests extends TestCase {
    
    
    public void testPlayerOneWinsEasily() {
        Score score = new Score();

        assertEquals("Initial winner incorrect",Player.NONE, score.getWinner());
        String expectedResult = "Player 1: 0 - Player 2: 0";
        String result = score.printScore();
        assertEquals(expectedResult, result);

        // 15 - 0 -> game not finished
        boolean isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 15 - Player 2: 0";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 30 - 0 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 30 - Player 2: 0";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 40 - 0 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 40 - Player 2: 0";
        result = score.printScore();
        assertEquals(expectedResult, result);

        //Victory of player one -> game finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should be finished",true, isMatchFinished);
        assertEquals("Winner incorrect",Player.PLAYER_ONE, score.getWinner());
    }

    
    public void testPlayerTwoWinsEasily() {
        Score score = new Score();

        assertEquals("Initial winner incorrect",Player.NONE, score.getWinner());
        String expectedResult = "Player 1: 0 - Player 2: 0";
        String result = score.printScore();
        assertEquals(expectedResult, result);

        // 0 - 15 -> game not finished
        boolean isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 0 - Player 2: 15";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 0 - 30 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 0 - Player 2: 30";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 0 - 40 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 0 - Player 2: 40";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 15 - 40 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 15 - Player 2: 40";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 30 - 40 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 30 - Player 2: 40";
        result = score.printScore();
        assertEquals(expectedResult, result);

        //Victory of player two -> game finished
        isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should be finished",true, isMatchFinished);
        assertEquals("Winner incorrect",Player.PLAYER_TWO, score.getWinner());

    }

    
    public void testPlayerOneWinsAfterDeuce() {
        Score score = new Score();

        assertEquals("Initial winner incorrect",Player.NONE, score.getWinner());
        String expectedResult = "Player 1: 0 - Player 2: 0";
        String result = score.printScore();
        assertEquals(expectedResult, result);

        // 0 - 15 -> game not finished
        boolean isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 0 - Player 2: 15";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 0 - 30 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 0 - Player 2: 30";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 0 - 40 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 0 - Player 2: 40";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 15 - 40 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 15 - Player 2: 40";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 30 - 40 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 30 - Player 2: 40";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 40 - 40 (DEUCE) -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "DEUCE";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // Advantage player one -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Advantage player 1";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // Victory of player one  -> game finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should be finished",true, isMatchFinished);
        assertEquals("Winner incorrect",Player.PLAYER_ONE, score.getWinner());
    }

    
    public void testPlayerTwoWinsAfterSeveralDeuce() {
        Score score = new Score();

        assertEquals("Initial winner incorrect",Player.NONE, score.getWinner());
        String expectedResult = "Player 1: 0 - Player 2: 0";
        String result = score.printScore();
        assertEquals(expectedResult, result);

        // 0 - 15 -> game not finished
        boolean isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 0 - Player 2: 15";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 0 - 30 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 0 - Player 2: 30";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 0 - 40 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 0 - Player 2: 40";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 15 - 40 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 15 - Player 2: 40";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 30 - 40 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Player 1: 30 - Player 2: 40";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 40 - 40 (DEUCE) -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "DEUCE";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // Advantage player one  -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Advantage player 1";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // 40 - 40 (DEUCE) -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "DEUCE";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // Advantage player Two -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should not be finished",false, isMatchFinished);
        expectedResult = "Advantage player 2";
        result = score.printScore();
        assertEquals(expectedResult, result);

        // Victory of player Two -> game finished
        isMatchFinished = score.computeScore(Player.PLAYER_TWO);
        assertEquals("Match should be finished",true, isMatchFinished);
        assertEquals("Winner incorrect",Player.PLAYER_TWO, score.getWinner());
    }

    
    public void testResetScore() {
        Score score = new Score();

        assertEquals("Initial winner incorrect",Player.NONE, score.getWinner());

        // 15 - 0 -> game not finished
        boolean isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);

        // 30 - 0 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);

        // 40 - 0 -> game not finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should not be finished",false, isMatchFinished);

        //Victory of player one -> game finished
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should be finished",true, isMatchFinished);
        assertEquals("Winner incorrect",Player.PLAYER_ONE, score.getWinner());

        // Reset score
        score.reset();
        assertEquals("Winner incorrect",Player.NONE, score.getWinner());
        isMatchFinished = score.computeScore(Player.PLAYER_ONE);
        assertEquals("Match should be finished",false, isMatchFinished);
    }
    
}
