package exercises;

import java.awt.Color;
import java.util.Random;
import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/* 
 * Use the Gridworld Reference document in the "doc" directory to complete the following tasks;
 * 
 * 1. Figure out how to get the World to show.
 * 2. Figure out how to add a Bug to the world (clue: you will need the Bug and Location objects)
 * 3. Add another bug at a random location in the world.
 * 4. Change the color of that bug to blue.
 * 5. Make the bug face to the right.
 * 6. Add flowers to the left and right of the bug.
 * 7. Fill the whole world with flowers!
*/

public class Gridworld {

	public static void main(String[] args) {

		ActorWorld world = new ActorWorld();
		Grid<Actor> theGrid = world.getGrid();
		int numRows = theGrid.getNumRows();
		int numCols = theGrid.getNumCols();

		world.show();

		Location location1 = new Location(0, 0);
		Bug bug1 = new Bug();
		world.add(location1, bug1);

		int randomX = new Random().nextInt(numRows);
		int randomY = new Random().nextInt(numCols - 2) + 1;
		Location location2 = new Location(randomX, randomY);
		System.out.println("Coordinates of random location are: " + randomX + " , " + randomY + ".");
		Bug bug2 = new Bug();
		world.add(location2, bug2);

		bug2.setColor(Color.BLUE);

		bug2.turn();
		bug2.turn();

		Location location3 = new Location(randomX, randomY - 1);
		Flower flower1 = new Flower();
		world.add(location3, flower1);

		Location location4 = new Location(randomX, randomY + 1);
		Flower flower2 = new Flower();
		world.add(location4, flower2);

		int occupiedLocations = theGrid.getOccupiedLocations().size();
		int emptyLocations = (numRows * numCols) - occupiedLocations;
		System.out.println("There are: " + emptyLocations + " empty locations left.");

		for (int i = 0; i < emptyLocations; i++) {
			Flower flower3 = new Flower();
			flower3.setColor(Color.WHITE);
			world.add(world.getRandomEmptyLocation(), flower3);
		}
	}
}
