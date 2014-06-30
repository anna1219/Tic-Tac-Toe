package com.tictactoe.app;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    private Board board = new Board();

    @Test
    public void shouldInitiateEmptyBoard() {
        assertEquals(9, (board.getEmptyBoxes()).size());
        assertEquals(new Integer(1), (board.getEmptyBoxes()).get(0));
    }

    @Test
    public void shouldDrawToTheBox() {
        int index = 2;
        String boxValue = "X";
        board.draw(index, boxValue);
        assertEquals("X", board.read(index));
    }

    @Test
    public void shouldNotDrawToTheBoxAlreadyTaken() {
        int index = 2;
        String boxValue1 = "X";
        String boxValue2 = "O";
        board.draw(index, boxValue1);
        boolean result = board.draw(index, boxValue2);
        assertEquals("X", board.read(index));
        assertTrue(!result);
    }

    @Test
    public void shouldReturnTrueWhenAllBoxesAreFilled() {
        for(int index=1; index<10; index++) {
            board.draw(index, "X");
        }
        boolean result = board.isFull();
        assertTrue(result);
    }

    @Test
    public void shouldReturnUnoccupiedBoxes() {
        board.draw(1, "X");
        board.draw(3, "O");
        System.out.println(board.getEmptyBoxes());
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        assertEquals(expected, board.getEmptyBoxes());
    }
}
