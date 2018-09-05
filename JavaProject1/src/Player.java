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
		// Accept Key Inputs and alter coordinates
		movePlayer(input);
		//Check if new coordinates within bounds
		boundsCheck();
	}
	
	private void movePlayer(Input input) {
		float dx = 0f;
		float dy = 0f;
		if (input.isKeyPressed(Input.KEY_UP)) {
				dy -=48f;
		} if (input.isKeyPressed(Input.KEY_DOWN)) {
			dy +=48f;
		} if (input.isKeyPressed(Input.KEY_RIGHT)) {
			dx +=48f;
		} if (input.isKeyPressed(Input.KEY_LEFT)) {
			dx -=48f;
		}
		setX(getX()+dx);
		setY(getY()+dy);
	}
	
	private void boundsCheck() {
		setX(Math.max(getX(), 0));
		setX(Math.min(getX(), App.SCREEN_WIDTH));
		setY(Math.max(getY(), 0));
		setY(Math.min(getY(), App.SCREEN_HEIGHT));
	}
}