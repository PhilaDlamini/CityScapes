package city_scapes;

import java.util.Random;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import main.Computations;
import themes.Theme;

/**
 * A building 
 * @author Phila Dlamini
 *
 */
public class Building {
	
	//Randomizes the building 
	private static Random random = new Random();
	
	//How the building should look like 
	private static Theme theme;
	
	//The length of the windows
	private static int windowLength = 5;
	
	/**
	 * Builds and returns the building 
	 * @param theme
	 * @return
	 */
	public static VBox get(Theme theme, int[] heightRange) {
		Building.theme = theme;
		
		//The FlowPane that contains the building 
		VBox pane = new VBox(0);
		
		//Create the windows randomly
		int cols = Computations.randomInRange(3, 12);
		int rows = Computations.randomInRange(heightRange[0], heightRange[1]);
		GridPane gridPane = new GridPane();
		gridPane.setVgap(2);
		gridPane.setHgap(2);
		gridPane.setPadding(new Insets(5));
		
		for(int x = 0; x < cols; x++) {
			for(int y = 0; y < rows; y++) {
				Rectangle window = new Rectangle(getWindowLength(), getWindowLength());
				window.setFill(theme.getWindowColor());
				window.setArcHeight(theme.getWindowRadius());
				window.setArcWidth(theme.getWindowRadius());
				window.setStroke(theme.getWindowStroke());
				gridPane.add(window, x, y);
			}
		}
		
		//Apply the coloring on the building
		gridPane.setBackground(theme.getBuildingBackground());
		gridPane.setBorder(theme.getBuildingBorder());
		
		//Return the building
		double width = cols * getWindowLength() + 10;

		if(rows > 20) pane.getChildren().add(new Group(getRoof(width)));
		pane.getChildren().add(gridPane);
		pane.setAlignment(Pos.BOTTOM_CENTER);
		return pane;
	}
	
	/**
	 * Returns the roof
	 * @param width	the width of the roof 
	 * @return the width of the roof
	 */
	private static Shape getRoof(double width) {
		Shape[] roofs =  new Shape[] {getArcRoof(width), getTriangleRoof(width)};
		return roofs[Computations.randomInRange(0, roofs.length - 1)];
	}
	
	/**
	 * Returns a dome roof
	 * @return a dome roof
	 */
	private static Arc getArcRoof(double width) {
		Arc arc = new Arc();
		arc.setStroke(theme.getRoofStroke());
		arc.setStrokeWidth(4);
		arc.setFill(theme.getRoofColor());
		arc.setStartAngle(0);
		arc.setLength(180);
		arc.setType(ArcType.ROUND);
		arc.setRadiusX((width / 2) + 10);
		arc.setRadiusY((width / 2) + 10);
		return arc;
	}
	
	/**
	 * Returns a triangle roof
	 * @return a triangle roof
	 */
	private static Polygon getTriangleRoof(double width) {
		Polygon polygon = new Polygon(0, 0, width / 2, width / 3, width, 0);
		polygon.setRotate(180);
		polygon.setStroke(theme.getRoofStroke());
		polygon.setStrokeWidth(4);
		polygon.setFill(theme.getRoofColor());
		return polygon;
	}
	
	/**
	 * Sets the length of the windows
	 * @param length
	 */
	public static void setWindowLength(int length) {
		Building.windowLength = length;
	}
	
	/**
	 * Returns the length of the windows
	 * @return the length of the windows
	 */
	private static int getWindowLength() {
		return Building.windowLength;
	}
}
