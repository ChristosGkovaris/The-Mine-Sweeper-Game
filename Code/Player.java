import java.util.Scanner;

public class Player {
    private final String name; // Name of the player
    private int score; // Number of mines found by the player

    // Constructor initializes the player's name and score
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    // Executes a turn for the player
    public boolean play(MineField mineField, Scanner scanner) {
        System.out.println("Player " + name + ", give the coordinates for the cell to open:");
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        // Retrieve the cell and check if it's already open
        Cell cell = mineField.getCell(row, column);
        while (cell.isOpen()) {
            System.out.println("Cell is already open. Try again:");
            row = scanner.nextInt();
            column = scanner.nextInt();
            cell = mineField.getCell(row, column);
        }

        cell.open();
        if (cell.containsMine()) {
            System.out.println("Mine found!");
            score++;
            return true; // Indicates a mine was found
        }
        return false; // Indicates no mine was found
    }

    // Prints the player's current status
    public void printStatus() {
        System.out.println("Player " + name + ": " + score + " mines found");
    }

    // Returns the player's current score
    public int getScore() {
        return score;
    }
}
