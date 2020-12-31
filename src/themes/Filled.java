package themes;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import main.Computations;

/**
 * A bare building 
 * @author Phila Dlamini
 *
 */
public class Filled implements Theme {
	
	//The radius of the building
	private int cornerRadii;
	
	//The building color
	private Color buildingColor;
	
	//The roof color
	private Color roofColor;
	
	/**
	 * Constructs the Bare theme
	 */
	public Filled() {
		this.cornerRadii = Computations.randomInRange(2, 6);
		this.roofColor = Theme.getColors()[Computations.randomInRange(0, Theme.getColors().length - 1)];
		this.buildingColor = Theme.getColors()[Computations.randomInRange(0, Theme.getColors().length - 1)];

	}

	/**
	 * Returns the windows stroke color
	 * @return the windows stroke color
	 */
	@Override
	public Paint getWindowStroke() {
		return Color.WHITE;
	}

	/**
	 * Returns the background of the windows
	 * @return the background of the windows
	 */
	@Override
	public Paint getWindowColor() {
		return Color.WHITE;
	}

	/**
	 * Returns the radius of the window (to make it have rounded corners)
	 * @return the radius of the window
	 */
	@Override
	public double getWindowRadius() {
		return 3;
	}

	/**
	 * Returns the building border
	 * Returns the building border
	 * @return
	 */
	@Override
	public Border getBuildingBorder() {
		return new Border(new BorderStroke(buildingColor,
				BorderStrokeStyle.SOLID, 
				new CornerRadii(cornerRadii), 
				new BorderWidths(3)));
	}

	/**
	 * Returns the background of the building 
	 * @return the background of the building
	 */
	@Override
	public Background getBuildingBackground() {
		return new Background(new BackgroundFill(buildingColor, new CornerRadii(cornerRadii), Insets.EMPTY));
	}

	/**
	 * Returns the color of the roof
	 * @return the color of the roof
	 */
	@Override
	public Paint getRoofColor() {
		return roofColor;
	}
	
	/**
	 * Returns the stroke color of the roof
	 * @return the stroke color of the roof
	 */
	@Override
	public Paint getRoofStroke() {
		return roofColor;
	}

}
