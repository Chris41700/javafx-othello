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

import java.util.HashMap;
import java.util.HashSet;
import java. util. Random;
public class GameBoard implements isLegalMove {
	public HashMap<Button, String> map = new HashMap();
	private static final int GRID_SIZE = 8;
	private static final int CELL_SIZE = 110;
	private static final int PLAYER_SIZE = 2;
	private Button[] buttonArray = new Button[64];
	GridPane root = new GridPane();
	int i = 0;
	Parent createContent() {

		HumanPlayer player = new HumanPlayer(32, "Fabio Pecora", true, 0);
		ComputerPlayer computer = new ComputerPlayer(32, "Richard Weir", false, 0);
		Chip chip = new Chip();
		Random rand = new Random();

		createBoard();
		
		
		//Add a button to each rows and columns
		for (int row = 0; row < GRID_SIZE; row++) {
			for (int col = 0; col < GRID_SIZE; col++) {
				Button button = new Button();
				//Set width and height to fit the cell
				button.setPrefWidth(85);
				button.setPrefHeight(85);
				//Setting the background of the button to green so that they are "invisible"
				button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
				// creating an array with all the buttons
				buttonArray[i] = button;
				i++;
				
				placeDefaultPieces(i);

				//Add a function to the button so it let's the player and the computer place a chip
				button.setOnAction(new EventHandler<ActionEvent>() {
				    @Override
				    public void handle(ActionEvent e) {
				    	// player
				    	
				    	chip.turn();
				    	ImageView blackChipImage = new ImageView();
			    		blackChipImage =  chip.getImageView();
			    		button.setGraphic(blackChipImage);
				    	button.setDisable(true);
				    	button.setOpacity(10);
				    	map.put(button, "black");
				    	
				    	int col = GridPane.getColumnIndex(button);
				    	int row = GridPane.getRowIndex(button);
				    	
				    	
				    	flipChip(indexToNum(col, row));
				    	
				    	player.setMyTurn(false);
				    	computer.setMyTurn(true);
				    	
				    	// turn
				    	chip.turn();
				    	
				    	//computer
				    	
			    		ImageView whiteChipImage = new ImageView();
			    		whiteChipImage =  chip.getImageView();			    		
			    		Button randomButton = new Button(); 		
			    		
			    		//checking if we can place the random button in that position
			    		int n = rand.nextInt(buttonArray.length);
			    		boolean isLegal = isLegal(n);
			    		if (isLegal == false) {
			    			while(isLegal == false) {
				    			n = rand.nextInt(buttonArray.length);
				    			isLegal = isLegal(n);
				    		}
			    		}
			    		
			    		randomButton = buttonArray[n];
			    		randomButton.setGraphic(whiteChipImage);
			    		randomButton.setDisable(true);
			    		randomButton.setOpacity(10);
			    		flipChip(n);
			    		map.put(randomButton, "white");
			    		
			    		
			    		player.setMyTurn(true);
				    	computer.setMyTurn(false);
			
				    	// When all the cells have been used, then close the game
				    	if(map.size() == 64) System.exit(0);
				    }
				});
				
				//Add button to every cell
				root.add(button, row, col);
			}
		}
		return root;
	}
	
	public boolean isLegal(int n) {
		if (!isEmptyPosition(n)) return false;
		if (!isButtonAroundPosition(n)) return false;
		return true;
	}
	
	public boolean isButtonAroundPosition(int n) {

		// directions
		int UP = n - 1;
		int DOWN = n + 1;
		int RIGHT = n + 8;
		int LEFT = n - 8;
		int UP_RIGHT = n + 7;
		int DOWN_RIGHT = n + 9;
		int UP_LEFT = n - 9;
		int DOWN_LEFT = n - 7;
		
		// if there is at least one chip around, we define it as a legal position
		if((isInBound(UP) && map.containsKey(buttonArray[UP])) ||
		   (isInBound(DOWN) && map.containsKey(buttonArray[DOWN])) ||
		   (isInBound(RIGHT) && map.containsKey(buttonArray[RIGHT])) ||
		   (isInBound(LEFT) && map.containsKey(buttonArray[LEFT])) ||
		   (isInBound(UP_RIGHT) && map.containsKey(buttonArray[UP_RIGHT])) ||
		   (isInBound(DOWN_RIGHT) && map.containsKey(buttonArray[DOWN_RIGHT])) ||
		   (isInBound(DOWN_LEFT) && map.containsKey(buttonArray[DOWN_LEFT])) ||
		   (isInBound(UP_LEFT) && map.containsKey(buttonArray[UP_LEFT])) ||
		   (isInBound(UP_RIGHT) && map.containsKey(buttonArray[UP_RIGHT]))) return true;
		
		return false;
	}
	
