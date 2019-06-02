package spaceshapes;

import java.awt.Color;

public class DynamicRectangleShape extends Shape {
	
	private Color _colour = Color.red;
	
	public DynamicRectangleShape() {
		super();
	}

	public DynamicRectangleShape(int x, int y) {
		super(x, y);
	}

	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color colour) {
		super(x,y,deltaX,deltaY,width,height,text);
		_colour = colour;
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color colour) {
		super(x,y,deltaX,deltaY,width,height);
		_colour = colour;
	}
	
	public void doPaint(Painter painter) {//need to draw rectangle in the new colour
		if(!_sideCollide) {
			painter.drawRect(_x, _y, _width, _height);
		}
		if(_sideCollide) {
			painter.setColor(_colour);
			painter.drawRect(_x, _y, _width, _height);
			painter.fillRect(_x,_y,_width,_height);
		}
		painter.setColor(new Color(212,212,212));
	}
	
}
