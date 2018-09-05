import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import java.util.ArrayList;


public class World {
	
	Image waterTile;
	Image grassTile;
	private final static String WATER_TILE_PATH = "assets/water.png";
	private final static String GRASS_TILE_PATH = "assets/grass.png";
	private ArrayList<Sprite> sprites = new ArrayList<>();
	
	
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
		sprites.add(new Player());
		for (int i=0; i<4; i++) {
			sprites.add(new Vehicle(48+i*312, 432));
		} for (int i=0; i<5; i++) {
			sprites.add(new Vehicle(i*240, 480));
		} sprites.add(new Vehicle(64, 528));
		sprites.add(new Vehicle(640, 528));
		for (int i=0; i<5; i++) {
			sprites.add(new Vehicle(128 + 240*i, 576));
		} for (int i=0; i<4; i++) {
			sprites.add(new Vehicle(250 + i*312, 624));
		}
		
		
	}
	
	
	//Iterate through sprite list for movement updates
	//Then iterate again with another loop for collision updates.
	public void update(Input input, int delta) {
		// Update all of the sprites in the game
		for(Sprite i: sprites) {
			i.update(input, delta);
		}
		for (int i=1; i<sprites.size(); i++) {
			if (sprites.get(0).intersects(sprites.get(i))) {
				System.exit(0);
			}
		}
		/*
		 * Create a method with a sprite array input to update all vehicles
		 * Create an update method in the player subclass
		 */
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			System.exit(0);
		}
		
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
		for(Sprite i: sprites) {
			i.render();
		}
	}
}
