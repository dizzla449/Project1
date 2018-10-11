import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class World {
	/*
	 * CONSTANTS DEFINED BELOW \/ \/ \/ \/
	*/
	public static final int TILE_SIZE = 48;
	
	private boolean playerAfloat = false;
	private static World world;

	// \/ \/ \/ \/ Cannot use default BoundingBox image dimensions. must reduce size.
	//width = img.getHeight()*World.BOUNDINGBOX_WIDTH_CONTRACTION_FACTOR;
	public final static float BOUNDINGBOX_HEIGHT_CONTRACTION_FACTOR = 0.75f;
	//width = img.getWidth()*World.BOUNDINGBOX_WIDTH_CONTRACTION_FACTOR;
	public final static float BOUNDINGBOX_WIDTH_CONTRACTION_FACTOR = 0.75f;
	
	//Other Instance Variables also initialized 

	private ArrayList<Level> levels = new ArrayList<>();
	
	public World() {
		// Perform initialization logic
		/*
		 * ALL SPRITES INITIALISED BELOW \/ \/ \/ \/ \/ \/ \/
		 */
		levels.add(new Level("assets/levels/0.lvl"));
		levels.add(new Level("assets/levels/1.lvl"));

		world = this;
	}
	
	public static World getInstance() {
		if (world == null) {
			world = new World();
		}
		return world;
	}
	
	//Need to update sprites ArrayList for movement and also check for collisions.
	public void update(Input input, int delta) {
		for (Level level: levels) {
			if (level.isLevelPassed() == false) {
				level.update(input, delta);
				break;
			}
		}
	}
	
	public boolean isPlayerAfloat() { return playerAfloat;}
	public void changePlayerAfloat(boolean Afloat) { playerAfloat = Afloat;}
	
	public void render(Graphics g) {
		for (Level level: levels) {
			if (level.isLevelPassed() == false) {
				level.render(g);
				break;
			}
		}
	}
	
}
