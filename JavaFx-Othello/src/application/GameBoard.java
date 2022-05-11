package application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Button;

public class GameBoard {
	private static final int GRID_SIZE = 8;
	private static final int CELL_SIZE = 90;
	private static final int PLAYER_SIZE = 2;
	
	Parent createContent() {
		GridPane root = new GridPane();
		root.setPrefSize(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
		Circle circle = new Circle(90);

		Image blackChip = new Image("C:\\Users\\Chris\\git\\javafx-othello\\JavaFx-Othello\\src\\application\\Black Chip.png");
		BackgroundImage backgroundImageBlack = new BackgroundImage(blackChip, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Image whiteChip = new Image("C:\\Users\\Chris\\git\\javafx-othello\\JavaFx-Othello\\src\\application\\White Chip.png");
		BackgroundImage backgroundImageWhite = new BackgroundImage(whiteChip, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		//Background bGround = new Background(backgroundImageBlack);
		
		root.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		root.setGridLinesVisible(true);
		for (int i = 0; i < 8; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / 8);
            colConst.setHalignment(HPos.CENTER);
            root.getColumnConstraints().add(colConst);

            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / 8);
            rowConst.setValignment(VPos.CENTER);
            root.getRowConstraints().add(rowConst);
        }
		
		root.add(new ImageView(blackChip), 3, 3);
		root.add(new ImageView(blackChip), 4, 4);
		root.add(new ImageView(whiteChip), 3, 4);
		root.add(new ImageView(whiteChip), 4, 3);

		
		
		return root;
	}
	/*
	 * private class Cell extends StackPane { private boolean isFlipped = false;
	 * private Rectangle bg;
	 * 
	 * Cell(int x, int y) { setTranslateX(x * CELL_SIZE); setTranslateY(y *
	 * CELL_SIZE);
	 * 
	 * bg = new Rectangle(CELL_SIZE, CELL_SIZE, Color.GREEN);
	 * bg.setStroke(Color.BLACK);
	 * 
	 * getChildren().add(bg); } }
	 */
}
