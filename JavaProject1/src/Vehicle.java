import org.newdawn.slick.Input;

public class Vehicle extends Sprite{
	
	//Defining Constants for the class.
	public final static String BUS_IMAGE_PATH = "assets/bus.png";
	public final static float SPEED = 0.15f;
	
	
	
	//Constructor for Vehicle Sprite.
	public Vehicle(float x, float y) {
		super(BUS_IMAGE_PATH, x, y);
	}
	
	
	//Used to reposition buses
	//WestTravelling determines which direction the bus is traveling. 
	public void update(Input input, int delta) {
		if (westTravelling()) {
			setX(getX()-SPEED*delta);
		} else {
			setX(getX()+SPEED*delta);
		}
		//Checks to see if the bus is off the screen and repositions it at the beginning.
		reposition();
	}
	
	// West or east moving bus?
	private boolean westTravelling() {
		if (getY()==432f || getY()==528f || getY()==624f) {
			return true;
		} return false;
	}
	
	//Checks to see if bus is at the end of the screen and needs to be reset at the beginning.
	private void reposition(){
		if (westTravelling()) {
			if (getX()<-30f) { setX(1200f);}
		}
		else {
			if (getX()>1088f) { setX(-30f);}
		}
	}
	
}
