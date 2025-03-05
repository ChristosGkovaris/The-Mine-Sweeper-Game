# The Mine Sweeper Game
Welcome to the "The Mine Sweeper Game" repository, a competitive version of the classic puzzle game implemented in Java. Two players take turns uncovering
cells in a shared minefield, racing to find the most mines. This project was implemented during the second semester, in the course MYY205 of the curriculum
of the University of Ioannina. The final grade of the project is 95 out of 100.



## Instructions
- Objective: Be the player who finds the most mines before all mines are uncovered.
- How to Play: At the start of the game, a grid is generated with hidden mines. Players take turns choosing cells to uncover.
  Each uncovered cell reveals the number of neighboring mines (if no mine is present) and a mine, earning the player a point.
  If a player uncovers an already opened cell, they are prompted to choose again. The game ends when all mines have been found.
- Scoring: Each mine uncovered earns the player one point. The player with the highest score at the end wins the game.
- Special Rules: If all non-mine cells are opened before all mines are found, the game also ends. The game supports user input
  validation to ensure cells are chosen within bounds.



## Implementation Details
- The game is implemented in Java, following object-oriented principles.
- Key Classes: **`Cell`**: Represents a single cell in the minefield, containing information about its coordinates, whether it contains a mine,
  and its neighboring cells. **`MineField`**: Manages the grid, places mines randomly, and handles cell interactions. **`Player`**: Tracks player
  names and scores while managing their moves during the game. **`MineSweeper`**: Controls the flow of the game, alternating turns between players,
  managing game state, and declaring the winner. **`Game`**: Serves as the entry point for the program and sets up the game based on user input.
