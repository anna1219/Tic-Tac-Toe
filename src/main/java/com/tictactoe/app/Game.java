package com.tictactoe.app;

public class Game {

    private int[][] array = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}, {1,4,7}, {2,5,8}, {3,6,9}, {1,5,9}, {3,5,7}};

    public boolean isWinning(Board board) {
        boolean isWinning = false;
        for(int i=0;i<8;i++){
            if(!board.read(array[i][0]).equals(" ") && board.read(array[i][0]).equals(board.read(array[i][1])) &&
                    board.read(array[i][1]).equals(board.read(array[i][2]))) {
                isWinning = true;
            }
        }
        return isWinning;
    }

    public int winningStep(Board board, String boxValue) {
        int i, j;
        for(i=0;i<8;i++){
            int count = 0;
            for(j=0;j<3;j++){
                if(board.read(array[i][j]).equals(boxValue)) {
                    count++;
                    if(count>1) {
                        if(j==1) {
                            if (board.read(array[i][j + 1]).equals(" ")) {
                                return array[i][j + 1];
                            }
                        }
                        else {
                            if (board.read(array[i][j - 1]).equals(" ")) return array[i][j-1]; }
                    }
                }
            }
        }

        return 0;
    }


    public int findNextStep(Board board) {
        int selfWinningStep = winningStep(board, "O");
        int opponentWinningStep = winningStep(board, "X");
        if (selfWinningStep == 0) {
            if(opponentWinningStep!=0){
                return opponentWinningStep;
            } else {
                int randomIndex = (int) Math.ceil(Math.random() * (board.getEmptyBoxes()).size());
                return (board.getEmptyBoxes()).get(randomIndex - 1);
            }
        }
        return selfWinningStep;
    }
}
