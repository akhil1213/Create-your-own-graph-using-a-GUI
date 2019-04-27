import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.Shape;
import java.awt.geom.Line2D;
public class Edge extends Line2D.Float {
	protected static Vertex drawStart, drawEnd;
	int randomWeight;
	int x1, x2, y1, y2;
	Edge(Vertex drawStart, Vertex drawEnd){
		this.drawStart = drawStart;
		this.drawEnd = drawEnd;
	}
	public void addPoint1(int x1, int y1){
		this.x1 = x1;
		this.y1 = y1;
	}
	public void addPoint2(int x2, int y2) {
		this.x2 = x2;
		this.y2 =y2;
		//repaint();
	}
	
	public Vertex getEnd() {
		return drawEnd;
	}
	public Vertex getBeginning() {
		return drawStart;
	}
	public void drawEdge(Graphics g) {
		Graphics2D k = (Graphics2D)g;
		this.setLine(x1, x2, y1,y2);
		k.draw(this);
	}	
	//edges.add(new Edge( x1,y1,x2,y2));
	
}
