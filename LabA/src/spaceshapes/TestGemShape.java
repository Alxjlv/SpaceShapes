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
public class TestGemShape {
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
	public void testSimpleMoveSmallGem() {
		GemShape shape = new GemShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(line 100,37,112,55)(line 112,55,125,37)(line 125,37,112,20)(line 112,20,100,37)"
				+"(line 112,52,124,70)(line 124,70,137,52)(line 137,52,124,35)(line 124,35,112,52)", 
				_painter.toString());
	}
	
	@Test
	public void testSimpleMoveBigGem() {
		GemShape shape = new GemShape(100, 20, 12, 15,90,90);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(line 100,65,120,110)(line 120,110,170,110)(line 170,110,190,65)(line 190,65,170,20)(line 170,20,120,20)(line 120,20,100,65)"
				+"(line 112,80,132,125)(line 132,125,182,125)(line 182,125,202,80)(line 202,80,182,35)(line 182,35,132,35)(line 132,35,112,80)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testSmallGemMoveWithBounceOffRight() {
		GemShape shape = new GemShape(100, 20, 12, 15);
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
	public void testBigGemMoveWithBounceOffRight() {
		GemShape shape = new GemShape(10, 20, 35, 15,90,90);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,65,30,110)(line 30,110,80,110)(line 80,110,100,65)"
				+ "(line 100,65,80,20)(line 80,20,30,20)(line 30,20,10,65)"
				+ "(line 45,80,65,125)(line 65,125,115,125)(line 115,125,135,80)"
				+ "(line 135,80,115,35)(line 115,35,65,35)(line 65,35,45,80)"
				+ "(line 10,95,30,140)(line 30,140,80,140)(line 80,140,100,95)"
				+ "(line 100,95,80,50)(line 80,50,30,50)(line 30,50,10,95)"
				, _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testSmallGemMoveWithBounceOffLeft() {
		GemShape shape = new GemShape(10, 20, -12, 15);
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
	public void testBigGemMoveWithBounceOffLeft() {
		GemShape shape = new GemShape(10, 20, -12, 15,90,90);
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
	
	/**
	 * Test to perform a bounce movement off the top-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testSmallGemMoveWithBounceOffTop() {
		GemShape shape = new GemShape(10, 90, 12, 16);
		shape.paint(_painter);
		shape.move(10000, 135);
		shape.paint(_painter);
		shape.move(10000, 135);
		shape.paint(_painter);
		assertEquals("(line 10,107,22,125)(line 22,125,35,107)"
				+ "(line 35,107,22,90)(line 22,90,10,107)(line 22,117,34,135)"
				+ "(line 34,135,47,117)(line 47,117,34,100)(line 34,100,22,117)"
				+ "(line 34,101,46,119)(line 46,119,59,101)(line 59,101,46,84)"
				+ "(line 46,84,34,101)", _painter.toString());
	}
	
	@Test
	public void testBigGemMoveWithBounceOffTop() {
		GemShape shape = new GemShape(10, 70, 12, 16,50,50);
		shape.paint(_painter);
		shape.move(10000, 135);
		shape.paint(_painter);
		shape.move(10000, 135);
		shape.paint(_painter);
		assertEquals("(line 10,95,30,120)(line 30,120,40,120)(line 40,120,60,95)"
				+ "(line 60,95,40,70)(line 40,70,30,70)(line 30,70,10,95)"
				+ "(line 22,110,42,135)(line 42,135,52,135)(line 52,135,72,110)"
				+ "(line 72,110,52,85)(line 52,85,42,85)(line 42,85,22,110)"
				+ "(line 34,94,54,119)(line 54,119,64,119)(line 64,119,84,94)"
				+ "(line 84,94,64,69)(line 64,69,54,69)(line 54,69,34,94)"
				, _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testSmallGemMoveWithBounceOffBottom() {
		GemShape shape = new GemShape(10, 10, 12, -16);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);		
		assertEquals("(line 10,27,22,45)(line 22,45,35,27)(line 35,27,22,10)"
				+ "(line 22,10,10,27)(line 22,17,34,35)(line 34,35,47,17)"
				+ "(line 47,17,34,0)(line 34,0,22,17)(line 34,33,46,51)"
				+ "(line 46,51,59,33)(line 59,33,46,16)(line 46,16,34,33)"
				, _painter.toString());
	}
	
	@Test
	public void testBigGemMoveWithBounceOffBottom() {
		GemShape shape = new GemShape(10, 10, 12, -16,50,50);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,35,30,60)(line 30,60,40,60)(line 40,60,60,35)"
				+ "(line 60,35,40,10)(line 40,10,30,10)(line 30,10,10,35)"
				+ "(line 22,25,42,50)(line 42,50,52,50)(line 52,50,72,25)"
				+ "(line 72,25,52,0)(line 52,0,42,0)(line 42,0,22,25)"
				+ "(line 34,41,54,66)(line 54,66,64,66)(line 64,66,84,41)"
				+ "(line 84,41,64,16)(line 64,16,54,16)(line 54,16,34,41)"
				, _painter.toString());
	}
	
	
	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testSmallGemShapeMoveWithBounceOffBottomAndRight() {
		GemShape shape = new GemShape(10, 90, -90, 60);
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
	public void testBigGemShapeMoveWithBounceOffBottomAndRight() {
		GemShape shape = new GemShape(10, 90, -90, 65,50,50);
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
	
	/**
	 * Test to perform a bounce movement off the top right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testSmallGemMoveWithBounceOffTopAndRight() {
		GemShape shape = new GemShape(75, 75, 25, 35);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(line 75,92,87,110)(line 87,110,100,92)"
				+ "(line 100,92,87,75)(line 87,75,75,92)(line 100,117,112,135)"
				+ "(line 112,135,125,117)(line 125,117,112,100)"
				+ "(line 112,100,100,117)(line 75,82,87,100)"
				+ "(line 87,100,100,82)(line 100,82,87,65)(line 87,65,75,82)"
				, _painter.toString());
	}
	
	@Test
	public void testBigGemMoveWithBounceOffTopAndRight() {
		GemShape shape = new GemShape(50, 50, 25, 35,50,50);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(line 50,75,70,100)(line 70,100,80,100)(line 80,100,100,75)"
				+ "(line 100,75,80,50)(line 80,50,70,50)(line 70,50,50,75)"
				+ "(line 75,110,95,135)(line 95,135,105,135)(line 105,135,125,110)"
				+ "(line 125,110,105,85)(line 105,85,95,85)(line 95,85,75,110)"
				+ "(line 50,75,70,100)(line 70,100,80,100)(line 80,100,100,75)"
				+ "(line 100,75,80,50)(line 80,50,70,50)(line 70,50,50,75)"
				, _painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom left corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testSmallGemMoveWithBounceOffBottomAndLeft() {
		GemShape shape = new GemShape(10, 10, -10, -10);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(line 10,27,22,45)(line 22,45,35,27)(line 35,27,22,10)"
				+ "(line 22,10,10,27)(line 0,17,12,35)(line 12,35,25,17)"
				+ "(line 25,17,12,0)(line 12,0,0,17)(line 10,27,22,45)"
				+ "(line 22,45,35,27)(line 35,27,22,10)(line 22,10,10,27)"
				, _painter.toString());
	}
	
	@Test
	public void testBigGemMoveWithBounceOffBottomAndLeft() {
		GemShape shape = new GemShape(10, 10, -10, -10,50,50);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(line 10,35,30,60)(line 30,60,40,60)(line 40,60,60,35)"
				+ "(line 60,35,40,10)(line 40,10,30,10)(line 30,10,10,35)"
				+ "(line 0,25,20,50)(line 20,50,30,50)(line 30,50,50,25)"
				+ "(line 50,25,30,0)(line 30,0,20,0)(line 20,0,0,25)"
				+ "(line 10,35,30,60)(line 30,60,40,60)(line 40,60,60,35)"
				+ "(line 60,35,40,10)(line 40,10,30,10)(line 30,10,10,35)"
				, _painter.toString());
	}
	
	
	/**
	 * Test to perform a bounce movement off the bottom left corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testSmallGemMoveWithBounceOffTopAndLeft() {
		GemShape shape = new GemShape(10, 65, -10, 35);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(line 10,82,22,100)(line 22,100,35,82)(line 35,82,22,65)"
				+ "(line 22,65,10,82)(line 0,117,12,135)(line 12,135,25,117)"
				+ "(line 25,117,12,100)(line 12,100,0,117)(line 10,82,22,100)"
				+ "(line 22,100,35,82)(line 35,82,22,65)(line 22,65,10,82)"
				, _painter.toString());
	}
	
	@Test
	public void testBigGemMoveWithBounceOffTopAndLeft() {
		GemShape shape = new GemShape(10, 75, -10, 10,50,50);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(line 10,100,30,125)(line 30,125,40,125)(line 40,125,60,100)"
				+ "(line 60,100,40,75)(line 40,75,30,75)(line 30,75,10,100)"
				+ "(line 0,110,20,135)(line 20,135,30,135)(line 30,135,50,110)"
				+ "(line 50,110,30,85)(line 30,85,20,85)(line 20,85,0,110)"
				+ "(line 10,100,30,125)(line 30,125,40,125)(line 40,125,60,100)"
				+ "(line 60,100,40,75)(line 40,75,30,75)(line 30,75,10,100)"
				, _painter.toString());
	}
}
