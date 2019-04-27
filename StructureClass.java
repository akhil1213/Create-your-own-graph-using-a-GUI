import java.util.HashMap;
import java.awt.Point;
import java.awt.Shape;
import java.util.*;
import java.util.HashSet;
public class StructureClass {
	HashMap <Vertex, HashSet<Edge>> vertexCoorespondingEdges;
	int numberOfEdges, numberOfVertexes;
	
	public StructureClass() {
		vertexCoorespondingEdges = new HashMap<Vertex, HashSet<Edge>>();
		numberOfEdges = 0;
		numberOfVertexes = 0;
	}
	

	public void addVertex(Vertex circle) {
		if(vertexCoorespondingEdges.containsKey(circle) == false) {
			vertexCoorespondingEdges.put(circle, new HashSet<Edge>());
		}
	}
	public void addEdge(Vertex obj1, Vertex obj2) {//obj1 is ur head, obj2 is your tail
		if(isEdgeNull(obj1,obj2)) {
			vertexCoorespondingEdges.get(obj1).add(new Edge(obj1, obj2));
			vertexCoorespondingEdges.get(obj2).add(new Edge(obj2, obj1));
		}
	}
	public boolean isEdgeNull(Vertex obj1, Vertex obj2) {
		HashSet<Edge> e1 = vertexCoorespondingEdges.get(obj1);
		for(Edge edges : e1) {
			if(edges.getEnd().equals(obj2)) return false;//comparing every edge inside of the head vertex to the tail vertex and seeing if they are equal, 
		}
		return true;
	}
	public HashMap<Vertex,HashSet<Edge>> getVertexes(){
		return vertexCoorespondingEdges;
	}
	public HashSet<Edge> getEdgesForGivenVertex(Vertex v){
		return vertexCoorespondingEdges.get(v);
	}
	public Vertex createEdge(Point obj) {//checks if the point user clicked on has a cooresponding vertex and that becomes the first point of that edge
		for(Vertex vertexes : vertexCoorespondingEdges.keySet()) {
			if(vertexes.getCircle().contains(obj)) return vertexes;
		}
		return null;
	}
}

