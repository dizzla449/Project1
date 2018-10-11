import org.newdawn.slick.Input;

public class Bus extends Vehicle {
	
	private final static String IMAGE_PATH_BUS = "assets/bus.png";
	public final static float BUS_SPEED = 0.15f;
	
	public Bus(float x, float y, boolean rightward) {
		super(IMAGE_PATH_BUS, x, y, rightward, new String[] { Sprite.HAZARD });
	}
	

	//Used to reposition buses
	//WestTravelling determines which direction the bus is traveling. 
	public void update(Input input, int delta) {
		if (!rightwardMoving()) {
			setX(getX()-BUS_SPEED*delta);
		} else {
			setX(getX()+BUS_SPEED*delta);
		}
		//Checks to see if the bus is off the screen and repositions it at the beginning.
		reposition();
	}
	
	@Override
	public void onCollision(Sprite other) {
		if (other instanceof Player) {
			System.exit(0);
		}
	}

}
