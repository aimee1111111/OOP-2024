package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {

    LifeBoard lifeBoard;

    public void setup() {
        lifeBoard = new LifeBoard(150, 150, this);
        lifeBoard.randomize();
        colorMode(HSB);
    }

    public void settings() {
        size(500, 500);
    }

    public void draw() {
        background(0);
        lifeBoard.update();
        lifeBoard.render();
    }

    public void keyPressed() {
        if (key == ' ') {
            lifeBoard.pauseResume(); // Pause or resume the simulation
        } else if (key == '1') {
            lifeBoard.randomize(); // Randomize the board when '1' is pressed
        } else if (key == '2') {
            lifeBoard.clearBoard(); // Clear the board when '2' is pressed
        } else if (key == '3') {
            drawCrossShape(); // Draw a cross shape when '3' is pressed
        }
    }

    public void mouseDragged() {
        if (mouseX >= 0 && mouseX < width && mouseY >= 0 && mouseY < height) {
            int x = (int)(mouseX / (float)width * lifeBoard.cols);
            int y = (int)(mouseY / (float)height * lifeBoard.rows);
            if (x >= 0 && x < lifeBoard.cols && y >= 0 && y < lifeBoard.rows) {
                lifeBoard.setCell(y, x, true); // Set the cell to be alive when mouse dragged
            }
        }
        lifeBoard.drawAtMousePosition(); // Call drawAtMousePosition method
    }
    
    

    void drawCrossShape() {
        // Draw a cross shape in the center of the board
        int centerX = lifeBoard.cols / 2;
        int centerY = lifeBoard.rows / 2;
        lifeBoard.drawCross(centerX, centerY);
    }

    public static void main(String[] args) {
        PApplet.main("ie.tudublin.Life");
    }
}
