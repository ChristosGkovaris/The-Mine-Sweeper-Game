import java.util.Scanner;

public class MineSweeper {
    private final MineField mineField; // The minefield for the game
    private final Player player1;      // First player
    private final Player player2;      // Second player
    private int remainingMines;        // Number of mines left to be found

    // Constructor initializes the minefield and players
    public MineSweeper(int size, int mineCount, String player1Name, String player2Name) {
        this.mineField = new MineField(size, mineCount);
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.remainingMines = mineCount;
    }

    // Method to start and control the gameplay
    public void play() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Start with the first player
            Player currentPlayer = player1; 
            while (remainingMines > 0) {
                mineField.print();
                System.out.println(remainingMines + " mines left");
                player1.printStatus();
                player2.printStatus();

                if (currentPlayer.play(mineField, scanner)) {
                    // Decrease remaining mines if a mine is found
                    remainingMines--; 
                }
                // Switch player
                currentPlayer = (currentPlayer == player1) ? player2 : player1; 
            }
            declareWinner();
        }
    }

    // Method to declare the winner based on scores
    private void declareWinner() {
        System.out.println("Game Over!");
        player1.printStatus();
        player2.printStatus();
        if (player1.getScore() > player2.getScore()) {
            System.out.println("Winner: " + player1);
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println("Winner: " + player2);
        } else {
            System.out.println("It's a tie!");
        }
    }
}
