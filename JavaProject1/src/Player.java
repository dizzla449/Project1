import org.newdawn.slick.Input;

public class Player extends Sprite {
	
	//Constants define below \/ \/
	private final static String FROG_IMAGE_PATH = "assets/frog.png";
	private final static float INITIAL_X = 512f;
	private final static float INITIAL_Y = 720f;
	private final static float EDGE_OF_WATER = 360f;
	
	
	//Constructor to define Player Sprite just uses super constructor.
	public Player() {
		super(FROG_IMAGE_PATH, INITIAL_X, INITIAL_Y);
	}
	
	
	//Update will handle the arrow key input, update coordinates 
	//and then check if valid coordinate positions.
	public void update(Input input, int delta) {
		
		// Accept Key Inputs and alter coordinates
		movePlayer(input);
		
		//Check if new coordinates within bounds
		boundsCheck();
		//Check if player is in the water, if so the App is exited.
		if (getY() < EDGE_OF_WATER) {
			System.exit(0);
		}
	}
	
	//Method to accept User arrow key input.
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
		
		//Update Coordinates in Sprite parent class.
		setX(getX()+dx);
		setY(getY()+dy);
	}
	
	//Method to check if player is within the view of the screen.
	private void boundsCheck() {
		setX(Math.max(getX(), 0));
		setX(Math.min(getX(), App.SCREEN_WIDTH));
		setY(Math.max(getY(), 0));
		setY(Math.min(getY(), App.SCREEN_HEIGHT));
	}
}