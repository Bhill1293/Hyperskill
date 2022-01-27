package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int movesMade = 0;
        int n =0;
        int m=0;
        boolean gameEnded = false;
        char[][] gameBoard = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = '_';
            }
        }

        while (!gameEnded) {
            printBoard(gameBoard);

            char symbol = '_';
            if (movesMade % 2 != 0) {
                symbol = 'X';
            } else symbol = 'O';

            while (true) {
                System.out.println("Enter the coordinates");
                n = scanner.nextInt();
                m = scanner.nextInt();
                if (!scanner.hasNextInt()) {
                    System.out.println("You should enter numbers!\n");
                } else if (n > 3 || m > 3)
                    System.out.println("Coordinates should be from 1 to 3!\n");
                else if (gameBoard[n - 1][m - 1] != '_')
                    System.out.println("This cell is occupied! Choose another one!\n");
                else {
                    break;
                }
            }


            gameBoard[n - 1][m - 1] = symbol;
            printBoard(gameBoard);
            if(isTheWinner(gameBoard,'X')) {
                System.out.println("X wins");
                gameEnded = true;
            } else if(isTheWinner(gameBoard,'O')) {
                System.out.println("O wins");
                gameEnded = true;
            } else {
                //If neither player has won, check to see if there has been a tie (if the board is full)
                if(isTie(gameBoard)) {
                    System.out.println("Draw");
                    gameEnded = true;
                } else {
                    //If player1 is true, make it false, and vice versa; this way, the players alternate each turn
                    movesMade++;
                }
            }
        }
    }



    private static void printBoard(char[][] gameBoard) {
        System.out.println("---------");
        System.out.println("|" + " " + gameBoard[0][0] + " " + gameBoard[0][1] + " " + gameBoard[0][2] + " " + "|");
        System.out.println("|" + " " + gameBoard[1][0] + " " + gameBoard[1][1] + " " + gameBoard[1][2] + " " + "|");
        System.out.println("|" + " " + gameBoard[2][0] + " " + gameBoard[2][1] + " " + gameBoard[2][2] + " " + "|");
        System.out.println("---------");
    }


    private static boolean isTie(char[][] gameBoard) {
        for (char[] chars : gameBoard) {
            for (char symbol : chars) {
                if (symbol == '_') {
                    return false;
                }
            }
        }
        return true;
    }

//
//    private static boolean isGameFinished(char[][] gameBoard) {
//
//        if (isTheWinner(gameBoard, 'X')) {
//            System.out.println("X wins");
//            return true;
//        }
//        if (isTheWinner(gameBoard, 'O')) {
//            System.out.println("O wins");
//            return true;
//        }
//        if (isTie(gameBoard)) {
//            System.out.println("Draw");
//            return true;
//        } else
//            return false;
//    }

    private static boolean isTheWinner(char[][] gameBoard, char symbol) {
        return (gameBoard[0][0] == symbol && gameBoard[0][1] == symbol && gameBoard[0][2] == symbol) ||
                (gameBoard[1][0] == symbol && gameBoard[1][1] == symbol && gameBoard[1][2] == symbol) ||
                (gameBoard[2][0] == symbol && gameBoard[2][1] == symbol && gameBoard[2][2] == symbol) ||

                (gameBoard[0][0] == symbol && gameBoard[1][0] == symbol && gameBoard[2][0] == symbol) ||
                (gameBoard[0][1] == symbol && gameBoard[1][1] == symbol && gameBoard[2][1] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][2] == symbol && gameBoard[2][2] == symbol) ||

                (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol);
    }
}

//    private static void playGame(char[][] gameBoard) {

