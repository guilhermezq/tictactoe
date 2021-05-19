import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        System.out.println("Welcome to Tic-Tac-Toe-made-by-Latvian-Girls!");
        System.out.println();

        System.out.println("Please take a note of the game positions.");
        System.out.println();

        System.out.println("1" + "|" + "2" + "|" + "3");
        System.out.println("-+-+-");
        System.out.println("4" + "|" + "5" + "|" + "6");
        System.out.println("-+-+-");
        System.out.println("7" + "|" + "8" + "|" + "9");
        System.out.println();

        System.out.println("Enter Your name, please!");
        String playerName = scanner.next();

        while (true) {
            playerMove(scanner, board, playerName);
            isGameFinished(board);
            printBoard(board);
            computerTurn(board);
        }
    }

    private static boolean isGameFinished(char[][] board) {
        if (isWinner(board, 'X')) {
            printBoard(board);
            System.out.println("Player wins!");
            return true;
        }

        if (isWinner(board, 'O')) {
            printBoard(board);
            System.out.println("Computer wins!");
            return true;
        }
        //check if the board is full
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }

    private static boolean isWinner(char[][] board, char symbol) {
        return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) || // rows check
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) || //column check
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) || //diagonale check
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, computerMove)) {
                break;
            }
        }
        System.out.println("Computer move: " + computerMove);
        placeMove(board, computerMove, 'O');
        printBoard(board);
    }


    private static boolean isValidMove(char[][] board, int position) {
        switch (position) {
            case 1:
                return (board[0][0] == ' ');
            case 2:
                return (board[0][1] == ' ');
            case 3:
                return (board[0][2] == ' ');
            case 4:
                return (board[1][0] == ' ');
            case 5:
                return (board[1][1] == ' ');
            case 6:
                return (board[1][2] == ' ');
            case 7:
                return (board[2][0] == ' ');
            case 8:
                return (board[2][1] == ' ');
            case 9:
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }


    private static void playerMove(Scanner scanner, char[][] board, String playerName) {
        int playerInput;
        while (true) {
            System.out.println(playerName + ", what will be Your move (1-9)?");
            playerInput = scanner.nextInt();
            if (isValidMove(board, playerInput)) {
                break;
            } else {
                System.out.println("Your input " + playerInput + " is not valid.");
            }
        }
        placeMove(board, playerInput, 'X');

    }


    private static void placeMove(char[][] board, int position, char symbol) {
        switch (position) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Invalid input!");

        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

}
