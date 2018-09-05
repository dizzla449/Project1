import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import java.util.ArrayList;


public class World {
	/*
	 * CONSTANTS DEFINED BELOW \/ \/ \/ \/
	 */
	private final static String WATER_TILE_PATH = "assets/water.png";
	private final static String GRASS_TILE_PATH = "assets/grass.png";
	private final static float OFFSET_1 = 48f;
	private final static float OFFSET_2 = 0f;
	private final static float OFFSET_3 = 64f;
	private final static float OFFSET_4 = 128f;
	private final static float OFFSET_5 = 250f;
	private final static float SEPERATION1 = 6.5f*48;
	private final static float SEPERATION2 = 5f*48;
	private final static float SEPERATION3 = 12f*48;
	private final static float SEPERATION4 = 5f*48;
	private final static float SEPERATION5 = 6.5f*48;
	private final static float BUS_Y_LOCATION1 = 432f;
	private final static float BUS_Y_LOCATION2 = 480f;
	private final static float BUS_Y_LOCATION3 = 528f;
	private final static float BUS_Y_LOCATION4 = 576f;
	private final static float BUS_Y_LOCATION5 = 624f;
	
	//Other Instance Variables also initialized 
	Image waterTile;
	Image grassTile;
	private ArrayList<Sprite> sprites = new ArrayList<>();
	
	
	public World() {
		// Perform initialization logic
		//Background Initialized below
		try {
			waterTile = new Image(WATER_TILE_PATH);
			grassTile = new Image(GRASS_TILE_PATH);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		/*
		 * ALL SPRITES INITIALISED BELOW \/ \/ \/ \/ \/ \/ \/
		 */
		// Add Player Sprite first in ArrayList
		sprites.add(new Player());
		
		
		//Add all 20 Vehicle Sprites to ArrayList
		for (int i=0; i<4; i++) {
			sprites.add(new Vehicle(OFFSET_1 + SEPERATION1*i, BUS_Y_LOCATION1));
		} 
		for (int i=0; i<5; i++) {
			sprites.add(new Vehicle(OFFSET_2+i*SEPERATION2, BUS_Y_LOCATION2));
		} 
		
		sprites.add(new Vehicle(OFFSET_3, BUS_Y_LOCATION3));
		sprites.add(new Vehicle(OFFSET_3 + SEPERATION3, BUS_Y_LOCATION3));
		
		for (int i=0; i<5; i++) {
			sprites.add(new Vehicle(OFFSET_4 + SEPERATION4*i, BUS_Y_LOCATION4));
		} 
		for (int i=0; i<4; i++) {
			sprites.add(new Vehicle(OFFSET_5 + i*SEPERATION5, BUS_Y_LOCATION5));
		}		
	}
	
	
	//Need to update sprites ArrayList for movement and also check for collisions.
	public void update(Input input, int delta) {
		// Update all sprites movement.
		for(Sprite i: sprites) {
			i.update(input, delta);
		}
		
		//Check player (first element) has collided with any other sprites(vehicles), and if so exit App.
		for (int i=1; i<sprites.size(); i++) {
			if (sprites.get(0).contactSprite(sprites.get(i))) {
				System.exit(0);
			}
		}
		//Quick escape enabled by with ESCAPE Key
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			System.exit(0);
		}
	}
	
	
	//Iterate through sprite list to render each sprites updated coordinates
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
		for(Sprite i: sprites) {
			i.render();
		}
	}
}
