e.ImageView;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Direction{
    private ImageView imageView;
    protected boolean isWhite = false;
    Chip chip = new Chip();
	HumanPlayer player = new HumanPlayer(32, "Fabio Pecora", true, 0);
	ComputerPlayer computer = new ComputerPlayer(32, "Richard Weir", false, 0);
	private enum isValid { UP, UP_RIGHT, RIGHT, DOWN_RIGHT, DOWN, DOWN_LEFT, LEFT, UP_LEFT };
	

}
