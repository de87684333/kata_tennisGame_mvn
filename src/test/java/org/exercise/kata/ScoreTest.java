package org.exercise.kata;

import junit.framework.TestCase;

public class ScoreTest extends TestCase {

    public void testConvertPoint() {

        Score score = new Score();

        String result = score.convertPoint(0);
        assertEquals("Conversion of ZERO is incorrect","0", result);

        result = score.convertPoint(1);
        assertEquals("Conversion of FIFTEEN is incorrect","15", result);

        result = score.convertPoint(2);
        assertEquals("Conversion of FIFTEEN is incorrect","30", result);

        result = score.convertPoint(3);
        assertEquals("Conversion of FIFTEEN is incorrect","40", result);
    }

    public void testPlayerWins_WhenOtherPlayerHasNot40() {

        //Given
        Score score = new Score();
        int playerPoint = 4;
        int otherPlayerPoint = 0;

        //When
        boolean result = score.isPlayerWonTheGame(playerPoint, otherPlayerPoint);

        //Then
        assertEquals("The player should have won", true, result);
    }

    public void testPlayerDoNotWin_WhenPlayerHas40() {

        //Given
        Score score = new Score();

        int playerPoint = 3;
        int otherPlayerPoint = 0;

        //When
        boolean result = score.isPlayerWonTheGame(playerPoint, otherPlayerPoint);

        //Then
        assertEquals("The player should not have won", false, result);
    }

    public void testPlayerWins_WhenOtherPlayerHas40ButThereIsADifferenceOfTwoPoints() {

        //Given
        Score score = new Score();

        int playerPoint = 6;
        int otherPlayerPoint = 4;

        //When
        boolean result = score.isPlayerWonTheGame(playerPoint, otherPlayerPoint);

        //Then
        assertEquals("The player should have won", true, result);
    }

    public void testPlayerDoNotWin_WhenOtherPlayerHas40AndThereIsNotADifferenceOfTwoPoints() {

        //Given
        Score score = new Score();

        int playerPoint = 5;
        int otherPlayerPoint = 4;

        //When
        boolean result = score.isPlayerWonTheGame(playerPoint, otherPlayerPoint);

        //Then
        assertEquals("The player should not have won", false, result);
    }
}
