package ie.tudublin;

import processing.core.PApplet;

public class MultiSensoryFoLoopExperience extends PApplet {

    int mode = 0;

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        colorMode(HSB);
        background(255); // Set background to black
        strokeWeight(100); // Set the thickness of the lines
    }

    public void draw() {
        // Display instructions to the user
        textSize(20);
        fill(0);
        text("Press 1, 2, 3 4 5 or 6 to choose a picture:", 50, 50);

        switch (mode) {
            case 1:
                draw1();
                break;
            case 2:
                draw2();
                break;
            case 3:
                draw3();
                break;
            case 4:
                draw4();
                break;
            case 5:
                draw5();
                break;

            
            default:
                // Handle invalid mode
                break;
        }
    }

    public void keyPressed() {
        if (key == '1') {
            mode = 1;
        } else if (key == '2') {
            mode = 2;
        } else if (key == '3') {
            mode = 3;
        }else if (key == '4') {
            mode = 4;}
        else if (key == '5') {
            mode = 5;}
        
    }

    // Picture 1: Vertical lines with varying hue
    public void draw1() {
        int numLines = 8;
        float lineWidth = width / (float) numLines;

        for (int i = 0; i < numLines; i++) {
            float x = i * lineWidth;
            float hue = map(i, 0, numLines, 0, 255);
            stroke(hue, 255, 255);
            line(x, 0, x, height);
        }
    }

    // Picture 2: Vertical lines with varying brightness
    public void draw2() {
        int numLines = 8;
        float lineWidth = width / (float) numLines;

        for (int i = 0; i < numLines; i++) {
            float x = i * lineWidth;
            float brightness = map(i, 0, numLines, 20, 200); // Adjust brightness from dark to light
            stroke(100, 255, brightness); // Set hue to green (100), saturation to maximum (255), and vary brightness
            line(x, 0, x, height);
        }
    }

    // Picture 3: Diagonal squares with a big square in the middle
    public void draw3() {
        float squareSize = width / 40; // Size of the squares
        float halfSize = squareSize / 4; // Half size of the squares

        // Draw colorful squares diagonally forming an X shape
        for (int x = 0; x < width; x += squareSize) {
            for (int y = 0; y < height; y += squareSize) {
                // Calculate hue based on position
                float hue = map(x + y, 0, width + height, 0, 255);
                // Set square color
                fill(hue, 255, 255);
                // Draw squares diagonally forming an X
                if (x == y || x + y == width) {
                    rect(x, y, squareSize, squareSize);
                }
            }
        }

        // Draw a big square in the middle
        float bigSquareSize = width / 2;
        float bigSquareX = (width - bigSquareSize) / 2;
        float bigSquareY = (height - bigSquareSize) / 2;
        fill(125, 255, 255); // Green-blue color
        rect(bigSquareX, bigSquareY, bigSquareSize, bigSquareSize);
    }





    public void draw4() {
        colorMode(HSB, 360, 100, 100); // Set color mode to HSB (hue, saturation, brightness)
        noStroke(); // Disable outline for circles
        smooth(); // Enable anti-aliasing

        // Calculate the radius of the circles
        float circleRadius = 30;

        // Define the number of circles to cover the window
        int numCirclesX = width / (int) (circleRadius * 2);
        int numCirclesY = height / (int) (circleRadius * 2);

        // Loop to draw circles across the width and height of the window
        for (int i = 0; i < numCirclesX; i++) {
            for (int j = 0; j < numCirclesY; j++) {
                // Calculate the position of the circle
                float x = i * (circleRadius * 2) + circleRadius;
                float y = j * (circleRadius * 2) + circleRadius;

                // Set hue based on the circle's position and row index
                float hue = map(x, 0, width, 0, 360); // Map hue based on x-position
                float saturation = 100;
                float brightness = 100;

                // If it's the second row, set saturation and brightness to 0 to make it white
                if (j == 1) {
                    saturation = 0;
                    brightness = 100;
                }

                // Set fill color using HSB color mode
                fill(hue, saturation, brightness);

                // Draw the circle
                ellipse(x, y, circleRadius * 2, circleRadius * 2);
            }
        }
    }

    public void draw5() {
        colorMode(HSB, 360, 100, 100); // Set color mode to HSB (hue, saturation, brightness)
        smooth(); // Enable anti-aliasing
    
        // Calculate the side length of the squares
        float squareSize = 60;
    
        // Define the number of squares to cover the window
        int numSquaresX = width / (int) squareSize;
        int numSquaresY = height / (int) squareSize;
    
        // Loop to draw squares across the width and height of the window
        for (int i = 0; i < numSquaresX; i++) {
            for (int j = 0; j < numSquaresY; j++) {
                // Calculate the position of the square
                float x = i * squareSize;
                float y = j * squareSize;
    
                // Set hue based on the square's position and column index
                float hue = map(x, 0, width, 0, 360); // Map hue based on x-position
                float saturation = 100;
                float brightness = 100;
    
                // If it's the second row, set saturation to 0 to make it white
                if (j == 1) {
                    saturation = 0;
                }
    
                // Set fill and stroke color using HSB color mode
                fill(hue, saturation, brightness);
                stroke(0); // Set stroke color to black
    
                // Draw the square
                rect(x, y, squareSize, squareSize);
            }
        }
    }


  

    

         


    public static void main(String[] args) {
        PApplet.main("ie.tudublin.MultiSensoryFoLoopExperience");
    }
}