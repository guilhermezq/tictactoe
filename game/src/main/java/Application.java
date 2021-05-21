import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        while (true) {

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
                Methods.playerMove(scanner, board, playerName);
                if (Methods.isGameFinished(board)) {
                    break;
                }
                Methods.printBoard(board);
                Methods.computerTurn(board);
                if (Methods.isGameFinished(board)) {
                    break;
                }
            }

            System.out.println("To play again press 1, to EXIT the game press 0!");
            int option;
            option = scanner.nextInt();
            if (option == 0) {
                System.out.println("Thanks for playing, see you later!");
                break;
            }

        }
    }

}