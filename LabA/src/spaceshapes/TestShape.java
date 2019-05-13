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
public class TestShape {
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
	public void testSimpleMoveRectangle() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 112,35,25,35)", 
				_painter.toString());
	}
	
	@Test
	public void testSimpleMoveOval() {
		OvalShape shape = new OvalShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(oval 100,20,25,35)(oval 112,35,25,35)", 
				_painter.toString());
	}
	
	@Test
	public void testSimpleMoveSmallHexagon() {
		HexagonShape shape = new HexagonShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(line 100,37,112,55)(line 112,55,125,37)(line 125,37,112,20)(line 112,20,100,37)"
				+"(line 112,52,124,70)(line 124,70,137,52)(line 137,52,124,35)(line 124,35,112,52)", 
				_painter.toString());
	}
	
	@Test
	public void testSimpleMoveBigHexagon() {
		HexagonShape shape = new HexagonShape(100, 20, 12, 15,90,90);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(line 100,65,120,110)(line 120,110,170,110)(line 170,110,190,65)(line 190,65,170,20)(line 170,20,120,20)(line 120,20,100,65)"
				+"(line 112,80,132,125)(line 132,125,182,125)(line 182,125,202,80)(line 202,80,182,35)(line 182,35,132,35)(line 132,35,112,80)", 
				_painter.toString());
	}
	
	@Test
	public void testSimpleMoveDynamicShape() {
		DynamicShape shape = new DynamicShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(rectangle colour set: 212 212 212)"
				+ "(rectangle 100,20,25,35)(rectangle colour set: 212 212 212)(rectangle 112,35,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testRectangleMoveWithBounceOffRight() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 110,35,25,35)"
				+ "(rectangle 98,50,25,35)", _painter.toString());
	}

	@Test
	public void testOvalMoveWithBounceOffRight() {
		OvalShape shape = new OvalShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(oval 100,20,25,35)(oval 110,35,25,35)"
				+ "(oval 98,50,25,35)", _painter.toString());
	}
	
	@Test
	public void testSmallHexagonMoveWithBounceOffRight() {
		HexagonShape shape = new HexagonShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(line 100,37,112,55)(line 112,55,125,37)(line 125,37,112,20)"
				+ "(line 112,20,100,37)(line 110,52,122,70)(line 122,70,135,52)"
				+ "(line 135,52,122,35)(line 122,35,110,52)(line 98,67,110,85)"
				+ "(line 110,85,123,67)(line 123,67,110,50)(line 110,50,98,67)"
				, _painter.toString());
	}
	
	@Test
	public void testBigHexagonMoveWithBounceOffRight() {
		HexagonShape shape = new HexagonShape(100, 20, 12, 15,90,90);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(line 100,65,120,110)(line 120,110,170,110)"
				+ "(line 170,110,190,65)(line 190,65,170,20)"
				+ "(line 170,20,120,20)(line 120,20,100,65)"
				+ "(line 45,80,65,125)(line 65,125,115,125)"
				+ "(line 115,125,135,80)(line 135,80,115,35)"
				+ "(line 115,35,65,35)(line 65,35,45,80"
				+ ")(line 33,95,53,140)(line 53,140,103,140)"
				+ "(line 103,140,123,95)(line 123,95,103,50)"
				+ "(line 103,50,53,50)(line 53,50,33,95)"
				, _painter.toString());
	}
	
	@Test
	public void testDynamicShapeMoveWithBounceOffRight() {
		DynamicShape shape = new DynamicShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle colour set: 212 212 212)(rectangle 100,20,25,35)"
				+ "(rectangle colour set: 212 212 212)(rectangle colour set: 255 0 0)"
				+ "(rectangle 110,35,25,35)(rectangle filled)(rectangle colour set: 212 212 212)"
				+ "(rectangle colour set: 255 0 0)(rectangle 98,50,25,35)"
				+ "(rectangle filled)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testRectangleMoveWithBounceOffLeft() {
		RectangleShape shape = new RectangleShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 10,20,25,35)(rectangle 0,35,25,35)"
				+ "(rectangle 12,50,25,35)", _painter.toString());
	}

	@Test
	public void testOvalMoveWithBounceOffLeft() {
		OvalShape shape = new OvalShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(oval 10,20,25,35)(oval 0,35,25,35)"
				+ "(oval 12,50,25,35)", _painter.toString());
	}
	
	@Test
	public void testSmallHexagonMoveWithBounceOffLeft() {
		HexagonShape shape = new HexagonShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,37,22,55)(line 22,55,35,37)"
				+ "(line 35,37,22,20)(line 22,20,10,37)"
				+ "(line 0,52,12,70)(line 12,70,25,52)"
				+ "(line 25,52,12,35)(line 12,35,0,52)"
				+ "(line 12,67,24,85)(line 24,85,37,67)"
				+ "(line 37,67,24,50)(line 24,50,12,67)"
				, _painter.toString());
	}
	
	@Test
	public void testBigHexagonMoveWithBounceOffLeft() {
		HexagonShape shape = new HexagonShape(10, 20, -12, 15,90,90);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,65,30,110)(line 30,110,80,110)"
				+ "(line 80,110,100,65)(line 100,65,80,20)"
				+ "(line 80,20,30,20)(line 30,20,10,65)"
				+ "(line 0,80,20,125)(line 20,125,70,125)"
				+ "(line 70,125,90,80)(line 90,80,70,35)"
				+ "(line 70,35,20,35)(line 20,35,0,80)"
				+ "(line 12,95,32,140)(line 32,140,82,140)"
				+ "(line 82,140,102,95)(line 102,95,82,50)"
				+ "(line 82,50,32,50)(line 32,50,12,95)"
				, _painter.toString());
	}
	
	@Test
	public void testDynamicShapeMoveWithBounceOffLeft() {
		DynamicShape shape = new DynamicShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle colour set: 212 212 212)(rectangle 10,20,25,35)"
				+ "(rectangle colour set: 212 212 212)(rectangle colour set: 255 0 0)"
				+ "(rectangle 0,35,25,35)(rectangle filled)(rectangle colour set: 212 212 212)"
				+ "(rectangle colour set: 255 0 0)(rectangle 12,50,25,35)"
				+ "(rectangle filled)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testRectangleMoveWithBounceOffTop() {
		RectangleShape shape = new RectangleShape(10, 90, 12, 16);
		shape.paint(_painter);
		shape.move(10000, 135);
		shape.paint(_painter);
		shape.move(10000, 135);
		shape.paint(_painter);
		System.out.println(_painter.toString());
		assertEquals("(rectangle 10,90,25,35)(rectangle 22,100,25,35)"
				+ "(rectangle 34,84,25,35)", _painter.toString());
	}
	
	@Test
	public void testOvalMoveWithBounceOffTop() {
		OvalShape shape = new OvalShape(10, 90, 12, 16);
		shape.paint(_painter);
		shape.move(10000, 135);
		shape.paint(_painter);
		shape.move(10000, 135);
		shape.paint(_painter);
		System.out.println(_painter.toString());
		assertEquals("(oval 10,90,25,35)(oval 22,100,25,35)"
				+ "(oval 34,84,25,35)", _painter.toString());
	}
	
	@Test
	public void testSmallHexagonMoveWithBounceOffTop() {
		HexagonShape shape = new HexagonShape(10, 90, 12, 16);
		shape.paint(_painter);
		shape.move(10000, 135);
		shape.paint(_painter);
		shape.move(10000, 135);
		shape.paint(_painter);
		System.out.println(_painter.toString());
		assertEquals("(line 10,107,22,125)(line 22,125,35,107)"
				+ "(line 35,107,22,90)(line 22,90,10,107)(line 22,117,34,135)"
				+ "(line 34,135,47,117)(line 47,117,34,100)(line 34,100,22,117)"
				+ "(line 34,101,46,119)(line 46,119,59,101)(line 59,101,46,84)"
				+ "(line 46,84,34,101)", _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testRectangleMoveWithBounceOffBottomAndRight() {
		RectangleShape shape = new RectangleShape(10, 90, -90, 60);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 10,90,25,35)(rectangle 0,100,25,35)"
				+ "(rectangle 90,40,25,35)", _painter.toString());
	}
	
	@Test
	public void testOvalShapeMoveWithBounceOffBottomAndRight() {
		OvalShape shape = new OvalShape(10, 90, -90, 60);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(oval 10,90,25,35)(oval 0,100,25,35)(oval 90,40,25,35)"
				, _painter.toString());
	}
	
	@Test
	public void testSmallHexagonShapeMoveWithBounceOffBottomAndRight() {
		HexagonShape shape = new HexagonShape(10, 90, -90, 60);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(line 10,107,22,125)(line 22,125,35,107)"
				+ "(line 35,107,22,90)(line 22,90,10,107)(line 0,117,12,135)"
				+ "(line 12,135,25,117)(line 25,117,12,100)(line 12,100,0,117)"
				+ "(line 90,57,102,75)(line 102,75,115,57)(line 115,57,102,40)"
				+ "(line 102,40,90,57)", _painter.toString());
	}
	
	@Test
	public void testBigHexagonShapeMoveWithBounceOffBottomAndRight() {
		HexagonShape shape = new HexagonShape(10, 90, -90, 65,50,50);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(line 10,115,30,140)(line 30,140,40,140)"
				+ "(line 40,140,60,115)(line 60,115,40,90)"
				+ "(line 40,90,30,90)(line 30,90,10,115)"
				+ "(line 0,110,20,135)(line 20,135,30,135)"
				+ "(line 30,135,50,110)(line 50,110,30,85)"
				+ "(line 30,85,20,85)(line 20,85,0,110)(line 75,45,95,70)"
				+ "(line 95,70,105,70)(line 105,70,125,45)"
				+ "(line 125,45,105,20)(line 105,20,95,20)"
				+ "(line 95,20,75,45)", _painter.toString());
	}
	
	@Test
	public void testDynamicShapeMoveWithBounceOffBottomAndRight() {
		DynamicShape shape = new DynamicShape(10, 90, -90, 60);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle colour set: 212 212 212)(rectangle 10,90,25,35)"
				+ "(rectangle colour set: 212 212 212)(rectangle colour set: 255 0 0)"
				+ "(rectangle 0,150,25,35)(rectangle filled)(rectangle colour set: 212 212 212)"
				+ "(rectangle 90,100,25,35)", _painter.toString());
	}
}
