import org.newdawn.slick.Input;

public class Bulldozer extends Vehicle {

		
		private final static String IMAGE_PATH_BULLDOZER = "assets/bulldozer.png";
		public final static float BULLDOZER_SPEED = 0.05f;
		
		public Bulldozer(float x, float y, boolean rightward) {
			super(IMAGE_PATH_BULLDOZER, x, y, rightward);
		}
		

		//Used to reposition buses
		//WestTravelling determines which direction the bus is traveling. 
		public void update(Input input, int delta) {
			if (!rightwardMoving()) {
				move(-BULLDOZER_SPEED*delta, 0);
			} else {
				move(BULLDOZER_SPEED*delta, 0);
			}
			//Checks to see if the bus is off the screen and repositions it at the beginning.
			reposition();
		}
		
		@Override
		public void onCollision(Sprite other) {
			if (other instanceof Player && inFront(other.getX(), other.getY())) {
				if (rightwardMoving()) { move(getX()+24, 0); }
				else           { move(getX()-24, 0); }
			}
		}
		
		public boolean inFront(float x, float y) {
			if ((rightwardMoving() && getX()<y) || (!rightwardMoving() && getX()>y)) {
				return (getY()+48 > y && getY()-48 < y);
			}
			return false;
		}
}

