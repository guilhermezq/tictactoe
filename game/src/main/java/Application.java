import java.util.Random;
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
                playerMove(scanner, board, playerName);
                if (isGameFinished(board)) {
                    break;
                }
                printBoard(board);
                computerTurn(board);
                printBoard(board);
            }
            System.out.println("Do you want to play again? Press 1, otherwise press 0");
            int option;
            option = scanner.nextInt();
            if(option == 0){
                System.out.println("Thanks for playing, see you later!");
                break;
            }

            //scanner.close(); //we will see if it will be needed
        }
    }

    private static boolean isGameFinished(char[][] board) {
        //is there winner; 3 rows, 3 columns, 2 diagonales, so total 8 posibilities

        if (whoHasWon(board, 'X')) {
            printBoard(board);
            System.out.println("Player Wins!");
            return true;
        }
        if (whoHasWon(board, 'O')) {
            printBoard(board);
            System.out.println("Computer Wins!");
            return true;
        }


        //check if the board is full
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }

    private static boolean whoHasWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) || // rows check
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) || //column check
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) || //diagonale check
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) ){
            return true;
        }
        return false;
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) {
                break;
            }//if the computer play is a valid move, it will kick us pit of the loop
        }
        System.out.println("Computer choose - " + computerMove);
        placeMove(board, computerMove, 'O');
        printBoard(board);
    }



    private static boolean isValidMove(char[][] board, String position) {
        if ("1".equals(position)) {
            return (board[0][0] == ' ');//if (board[0][0] == ' '){return true;}else{return false;}
            //if the spot will be blank, it will return true
        } else if ("2".equals(position)) {
            return (board[0][1] == ' ');
        } else if ("3".equals(position)) {
            return (board[0][2] == ' ');
        } else if ("4".equals(position)) {
            return (board[1][0] == ' ');
        } else if ("5".equals(position)) {
            return (board[1][1] == ' ');
        } else if ("6".equals(position)) {
            return (board[1][2] == ' ');
        } else if ("7".equals(position)) {
            return (board[2][0] == ' ');
        } else if ("8".equals(position)) {
            return (board[2][1] == ' ');
        } else if ("9".equals(position)) {
            return (board[2][2] == ' ');
        }
        return false;
    }




    private static void playerMove(Scanner scanner, char[][] board, String playerName) {
        String playerInput; //must be added so it can be used as well outside while loop
        while (true) {
            System.out.println(playerName + ", what will be Your move (1-9)?");
            playerInput = scanner.next();
            if (isValidMove(board, playerInput)){
                break;
            }else{
                System.out.println(playerName + ", Your input " + playerInput + " is not valid move.");
            }
        }
        placeMove(board, Integer.parseInt(playerInput), 'X');
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