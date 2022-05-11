package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Button;

public class GameBoard implements isIllegalMove {
	private static final int GRID_SIZE = 8;
	private static final int CELL_SIZE = 110;
	private static final int PLAYER_SIZE = 2;
	private boolean whiteTurn = false;				// to check the turn
	
	Parent createContent() {
		GridPane root = new GridPane();
		root.setPrefSize(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
		HumanPlayer player = new HumanPlayer(32, "Fabio Pecora", true, 0);
		ComputerPlayer computer = new ComputerPlayer(32, "Richard Weir", false, 0);

		//Add Black and White Chip images
		Image blackChip = new Image("C:\\Users\\Chris\\git\\javafx-othello\\JavaFx-Othello\\src\\application\\Black Chip.png");
        Image whiteChip = new Image("C:\\Users\\Chris\\git\\javafx-othello\\JavaFx-Othello\\src\\application\\White Chip.png");
	
		//Creates the background
		root.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		root.setGridLinesVisible(true);
		
		//Creates rows and columns on the board
		for (int i = 0; i < GRID_SIZE; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / 8);
            colConst.setHalignment(HPos.CENTER);
            root.getColumnConstraints().add(colConst);

            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / 8);
            rowConst.setValignment(VPos.CENTER);
            root.getRowConstraints().add(rowConst);
        }
		
		//Add a button to each rows and columns
		for (int row = 0; row < GRID_SIZE; row++) {
			for (int col = 0; col < GRID_SIZE; col++) {
				Button button = new Button();
				
				//Set width and height to fit the cell
				button.setPrefWidth(85);
				button.setPrefHeight(85);
				
				//Check the position if there is a circle cause we don't want a button there
				
				//Setting the background of the button to green so that they are "invisible"
				button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			
				//Add a function to the button so it let's the user place a chip
				button.setOnAction(new EventHandler<ActionEvent>() {
				    @Override
				    public void handle(ActionEvent e) {
				    	//Want to find the position of the button and add the image of that position
				    	//Check the color of the image that we should put
				    	if(whiteTurn == false) {
				    		ImageView black = new ImageView(blackChip);
				    		button.setGraphic(black);
				    		whiteTurn = true;
				    	}
				    	else {
				    		button.setGraphic(new ImageView(whiteChip));
				    		whiteTurn = false;
				    	}
				    	// we don't want this button to work again because every spot can be hit only once
				    	button.setDisable(true);
				    	
				    	// but we don't want the color of the button to change so we set the opacity
				    	button.setOpacity(10);
				    }
				});
				//Add button to every cell
				root.add(button, row, col);
			
			}
		}
		
		//Starting pieces on the board
		root.add(new ImageView(blackChip), 3, 3);
		root.add(new ImageView(blackChip), 4, 4);
		root.add(new ImageView(whiteChip), 3, 4);
		root.add(new ImageView(whiteChip), 4, 3);
		
		return root;
	}
	
	public boolean isIllegal(int posX, int posY) {
		return true;
	}
}