import java.util.Random;

public class MineField {
    private final int size; // Size of the grid
    private final int mineCount; // Total number of mines in the field
    private final Cell[][] field; // 2D array representing the field of cells

    // Constructor initializes the field with the given size and mine count
    public MineField(int size, int mineCount) {
        this.size = size;
        this.mineCount = mineCount;
        this.field = new Cell[size][size];
        initializeCells(); // Initialize all cells and their neighbors
        initializeMines(); // Place mines randomly
    }

    // Initializes the cells and sets their neighbors
    private void initializeCells() {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                field[row][column] = new Cell(row, column);
            }
        }
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                for (int r = Math.max(0, row - 1); r <= Math.min(size - 1, row + 1); r++) {
                    for (int c = Math.max(0, column - 1); c <= Math.min(size - 1, column + 1); c++) {
                        if (!(r == row && c == column)) {
                            field[row][column].addNeighbor(field[r][c]);
                        }
                    }
                }
            }
        }
    }

    // Places mines randomly in the field
    private void initializeMines() {
        Random random = new Random(2023); // Random seed for consistent results
        int placedMines = 0;
        while (placedMines < mineCount) {
            int row = random.nextInt(size);
            int column = random.nextInt(size);
            if (!field[row][column].containsMine()) {
                field[row][column].addMine();
                placedMines++;
            }
        }
    }

    // Retrieves a cell at the specified coordinates
    public Cell getCell(int row, int column) {
        return field[row][column];
    }

    // Prints the entire field
    public void print() {
        System.out.print("\t");
        for (int i = 0; i < size; i++) {
            System.out.print(i + "  "); // Column headers
        }
        System.out.println();
        for (int row = 0; row < size; row++) {
            System.out.print(row + "\t"); // Row headers
            for (int column = 0; column < size; column++) {
                System.out.print(field[row][column] + "  "); // Cell content
            }
            System.out.println();
        }
    }
}
