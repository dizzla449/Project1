import org.newdawn.slick.Input;

public class Racecar extends Vehicle {
	
		private final static String IMAGE_PATH_RACECAR = "assets/racecar.png";
		public final static float RACECAR_SPEED = 0.5f;
		
		public Racecar(float x, float y, boolean rightward) {
			super(IMAGE_PATH_RACECAR, x, y, rightward, new String[] { Sprite.HAZARD });
		}
		

		//Used to reposition buses
		//WestTravelling determines which direction the bus is traveling. 
		public void update(Input input, int delta) {
			if (!rightwardMoving()) { move(getX()-RACECAR_SPEED*delta, 0);}
			else            { move(getX()+RACECAR_SPEED*delta, 0);}
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

