package main;

/**
 * Performs mathematical computations for our program 
 * @author Phila Dlamini
 *
 */
public interface Computations {

	/**
	 * Returns a random number within the given range
	 * @param min 		the lowest possible value returned
	 * @param max		the highest possible value to be returned
	 * @return	a random number within the given range
	 */
	public static int randomInRange(int min, int max) {
		return (int) (Math.random() * (max - min) + min + 0.5);
	}
}
