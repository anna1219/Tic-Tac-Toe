package com.tictactoe.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private Board board = new Board();
    private Game game = new Game();

    @Test
    public void shouldDetectWhenWinning() {
        for(int index=4; index<7; index++) {
            board.draw(index, "X");
        }
        boolean result = game.isWinning(board);
        assertTrue(result);
    }

    @Test
    public void shouldNotDetectWinningWhenBoardEmpty() {
        boolean result = game.isWinning(board);
        assertFalse(result);
    }

    @Test
    public void shouldReturnWinningStep() {
        board.draw(1, "O");
        board.draw(7, "O");
        board.draw(2, "O");
        board.draw(3, "X");
        board.draw(6, "X");
        assertEquals(4, game.winningStep(board, "O"));
    }

    @Test
    public void shouldDrawToRandomEmptyBoxWhenNotWinningAndNotLosing() {
        board.draw(1, "O");
        board.draw(2, "X");
        int randomIndex = game.findNextStep(board);
        System.out.println("The randomized index is: " + randomIndex);
        assertTrue(randomIndex > 2);
        assertTrue(randomIndex <10);
    }

    @Test
    public void shouldDrawToBlockWhenOpponentIsWinning() {
        board.draw(1, "O");
        board.draw(2, "X");
        board.draw(5, "X");
        int index = game.findNextStep(board);
        System.out.println("The blocking index is: " + index);
        assertEquals(8, index);
    }

}
