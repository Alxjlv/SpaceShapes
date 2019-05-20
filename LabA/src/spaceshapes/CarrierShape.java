package spaceshapes;

public class CarrierShape extends Shape {

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
		painter.drawRect(_x,_y,_width,_height);
	}

	@Override
	public void move(int width, int height) {
		
	}
	
	void add(Shape shape) throws IndexOutOfBoundsException {
		
	}
}
