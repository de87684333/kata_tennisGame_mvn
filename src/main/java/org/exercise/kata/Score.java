package org.exercise.kata;

enum Player {
    NONE, PLAYER_ONE, PLAYER_TWO
}

public class Score {
    
    public static final int ZERO = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FOURTY = 3;


    // Points of player 1
    protected int playerOnePoints = 0;

    //Points of player 2
    protected int playerTwoPoints = 0;

    //Winner ID: 1 for player 1 and 2 for player2
    private Player winner = Player.NONE;

    // Reset the score
    public void reset() {
        playerOnePoints = 0;
        playerTwoPoints = 0;
        winner = Player.NONE;
    }

    // Computation of the score depending on which player won the point
    public boolean computeScore(Player pointWinner) {
        boolean isMatchFinished = false;

        // Increment the points of the winner
        if(Player.PLAYER_ONE == pointWinner)
            playerOnePoints++;
        else
            playerTwoPoints++;

        //Check if some player win the game
        if(isPlayerWonTheGame(playerOnePoints, playerTwoPoints))
        {
            // Player One wins
            isMatchFinished = true;

            winner = Player.PLAYER_ONE;
        } else if(isPlayerWonTheGame(playerTwoPoints, playerOnePoints))
        {
            // Player Two wins
            isMatchFinished = true;
            winner = Player.PLAYER_TWO;
        }

        return isMatchFinished;
    }

    public Player getWinner() {
        return winner;
    }

    public String printScore() {
        String result="Player 1: ";
        result=result.concat(convertPoint(playerOnePoints));

        result=result.concat(" - Player 2: ");
        result=result.concat(convertPoint(playerTwoPoints));

        if(playerOnePoints >= FOURTY && playerTwoPoints>= FOURTY) {
            if (playerTwoPoints == playerOnePoints) {
                result = "DEUCE";
            } else if (playerOnePoints > playerTwoPoints) {
                result = "Advantage player 1";
            } else {
                result = "Advantage player 2";
            }
        }

        return result;
    }

    // Convert number of points into tennis counting (0,15,30,40)
    public String convertPoint(int l_playerPoints){
        String result="";

        switch(l_playerPoints)
        {
            case ZERO:
                result="0";
                break;
            case FIFTEEN:
                result="15";
                break;
            case THIRTY:
                result="30";
                break;
            case FOURTY:
                result="40";
                break;
            default:
                break;
        }
        return  result;
    }

    // Return if the player won the game regarding points of each players
    public boolean isPlayerWonTheGame(int playerPoints, int otherPlayerPoints) {
        boolean isMatchFinished =  false;

        // The player wins the game
        // when he gets more than 40
        if(playerPoints > FOURTY) {
            // And the other player has less than 40 or the difference between both players are more than 2 points
            if((otherPlayerPoints < FOURTY) || ((playerPoints - otherPlayerPoints) >= 2)) {
                isMatchFinished = true;
            }
        }

        return isMatchFinished;
    }
}
