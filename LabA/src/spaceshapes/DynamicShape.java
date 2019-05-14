package spaceshapes;

import java.awt.Color;

public class DynamicShape extends Shape {
	
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
