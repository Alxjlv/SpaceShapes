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
	
	public void paintShape(Painter painter) {//need to draw rectangle in the new colour
		if(!_sideCollide) {
			painter.drawRect(_x, _y, _width, _height);
		}
		if(_sideCollide) {
			painter.setColor(Color.red);
			painter.drawRect(_x, _y, _width, _height);
			painter.fillRect(_x,_y,_width,_height);
		}
		painter.setColor(new Color(212,212,212));
	}
	
}
