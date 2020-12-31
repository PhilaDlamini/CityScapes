package city_scapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import main.Computations;

/** 
 * @author Phila Dlamini
 * The mountain in the background
 *
 */
public class Mountain {
	
	/**
	 * Constructs the mountain in the background 
	 */
	public static Node get(double width, double height) {
		
		VBox box = new VBox();
		box.setAlignment(Pos.BOTTOM_CENTER);
		Rectangle base = new Rectangle(width, 150);
		base.setFill(Color.PALEGOLDENROD);
		box.getChildren().add(base);
		return box;
		
		//Fix the rest of the mountain? Might not be the most worth thing
	}
}
