package spaceshapes;

public class HexagonShape extends Shape {

	
	public HexagonShape() {
		super();
	}

	public HexagonShape(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public HexagonShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
		// TODO Auto-generated constructor stub
	}

	public HexagonShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintShape(Painter painter) {
		if(_width >=40){
			painter.drawLine(_x, _y +_height/2, _x+20, _y + _height);
			painter.drawLine(_x+20, _y + _height, _x + _width-20, _y + _height);
			painter.drawLine(_x+_width-20, _y + _height, _x + _width, _y + _height/2);
			painter.drawLine(_x + _width, _y + _height/2, _x+_width-20, _y);
			painter.drawLine(_x+_width-20, _y, _x+20, _y);
			painter.drawLine(_x+20, _y, _x, _y+_height/2);
		}else{
			painter.drawLine(_x, _y+_height/2, _x+_width/2, _y + _height);//far left to top middle
			painter.drawLine(_x+_width/2, _y + _height, _x+_width, _y +_height/2);//top middle to far right
			painter.drawLine(_x+_width, _y+_height/2, _x+_width/2, _y);//far right to bottom middle
			painter.drawLine(_x+_width/2, _y, _x, _y+_height/2);//bottom middle to far left			
		}
		}
		

}
