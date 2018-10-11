import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import utilities.BoundingBox;

public abstract class Sprite {
	
	public final static String HAZARD = "hazard";
	
	//Instance variables initialized
	private float xCoordinate = 512f;
	private float yCoordinate = 720f;
	private Image image;
	private BoundingBox bb;
	
	private String[] tags;
	
	//Sprite Constructor
	public Sprite(String imageSrc, float x, float y) {
		setupSprite(imageSrc, x, y);
	}
	
	public Sprite(String imageSrc, float x, float y, String[] tags) {
		setupSprite(imageSrc, x, y);
		this.tags = tags;
	}
	
	private void setupSprite(String imageScr, float x, float y) {
		try {
			image = new Image(imageScr);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		xCoordinate = x;
		yCoordinate = y;
		
		bb = new BoundingBox(image, (int)xCoordinate, (int)yCoordinate);
		
		tags = new String[0];
	}
	
	public void update(Input input, int delta) {
		// Method overridden in sprite subclasses.
	}
	
	// Method draws updated image to screen, no need for overriding.
	public void render() {
		if ((this instanceof Turtles && ((Turtles) this).isAboveWater()) || !(this instanceof Turtles)) {
			image.drawCentered(xCoordinate, yCoordinate);
		}
	}
	
	public final void move(float dx, float dy) {
		setX(xCoordinate + dx);
		setY(yCoordinate + dy);
	}
		
	public final boolean onScreen() {
		return !(getX() + World.TILE_SIZE / 2 > App.SCREEN_WIDTH || getX() - World.TILE_SIZE / 2 < 0
				 || getY() + World.TILE_SIZE / 2 > App.SCREEN_HEIGHT || getY() - World.TILE_SIZE / 2 < 0);
	}

	//Used to check if two BoundingBoxes are touching by using intersects methods in BoundingBox.java
	//Is they are touching, return true and the game will exit in the World class.
	public boolean contactsSprite(Sprite other) {
		return bb.intersects(other.getBoundingBox());
	}
	
	public void onCollision(Sprite other) { }
	
	//Returns Sprite's BoundingBox.
	public BoundingBox getBoundingBox() {
		return bb;
	}
	
	public boolean hasTag(String tag) {
		for (String test : tags) {
			if (tag.equals(test)) {
				return true;
			}
		}
		return false;
	}
	
	//Coordinate getters and setters.
	public float getX() { return xCoordinate;}
	public float getY() { return yCoordinate;}
	public void setX(float x) { xCoordinate = x; bb.setX((int)xCoordinate);}
	public void setY(float y) { yCoordinate = y; bb.setY((int)yCoordinate);}
}
