package com.tictactoe.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String [] args) throws IOException {

        int numOfMove = 0;
        int player = 0;
        boolean diffLocation;
        String[] boxValue = {"X", "O"};
        Board board = new Board();
        Game game = new Game();
        IOHelper helper = new IOHelper();

        String mode = IOHelper.initiateGame(helper);
        IOHelper.printBoardIndex();

        if(mode.matches("[m|M]")){
            while(!board.isFull() && !game.isWinning(board)) {
                if(numOfMove % 2 == 0) { player = 1; }
                else { player = 2; }
                System.out.println("Player " + player + "'s turn:");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String input = br.readLine();
                if (!helper.isValidInput(input)){
                    System.out.println("Invalid input! Please only type a number between 1 and 9.");
                    continue;
                } else {
                    diffLocation = board.draw(Integer.parseInt(input), boxValue[(player-1)]);
                    if (diffLocation) {
                        numOfMove++;
                    }
                }
                board.print();
            }
        }
        else {
            //computer mode
            while(!board.isFull() && !game.isWinning(board)) {
                if(numOfMove % 2 == 0) {
                    //human player
                    player = 1;
                    System.out.println("Player " + player + "'s turn:");
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String input = br.readLine();
                    if (!helper.isValidInput(input)) {
                        System.out.println("Invalid input! Please only type a number between 1 and 9.");
                        continue;
                    } else {
                        diffLocation = board.draw(Integer.parseInt(input), boxValue[(player - 1)]);
                        if (diffLocation) {
                            numOfMove++;
                        }
                    }
                }
                else {
                    //computer
                    player = 2;
                    System.out.println("Player 2's turn: (computer)");
                    board.draw(game.findNextStep(board), boxValue[(player - 1)]);
                    numOfMove++;
                    try {
                        Thread.sleep(500l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                board.print();
            }
            }

        if(game.isWinning(board)){
            System.out.println("Player " + player + " wins!");
        } else {
            System.out.println("Game is a draw.");
        }
    }

}
