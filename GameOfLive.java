package pl.samouczekprogramisty.kursyjava.gameOfLive;



public class GameOfLive {

    private String[][] board;
    private LiveCells[] cells;

    public GameOfLive(int n, LiveCells[] cells) {

        this.cells = cells;
        int x, y;
        board = new String[n][n];

        for (int i = 0; i < cells.length; i++) {
            x = cells[i].getX();
            y = cells[i].getY();
            board[x][y] = "#";
        }
    }

    public void showData() {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j] + "\t");
                }else{
                    System.out.print("." + "\t");
                }
            }
            System.out.println();
        }
    }

    public void nextGeneration() {
        int isLive = 0;
        String[][] copyBoard = new String[board.length][board.length];
        //copyBoard = board;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != null) {

                    if (board[checkMinus(i)][j] != null) {
                        isLive++;
                    }
                    if (board[checkMinus(i)][checkPlus(j)] != null) {
                        isLive++;
                    }
                    if (board[checkMinus(i)][checkMinus(j)] != null) {
                        isLive++;
                    }
                    if (board[i][checkMinus(j)] != null) {
                        isLive++;
                    }
                    if (board[i][checkPlus(j)] != null) {
                        isLive++;
                    }
                    if (board[checkPlus(i)][j] != null) {
                        isLive++;
                    }
                    if (board[checkPlus(i)][checkMinus(j)] != null) {
                        isLive++;
                    }
                    if (board[checkPlus(i)][checkPlus(j)] != null) {
                        isLive++;
                    }
                    if (isLive < 2) {
                        copyBoard[i][j] = null;
                    } else if (isLive > 3) {
                        copyBoard[i][j] = null;
                    }
                                      isLive = 0;

                }else{
                    if (board[checkMinus(i)][j] != null) {
                        isLive++;
                    }
                    if (board[checkMinus(i)][checkPlus(j)] != null) {
                        isLive++;
                    }
                    if (board[checkMinus(i)][checkMinus(j)] != null) {
                        isLive++;
                    }
                    if (board[i][checkMinus(j)] != null) {
                        isLive++;
                    }
                    if (board[i][checkPlus(j)] != null) {
                        isLive++;
                    }
                    if (board[checkPlus(i)][j] != null) {
                        isLive++;
                    }
                    if (board[checkPlus(i)][checkMinus(j)] != null) {
                        isLive++;
                    }
                    if (board[checkPlus(i)][checkPlus(j)] != null) {
                        isLive++;
                    }
                    if(isLive == 3){
                        copyBoard[i][j] = "#";

                    }
                                        isLive = 0;
                }

            }
        }
        board = copyBoard;
    }


    public int checkMinus(int num){
        if( num == 0){
            num = num + board.length -1;
        }else{
            num = num - 1;
        }
    return num;
    }

    public int checkPlus(int num){
        if( num == board.length -1){
            num = 0;
        }else{
            num = num +1;
        }
        return num;
    }





    public static void main(String[] args) {

        LiveCells[] dataToArrays = {
                new LiveCells(0, 1),
                new LiveCells(0, 2),
                new LiveCells(1, 1),
                new LiveCells(1,2),
                new LiveCells(4, 2)
        };

        GameOfLive gameOfLive = new GameOfLive(5, dataToArrays);
        gameOfLive.showData();
        System.out.println();
        gameOfLive.nextGeneration();
        gameOfLive.showData();
        gameOfLive.nextGeneration();
        gameOfLive.showData();
        gameOfLive.nextGeneration();
        gameOfLive.showData();
        gameOfLive.nextGeneration();
        gameOfLive.showData();
        gameOfLive.nextGeneration();
        gameOfLive.showData();
        gameOfLive.nextGeneration();
        gameOfLive.showData();


    }
}