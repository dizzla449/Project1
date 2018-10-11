
public abstract class Rider extends Vehicle {
	
	private boolean playerOnTop = false;
	
	public Rider(String image, float x, float y, boolean rightward) {
		super(image, x, y, rightward);
	}
	
	public Rider(String image, float x, float y, boolean rightward, String[] tags) {
		super(image, x, y, rightward, tags);
	}
	
	public boolean isPlayerAfloat() {
		return playerOnTop;
	}
	
	public void playerOnTop() {
		if (Player.getInstance().getX() < getX() + getBoundingBox().getWidth()/2
				&& Player.getInstance().getX() > getX() - getBoundingBox().getWidth()/2
				) {
			if (Player.getInstance().getY() < getY() + getBoundingBox().getHeight()/2
					|| Player.getInstance().getY() < getY() + getBoundingBox().getHeight()/2
					) {
				if (!(this instanceof Turtles) || (this instanceof Turtles && ((Turtles) this).isAboveWater())) {
					playerOnTop = true;
				}
			}
		} else { playerOnTop = false;}		
	}
}
