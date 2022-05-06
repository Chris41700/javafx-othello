package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.beans.property.BooleanProperty;

public class Main extends Application {
	
	private static final int GRID_SIZE = 8;
	private static final int CELL_SIZE = 90;
	
	@Override	
	public void start(Stage primaryStage) {
		try {
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			primaryStage.setTitle("Othello");
			primaryStage.setScene(new Scene(createContent()));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Parent createContent() {
		GridPane root = new GridPane();
		root.setPrefSize(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
		
		for (int row = 0; row < GRID_SIZE; row++) {
			for (int col = 0; col < GRID_SIZE; col++) {
				Cell cell = new Cell(row, col);
				
				root.getChildren().add(cell);
			}
		}
		return root;
	}
	
	private static class Cell extends StackPane {
		private boolean isFlipped = false;
		private Rectangle bg;
		
		Cell(int x, int y) {
			setTranslateX(x * CELL_SIZE);
			setTranslateY(y * CELL_SIZE);
			
			bg = new Rectangle(CELL_SIZE, CELL_SIZE, Color.GREEN);
			bg.setStroke(Color.BLACK);
			
			getChildren().add(bg);
		}
		
		void flip() {
			isFlipped = !isFlipped;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
