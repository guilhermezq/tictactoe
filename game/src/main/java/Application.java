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


        playerMove(scanner, board, playerName);

        Random rand = new Random();
        while (true) {
            int computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, computerMove)) {
                break;
            }
        }
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
        System.out.println(playerName + ", what will be Your move (1-9)?");
        int playerInput = scanner.nextInt();
        switch (playerInput) {
            case 1:
                board[0][0] = 'X';
                break;
            case 2:
                board[0][1] = 'X';
                break;
            case 3:
                board[0][2] = 'X';
                break;
            case 4:
                board[1][0] = 'X';
                break;
            case 5:
                board[1][1] = 'X';
                break;
            case 6:
                board[1][2] = 'X';
                break;
            case 7:
                board[2][0] = 'X';
                break;
            case 8:
                board[2][1] = 'X';
                break;
            case 9:
                board[2][2] = 'X';
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
