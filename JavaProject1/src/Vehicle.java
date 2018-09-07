import org.newdawn.slick.Input;

public class Vehicle extends Sprite{
	
	//Defining Constants for the class.
	public final static String BUS_IMAGE_PATH = "assets/bus.png";
	public final static float BUS_SPEED = 0.15f;
	private final static float ROAD_EDGE_EAST = 1200f;
	private final static float ROAD_EDGE_WEST = -30f;
	
	
	
	//Constructor for Vehicle Sprite.
	public Vehicle(float x, float y) {
		super(BUS_IMAGE_PATH, x, y);
	}
	
	
	//Used to reposition buses
	//WestTravelling determines which direction the bus is traveling. 
	public void update(Input input, int delta) {
		if (westTravelling()) {
			setX(getX()-BUS_SPEED*delta);
		} else {
			setX(getX()+BUS_SPEED*delta);
		}
		//Checks to see if the bus is off the screen and repositions it at the beginning.
		reposition();
	}
	
	// West or east moving bus?
	private boolean westTravelling() {
		if (getY()==World.BUS_Y_LOCATION1 || getY()==World.BUS_Y_LOCATION3 || getY()==World.BUS_Y_LOCATION5) {
			return true;
		} return false;
	}
	
	//Checks to see if bus is at the end of the screen and needs to be reset at the beginning.
	private void reposition(){
		if (westTravelling()) {
			if (getX()<ROAD_EDGE_WEST) { setX(ROAD_EDGE_EAST);}
		}
		else {
			if (getX()>ROAD_EDGE_EAST) { setX(ROAD_EDGE_WEST);}
		}
	}
	
}
