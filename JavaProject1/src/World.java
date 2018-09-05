import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {
	
	Image waterTile;
	Image grassTile;
	private final static String WATER_TILE_PATH = "assets/water.png";
	private final static String GRASS_TILE_PATH = "assets/grass.png";
	
	
	public World() {
		// Perform initialization logic
		try {
			waterTile = new Image(WATER_TILE_PATH);
			grassTile = new Image(GRASS_TILE_PATH);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		/*
		 * create background here
		 * CREATE ALL SPRITES
		 * */
		
	}
	
	
	//Iterate through sprite list for movement updates
	//Then iterate again with another loop for collision updates.
	public void update(Input input, int delta) {
		// Update all of the sprites in the game
		/*
		 * Create a method with a sprite array input to update all vehicles
		 * Create an update method in the player subclass
		 */
	}
	
	
	//Iterate through sprite list to render
	public void render(Graphics g) {
		//Render Tiles in correct position 
		for (int i=0 ; i<7 ; i++) {
			for (int j=0; j<22; j++) {
				waterTile.drawCentered(24 + j*48, 48+i*48);
			}
		} for (int i=0; i<22; i++) {
			grassTile.drawCentered(24 + i*48, 384);
			grassTile.drawCentered(24 + 48*i, 672);
		}
		// Draw all of the sprites in the game
		/*
		 * Create a method to iterate though sprite array of vehicless
		 */
	}
}
