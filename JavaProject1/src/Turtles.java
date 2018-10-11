import org.newdawn.slick.Input;

public class Turtles extends Rider {
			
				private final static String IMAGE_PATH_TURTLES = "assets/turtles.png";
				public final static float TURTLES_SPEED = 0.085f;
				private boolean aboveWater = true;
				private int time = 0;
				
				public Turtles(float x, float y, boolean rightward) {
					super(IMAGE_PATH_TURTLES, x, y, rightward);
				}
				

				//Used to reposition buses
				//WestTravelling determines which direction the bus is traveling. 
				public void update(Input input, int delta) {
					time += delta;
					if (!rightwardMoving()) { move(getX()-TURTLES_SPEED*delta, 0);}
					else            { move(getX()+TURTLES_SPEED*delta, 0);}
					//Checks to see if the bus is off the screen and repositions it at the beginning.
					reposition();
					playerOnTop();
					if (time>7) {
						aboveWater = false;
					} if (time>9) {
						time = 0;
						aboveWater = true;
					}
				}
				
				@Override
				public void onCollision(Sprite other) {

				}
				
				public boolean isAboveWater() { return aboveWater;}
			}

