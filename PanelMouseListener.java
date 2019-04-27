import java.awt.AlphaComposite;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import javax.swing.JComponent;
public class PanelMouseListener extends JPanel implements MouseListener{
	GraphsGui jf;
	RadioButtonListener j;
	
	protected static StructureClass saveVertexesAndEdges;
	public static Vertex drawStart, drawEnd;
	
	public PanelMouseListener(GraphsGui jf)
	{
		this.jf = jf;
		saveVertexesAndEdges = new StructureClass();
	}
	public PanelMouseListener(GraphsGui jf, RadioButtonListener j/*, Edge obj*/)
	{
		this.jf = jf;
		this.j = j;
		saveVertexesAndEdges = new StructureClass();
		this.addMouseListener(this);
		//this.obj = obj;
	}
	
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);        
	        Graphics2D g2 = (Graphics2D)g;
	        Iterator<HashMap.Entry<Vertex, HashSet<Edge>>> iterate = saveVertexesAndEdges.getVertexes().entrySet().iterator();
	        while(iterate.hasNext()) {
	        		Vertex vertex = iterate.next().getKey();
	        		Shape circle = vertex.getCircle();
	        		g2.setColor(vertex.color);
	        		g2.fill(circle);
	        }
	        if(drawEnd != null) {
	        		System.out.print("ok");
	        		g2.drawLine(drawStart.x1, drawStart.y1, drawEnd.x1, drawEnd.y1);
	        }
//	        for(Vertex x : vertexes) {
//	        		//g2.drawLine(3,5,7,9);
//	        		HashSet<Edge> edges = saveVertexesAndEdges.getEdgesForGivenVertex(x);
//	        		for(Edge e : edges) {
//	        			e.drawEdge(g);
//	        		}
//	        }
	    }
	public void mousePressed(MouseEvent e) {
	       if(j.vertexButton==true) {
	    	   		Vertex obj = new Vertex(e.getX(), e.getY());
	    	   		//Shape vertex = new Ellipse2D.Double(obj.getX1(), obj.getY1(),5,5);
	    	   		saveVertexesAndEdges.addVertex(obj);
	    	   		//saveVertexesAndEdges.getSavedVertexes(saveVertexes);//send vertexes to structure class every click 
	    	   		//edges.add(vertex);
	    	   		repaint();
	    	   		//this.paintComponent(this.getGraphics());
	    	   	}
	       if(j.edgeButton) {
	    	  // drawStart = saveVertexesAndEdges.createEdge(e.getPoint());
	    	   		if(drawStart == null) {
	    	   			
	    	   			
	    	   			saveVertexesAndEdges.createEdge(e.getPoint()).x1 = 40;;
	    	   			//drawStart.x1 = 40;
	    	   			//System.out.println(drawStart);
	    	   			//System.out.println(drawStart.getX1() + "k");
	    	   			//StructureClass.vertexCoorespondingEdges.remove(drawStart);
//	    	   			try {
//	    	   				drawStart.color = Color.GREEN;
//	    	   				System.out.println(drawStart.getX1() + "G");
//	    	   				
//	    	   				//saveVertexesAndEdges.addVertex(drawStart);
//	    	   				this.repaint();
//	    	   			}catch(NullPointerException z){
//	    	   				System.out.print("didntwork");
//	    	   				//this.repaint();
//	    	   				return;
//	    	   			}
	    	   			this.repaint();
	    	   		} else if(drawStart.color.equals(Color.GREEN))  {
	    	   			//Point pt2 = new Point(e.getX(),e.getY());
	    	   			drawEnd = saveVertexesAndEdges.createEdge(e.getPoint());//find vertex of users click
	    	   			System.out.println(drawEnd.getX1() + "E");
	    	   			//if(drawStart == drawEnd || drawEnd == null) throw new NullPointerException();
	    	   			saveVertexesAndEdges.addEdge(drawStart, drawEnd);
	    	   			try{
	    	   				if(drawEnd == null || drawStart==drawEnd) throw new NullPointerException();
	    	   			}catch(NullPointerException z) {
	    	   				drawStart.color = Color.RED;
	    	   				drawStart = null;
	    	   				drawEnd = null;
	    	   				return;
	    	   			}
	    	   			drawStart.color = Color.GREEN;
	    	   			repaint(); 
//	    	   			drawStart = null;
//	    	   			drawEnd = null;
	    	   		}
	       }
	       if(j.moveVertex) {
	    	   		Point obj = new Point(e.getX(), e.getY());
	    	   		Vertex v = saveVertexesAndEdges.createEdge(obj);
	    	   		v.x1 = obj.x;
	    	   		v.y1 = obj.y;
	    	   		
	       }
 	}
	    public void mouseReleased(MouseEvent e) {
	       //saySomething("Mouse released; # of clicks: "
	                 //   + e.getClickCount(), e);
	    }
	    public void mouseEntered(MouseEvent e) {
	       //saySomething("Mouse entered", e);
	    }

	    public void mouseExited(MouseEvent e) {
	      // saySomething("Mouse exited", e);
	    }

	    public void mouseClicked(MouseEvent e) {
	    		
	    		//saySomething("Mouse clicked (# of clicks: "
	          //          + e.getClickCount() + ")", e);
	    }

	    void saySomething(String eventDescription, MouseEvent e) {
	        System.out.println(eventDescription + " detected on "
	                        + e.getComponent().getClass().getName()
	                        + "." + "\n");
	    }
	}
