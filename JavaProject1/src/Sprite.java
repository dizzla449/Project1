import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import utilities.BoundingBox;

public class Sprite {
	
	//Instance variables initialized
	private float xCoordinate = 512f;
	private float yCoordinate = 720f;
	private Image movingPiece;
	private BoundingBox bb;
	
	//Sprite Constructor
	public Sprite(String imageSrc, float x, float y) {
		// Image is initialized 
		try {
			movingPiece = new Image(imageSrc);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		xCoordinate = x;
		yCoordinate = y;
	}
	
	public void update(Input input, int delta) {
		// Method overridden in sprite subclasses.
	}
	
	// Method draws updated image to screen, no need for overriding.
	public void render() {
		movingPiece.drawCentered(xCoordinate, yCoordinate);
	}
	
	//Used to check if two BoundingBoxes are touching by using intersects methods in BoundingBox.java
	//Is they are touching, return true and the game will exit in the World class.
	public boolean contactSprite(Sprite other) {
		//'this' object's bounding box is initialized.
		bb = new BoundingBox(movingPiece, xCoordinate, yCoordinate);
		
		//getBoundingBox() initializes other's BoundingBox to use to check for intersection.
		if (bb.intersects(other.getBoundingBox())) {
			return true;
		} 
		return false;
	}
	//Creates Sprite BoundingBox.
	public BoundingBox getBoundingBox() {
		return new BoundingBox(movingPiece, xCoordinate, yCoordinate);
	}
	
	//Coordinate getters and setters.
	public float getX() { return xCoordinate;}
	public float getY() { return yCoordinate;}
	public void setX(float x) { xCoordinate = x;}
	public void setY(float y) { yCoordinate = y;}
}
