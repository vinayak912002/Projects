import java.util.*;

public class TicTacToe {


    static String[] board;
    static String turn;

    static String checkWinner(){
        for(int i = 0; i < 7; i++){
            String line = null;//this is the line for which we are checking the results
            //here we are iterating over all the possible cases
            switch (i){
                case 0 :
                    line = board[0]+board[1]+board[2];
                    break;
                case 1 :
                    line = board[3]+board[4]+board[5];
                    break;
                case 2 :
                    line = board[6]+board[7]+board[8];
                    break;
                case 3 :
                    line = board[0]+board[3]+board[6];
                    break;
                case 4 :
                    line = board[1]+board[4]+board[7];
                    break;
                case 5 :
                    line = board[2]+board[5]+board[8];
                    break;
                case 6 :
                    line = board[0]+board[4]+board[8];
                    break;
                case 7 :
                    line = board[2]+board[4]+board[6];
                    break;
            }
            //if X is the winner
            if(line.equals("XXX")){
                return "X";
            //if O is the winner
            }else if(line.equals("OOO")){
                return "O";
            }
        }
       //we iterate over the array and check whether all the places are filled or not
        for(int i = 0; i <= 8; i++){
            if(Arrays.asList(board).contains(String.valueOf(i))){
                break;
            }else if(i==8){
                return "draw";
            }
        }
        //To enter the X or O at the exact place on the board
        System.out.println(turn + "'s turn; enter a slot number to place " + turn + "in: ");
        return null; // while there is no winner we will return null
    }

    // To print out the board
    /* |---|---|---|
       | 1 | 2 | 3 |
       | 4 | 5 | 6 |
       | 7 | 8 | 9 |
       |---|---|---|*/
    static void printBoard(){
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] +" |");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] +" |");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] +" |");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for(int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i +1);
        }
        System.out.println("Welcome to the 3X3 Tic-Tac-Toe game");
        printBoard();

        System.out.println("X will play first, Enter a slot number to place X in : ");

        while(winner == null){
            int numInput;

            //Exception handling,
            //numInput will take the input and check whether it is valid or not
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)){
                    System.out.println("Invalid Input; re-enter slot number : ");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid Input; re-enter slot number : ");
                continue;
            }
            //This is two player game
            //deciding the turns
            if(board[numInput - 1].equals(String.valueOf(numInput))){
                board[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();
            }else {
                System.out.println("Slot already taken; re-enter slot number;");
            }
        }
        if (winner.equalsIgnoreCase("draw")){
            System.out.println("The game is a draw");
        }
        else{
            System.out.println("congratulations " + winner + "'s has won the game");
        }
        in.close(); //we want the scanner object to be closed at the end
    }
}