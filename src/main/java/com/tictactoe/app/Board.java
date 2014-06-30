package com.tictactoe.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    private HashMap<Integer, String> board = new HashMap<Integer, String>();
    private List<Integer> emptyBoxes = new ArrayList<Integer>();

    public Board() {
        for(int index=1;index<10;index++){
            board.put(index, " ");
            emptyBoxes.add(index);
        }
    }

    public String read(int index) {
        return board.get(index);
    }

    public boolean draw(int index, String boxValue) {
        if(!board.get(index).equals(" "))
        {
            System.out.println("This box is already taken! Please enter another index.\n");
            return false;
        }
        else {
            board.put(index, boxValue);
            emptyBoxes.remove(emptyBoxes.indexOf(index));
            return true;
        }
    }

    public void print() {
        System.out.println(" " + board.get(1) + " | " + board.get(2) + " | " + board.get(3) + " \n" +
                "-----------\n" +
                " " + board.get(4) + " | " + board.get(5) + " | " + board.get(6) + " \n" +
                "-----------\n" +
                " " + board.get(7) + " | " + board.get(8) + " | " + board.get(9) + " \n");
    }

    public boolean isFull() {
        return emptyBoxes.isEmpty();
    }

    public List<Integer> getEmptyBoxes() {
        return emptyBoxes;
    }
}
