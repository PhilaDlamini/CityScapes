package main;

import city_scapes.Building;
import city_scapes.Mountain;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Screen;
import javafx.stage.Stage;
import themes.*;

/**
 * The cityScape application
 * 
 * @author Phila Dlamini
 *
 */
public class CityScape extends Application {

	// Possible spaces between buildings
	private final int[] spaces = new int[] { 0, 20, 40 };

	// Holds the themes
	private Theme[] themes = new Theme[] { new Bare(), new PartiallyFilled(), new Filled() };

	/**
	 * The entry point of our application
	 */
	@Override
	public void start(Stage primaryStage) {

		// Get the height and width of the screen
		Rectangle2D screen = Screen.getPrimary().getBounds();
		double height = screen.getHeight();
		double width = screen.getWidth();

		// The cityScape
		StackPane stack = new StackPane();
		stack.getChildren().add(Mountain.get(width, height));

		// Add two "layers" of buildings
		for (int x = 0; x < 2; x++) {
			
			//Holds the row of buildings --> the layer
			FlowPane fPane = new FlowPane();
			fPane.setAlignment(Pos.BOTTOM_CENTER);

			for (int i = 0; i < 12; i++) {
				
				//Get each building. If it is at the back (x == 0), make it taller
				VBox building = Building.get(themes[Computations.randomInRange(0, themes.length - 1)],
						x == 0 ? new int[] {20, 40} : new int[] {10, 20});
				
				//If it a building is at the back, have spaces in between buildings 
				building.setPadding(new Insets(0, x == 0 ? spaces[Computations.randomInRange(0, 2)] : 0, 0, 0));
				
				//Add the building to the row and randomize the themes again
				fPane.getChildren().add(building);
				themes[0] = new Bare();
				themes[1] = new PartiallyFilled();
				themes[2] = new Filled();
			}

			stack.getChildren().add(fPane);

		}

		//The sun 
		Node sun = getSun();
		stack.getChildren().add(sun);
		StackPane.setAlignment(sun, Pos.CENTER_RIGHT);
		
		//Show the stage 
		Scene scene = new Scene(stack);
		primaryStage.setTitle("City scape");
		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Returns the sun 
	 * @return the sun
	 */
	public Node getSun() {
		Circle sun = new Circle(25);
		VBox box = new VBox();
		box.setAlignment(Pos.TOP_RIGHT);
		box.setPadding(new Insets(100));
		box.getChildren().add(sun);
		sun.setFill(Color.ORANGE);
		return box;
	}

	/**
	 * The entry point of our program
	 * 
	 * @param args the arguments passed into the program
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

}
