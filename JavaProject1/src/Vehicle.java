
public class Vehicle extends Sprite{
	
	public final static String BUS_IMAGE_PATH = "assets/bus.png";
	
	//Constructor for Vehicle Sprites
	public Vehicle(float x, float y) {
		super(BUS_IMAGE_PATH, x, y);
	}
	
	//Used to reposition buses
	public void update(int delta) {
		
	}
	
	
	
	//Only used to draw busses onto screen using a for loop
	public void render() {
		
	}
}
