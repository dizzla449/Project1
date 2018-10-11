import org.newdawn.slick.Input;

public class Longlog extends Rider {
	
	private final static String IMAGE_PATH_LONGLOG = "assets/longlog.png";
	public final static float LONGLOG_SPEED = 0.07f;
	
	public Longlog(float x, float y, boolean rightward) {
		super(IMAGE_PATH_LONGLOG, x, y, rightward);
	}
	

	//Used to reposition buses
	//WestTravelling determines which direction the bus is traveling. 
	public void update(Input input, int delta) {
		if (!rightwardMoving()) { move(getX()-LONGLOG_SPEED*delta, 0);}
		else            { move(getX()+LONGLOG_SPEED*delta, 0);}
		//Checks to see if the bus is off the screen and repositions it at the beginning.
		reposition();
		playerOnTop();
	}
	
	@Override
	public void onCollision(Sprite other) {
	}

}

