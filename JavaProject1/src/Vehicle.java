import org.newdawn.slick.Input;

public abstract class Vehicle extends Sprite{
	
	//Defining Constants for the class.
	private final static float ROAD_EDGE_EAST = 1200f;
	private final static float ROAD_EDGE_WEST = -30f;
	private  boolean rightward;
	
	
	
	//Constructor for Vehicle Sprite.
	public Vehicle(String image, float x, float y, boolean right) {
		super(image, x, y);
		rightward = right;
	}
	public Vehicle(String image, float x, float y, boolean right, String[] tags) {
		super(image, x, y, tags);
		rightward = right;
	}
	
	

	public void update(Input input, int delta) {
		
	}

	
	//Checks to see if bus is at the end of the screen and needs to be reset at the beginning.
	public void reposition(){
		if (getX() > App.SCREEN_WIDTH + World.TILE_SIZE / 2 || getX() < -World.TILE_SIZE / 2
				 || getY() > App.SCREEN_HEIGHT + World.TILE_SIZE / 2 || getY() < -World.TILE_SIZE / 2) {
					setX(getInitialX());
				}
	}
	
	private final float getInitialX() {
		return rightward ? -World.TILE_SIZE / 2
						 : App.SCREEN_WIDTH + World.TILE_SIZE / 2;
	}
	public void changeDirection() {
		rightward = !rightward;
	}
	
	public boolean rightwardMoving() {
		return rightward;
	}
}
