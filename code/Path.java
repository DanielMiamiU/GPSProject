

public class Path implements Comparable<Path> {

	public Vertex vert;
	public int cost;
	public String name;
	
	public Path(Vertex vertex, String name, int co) {
		vert = vertex;
		this.name = name;
		cost = co;
	}
	@Override
	public int compareTo(Path o) {
		
		return this.cost - o.cost;
	}
	
	public String toString() {
		return "[" + vert.getSymbol() + ", " + name + ", " + cost + "]";
	}
	/*
	 * set of vertices or set of edges
	 */
	

	
	
}
