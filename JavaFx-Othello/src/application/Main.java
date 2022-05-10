package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.beans.property.BooleanProperty;

public class Main extends Application {
	@Override	
	public void start(Stage primaryStage) {
		try {
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			GameBoard board = new GameBoard();
			
			primaryStage.setTitle("Othello");
			primaryStage.setScene(new Scene(board.createContent()));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
