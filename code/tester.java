import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class tester<Object> {

	// add a new part of the map information file for # of police on the road
	public static void main(String[] args) {
		Graph g = new Graph("MapInformation-1.txt");
		Vertex Start = g.getVertex('A');
		Vertex end = g.getVertex('H');
	
		System.out.println(Dijkstras.lessCops( 'O', 'D').toString());
		
/*		PriorityQueue<Path> pq = new PriorityQueue();
		Set<Vertex> s = new TreeSet();
		pq.add(new Path (Start, "" + Start.getSymbol(), 0));
		
		while (!pq.isEmpty()) {
			Path next = pq.remove();
			
			if (next.vert.equals(end)) {
				System.out.println(next.cost);
				break;
			}
			
			if (s.contains(next.vert)) {
				continue;
			} else {
				s.add(next.vert);
				for (Edge e: g.hm.get(next.vert)) {
					Path p = new Path(e.getTo(), next.name + e.getTo().getSymbol(), next.cost + e.getDistance());
					pq.add(p);
					System.out.println("Path created:" + p.toString());
				}
			}
			
		}
		
		
	*/	
	}
}
