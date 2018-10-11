import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Level {
	
	private ArrayList<Sprite> sprites;
	private boolean levelPassed = false;
	
	public Level(String file_path) {
		sprites = createPlayerAndVehicles(file_path);
	}

	
	public void update(Input input, int delta) {
		// Update all sprites movement.
		World.getInstance().changePlayerAfloat(false);
		
		for(Sprite i: sprites) {
			i.update(input, delta);
			
			if (i instanceof Rider && !World.getInstance().isPlayerAfloat() && ((Rider) i).isPlayerAfloat()) {
				World.getInstance().changePlayerAfloat(true);
			}
		}
		
		//Check player (first element) has collided with any other sprites(vehicles), and if so exit App.
		for (Sprite sprite1: sprites) {
			for (Sprite sprite2: sprites) {
				if (sprite1 != sprite2 && sprite1.contactsSprite(sprite2)) {
					sprite1.onCollision(sprite2);
				}
			}
		}
		//Quick escape enabled by pressing ESCAPE Key
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			System.exit(0);
		}
	}
	
	public void render(Graphics g) {
		for (Sprite sprite : sprites) {
			sprite.render();
		}
	}
	
	public boolean isLevelPassed() { return levelPassed;}
	
	private ArrayList<Sprite> createPlayerAndVehicles(String level) {
		
		ArrayList<Sprite> sprites = new ArrayList<>();
		sprites.add(new Player());
		
		try (BufferedReader br = new BufferedReader(new FileReader(level))) {
			String line = null;
			while ((line = br.readLine()) != null) {
					// read the data from the line
					String[] data = line.split(",");
					
					// This next section uses a technique called "reflection", where
					// classes are looked up by their (string) names. In this way,
					// we can avoid having to use the Factory pattern without
					// sacrificing extensibility. Is there a downside to this approach?
					String className =  data[0].substring(0, 1).toLowerCase() + data[0].substring(1);
					int x = Integer.parseInt(data[1]);
					int y = Integer.parseInt(data[2]);
					boolean rightwards = Boolean.parseBoolean(data[3]);
					
					Class<?> c = Class.forName(className);
					sprites.add((Sprite)c.getConstructor(new Class[] { float.class, float.class, boolean.class })
								       .newInstance(new Object[] { x, y, rightwards }));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sprites;
	}
}
