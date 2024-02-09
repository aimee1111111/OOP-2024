package ie.tudublin;

import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class MultiSensoryFoLoopExperience extends PApplet {

    int mode = 0;

    Minim minim;
    AudioOutput out;
//colours for green lines 
    int[] pic2 = {
            color(0, 0, 0),
            color(0, 25, 10),
            color(0, 51, 18),
            color(0, 76, 27),
            color(0, 100, 36),
            color(0, 125, 45),
            color(0, 153, 52),
            color(0, 182, 63),
            color(0, 204, 72),
            color(0, 320, 95)
    };

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        colorMode(HSB);
    }

    public void draw() {
        background(0);
        noStroke();
        switch (mode) {
            case 0:
                // Draw a square with rainbow colours 
                float squareSize = 800;
                float sectionWidth = squareSize / 10;

                for (int i = 0; i < 10; i++) {
                    float x = i * sectionWidth;
                    float y = 0;

                    // Set the colours 
                    fill(map(i, 0, 10, 0, 200), 255, 255);

                    rect(x, y, sectionWidth, squareSize);
                }
                break;

            case 1: // green shades 
                float segmentWidth2 = (float) width / pic2.length;//call the image colours 
                float blendScale2 = 0.2f;
                for (int i = 0; i < width; i++) {
                    float segmentIndex2 = i / segmentWidth2;
                    int colorIndex3 = min(floor(segmentIndex2), pic2.length - 1);
                    int colorIndex4 = min(ceil(segmentIndex2), pic2.length - 1);
                    float blendFactor2 = segmentIndex2 - colorIndex3;
                    blendFactor2 *= (float) blendScale2;
                    int blendedColor2 = lerpColor(pic2[colorIndex3], pic2[colorIndex4], blendFactor2);
                    stroke(blendedColor2);
                    line(i, 0, i, height);
                }
                break;

            case 2:// diagnol sqaure with big sqaure in the middle 
                int numSquares = 10;
                float squareSize3 = width / numSquares;

                for (int i = 0; i < numSquares; i++) {
                    float x = i * squareSize3;
                    float y = i * squareSize3;

                    // Map to hue color
                    float hue = map(y, 0, height, 0, 255);

                    // Set colour
                    fill(hue, 255, 255);

                    // Draw square
                    rect(x, y, squareSize3, squareSize3);
                }

                for (int i = 0; i < numSquares; i++) {
                    float x = i * squareSize3;
                    float y = (numSquares - i - 1) * squareSize3;

                    // Map to ue colour
                    float hue = map(y, 0, height, 0, 255);

                    // Set colour
                    fill(hue, 255, 255);

                    // Draw square
                    rect(x, y, squareSize3, squareSize3);
                }
                break;

            case 3://  big colourful circle 
                int colorspec = 200;
                for (int i = 0; i < 10; i++) {
                    int x_value = 400;
                    int y_value = 400;
                    fill(colorspec, 255, 255);
                    stroke(colorspec, 255, 255);
                    circle(x_value, y_value, 800 - i * 80);

                    colorspec -= 18;
                }
                break;

            case 4://
                int numCircles2 = 10;
                float d = width / (float) numCircles2;
                for (int j = 0; j < numCircles2; j++) {
                    for (int i = 0; i < numCircles2; i++) {
                        float x = (d * 0.5f) + (d * i);
                        float y = (d * 0.5f) + (d * j);
                        float c = ((i + j) / (numCircles2 * 2.0f)) * 255.0f;
                        fill(c, 255, 255);
                        circle(x, y, d);
                    }
                }
                break;

            case 5:
            
            // Draw a square with 10 vertical sections in a gradient from black to green
            int numSquare = 10;
            float halfWidth = width / (float) numSquare;
            for (int j = 0; j < numSquare; j++) {
                for (int i = 0; i < numSquare; i++) {
                    float x =  (halfWidth * i);
                    float y =  (halfWidth * j);
                    float c = ((i + j) / (numSquare * 2.0f)) * 255.0f;
                    stroke(144);
                    fill(0, 0, 0);
                    rect(x, y, halfWidth, halfWidth);
                }
            }
            break;
     
            

            case 6: // Pentagon
                fill(0); // White fill color
                stroke(255); // Black stroke color
                int numSidesPentagon = 5; // Number of sides in the polygon
                float centerX2 = width / 2; // X-coordinate of the center of the polygon
                float centerY2 = height / 2; // Y-coordinate of the center of the polygon
                float radius2 = 100; // Radius of the polygon

                // Calculate the angle between vertices
                float anglePentagon = TWO_PI / numSidesPentagon;

                // Adjust the initial angle to start from the top vertex and proceed clockwise
                float initialAngle = -HALF_PI;

                // Begin drawing the polygon
                beginShape();
                for (int i = 0; i < numSidesPentagon; i++) {
                    // Calculate the current angle
                    float currentAngle = initialAngle + i * anglePentagon;

                    // Calculate the x and y coordinates of the current vertex using sine and cosine
                    // functions
                    float x = centerX2 + radius2 * cos(currentAngle);
                    float y = centerY2 + radius2 * sin(currentAngle);

                    // Draw a line to the current vertex
                    vertex(x, y);
                }
                endShape(CLOSE); // Close the shape
                break;
                case 7:
                fill(0); // White fill color
                stroke(255); // Black stroke color

                int numSides = 6; // Number of sides in the polygon
                float centerX = width / 2; // X-coordinate of the center of the polygon
                float centerY = height / 2; // Y-coordinate of the center of the polygon
                float radius = 100; // Radius of the polygon

                // Calculate the angle between vertices
                float angle = TWO_PI / numSides;

                // Begin drawing the polygon
                beginShape();
                for (int i = 0; i < numSides; i++) {
                    // Calculate the current angle
                    float currentAngle = i * angle;

                    // Calculate the x and y coordinates of the current vertex using sine and cosine
                    // functions
                    float x = centerX + radius * cos(currentAngle);
                    float y = centerY + radius * sin(currentAngle);

                    // Draw a line to the current vertex
                    vertex(x, y);
                }
                endShape(CLOSE); // Close the shape
                break;

            case 8: // Octagon
                fill(0); // White fill color
                stroke(255); // Black stroke color
                int numSidesOctagon = 8; // Number of sides in the polygon
                float centerX3 = width / 2; // X-coordinate of the center of the polygon
                float centerY3 = height / 2; // Y-coordinate of the center of the polygon
                float radius3 = 100; // Radius of the polygon

                // Calculate the angle between vertices
                float angleOctagon = TWO_PI / numSidesOctagon;

                // Begin drawing the polygon
                beginShape();
                for (int i = 0; i < numSidesOctagon; i++) {
                    // Calculate the current angle
                    float currentAngle = i * angleOctagon;

                    // Calculate the x and y coordinates of the current vertex using sine and cosine
                    // functions
                    float x = centerX3 + radius3 * cos(currentAngle);
                    float y = centerY3 + radius3 * sin(currentAngle);

                    // Draw a line to the current vertex
                    vertex(x, y);
                }
                endShape(CLOSE); // Close the shape
                break;

            default:
                break;
        }
    }

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
    }

    public static void main(String[] args) {
        PApplet.main("ie.tudublin.MultiSensoryFoLoopExperience");
    }
}