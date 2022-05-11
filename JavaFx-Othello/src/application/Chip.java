package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Chip {
    protected boolean isPlaced = false;
    protected boolean isWhite = false;

    public void turn() {
        if (isWhite == false) {
            isWhite = true;
            //White Circle was set here
        }
        else if (isWhite == true) {
            isWhite = false;
            //Black Circle was set here
        }
    }

    public void place(int player) {
        if (player == 1) {
            turn();
        }
        isPlaced = true;
    }
//
//    public Circle getCircle() {
//    	//Returning the circle here
//    }
}
