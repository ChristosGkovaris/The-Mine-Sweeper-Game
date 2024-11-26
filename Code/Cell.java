import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final int row, column;          // Coordinates of the cell
    private boolean containsMine;           // Indicates if the cell contains a mine
    private boolean isOpen;                 // Indicates if the cell has been opened
    private int mineCount;                  // Number of mines in the neighboring cells
    private final List<Cell> neighbors;     // List of neighboring cells


    // Constructor initializes the cell with its row and column
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.containsMine = false;
        this.isOpen = false;
        this.mineCount = 0;
        this.neighbors = new ArrayList<>();
    }


    // Adds a neighboring cell to this cell and vice versa
    public void addNeighbor(Cell neighbor) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
            neighbor.neighbors.add(this);
        }
    }


    // Adds a mine to this cell and updates neighboring cells' mine counts
    public void addMine() {
        this.containsMine = true;
        for (Cell neighbor : neighbors) {
            if (!neighbor.containsMine) {
                neighbor.mineCount++;
            }
        }
    }


    // Marks the cell as opened
    public void open() {
        this.isOpen = true;
    }


    // Checks if the cell is already opened
    public boolean isOpen() {
        return isOpen;
    }


    // Checks if the cell contains a mine
    public boolean containsMine() {
        return containsMine;
    }

    
    // Returns the string representation of the cell
    @Override
    public String toString() {
        if (!isOpen) {
            return "-"; // Closed cell
        } else if (containsMine) {
            return "*"; // Opened cell with a mine
        } else {
            return String.valueOf(mineCount); // Opened cell with the mine count
        }
    }
}