package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {

    boolean[][] board;
    boolean[][] next;

    int rows;
    int cols;

    float cellWidth;
    float cellHeight;
    PApplet p;

    boolean isPaused;

    public LifeBoard(int rows, int cols, PApplet p) {
        this.rows = rows;
        this.cols = cols;
        this.p = p;
        board = new boolean[rows][cols];
        next = new boolean[rows][cols]; // Initialize next array
        cellWidth = p.width / (float) cols;
        cellHeight = p.height / (float) rows;
        isPaused = false;
    }

    void randomize() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                float dice = p.random(1.0f);
                board[row][col] = (dice < 0.5f);
            }
        }
    }

    void clearBoard() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = false;
            }
        }
    }

    void pauseResume() {
        isPaused = !isPaused;
    }

    void drawCross(int x, int y) {
        board[y][x] = true;
        board[y + 1][x] = true;
        board[y - 1][x] = true;
        board[y][x + 1] = true;
        board[y][x - 1] = true;
    }

    void drawGlider(int x, int y) {
        board[y][x] = true;
        board[y + 1][x] = true;
        board[y + 2][x] = true;
        board[y + 2][x - 1] = true;
        board[y + 1][x - 2] = true;
    }

    void drawGosperGun(int x, int y) {
        int[][] gunPattern = {
            {0, 4}, {0, 5}, {1, 4}, {1, 5},
            {10, 4}, {10, 5}, {10, 6}, {11, 3}, {11, 7}, {12, 2}, {12, 8},
            {13, 2}, {13, 8}, {14, 5}, {15, 3}, {15, 7}, {16, 4}, {16, 5}, {16, 6},
            {17, 5}, {20, 2}, {20, 3}, {20, 4}, {21, 2}, {21, 3}, {21, 4}, {22, 1},
            {22, 5}, {24, 0}, {24, 1}, {24, 5}, {24, 6},
            {34, 2}, {34, 3}, {35, 2}, {35, 3}
        };

        for (int[] point : gunPattern) {
            board[y + point[1]][x + point[0]] = true;
        }
    }

    public void update() {
        if (!isPaused) {
            // Write a nested for loop to update the board each frame
            // Read board, write to next

            // Nested loop to iterate over each cell
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    // Count live neighbors for current cell
                    int liveNeighbors = countLiveNeighbors(row, col);

                    // Apply rules of Conway's Game of Life
                    if (board[row][col]) {
                        // Cell is alive
                        if (liveNeighbors < 2 || liveNeighbors > 3) {
                            // Cell dies due to underpopulation or overpopulation
                            next[row][col] = false;
                        } else {
                            // Cell survives
                            next[row][col] = true;
                        }
                    } else {
                        // Cell is dead
                        if (liveNeighbors == 3) {
                            // Cell becomes alive due to reproduction
                            next[row][col] = true;
                        } else {
                            // Cell remains dead
                            next[row][col] = false;
                        }
                    }
                }
            }

            // Swap board and next arrays
            boolean[][] temp = board;
            board = next;
            next = temp;
        }
    }

    public int countLiveNeighbors(int row, int col) {
        int liveNeighbors = 0;
        // Iterate over neighboring cells
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Skip the cell itself
                if (i == 0 && j == 0) {
                    continue;
                }
                int neighborRow = row + i;
                int neighborCol = col + j;
                // Check if neighbor cell is within bounds and alive
                if (neighborRow >= 0 && neighborRow < rows && neighborCol >= 0 && neighborCol < cols) {
                    if (board[neighborRow][neighborCol]) {
                        liveNeighbors++;
                    }
                }
            }
        }
        return liveNeighbors;
    }

    public void setCell(int row, int col, boolean value) {
        if (row >= 0 && col >= 0 && row < rows && col < cols) {
            board[row][col] = value;
        }
    }

    public boolean getCell(int row, int col) {
        if (row >= 0 && col >= 0 && row < rows && col < cols) {
            return board[row][col];
        }
        return false;
    }

    public void render() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                float x = p.map(col, 0, cols, 0, p.width);
                float y = row * cellHeight;
                p.stroke(0);
                if (board[row][col]) {
                    p.fill(255);
                } else {
                    p.noFill();
                }
                p.rect(x, y, cellWidth, cellHeight);
            }
        }
    }
    
    public void drawAtMousePosition() {
        int x = (int)(p.mouseX / cellWidth);
        int y = (int)(p.mouseY / cellHeight);
        
        // Draw a cross
        drawCross(x, y);
        
    }
}
