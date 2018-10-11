import org.newdawn.slick.Input;

public class Bike extends Vehicle {

		
		private final static String IMAGE_PATH_BIKE = "assets/bike.png";
		public final static float BIKE_SPEED = 0.2f;
		private final float randomXCoordinate = Math.random()<0.5 ? 24 : 1000;
		
		public Bike(float x, float y, boolean rightward) {
			super(IMAGE_PATH_BIKE, x, y, rightward, new String[] { Sprite.HAZARD });
		}
		

		//Used to reposition buses
		//WestTravelling determines which direction the bus is traveling. 
		public void update(Input input, int delta) {
			if (!!rightwardMoving()) {
				setX(getX()-BIKE_SPEED*delta);
			} else {
				setX(getX()+BIKE_SPEED*delta);
			}
			if (Math.abs(getX()-randomXCoordinate) <1) {
				changeDirection();
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

