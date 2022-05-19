package application;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Chip {
    protected boolean isPlaced = false;
    protected boolean isWhite = false;
    private ImageView imageView;

    public void turn() {
        if (isWhite == false) {
            isWhite = true;
            Image blackChip = new Image("C:\\Users\\Chris\\git\\javafx-othello\\JavaFx-Othello\\src\\application\\Black Chip.png");
            imageView =  new ImageView(blackChip);
        }
        else if (isWhite == true) {
            isWhite = false;
            Image whiteChip = new Image("C:\\Users\\Chris\\git\\javafx-othello\\JavaFx-Othello\\src\\application\\White Chip.png");
            imageView =  new ImageView(whiteChip);
        }
    }
    
    public ImageView getImageView() {
    	return imageView;
    }
    public void place(int player) {
        if (player == 1) {
            turn();
        }
        isPlaced = true;
    }
}