 package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes Shape and RectangleShape.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class TestDynamicShape {
	// Fixture object that is used by the tests.
	private MockPainter _painter;

	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 */
	@Test
	public void testSimpleMoveDynamicShape() {
		DynamicShape shape = new DynamicShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 112,35,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffRight() {
		DynamicShape shape = new DynamicShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)"
				+ "(rectangle 110,35,25,35)"
				+ "(rectangle 98,50,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffLeft() {
		DynamicShape shape = new DynamicShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 10,20,25,35)"
				+ "(rectangle 0,35,25,35)"
				+ "(rectangle 12,50,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffTop() {
		DynamicShape shape = new DynamicShape(10, 90, 12, 16);
		shape.paint(_painter);
		shape.move(10000, 135);
		shape.paint(_painter);
		shape.move(10000, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 10,90,25,35)"
				+ "(rectangle 22,100,25,35)"
				+ "(rectangle 34,84,25,35)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffBottom() {
		DynamicShape shape = new DynamicShape(10, 10, 12, -16);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 10,10,25,35)"
				+ "(rectangle 22,0,25,35)"
				+ "(rectangle 34,16,25,35)"
				, _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffBottomAndRight() {
		DynamicShape shape = new DynamicShape(10, 90, -90, 60);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 10,90,25,35)"
				+ "(rectangle 0,100,25,35)"
				+ "(rectangle 90,40,25,35)"
				, _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffTopAndRight() {
		DynamicShape shape = new DynamicShape(75, 65, 25, 35);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 75,65,25,35)"
				+ "(rectangle 100,100,25,35)"
				+ "(rectangle 75,65,25,35)"
				, _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom left corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffBottomAndLeft() {
		DynamicShape shape = new DynamicShape(10, 10, -10, -10,50,50);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 10,10,50,50)"
				+ "(rectangle 0,0,50,50)"
				+ "(rectangle 10,10,50,50)"
				, _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom left corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffTopAndLeft() {
		DynamicShape shape = new DynamicShape(10, 65, -10, 35);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 10,65,25,35)"
				+ "(rectangle 0,100,25,35)"
				+ "(rectangle 10,65,25,35)"
				, _painter.toString());
	}
}
