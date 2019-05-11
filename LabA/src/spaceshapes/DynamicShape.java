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
	public void paint(Painter painter) {
		painter.drawRect(_x, _y, _width, _height);
		if(_deltaX <0 && (_x + _deltaX)<=0 ||_collide) {
			_collide = true;
			painter.setColor(Color.red);
			painter.fillRect(_x,_y,_width,_height);
		}
		if(_deltaY <0 && (_y + _deltaY)<=0) {
			_collide = false;
			painter.setColor(Color.black);
			painter.fillRect(_x,_y,_width,_height);
		}
	}

}
