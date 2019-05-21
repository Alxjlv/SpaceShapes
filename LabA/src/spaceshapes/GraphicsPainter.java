package spaceshapes;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaeshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
	}

	@Override
	public Color getColor() {
		return _g.getColor();
	}

	@Override
	public void setColor(Color c) {
		_g.setColor(c);
	}
	
	public void translate(int x, int y) {
		_g.translate(x, y);
	}
	
	public void paintText(String text,int x, int y) {
		if(text == null) {
			return;
		}
		FontMetrics fontAdjust = _g.getFontMetrics();
		int stringWidth = fontAdjust.stringWidth(text);
		int ascent = fontAdjust.getAscent();
		int descent = fontAdjust.getDescent();
		x -= stringWidth/2;
		if(ascent > descent) {
			y+=(ascent-descent)/2;
		}else if(descent>ascent) {
			y+=(descent-ascent)/2;
		}else {
			y-= (descent+ascent)/2;
		}
		//_g.getFontMetrics();
		_g.drawString(text, x, y);
	}
}
