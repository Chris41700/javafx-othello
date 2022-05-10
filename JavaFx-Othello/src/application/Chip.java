package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Chip {
    protected boolean isPlaced = false;
    protected boolean isWhite = false;
    private Circle circle = new Circle(20, 20, 30);

    public void turn() {
        if (isWhite == false) {
            isWhite = true;
            circle.setFill(Color.WHITE);
        }
        else if (isWhite == true) {
            isWhite = false;
            circle.setFill(Color.BLACK);
        }
    }

    public void place(int player) {
        if (player == 1) {
            turn();
        }
        isPlaced = true;
    }

    public Circle getCircle() {
        return circle;
    }
}
