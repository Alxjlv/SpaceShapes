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
	
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}

	@Override
	public void doPaint(Painter painter) {
		painter.drawRect(_x,_y,_width,_height);
		painter.translate(_x,_y);
		for(Shape shape : _children) {
			shape.paint(painter);
		}
		painter.translate(-_x,-_y);
	}

	@Override
	public void move(int width, int height) {
		super.move(width, height);
		for(Shape shape : _children) {
			shape.move(_width, _height);
		}
	}
	
	void add(Shape shape) throws IllegalArgumentException {
		if(shape.parent()==null) {
			if(withinBounds(shape)) {
				_children.add(shape);
				shape.addParent(this);
				return;
			}
		}
		throw new IllegalArgumentException();
	}
	
	protected boolean withinBounds(Shape shape) {
		if((shape.height() > _height)||(shape.width() > _width)) {
			return false;
		}else if((shape.height()+shape.y() > _height + _y)||(shape.width()+shape.x() > _width + _x)) {
			return false;
		}else if ((shape.x() < _x)||(shape.y() < _y)){
			return false;
		}
		return true;
	}
	
	void remove(Shape shape) {
		if(_children.contains(shape)) {
			_children.remove(shape);
			shape.addParent(null);
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
