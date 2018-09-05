import org.newdawn.slick.Input;

public class Player extends Sprite {
	
	private final static String FROG_IMAGE_PATH = "assets/frog.png";
	private final static float INITIAL_X = 512f;
	private final static float INITIAL_Y = 720f;
	
	
	//Constructor to define Player Sprite
	public Player() {
		super(FROG_IMAGE_PATH, INITIAL_X, INITIAL_Y);
	}
	
	
	//Update will handle the arrow key input
	public void update(Input input, int delta) {
	
	
	}
	
	
	
	
	
	//Render image and does nothing else
	public void render() {
		
	}
}