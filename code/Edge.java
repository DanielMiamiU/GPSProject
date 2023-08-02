
public class Edge implements Comparable<Edge>{
	/*
	 * from (vertex)
	 * to (vertex)
	 * cost
	 */
	private Vertex to;
	private int cost;
	private int distance;
	private int police;
	
	public Edge( Vertex to, int co, int dis, int cops) {
		
		this.to = to;
		cost = co;
		distance = dis;
		police = cops;
	}

	public int getDistance() {
		return distance;
	}
	
	public int getPolice() {
		return police;
	}

	public Vertex getTo() {
		return to;
	}

	public int getCost() {
		return cost;
	}

	public String toString() {
		return "" + to.getSymbol() + " " + cost;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if (this.cost == o.cost) {
			return this.to.getSymbol() - o.to.getSymbol();
		}
				return this.cost - o.cost;
	}
	
	
}
