package spaceshapes;

import java.util.ArrayList;
import java.util.List;

public class CarrierShape extends Shape {

	private List<Shape> _children = new ArrayList<Shape>();
	
	public CarrierShape() {
		super();
	}

	public CarrierShape(int x, int y) {
		super(x, y);
	}

	public CarrierShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}

	@Override
	public void paint(Painter painter) {
		//may also need to call paint on the child
		painter.drawRect(_x,_y,_width,_height);
		for(Shape shape : _children) {
			shape.paint(painter);
		}
	}

	@Override
	public void move(int width, int height) {
		super.move(width, height);
		for(Shape shape : _children) {
			shape.move(_x+_width, _y+_height);
		}
	}
	
	void add(Shape shape) throws IllegalArgumentException {
		if(!_children.contains(shape)) {
			if((!(shape._height>=_height||shape._width>=_width))
					&&!((shape._height+shape._y>_height+_y)||(shape._width+shape._x>_width+_x))) {
				_children.add(shape);
				shape.addParent(this);
				shape._isChild = true;
			}
			else {
				throw new IllegalArgumentException();
			}
		}
	}
	
	void remove(Shape shape) {
		if(_children.contains(shape)) {
			_children.remove(shape);
			shape._isChild = false;
		}		
	}
	
	public Shape shapeAt(int index) throws IndexOutOfBoundsException {
		return _children.get(index);
	}
	
	public int shapeCount() {
		return _children.size();
	}
	
	public int indexOf(Shape shape) {
		if(_children.contains(shape)) {
			return _children.indexOf(shape);
		}
		return -1;
	}
	
	public boolean contains(Shape shape) {
		return _children.contains(shape);
	}
}
