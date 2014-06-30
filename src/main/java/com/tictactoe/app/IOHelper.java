package com.tictactoe.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOHelper {

    static void printBoardIndex() {
        System.out.println(" 1 | 2 | 3 \n" +
                "-----------\n" +
                " 4 | 5 | 6 \n" +
                "-----------\n" +
                " 7 | 8 | 9 \n");
    }

    static String initiateGame(IOHelper helper) throws IOException {
        System.out.println("Welcome to Tic-Tac-Toe!\nWhen it's your turn, type the index of the box where you want to make a move and press enter.");
        System.out.println("Type 'C' for a human vs computer game or 'M' for a human vs human game.");
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            if (!helper.isValidMode(input)) {
                System.out.println("Invalid input! Please choose between 'C' and 'M'!");
                continue;
            }
            return input;
        }
    }

    public boolean isValidInput(String input) {
        return input != null && input.matches("[1-9]");
    }

    public boolean isValidMode(String mode) { return mode != null && mode.matches("[Cc]|[Mm]"); }
}
