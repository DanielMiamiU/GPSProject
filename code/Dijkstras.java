import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Dijkstras {

	/*
	 * totalCost
	 * shortestPath ( returns a path)
	 */
	public static int totalCost(int path, char start, char end) {
		return shortestPath(path, start, end).cost;
	}
	
	public static Path shortestPath(int path, char start, char end) {
		// if cost is picked
		// else distance
		Graph g = new Graph("MapInformation-1.txt");
		if (path == 1) {
			return costPath(g, start, end);
		} else if (path == 2){
			return distPath(g, start, end);
		} else {
			return lessCops(start, end);
		}
		
	}
	
	public static Path lessCops(char start, char finish) {
		Graph g = new Graph("MapInformation-1.txt");
		
		Vertex Start = g.getVertex(start);
		Vertex end = g.getVertex(finish);
	
		
		
		PriorityQueue<Path> pq = new PriorityQueue();
		Set<Vertex> s = new TreeSet();
		pq.add(new Path (Start, "" + Start.getSymbol(), 0));
		
		while (!pq.isEmpty()) {
			Path next = pq.remove();
			
			if (next.vert.equals(end)) {
				return next;
			}
			
			if (s.contains(next.vert)) {
				continue;
			} else {
				s.add(next.vert);
				for (Edge e: g.hm.get(next.vert)) {
					Path p = new Path(e.getTo(), next.name + e.getTo().getSymbol(), next.cost + e.getPolice());
					pq.add(p);
					
				}
			}
			
		}
		return null;
	}
	
	private static Path distPath(Graph g, char start, char finish) {
		Vertex Start = g.getVertex(start);
		Vertex end = g.getVertex(finish);
	
		
		
		PriorityQueue<Path> pq = new PriorityQueue();
		Set<Vertex> s = new TreeSet();
		pq.add(new Path (Start, "" + Start.getSymbol(), 0));
		
		while (!pq.isEmpty()) {
			Path next = pq.remove();
			
			if (next.vert.equals(end)) {
				return next;
			}
			
			if (s.contains(next.vert)) {
				continue;
			} else {
				s.add(next.vert);
				for (Edge e: g.hm.get(next.vert)) {
					Path p = new Path(e.getTo(), next.name + e.getTo().getSymbol(), next.cost + e.getDistance());
					pq.add(p);
					
				}
			}
			
		}
		return null;
	}
	
	private static Path costPath(Graph g, char start, char finish) {
		Vertex Start = g.getVertex(start);
		Vertex end = g.getVertex(finish);
	
		
		
		PriorityQueue<Path> pq = new PriorityQueue();
		Set<Vertex> s = new TreeSet();
		pq.add(new Path (Start, "" + Start.getSymbol(), 0));
		
		while (!pq.isEmpty()) {
			Path next = pq.remove();
			
			if (next.vert.equals(end)) {
				return next;
			}
			
			if (s.contains(next.vert)) {
				continue;
			} else {
				s.add(next.vert);
				for (Edge e: g.hm.get(next.vert)) {
					Path p = new Path(e.getTo(), next.name + e.getTo().getSymbol(), next.cost + e.getCost());
					pq.add(p);
					
				}
			}
			
		}
		return null;
	}
	
	
}
