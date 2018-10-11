import org.newdawn.slick.Input;

public class Player extends Sprite {
	
	//Constants define below \/ \/
	private final static String FROG_IMAGE_PATH = "assets/frog.png";
	private final static float INITIAL_X = App.SCREEN_WIDTH/2;
	private final static float INITIAL_Y = App.SCREEN_HEIGHT-World.TILE_SIZE;
	private boolean playerAfloat = false;
	
	private static Player player;
	
	
	//Constructor to define Player Sprite just uses super constructor.
	public Player() {
		super(FROG_IMAGE_PATH, INITIAL_X, INITIAL_Y);
		player = this;
	}
	
	public static Player getInstance() {
		if (player == null) {
			player = new Player();
		}
		return player;
	}
	
	//Update will handle the arrow key input, update coordinates 
	//and then check if valid coordinate positions.
	public void update(Input input, int delta) {
		
		// Accept Key Inputs and alter coordinates
		movePlayer(input);
		
		//Check if new coordinates within bounds
		withinScreen();
	}
	
	//Method to accept User arrow key input.
	private void movePlayer(Input input) {
		float dx = 0f;
		float dy = 0f;
		if (input.isKeyPressed(Input.KEY_UP)) {
				dy -= World.TILE_SIZE;
		} if (input.isKeyPressed(Input.KEY_DOWN)) {
			dy += World.TILE_SIZE;
		} if (input.isKeyPressed(Input.KEY_RIGHT)) {
			dx += World.TILE_SIZE;
		} if (input.isKeyPressed(Input.KEY_LEFT)) {
			dx -= World.TILE_SIZE;
		}
		
		//Update Coordinates in Sprite parent class.
		move(dx, dy);
	}
	@Override
	public void onCollision(Sprite other) {
		if (other.hasTag(Sprite.HAZARD) && !World.getInstance().isPlayerAfloat()) {
			System.exit(0);
		}
	}

	//Method to check if player is within the view of the screen.
	private void withinScreen() {
		setX(Math.max(getX(), World.TILE_SIZE/2));
		setX(Math.min(getX(), App.SCREEN_WIDTH-World.TILE_SIZE));
		setY(Math.max(getY(), World.TILE_SIZE));
		setY(Math.min(getY(), App.SCREEN_HEIGHT-World.TILE_SIZE));
	}
}