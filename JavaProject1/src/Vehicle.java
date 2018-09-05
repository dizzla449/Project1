import org.newdawn.slick.Input;

public class Vehicle extends Sprite{
	
	public final static String BUS_IMAGE_PATH = "assets/bus.png";
	public final static float SPEED = 0.15f;
	
	
	
	//Constructor for Vehicle Sprites
	public Vehicle(float x, float y) {
		super(BUS_IMAGE_PATH, x, y);
	}
	
	//Used to reposition buses
	public void update(Input input, int delta) {
		if (westTravelling()) {
			setX(getX()-SPEED*delta);
		} else {
			setX(getX()+SPEED*delta);
		}
		reposition();
	}
	
	private boolean westTravelling() {
		if (getY()==432f || getY()==528f || getY()==624f) {
			return true;
		} return false;
	}
	
	private void reposition(){
		if (westTravelling()) {
			if (getX()<-30f) {
				setX(1200f);
			}
		} else {
			if (getX()>1088f) {
				setX(-30f);
			}
		}
	}
}
