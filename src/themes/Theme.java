package themes;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Defines what a building looks likes
 * @author Phila Dlamini
 *
 */
public interface Theme {

	/**
	 * Returns all the colors used for buildings
	 * @return
	 */
	static Color[] getColors() {
		return new Color[] {
				Color.GREEN,
				Color.ROYALBLUE, 
				Color.GAINSBORO, 
				Color.RED, 
				Color.GRAY, 
				Color.TAN, 
				Color.STEELBLUE, 
				Color.LIGHTSEAGREEN, 
				Color.BLACK	
		};
	}
	/**
	 * Returns the windows stroke color
	 * @return the windows stroke color
	 */
	Paint getWindowStroke();
	
	/**
	 * Returns the background of the windows
	 * @return the background of the windows
	 */
	Paint getWindowColor();
	
	/**
	 * Returns the radius of the window (to make it have rounded corners)
	 * @return the radius of the window
	 */
	double getWindowRadius();
	
	/**
	 * Returns the building border
	 * Returns the building border
	 * @return
	 */
	Border getBuildingBorder();
	
	/**
	 * Returns the background of the building 
	 * @return the background of the building
	 */
	Background getBuildingBackground();
	
	/**
	 * Returns the color of the roof
	 * @return the color of the roof
	 */
	Paint getRoofColor();
	
	/**
	 * Returns the stroke color of the roof
	 * @return the stroke color of the roof
	 */
	Paint getRoofStroke();
}
