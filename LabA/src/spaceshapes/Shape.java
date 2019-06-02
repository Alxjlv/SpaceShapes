package spaceshapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract superclass to represent the general concept of a Shape. This class
 * defines state common to all special kinds of Shape instances and implements
 * a common movement algorithm. Shape subclasses must override method paint()
 * to handle shape-specific painting.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public abstract class Shape {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;
	
	protected static final int DEFAULT_Y_POS = 0;
	
	protected static final int DEFAULT_DELTA_X = 5;
	
	protected static final int DEFAULT_DELTA_Y = 5;
	
	protected static final int DEFAULT_HEIGHT = 35;

	protected static final int DEFAULT_WIDTH = 25;
	// ===

	// === Instance variables, accessible by subclasses.
	protected int _x;

	protected int _y;

	protected int _deltaX;

	protected int _deltaY;

	protected int _width;

	protected int _height;
	
	protected boolean _sideCollide = false;
	
	protected CarrierShape _parent;
	
	protected String _displayText;
	
	// ===
	
	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public Shape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
	}
	
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		_displayText = text;
	}
	
	/**
	 * Moves this Shape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world. 
	 * @param width - width of two-dimensional world.
	 * @param height - height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;
		
		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
			_sideCollide = false;
			_x = nextX;
			_y = nextY;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
			_sideCollide = false;
			_x = nextX;
			_y = nextY;
		}
		
		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
			_sideCollide = true;
			_x = nextX;
			_y = nextY;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
			_sideCollide = true;
			_x = nextX;
			_y = nextY;
		}

		

		_x = nextX;
		_y = nextY;
	}
	
	/**
	 * Method to be implemented by concrete subclasses to handle subclass
	 * specific painting.
	 * @param painter the Painter object used for drawing.
	 */
	public final void paint(Painter painter) {
		this.doPaint(painter);
		int centreX = _width/2 + _x;
		int centreY = _height/2 +_y;
		painter.paintText(_displayText,centreX,centreY);
	}
	//make not abstract, and paint string part of it.
	//Add a hook method which is abstract, which every class will implement - eg. slot
	//This is the paintShape method
	
	protected abstract void doPaint(Painter painter);

	public void setDisplayText(String text) {
		_displayText = text;
	}
	
	/**
	 * Returns this Shape object's x position.
	 */
	public int x() {
		return _x;
	}
	
	/**
	 * Returns this Shape object's y position.
	 */
	public int y() {
		return _y;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaX() {
		return _deltaX;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaY() {
		return _deltaY;
	}
	
	/**
	 * Returns this Shape's width.
	 */
	public int width() {
		return _width;
	}
	
	/**
	 * Returns this Shape's height.
	 */
	public int height() {
		return _height;
	}
	
	public String text() {
		return _displayText;
	}
	
	/**
	 * Returns a String whose value is the fully qualified name of this class 
	 * of object. E.g., when called on a RectangleShape instance, this method 
	 * will return "spaceshapes.RectangleShape".
	 */
	public String toString() {
		return getClass().getName();
	}
	
/**
 * Returns an ordered list of Shape objects
 * First item in the list is the root CarrierShape
 * Last item in the list is the object calling the method. Any items in between are between those 2
 * @return
 */
	public List<Shape> path(){
		List<Shape> shapeList = new ArrayList<Shape>();
		if(_parent !=null) {
			shapeList.addAll(_parent.path());
		}
		shapeList.add(this);
		return shapeList;
	}
	
	public void addParent(CarrierShape carrier) {
		if (_parent == null) {
			_parent = carrier;
		}else if(carrier == null) {
			_parent = null;
		}
	}
	
	/**
	 * returns the parent carrier shape - null if there isn't any parent carrier shape
	 * @return
	 */
	public CarrierShape parent() {
		if(_parent !=null) {
			return _parent;
		}else {
			return null;
		}
	}
	
}
