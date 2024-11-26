import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Give the board size:");
            int size = scanner.nextInt();

            System.out.println("Give the number of mines:");
            int mineCount = scanner.nextInt();

            System.out.println("Give the names of the players:");
            String player1Name = scanner.next();
            String player2Name = scanner.next();

            MineSweeper game = new MineSweeper(size, mineCount, player1Name, player2Name);
            game.play();
        }
    }
}
