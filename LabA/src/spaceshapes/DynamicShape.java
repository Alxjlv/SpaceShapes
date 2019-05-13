package spaceshapes;

import java.awt.Color;

public class DynamicShape extends Shape {

	private boolean _collide = false;
	
	public DynamicShape() {
		super();
	}

	public DynamicShape(int x, int y) {
		super(x, y);
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}

	@Override
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
			_collide = true;
			_x = nextX;
			_y = nextY;
			return;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
			_collide = true;
			_x = nextX;
			_y = nextY;
			return;
		}

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
			_collide = false;
			_x = nextX;
			_y = nextY;
			return;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
			_collide = false;
			_x = nextX;
			_y = nextY;
			return;
		}

		_x = nextX;
		_y = nextY;
	}
	
	@Override
	public void paint(Painter painter) {//need to draw rectangle in the new colour
		painter.setColor(new Color(212,212,212));
		if(!_collide) {
			painter.drawRect(_x, _y, _width, _height);
		}
		if(_collide) {
			painter.setColor(Color.red);
			painter.drawRect(_x, _y, _width, _height);
			painter.fillRect(_x,_y,_width,_height);
		}
		
	}

}
