package io.RPS;

public class GamePlay {

    public static String determineWinner(String frstInputStr, String scndInputStr){

        int frstInputInt = GamePlay.transformToInt(frstInputStr.toUpperCase());
        int scndInputInt = GamePlay.transformToInt(scndInputStr.toUpperCase());
        return winner(frstInputInt, scndInputInt);

    }

    // Transfroms the inputs rock, paper, scissors from user
    // or the correspoding 0,1 and 2 to int 0, 1 or 2
    public static int transformToInt(String readIn) {
        switch (readIn) {
            case "ROCK":
            case "0":
                return 0;
            case "PAPER":
            case "1":
                return 1;
            case "SCISSORS":
            case "2":
                return 2;
            case "quit":
            case "-1":
                return -1;
            default:
                return -999999;

        }
    }

    public static String winner(int player1, int player2) {
        switch (player1 | (player2 << 4)) {
            case 0:
            case 0x11:
            case 0x22:
                return "Tie";
            case 0x02: // computer:scissors, player:paper
            case 0x10:
            case 0x21:
                return "Second player wins\n";
            case 0x01:
            case 0x12:
            case 0x20:
                return "First player wins\n";
            default:
                return "Invalid choice, try again\n";
        }
    }
}
