package spaceshapes;

public class OvalShape extends Shape {

	public OvalShape() {
		super();
	}

	public OvalShape(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public OvalShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
		// TODO Auto-generated constructor stub
	}

	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintShape(Painter painter) {
		// TODO Auto-generated method stub
		painter.drawOval(_x, _y, _width, _height);

	}

}
