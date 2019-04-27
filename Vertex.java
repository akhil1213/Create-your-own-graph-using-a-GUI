
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Vertex {
	protected int x1, y1;
	public static Vertex preClicked;
	Shape circle;
	Color color;
	int index; 
	int idOfVertex;
	//HashMap<Integer, Shape> vertexes = new HashMap<Integer,Shape>();
	
	Vertex(int x1, int y1){
		//super();
		color = Color.RED;
		this.x1 = x1;
		this.y1 = y1;
		idOfVertex = index++;
		circle = new Ellipse2D.Double(x1-2,y1-2,13,13);
		//vertexes.put(index, circle);
	}
	public void setColor(Color obj) {
		color = obj;
	}
	public int getX1() {
		return x1;
	}
	public int getY1() {
		return y1;
	}
	public Shape getCircle() {
		return circle;
	}
}
	