	public boolean isInBound(int position) {
		if (position < 0 || position >= 64) return false;
		return true;
	}
	
	
	public boolean isEmptyPosition(int n) {
		if(map.containsKey(buttonArray[n])) return false;
		return true;
	}
	
	public int getColumnIndex(int num) {
		int column = (int)num/8;
		return column;
	}
	
	public int getRowIndex(int num) {
		int row = num % 8;
		return row;
	}
	
	public void placeDefaultPieces(int i) {
		// placing the first 4 default chip at the middle of the game board
		if(i == 28) {
			buttonArray[i - 1].setGraphic(new ImageView(new Image("C:\\Users\\Chris\\git\\javafx-othello\\JavaFx-Othello\\src\\application\\Black Chip.png")));
			// add the buttons to the hash set to that we do not place other chip in an already token spot
			map.put(buttonArray[i - 1], "white");
			// disable them because we want a cell to be able to be clicked only if empty
			buttonArray[i - 1].setDisable(true);
			// we don't want the disable to affect out chip color so we set the opacity back to bright
			buttonArray[i - 1].setOpacity(10);
		}
		else if(i == 29) {
			buttonArray[i - 1].setGraphic(new ImageView(new Image("C:\\Users\\Chris\\git\\javafx-othello\\JavaFx-Othello\\src\\application\\White Chip.png")));
			map.put(buttonArray[i - 1], "white");
			buttonArray[i - 1].setDisable(true);
			buttonArray[i - 1].setOpacity(10);
		}
		else if(i == 36) {
			buttonArray[i - 1].setGraphic(new ImageView(new Image("C:\\Users\\Chris\\git\\javafx-othello\\JavaFx-Othello\\src\\application\\White Chip.png")));
			map.put(buttonArray[i - 1], "white");
			buttonArray[i - 1].setDisable(true);
			buttonArray[i - 1].setOpacity(10);
		}
		else if(i == 37){
			buttonArray[i - 1].setGraphic(new ImageView(new Image("C:\\Users\\Chris\\git\\javafx-othello\\JavaFx-Othello\\src\\application\\Black Chip.png")));
			map.put(buttonArray[i - 1], "black");
			buttonArray[i - 1].setDisable(true);
			buttonArray[i - 1].setOpacity(10);
		}
	}
	
	public void createBoard() {
		root.setPrefSize(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
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
	}
	
	public void flipChip(int n) {
		int UP = n - 1;
		int DOWN = n + 1;
		int RIGHT = n + 8;
		int LEFT = n - 8;
		int UP_RIGHT = n + 7;
		int DOWN_RIGHT = n + 9;
		int UP_LEFT = n - 9;
		int DOWN_LEFT = n - 7;
		int var;
		String type;
		int beginnerNum = n;
		int track = 0;
		
		if(map.containsKey(buttonArray[DOWN])) {
			type = map.get(buttonArray[DOWN]);
			
			if(type == "white") {
				while(type == "white") {
					if(map.containsKey(buttonArray[DOWN + 1])) {
						type = map.get(buttonArray[DOWN + 1]);
					}
					flipChip(n);
				}
			}
			else if(type == "black") {
				for(int i = track; i > 0; i--) {
					buttonArray[n--].setGraphic(new ImageView(new Image("C:\\Users\\Chris\\git\\javafx-othello\\JavaFx-Othello\\src\\application\\Black Chip.png")));
				}
			}
		}
	}
	
	public int indexToNum(int col, int row) {
		int num = 8 * col + row;
		return num;
	}
}