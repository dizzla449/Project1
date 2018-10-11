import org.newdawn.slick.Input;

public class Log extends Rider {
		
			private final static String IMAGE_PATH_LOG = "assets/log.png";
			public final static float LOG_SPEED = 0.1f;
			
			public Log(float x, float y, boolean rightward) {
				super(IMAGE_PATH_LOG, x, y, rightward);
			}
			

			//Used to reposition buses
			//WestTravelling determines which direction the bus is traveling. 
			public void update(Input input, int delta) {
				if (!rightwardMoving()) { move(getX()-LOG_SPEED*delta, 0);}
				else            { move(getX()+LOG_SPEED*delta, 0);}
				//Checks to see if the bus is off the screen and repositions it at the beginning.
				reposition();
				playerOnTop();
			}
			
			@Override
			public void onCollision(Sprite other) {

			}

		}

