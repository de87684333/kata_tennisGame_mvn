package org.exercise.kata;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Score score = new Score();
        score.reset();
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert 1 if player 1 won the point, insert 2 if player 2 won the point");

        boolean isMatchFinished = false;
        while(!isMatchFinished) {

            // Get point winner from the console
            System.out.println("Who won the point?");
            Player pointWinner;
            int consoleInput = scanner.nextInt();

            //convert the player
            if(1 == consoleInput) {
                pointWinner = Player.PLAYER_ONE;
            }
            else {
                pointWinner = Player.PLAYER_TWO;
            }

            isMatchFinished = score.computeScore(pointWinner);

            if(!isMatchFinished)
                System.out.println("Score: "+ score.printScore());
        }

        System.out.println("Match finished, " + score.getWinner() + " won");
    }
}
