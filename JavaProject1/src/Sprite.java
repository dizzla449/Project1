import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import utilities.BoundingBox;

public class Sprite {
	
	private float xCoordinate = 512f;
	private float yCoordinate = 720f;
	private Image movingPiece;
	private BoundingBox bb;
	
	
	public Sprite(String imageSrc, float x, float y) {
		// Why would the constructor need a path to an image, and a coordinate?
		try {
			movingPiece = new Image(imageSrc);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		xCoordinate = x;
		yCoordinate = y;
	}
	
	public void update(Input input, int delta) {
		// How can this one method deal with different types of sprites?
	}
	
	public void render() {
		// This should be pretty simple.
		movingPiece.drawCentered(xCoordinate, yCoordinate);
	}
	
	public void contactSprite(Sprite other) {
		// Should be called when one sprite makes contact with another. 
	}
	
	//Coordinate getters and setters
	public float getX() { return xCoordinate;}
	public float getY() { return yCoordinate;}
	public void setX(float x) { xCoordinate = x;}
	public void setY(float y) { yCoordinate = y;}
	
	public BoundingBox getBoundingBox() {
		return new BoundingBox(movingPiece, xCoordinate, yCoordinate);
	}
	public boolean intersects(Sprite other) {
		bb = new BoundingBox(movingPiece, xCoordinate, yCoordinate);
		if (bb.intersects(other.getBoundingBox())) {
			return true;
		} return false;
	}
	
}
